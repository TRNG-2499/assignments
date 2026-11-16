import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        House house = new House();
        boolean running = true;

        printRoom(house.getCurrentRoom());

        while (running) {
            System.out.print("\nEnter a command: ");
            if (!scanner.hasNextLine()) {
                break;
            }
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                continue;
            }

            String[] parts = input.split("\\s+", 2);
            String command = parts[0].toLowerCase();
            String argument = parts.length > 1 ? parts[1].trim() : "";

            try {
                switch (command) {
                    case "move":
                        house.move(argument);
                        printRoom(house.getCurrentRoom());
                        break;
                    case "look":
                        printRoom(house.getCurrentRoom());
                        break;
                    case "interact":
                        System.out.println(house.interact(argument));
                        break;
                    case "exit":
                    case "quit":
                        System.out.println("Thanks for visiting! Goodbye.");
                        running = false;
                        break;
                    default:
                        System.out.println("Unknown command: " + command);
                        break;
                }
            } catch (InvalidDirectionException | EntityNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static void printRoom(Room room) {
        System.out.println("\nYou are in the " + room.getName() + ".");
        System.out.println(room.getDescription());
        Entity[] entities = room.getEntities();
        if (entities.length == 0) {
            System.out.println("Interactable entities: None");
        } else {
            StringBuilder sb = new StringBuilder("Interactable entities: ");
            for (int i = 0; i < entities.length; i++) {
                sb.append(entities[i].getName());
                if (i < entities.length - 1) {
                    sb.append(", ");
                }
            }
            System.out.println(sb.toString());
        }
    }
}