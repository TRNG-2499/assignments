package java_assignment_11;

import java.util.Scanner;

public class Main {

    public static Room createHouse() {
        Room foyer = new Room(
            "Foyer",
            "You are at the entrance of the house. A beautiful home awaits!"
        );
        Room livingRoom = new Room(
            "Living Room",
            "A comfortable room with a sofa, television, and fireplace."
        );
         Room kitchen = new Room(
            "Kitchen",
            "A bright kitchen with modern appliances and a dining table."
        );

        Room bedroom = new Room(
            "Bedroom",
            "A peaceful bedroom with a large bed and a bookshelf."
        );
         Entity painting = new Entity(
            "painting",
            "A beautiful landscape painting hangs on the wall.",
            "You admire the beautiful landscape painting."
        );

        Entity television = new Entity(
            "television",
            "A large television sits across from the sofa.",
            "You turn on the television. A nature documentary is playing!"
        );

        Entity refrigerator = new Entity(
            "refrigerator",
            "A large refrigerator stands in the kitchen.",
            "You open the refrigerator. There are plenty of snacks inside!"
        );

        Entity bookshelf = new Entity(
            "bookshelf",
            "A bookshelf filled with interesting books.",
            "You browse the books and find an interesting mystery novel."
        );

        foyer.addEntity(painting);
        livingRoom.addEntity(television);
        kitchen.addEntity(refrigerator);
        bedroom.addEntity(bookshelf);

        foyer.addExit("north", livingRoom);

        livingRoom.addExit("south", foyer);
        livingRoom.addExit("east", kitchen);
        livingRoom.addExit("north", bedroom);

        kitchen.addExit("west", livingRoom);

        bedroom.addExit("south", livingRoom);

        return foyer;
    }

    public static void displayInstructions() {
        System.out.println("Available commands:");
        System.out.println("  move [direction]  - Move to another room");
        System.out.println("  look              - Look around the current room");
        System.out.println("  interact [entity] - Interact with an entity");
        System.out.println("  exit              - Leave the home tour");
        System.out.println("  quit              - Leave the home tour");
        System.out.println("Directions: north, south, east, west");
    }


    public static void startHouseTour() {

        Scanner scanner = new Scanner(System.in);
        Room currentRoom = createHouse();
        currentRoom.displayRoom();

        while (true) {
            System.out.print("\nEnter a command: ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                continue;
            }
            input = input.toLowerCase().trim();
            String[] parts = input.split("\\s+", 2);

            String command = parts[0];
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
                    System.out.println("\nYou moved to a new room.");
                    currentRoom.displayRoom();
                }
                else if (command.equals("look")) {
                    currentRoom.displayRoom();
                }
                else if (command.equals("interact")) {
                    if (argument.isEmpty()) {
                        System.out.println("Please specify an entity to interact with.");
                        continue;
                    }
                    Entity entity = currentRoom.getEntity(argument);
                    System.out.println(entity.interact());
                }
                else if (command.equals("exit") || command.equals("quit")) {

                    System.out.println("Thank you for taking the home tour. Goodbye!");
                    break;
                }
                else {
                    System.out.println("Unknown command. Please try again.");
                    displayInstructions();
                }

            }

            catch (InvalidDirectionException e) {

                System.out.println(e.getMessage());
            }

            catch (EntityNotFoundException e) {

                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }


    public static void main(String[] args) {
        System.out.println("Welcome to the Home Tour!");
        displayInstructions();
        startHouseTour();

    }
}
