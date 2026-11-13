import java.util.Scanner;

public class main {

    public static class InvalidDirectionException extends Exception {

        public InvalidDirectionException(String message) {
            super(message);
        }

    }

    public static class EntityNotFoundException extends Exception {
        public EntityNotFoundException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Room currentRoom;
        try {
            currentRoom = Initialize();
        } catch (Exception e) {
            System.out.println("Initialization failed: " + e.getMessage());
            scanner.close();
            return;
        }

        System.out.println("This is the " + currentRoom.describe());

        System.out.println("--------------------------------------------------");

        System.out.println("Initialize complete");

        System.out.println("Enter a command");
        System.out.println("move [direction]");
        System.out.println("look");
        System.out.println("interact [entity]");
        System.out.println("exit/quit");
        if (!scanner.hasNextLine()) {
            System.out.println("Thank you for visiting, goodbye!");
            scanner.close();
            return;
        }
        String input = scanner.nextLine().trim().toLowerCase();
        System.out.println("--------------------------------------------------");

        if (input.equals("exit") || input.equals("quit")) {
            System.out.println("Thank you for visiting, goodbye!");
            scanner.close();
            return;
        }

        if (input.isEmpty()) {
            System.out.println("No command entered.");
            scanner.close();
            return;
        }

        while (!input.equals("exit") && !input.equals("quit")) {
            String[] parts = input.split("\\s+");

            try {
                switch (parts[0]) {
                    case "move":
                        if (parts.length != 2) {
                            throw new InvalidDirectionException("Invalid command. Argument length must be 2.");
                        }

                        Room nextRoom = currentRoom.getExit(parts[1].toLowerCase());
                        if (nextRoom == null) {
                            throw new InvalidDirectionException("You can't go that way." + parts[1] + " is dead end.");
                        } else {
                            currentRoom = nextRoom;
                            System.out.println("You moved to the " + currentRoom.describe() + ".");
                        }
                        break;
                    case "look":
                        if (parts.length != 1) {
                            System.out.println("Invalid command. Argument length must be 1.");
                            break;
                        }
                        System.out.println("This is the " + currentRoom.describe() + ".");
                        break;
                    case "interact":
                        if (parts.length != 2) {
                            throw new EntityNotFoundException("Invalid command. Argument length must be 2.");
                        }

                        Entity entity = currentRoom.getEntity(parts[1].toLowerCase());

                        if (entity == null) {
                            throw new EntityNotFoundException("There is no " + parts[1] + " here.");
                        } else {
                            System.out.println(entity.interact());
                        }
                        break;
                    default:
                        System.out.println("Unknown command: " + parts[0]);
                        break;

                }
            } catch (InvalidDirectionException | EntityNotFoundException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Enter a command");
            System.out.println("move [direction]");
            System.out.println("look");
            System.out.println("interact [entity]");
            System.out.println("exit/quit");

            if (!scanner.hasNextLine()) {
                break;
            }
            input = scanner.nextLine().trim().toLowerCase();
            System.out.println("--------------------------------------------------");

        }

        System.out.println("Thank you for visiting, goodbye!");

        scanner.close();

    }

    private static Room Initialize() {
        // Initialize foyer
        Room foyer = new Room("Foyer", "A small entryway with a coat rack and a stairway leading up.");
        Entity coatRack = new Entity("CoatRack", "An old wooden coat rack.", "There's an old raincoat hanging on it.");
        foyer.addEntity(coatRack);

        Room kitchen = new Room("Kitchen", "A kitchen with a lingering smell of freshly baked bread.");
        Entity coffeeMaker = new Entity("CoffeeMaker", "A modern coffee maker.", "The plug is disconnected.");
        kitchen.addEntity(coffeeMaker);
        Entity fridge = new Entity("Fridge", "A large ice maker refrigerator.", "You can hear it buzzing inside.");
        kitchen.addEntity(fridge);

        Room livingRoom = new Room("Living Room", "A cozy living room with a fireplace.");
        Entity sofa = new Entity("Sofa", "A comfortable leather sofa.", "It looks very inviting.");
        livingRoom.addEntity(sofa);

        Room bedRoom = new Room("Bedroom", "A quiet bedroom with a large bed.");
        Entity bed = new Entity("Bed", "A king-sized bed.", "It looks very comfortable.");
        bedRoom.addEntity(bed);

        // Adding exits
        foyer.addExit("north", kitchen);
        kitchen.addExit("south", foyer);
        foyer.addExit("west", livingRoom);
        livingRoom.addExit("east", foyer);
        foyer.addExit("up", bedRoom);
        bedRoom.addExit("down", foyer);

        return foyer;
    }
}
