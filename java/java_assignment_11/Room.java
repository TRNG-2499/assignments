import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * A location in the house (Pattern A: one data-driven Room class).
 * Switch to an abstract class with subclasses if you want Pattern B.
 */
public class Room {

    private final String name;
    private final String description;
    private final Map<String, Room> exits = new LinkedHashMap<>();
    private final List<Entity> entities = new ArrayList<>();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);

    }

    /**
     * Connects this room to another in the given direction, and connects the
     * other room back in the opposite direction so exits are always two-way.
     */
    public void connect(String direction, Room other) {
        this.exits.put(direction.toLowerCase(), other);
        other.exits.put(opposite(direction).toLowerCase(), this);
    }

    /** Returns the room in the given direction (case-insensitive). */
    public Room getExit(String direction) throws InvalidDirectionException {
        Room next = exits.get(direction.toLowerCase());
        if (next == null) {
            throw new InvalidDirectionException(direction);
        }
        return next;

    }

    /** Finds an entity in this room by name (case-insensitive). */
    public Entity findEntity(String entityName) throws EntityNotFoundException {
        for (Entity e : entities) {
            if (e.getName().equalsIgnoreCase(entityName)) {
                return e;
            }
        }
        throw new EntityNotFoundException(entityName);
    }

    /** Builds the text shown when entering the room or using "look". */
    public String describe() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < entities.size(); i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(entities.get(i).getName());
        }
        return "You are in the " + name + ".\n" + description + "\n" + "Interactable Entities: " + sb;
    }

    private static String opposite(String direction) {

        return switch (direction.toLowerCase()) {
            case "north" -> "south";
            case "south" -> "north";
            case "west" -> "east";
            case "east" -> "west";
            case "up" -> "down";
            case "down" -> "up";
            default -> throw new IllegalArgumentException(
                    "This direction " + direction + " doesn't exist. Choose a value direction.");
        };
    }
}
