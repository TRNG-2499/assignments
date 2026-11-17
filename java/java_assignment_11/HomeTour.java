import java.util.Scanner;

/**
 * Entry point: runs the command loop.
 * Compile and run:  javac *.java && java HomeTour
 */
public class HomeTour {

    private Room currentRoom;

    public HomeTour(Room startingRoom) {
        this.currentRoom = startingRoom;
    }

    public static void main(String[] args) {
        new HomeTour(House.build()).run();
    }

    public void run() {
        System.out.println(currentRoom.describe());

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                System.out.print("\nEnter a command: ");
                if (!scanner.hasNextLine()) {
                    break;
                }
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }

                // Split into command word and the rest (argument), case-insensitive
                String[] parts = line.split("\\s+", 2);
                String command = parts[0].toLowerCase();
                String argument = parts.length > 1 ? parts[1].trim() : "";

                try {
                    switch (command) {
                        case "move" -> move(argument);
                        case "look" -> look();
                        case "interact" -> interact(argument);
                        case "exit", "quit" -> running = false;
                        // Stretch: case "take" -> ...; case "inventory" -> ...;
                        default -> System.out.println("Unknown command: " + command);
                    }
                } catch (InvalidDirectionException | EntityNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        System.out.println("Thanks for visiting! Goodbye.");
    }

    private void move(String direction) throws InvalidDirectionException {
        if (direction.isEmpty()) {
            System.out.println("Move where? Usage: move [direction]");
            return;
        }
        currentRoom = currentRoom.getExit(direction);
        System.out.println(currentRoom.describe());
    }

    private void look() {
        System.out.println(currentRoom.describe());
    }

    private void interact(String entityName) throws EntityNotFoundException {
        if (entityName.isEmpty()) {
            System.out.println("Interact with what? Usage: interact [entity name]");
            return;
        }
        Entity entity = currentRoom.findEntity(entityName);
        System.out.println(entity.interact());
    }
}
