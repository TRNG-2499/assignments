import java.util.Scanner;


public class Home_Tour {
    
    public static Room createHouse(){
        //Creating the Rooms
        Room foyer = new Room("Foyer", "A small entryway with a coat rack and a stairway leading up.");
        Room kitchen = new Room("Kitchen", "A bright kitchen with the smell of fresh coffee.");
        Room livingRoom = new Room("LivingRoom", "A comfortable living room with a large TV and sofa.");
        Room bedroom = new Room("Bedroom", "A quiet bedroom with a bed, a closet, and a night stand.");

        //Creating the entities
        
        //Foyer
        Entity coatRack = new Entity("CoatRack", "A coatrack stands near the entrance.", "You check the CoatRack. There are multiple different colored coats on it.");
        //Kitchen
        Entity coffeeMaker = new Entity("CoffeeMaker", "A coffee maker sits on the counter.", "It smells of freshly brewed coffee.");
        Entity refrigerator = new Entity("Refrigerator", "A refrigerator sits solidly against the wall","It hums as it cools the delicious food inside");
        //Living Room
        Entity sofa = new Entity("Sofa", "The sofa sits in the middle of the living room, facing the TV.", "As you press into the sofa, your hand sinks inside the soft material.");
        Entity tv = new Entity("TV", "The TV sits mounted on the wall", "The TV is playing a football game.");
        //Bedroom
        Entity bed = new Entity("Bed", "A bed sits against the wall with the end facing the door.", "The bed looks extra comfy as you jump on it.");
        Entity closet = new Entity("Closet", "A closet to hold all of your clothes", "Opening it up, you see the new T-shirt you bought the other day.");
        Entity nightStand = new Entity("NightStand", "A nightstand sits next to the bed, with a drawer on it.", "The drawer hold a spare pair of glasses.");
    
        //Adding entities into the room
        foyer.addEntity(coatRack);

        kitchen.addEntity(coffeeMaker);
        kitchen.addEntity(refrigerator);

        livingRoom.addEntity(sofa);
        livingRoom.addEntity(tv);

        bedroom.addEntity(bed);
        bedroom.addEntity(closet);
        bedroom.addEntity(nightStand);

        //Connecting the rooms
        foyer.addExit("up", kitchen);
        kitchen.addExit("south", foyer);
        kitchen.addExit("east", livingRoom);
        livingRoom.addExit("west", kitchen);
        livingRoom.addExit("up", bedroom);
        bedroom.addExit("down", livingRoom);
        
        return foyer;
    }

    //Processing User commands
    public static Room processCommand(String command, Room currentRoom){
        String[] parts = command.trim().split("\\s+", 2);
        String action = parts[0].toLowerCase();
        String argument = "";

        if(parts.length > 1)
            argument = parts[1].trim();

        try{
    switch(action){

        //Command is move (direction)
        case "move":
            if(argument.isEmpty()){
                System.out.println("Please specify direction.");
                break;
            }

            currentRoom = currentRoom.move(argument);
            currentRoom.displayRoom();
            break;

        case "look":
            currentRoom.displayRoom();
            break;

        //Command is interact (entity)
        case "interact":
            if(argument.isEmpty()){
                System.out.println("Please specify entity to interact with.");
                break;
            }

            Entity entity = currentRoom.findEntity(argument);
            System.out.println(entity.getResponse());
            break;

        case "exit":
        case "quit":
            System.out.println("Thanks for visiting. Goodbye.");
            return null;

        default:
            System.out.println("Unknown command. Try move, look, interact, or exit.");
            break;
                }
        } catch (InvalidDirectionException | EntityNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }
    return currentRoom;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Room currentRoom = createHouse();

        currentRoom.displayRoom();

        while(currentRoom != null){
            System.out.println("Enter a command: ");
            String command = scan.nextLine();
            currentRoom = processCommand(command, currentRoom);
        }
        scan.close();
    }
}