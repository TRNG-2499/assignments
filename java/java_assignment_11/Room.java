import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Room {
    public static final List<String> VALID_DIRECTIONS =
            List.of("north", "south", "east", "west", "up", "down");

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

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    void setExit(String direction, Room room) {
        exits.put(direction.toLowerCase(), room);
    }

    public Room getExit(String direction) throws InvalidDirectionException {
        String dir = direction.toLowerCase();

        if (!VALID_DIRECTIONS.contains(dir)) {
            throw new InvalidDirectionException("\"" + direction + "\" is not a direction. "
                    + "Try north, south, east, west, up or down.");
        }

        Room next = exits.get(dir);
        if (next == null) {
            throw new InvalidDirectionException("You can't go " + dir + " from the " + name
                    + ". Exits: " + String.join(", ", exits.keySet()) + ".");
        }
        return next;
    }

    public Entity findEntity(String entityName) throws EntityNotFoundException {
        for (Entity entity : entities) {
            if (entity.getName().equalsIgnoreCase(entityName)) {
                return entity;
            }
        }
        throw new EntityNotFoundException("There is no \"" + entityName + "\" in the " + name + ".");
    }

    public String describe() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=== ").append(name).append(" ===\n");
        sb.append(description).append("\n");

        if (entities.isEmpty()) {
            sb.append("There is nothing here to interact with.\n");
        } else {
            sb.append("You see:\n");
            for (Entity entity : entities) {
                sb.append("  - ").append(entity.getName())
                  .append(": ").append(entity.getDescription()).append("\n");
            }
        }

        sb.append("Exits: ").append(String.join(", ", exits.keySet()));
        return sb.toString();
    }
    
}
