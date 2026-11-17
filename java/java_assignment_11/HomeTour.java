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
                String[] parts = line.split("\s+", 2);
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
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }

        System.out.println("Thanks for visiting! Goodbye.");
    }

    private void move(String direction) throws InvalidDirectionException {
        // TODO: handle a missing direction argument
        // TODO: currentRoom = currentRoom.getExit(direction); then print the new room's description
    }

    private void look() {
        // TODO: print currentRoom.describe()
    }

    private void interact(String entityName) throws EntityNotFoundException {
        // TODO: handle a missing entity argument
        // TODO: find the entity in currentRoom and print entity.interact()
    }
}
