import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    private String name;
    private String description;
    private Map<String, Room> exits = new HashMap<>();
    private List<Entity> entities = new ArrayList<>();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }

    // connects both ways so exits are always consistent
    public void connect(String direction, Room other) {
        exits.put(direction, other);
        other.exits.put(opposite(direction), this);
    }

    public Room getExit(String direction) throws InvalidDirectionException {
        Room next = exits.get(direction);
        if (next == null) {
            throw new InvalidDirectionException(direction);
        }
        return next;
    }

    public Entity findEntity(String entityName, String action) throws EntityNotFoundException {
        for (Entity entity : entities) {
            if (entity.getName().equalsIgnoreCase(entityName)) {
                return entity;
            }
        }
        throw new EntityNotFoundException(entityName, action);
    }

    public void show() {
        System.out.println("You are in the " + name + ".");
        System.out.println(description);

        String names = "none";
        if (!entities.isEmpty()) {
            List<String> list = new ArrayList<>();
            for (Entity entity : entities) {
                list.add(entity.getName());
            }
            names = String.join(", ", list);
        }
        System.out.println("Interactable entities: " + names);
    }

    private static String opposite(String direction) {
        switch (direction) {
            case "north": return "south";
            case "south": return "north";
            case "east": return "west";
            case "west": return "east";
            case "up": return "down";
            case "down": return "up";
            default:
                throw new IllegalArgumentException("Unknown direction: " + direction);
        }
    }
}