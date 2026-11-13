import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Room {
    private String name;
    private String description;
    private Map<String, Room> exits;
    private List<Entity> entities;

    public Room(String name, String description, List<Entity> entities) {
        this.name = name;
        this.description = description;
        this.entities = entities;
        this.exits = new HashMap<>();
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public List<Entity> getEntities() { return entities; }
    
    public void setExit(String direction, Room room) {
        exits.put(direction.toLowerCase(), room);
    }

    public Room getExit(String direction) throws InvalidDirectionException {
        Room next = exits.get(direction.toLowerCase());
        if (next == null) {
            throw new InvalidDirectionException("Error: There is no exit to the " + direction.toLowerCase() + " from  here.");
        }
        return next;
    }

    public Entity getEntity(String entityName) throws EntityNotFoundException {
        for (Entity e: entities) {
            if (e.getName().equalsIgnoreCase(entityName)) {
                return e;
            }
        }
        throw new EntityNotFoundException("Error: There is no '" + entityName + "' here to interact with.");
    }

    public void display() {
        System.out.println("You are in the " + name + ".");
        System.out.println(description);
        
        if (!entities.isEmpty()) {
            System.out.println("Interactable entities: ");
            for (int i = 0; i < entities.size(); i++) {
                System.out.print(entities.get(i).getName());
                if (i < entities.size() - 1) {
                    System.out.print(", ");
                }
            }
        } else {
            System.out.println("Interactable entities: None");
        }
    }
}