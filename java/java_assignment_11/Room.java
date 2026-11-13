import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    private final String name;
    private final String description;
    private final List<Entity> entities = new ArrayList<>();
    private final Map<String, Room> exits = new HashMap<>();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public String describe() {
        String result = name + ".\n" + description;

        if (entities.isEmpty()) {
            result += "\nNo interactable entities.";
        } else {
            result += "\nInteractable entities:";
            for (Entity entity : entities) {
                result += "\n- " + entity.getName();
            }
        }

        if (exits.isEmpty()) {
            result += "\nNo exits.";
        } else {
            result += "\nExits:";
            for (String direction : exits.keySet()) {
                result += "\n- " + direction;
            }
        }
        return result;
    }

    public Entity getEntity(String name) {
        for (Entity entity : entities) {
            if (entity.getName().toLowerCase().equals(name.toLowerCase())) {
                return entity;
            }
        }
        return null;
    }

    public void addExit(String direction, Room room) {
        exits.put(direction, room);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }
}
