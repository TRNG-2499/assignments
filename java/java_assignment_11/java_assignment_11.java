package java_assignment_11;

import java.util.Scanner;

public class java_assignment_11 {

    /* Instantiate rooms */
    private static Room kitchen;
    private static Room lounge;
    private static Room diningRoom;
    private static Room bathroom;
    private static Room currentRoom;

    private static void defineRooms(){
        kitchen = new Room("Kitchen", "An absolute mess");
        lounge = new Room("Lounge", "Smells like football");
        diningRoom = new Room("Dining Room", "Gather round");
        bathroom = new Room("Bathroom", "Out of TP");
    }

    private static void connectRooms(){
        kitchen.addExit("east", diningRoom);
        diningRoom.addExit("west", kitchen);

        diningRoom.addExit("south", bathroom);
        bathroom.addExit("north", diningRoom);

        bathroom.addExit("west", lounge);
        lounge.addExit("east", bathroom);

        lounge.addExit("north", kitchen);
        kitchen.addExit("south", lounge);
    }

    /* Instantiate entities */
    // Kitchen
    private static Entity fridge;
    private static Entity microwave;
    private static Entity garbage;
    // Dining room
    private static Entity table;
    private static Entity chair;
    private static Entity lamp;
    // Bathroom
    private static Entity toilet;
    private static Entity sink;
    private static Entity window;
    // Lounge
    private static Entity couch;
    private static Entity bookshelf;
    private static Entity television;

    private static void defineEntities(){
        fridge = new Entity("Fridge", "Almost everything inside is expired.");
        microwave = new Entity("Microwave", "It has a \"plastic mode\"");
        garbage = new Entity("Garbage", "Full of candy wrappers");
        table = new Entity("Table", "Only $400 at IKEA");
        chair = new Entity("Chair", "Got them all on FBM");
        lamp = new Entity("Lamp", "I love lamp");
        toilet = new Entity("Toilet","Reminds me of my life");
        sink = new Entity("Sink", "Employees are required to wash their hands before returning to work");
        window = new Entity("Window", "Emergency exit for fumes");
        couch = new Entity("Couch", "Time to kick back and enjoy the big game with a cold one");
        bookshelf = new Entity("Bookshelf", "Uh nerd much?");
        television = new Entity("TV", "My one and only friend in this cold dark world");
    }

    public static void addEntities(){
        kitchen.addEntity(fridge);
        kitchen.addEntity(microwave);
        kitchen.addEntity(garbage);

        diningRoom.addEntity(table);
        diningRoom.addEntity(chair);
        diningRoom.addEntity(lamp);

        bathroom.addEntity(toilet);
        bathroom.addEntity(sink);
        bathroom.addEntity(window);
        
        lounge.addEntity(couch);
        lounge.addEntity(bookshelf);
        lounge.addEntity(television);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void coreLoop(){
        /*  Declare and describe current room
        *   Prompt for input
        *   Process input:
        *       move to specified room (retrigger full loop)
        *       interact with specified entity (trigger entity then reprompt for command)
        *       handle invalid of either
        *   Repeat
        */
       identifyRoom();
       receiveCommand();
    }

    public static void identifyRoom(){
       System.out.printf("You are in the %s.\n", currentRoom.getName());
       System.out.println(currentRoom.getDescription());
       System.out.printf("Interactable entities: %s\n", printEntities());
    }

    public static StringBuilder printEntities(){
        StringBuilder entityList = new StringBuilder();

        for (int i = 0; i < currentRoom.getEntities().size(); i++){
            Entity entity = currentRoom.getEntities().get(i);
            entityList.append(entity.getName());
            if (i < currentRoom.getEntities().size() - 1){
                entityList.append(", ");
            }
        }

        return entityList;
    }

    public static void receiveCommand(){
        while(true){
            System.out.print("Enter a command: ");
            String command = scanner.nextLine();
            try {
                processCommand(command);
            } catch (InvalidDirectionException e) {
                System.out.println(e.getMessage());
            } catch (EntityNotFoundException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void processCommand(String command) throws InvalidDirectionException, EntityNotFoundException{
        String[] words = command.toLowerCase().split(" ");

        if (words.length == 1){
            if(words[0].equals("look")){
                identifyRoom();
            } else if (words[0].equals("exit") || words[0].equals("quit")){
                System.out.println("Thanks for visiting! Goodbye.");
                scanner.close();
                System.exit(0);
            } else {
                System.out.println("Invalid input.");
            }
        } else if (words.length == 2){
            if(words[0].equals("interact")){
                interact(words[1]);
            } else if (words[0].equals("move")){
                move(words[1]);
            }
        } else {
            System.out.println("Invalid input. Try again.");
        }
    }

    public static void move(String direction) throws InvalidDirectionException{
        Room targetRoom = currentRoom.getExit(direction);
        if (targetRoom == null){
            throw new InvalidDirectionException("Error: there is no exit to the " + direction + " from here.");
        } else {
            currentRoom = targetRoom;
            identifyRoom();
        }
    }

    public static void interact(String entityName) throws EntityNotFoundException{
        Entity entity = currentRoom.getEntity(entityName.toLowerCase());
        System.out.println(entity.getDescription());
    }
    

    public static void main(String[] args){
        defineRooms();
        connectRooms();
        defineEntities();
        addEntities();

        currentRoom = kitchen;
        coreLoop();
    }
}
