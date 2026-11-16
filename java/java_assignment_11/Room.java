import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;





public class Room {
    String name;
    String description;
    Map<String, Room> exits;
    List<Entity> entities;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.exits = new HashMap<>();
        this.entities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setExit(String direction, Room room) {
        exits.put(direction.toLowerCase(), room);
    }

    public Room getExit(String direction) {
        return exits.get(direction.toLowerCase());
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public Entity getEntity(String entityName) throws EntityNotFoundException {
        for (Entity entity : entities) {
            if (entity.getName().equalsIgnoreCase(entityName)) {
                return entity;
            }
        }
        throw new EntityNotFoundException("Error: There is no '" + entityName + "' here to interact with.");
    }

    public void displayRoom() {
        System.out.println("You are in the " + name + ".");
        System.out.println(description);
        
        if (!entities.isEmpty()) {
            System.out.print("Interactable entities: ");
            for (int i = 0; i < entities.size(); i++) {
                System.out.print(entities.get(i).getName());
                if (i < entities.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        } else {
            System.out.println("Interactable entities: None");
        }
    }
}