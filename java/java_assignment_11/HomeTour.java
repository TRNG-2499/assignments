import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class HomeTour {
    public static void main(String[] args) {
        // Start in the foyer and show the room before asking for a command.
        Room current = buildHouse();
        current.look();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("\nEnter a command: ");

                // Stop cleanly if the input stream closes.
                if (!scanner.hasNextLine()) {
                    break;
                }

                // Split "move north" into the command "move" and the argument "north".
                String[] parts = scanner.nextLine().trim().split("\\s+", 2);
                // Lowercase the command so MOVE and move work the same way.
                String command = parts[0].toLowerCase(Locale.ROOT);
                String argument = parts.length == 2 ? parts[1] : "";

                try {
                    switch (command) {
                        case "move":
                            // If the exit is invalid, move throws before current gets updated.
                            current = current.move(argument);
                            current.look();
                            break;
                        case "look":
                            current.look();
                            break;
                        case "interact":
                            System.out.println(current.interact(argument));
                            break;
                        case "exit":
                        case "quit":
                            System.out.println("Thanks for visiting! Goodbye.");
                            return;
                        default:
                            System.out.println("Use move [direction], look, interact [entity], or quit.");
                    }
                } catch (InvalidDirectionException | EntityNotFoundException e) {
                    // Show what went wrong, then let the player try another command.
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }

    // Create the four rooms, connect them, and return the starting room.
    private static Room buildHouse() {
        Room foyer = new Room("Foyer", "A small entryway with a coat rack.",
                new Entity("CoatRack", "A wooden rack by the door.",
                        "An old raincoat is hanging on it."));
        Room kitchen = new Room("Kitchen", "A bright room that smells like coffee.",
                new Entity("CoffeeMaker", "A coffee maker on the counter.",
                        "The coffee maker starts brewing."));
        Room livingRoom = new Room("Living Room", "A quiet room with a large window.",
                new Entity("Lamp", "A floor lamp beside the couch.",
                        "The lamp lights up the room."));
        Room bedroom = new Room("Bedroom", "A small room at the top of the stairs.",
                new Entity("Clock", "A clock on the nightstand.",
                        "The clock reads 8:00."));

        foyer.connect("north", kitchen, "south");
        foyer.connect("east", livingRoom, "west");
        foyer.connect("up", bedroom, "down");

        return foyer;
    }
}

class Room {
    private final String name;
    private final String description;

    // Look up connected rooms by direction and objects by name.
    private final Map<String, Room> exits = new LinkedHashMap<>();
    private final Map<String, Entity> entities = new LinkedHashMap<>();

    Room(String name, String description, Entity... roomEntities) {
        this.name = name;
        this.description = description;

        // Use lowercase keys for searches and keep the original names for display.
        for (Entity entity : roomEntities) {
            entities.put(entity.getName().toLowerCase(Locale.ROOT), entity);
        }
    }

    void connect(String direction, Room other, String returnDirection) {
        // Add both exits so the player can return the way they came.
        exits.put(direction, other);
        other.exits.put(returnDirection, this);
    }

    void look() {
        // Use the same display when entering a room or typing look.
        System.out.println("You are in the " + name + ".");
        System.out.println(description);
        System.out.println("Interactable entities:");

        for (Entity entity : entities.values()) {
            System.out.println("  " + entity.getName() + " - " + entity.getDescription());
        }

        System.out.println("Exits: " + String.join(", ", exits.keySet()));
    }

    Room move(String direction) throws InvalidDirectionException {
        if (direction.isEmpty()) {
            throw new InvalidDirectionException("Enter a direction, such as move north.");
        }

        // Match the direction regardless of how the player capitalizes it.
        Room next = exits.get(direction.toLowerCase(Locale.ROOT));
        if (next == null) {
            throw new InvalidDirectionException("There is no exit to the " + direction + " from here.");
        }

        return next;
    }

    String interact(String entityName) throws EntityNotFoundException {
        if (entityName.isEmpty()) {
            throw new EntityNotFoundException("Enter an entity name, such as interact CoatRack.");
        }

        // Search the current room so CoffeeMaker and coffeemaker find the same object.
        Entity entity = entities.get(entityName.toLowerCase(Locale.ROOT));
        if (entity == null) {
            throw new EntityNotFoundException("There is no '" + entityName + "' here to interact with.");
        }

        return entity.interact();
    }
}

// Each object has a name, a description for look, and a response for interact.
class Entity {
    private final String name;
    private final String description;
    private final String response;

    Entity(String name, String description, String response) {
        this.name = name;
        this.description = description;
        this.response = response;
    }

    String getName() {
        return name;
    }

    String getDescription() {
        return description;
    }

    String interact() {
        return response;
    }
}

// Thrown when the player leaves out a direction or the room has no matching exit.
class InvalidDirectionException extends Exception {
    InvalidDirectionException(String message) {
        super(message);
    }
}

// Thrown when the player leaves out an object name or the object is absent.
class EntityNotFoundException extends Exception {
    EntityNotFoundException(String message) {
        super(message);
    }
}