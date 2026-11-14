import java.util.Scanner;

public class HomeTour {
    private static Room currentRoom;
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        setupWorld();
        displayCurrentRoom();

        while(true) {
            System.out.println("\nEnter a command: ");
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                continue;
            }

            String[] parts = input.split(" ", 2);
            String command = parts[0].toLowerCase();

            try {
                switch(command) {
                    case "move":
                        handleMove(parts.length > 1 ? parts[1].trim() : "");
                        break;
                    case "look":
                        displayCurrentRoom();
                        break;
                    case "interact":
                        handleInteract(parts.length > 1 ? parts[1].trim() : "");
                        break;
                    case "exit":
                    case "quit":
                        System.out.println("Thanks for visting! Goodbye.");
                        return;
                    default:
                        System.out.println("I don't understand that command.");

                }   
            }
            catch (GameException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void setupWorld() {
        Room foyer = new Room("Foyer", "A small entryway with a coat rack.");
        Room kitchen = new Room("Kitchen", "A bright kitchen smelling of coffee.");
        Room livingRoom = new Room("Living Room", "A cozy room with a large sofa.");
        Room attic = new Room("Attic", "A dusty space filled with old trunks.");

        foyer.addEntity(new Entity("CoatRack", "There's an old raincoat hanging on it."));
        kitchen.addEntity(new  Entity("CoffeeMaker", "It is warm to the touch."));
        kitchen.addEntity(new Entity("Refrigerator", "It hums quietly."));

        // adding exits 
        foyer.addExit("north", kitchen);
        kitchen.addExit("south", foyer);
        foyer.addExit("east", livingRoom);
        livingRoom.addExit("west", foyer);
        foyer.addExit("up", attic);
        attic.addExit("down", foyer);

        currentRoom = foyer;
    }

    private static void handleMove(String directionInput) {
        if (directionInput.isEmpty()) {
            System.out.println("Please specify a direction.");
            return;
        }

        String direction = directionInput.toLowerCase();
        Room nextRoom = null;

        for (Exit exit : currentRoom.getExits()) {
            if (exit.getDirection().equals(direction)) {
                nextRoom = exit.getDestination();
                break;
            }
        }

        if (nextRoom == null) {
            throw new InvalidDirectionException(direction);
        }

        currentRoom = nextRoom;
        displayCurrentRoom();
    }

    private static void handleInteract(String entityName) {
        if (entityName.isEmpty()) {
            System.out.println("What do you want to interact with?");
            return;
        }

        boolean found = false;
        for (Entity e : currentRoom.getEntities()) {
            if (e.getName().equalsIgnoreCase(entityName)) {
                System.out.println(e.interact());
                found = true;
                break;
            }
        }

        if (!found) {
            throw new EntityNotFoundException(entityName);
        }
    }

    private static void displayCurrentRoom() {
        System.out.println("You are in the " + currentRoom.getName() + ".");
        System.out.println(currentRoom.getDescription());
        
        if (!currentRoom.getEntities().isEmpty()) {
            System.out.print("Interactable entities: ");
            for (int i = 0; i < currentRoom.getEntities().size(); i++) {
                System.out.print(currentRoom.getEntities().get(i).getName());
                if (i < currentRoom.getEntities().size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

}
