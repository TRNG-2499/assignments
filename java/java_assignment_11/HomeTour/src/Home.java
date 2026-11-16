import java.util.Scanner;

public class Home {
    public static void main(String[] args) {

       //room creations
        Rooms foyer = new Rooms(
            "Foyer",
            "A small entryway with a coat rack and a stairway."
        );
        Rooms kitchen = new Rooms(
            "Kitchen",
            "A bright kitchen with the smell of fresh coffee."
        );
        Rooms livingRoom = new Rooms(
            "LivingRoom",
            "A comfortable living room with a large television."
        );
        Rooms bedroom = new Rooms(
            "Bedroom",
            "A quiet bedroom with a comfortable bed."
        );

        //connecting the rooms
        foyer.addExit("north", kitchen);
        kitchen.addExit("south", foyer);
        foyer.addExit("east", livingRoom);
        livingRoom.addExit("west", foyer);
        kitchen.addExit("east", bedroom);
        bedroom.addExit("west", kitchen);

        //create entities
        Entities coatRack = new Entities(
            "CoatRack",
            "A wooden coat rack.",
            "\nYou check the CoatRack. There are 3 different coats hanging on it."
        );
        Entities coffeeMaker = new Entities(
            "CoffeeMaker",
            "A machine that makes coffee.",
            "\nYou brew yourself a fresh cup of coffee."
        );
        Entities refrigerator = new Entities(
            "Refrigerator",
            "A large refrigerator.",
            "\nYou open the refrigerator and find some leftover pizza."
        );
        Entities television = new Entities(
            "Television",
            "A large flat-screen television.",
            "\nYou turn on the television. A cooking show is playing."
        );
        Entities bed = new Entities(
            "Bed",
            "A comfortable bed.",
            "\nYou lie down on the bed and relax."
        );

        //adding entities to the rooms
        foyer.addEntity(coatRack);
        kitchen.addEntity(coffeeMaker);
        kitchen.addEntity(refrigerator);
        livingRoom.addEntity(television);
        bedroom.addEntity(bed);

        //initialize Scanner and starting room
        Scanner scanner = new Scanner(System.in);
        Rooms currentRoom = foyer;
        currentRoom.displayRoom();
        boolean running = true;

        //main loop for user input and command processing
        while (running) {
            System.out.print("\nList of commands: move (direction), look, interact (entity), exit");
            System.out.print("\nEnter a command: ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                continue;
            }
            
            //separate command and argument
            String[] parts = input.split("\\s+", 2);
            String command = parts[0].toLowerCase();
            String argument = "";

            if (parts.length > 1) {
                argument = parts[1].trim();
            }
            try {
                if (command.equals("move")) {
                    if (argument.isEmpty()) {
                        System.out.println("Please specify a direction.");
                        continue;
                    }
                    currentRoom = currentRoom.getExit(argument);
                    currentRoom.displayRoom();
                }
                else if (command.equals("look")) {
                    currentRoom.displayRoom();
                }
                else if (command.equals("interact")) {
                    if (argument.isEmpty()) {
                        System.out.println("Please specify an entity.");
                        continue;
                    }
                    Entities entity = currentRoom.getEntity(argument);
                    System.out.println(entity.interact());
                }
                else if (command.equals("exit") ||
                         command.equals("quit")) {
                    System.out.println(
                        "\nThanks for visiting! Goodbye."
                    );
                    running = false;
                }
                else {
                    System.out.println(
                        "\nUnknown command. Try move (input direction), look (displays current room's description and entities), interact (input entity name), or exit (exits the program)."
                    );
                }
            }
            catch (InvalidDirectionException |
                   EntityNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
