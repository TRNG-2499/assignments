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
        // TODO: add the entity to this room
    }

    /**
     * Connects this room to another in the given direction, and connects the
     * other room back in the opposite direction so exits are always two-way.
     */
    public void connect(String direction, Room other) {
        // TODO: put other in exits under direction (lowercase)
        // TODO: put this in other's exits under opposite(direction)
    }

    /** Returns the room in the given direction (case-insensitive). */
    public Room getExit(String direction) throws InvalidDirectionException {
        // TODO: look up direction.toLowerCase(); throw InvalidDirectionException if missing
        return null;
    }

    /** Finds an entity in this room by name (case-insensitive). */
    public Entity findEntity(String entityName) throws EntityNotFoundException {
        // TODO: loop over entities, compare with equalsIgnoreCase; throw if not found
        return null;
    }

    /** Builds the text shown when entering the room or using "look". */
    public String describe() {
        // TODO: return something like:
        //   You are in the <name>.
        //   <description>
        //   Interactable entities: A, B, C
        return "";
    }

    private static String opposite(String direction) {
        // TODO: north<->south, east<->west, up<->down
        return "";
    }
}
