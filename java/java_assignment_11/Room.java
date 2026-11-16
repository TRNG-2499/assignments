import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    private final Map<String, Entity> entities = new HashMap<>();
    private final Map<String, Room> exits = new HashMap<>();
    private final String name;
    private final String description;


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

    public void addExit(String direction, Room room) {
        exits.put(direction.toUpperCase(), room);
    }

    public void addEntity(Entity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
        entities.put(entity.getName().toUpperCase(), entity);
        

    }

    public Room getExit(String direction) throws InvalidDirectionException {
        String key = direction.toUpperCase();
        if (exits.containsKey(key)) {
            return exits.get(key);
        }
        throw new InvalidDirectionException("There is no exit to the " + direction + " from here.");
        
    }

    public Entity findEntity(String name) throws EntityNotFoundException {

        Entity found = entities.get(name.toUpperCase());
        if(found == null) {
            throw new EntityNotFoundException("Entity not found: " + name);
        }
        return found;
    }
    public String describe() {
        List<String> entityNames = new ArrayList<>();
        for (Entity entity : entities.values()) {
            entityNames.add(entity.getName());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("You are in the " + name + ".").append("\n");
        sb.append(description).append("\n");
        sb.append("Exits: ").append(exits.keySet()).append("\n");
        sb.append("Interactable entities: ").append(String.join(", ", entityNames)).append("\n");
        return sb.toString();
        
    }

}
