package java_assignment_11;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Room {
    // Basic properties
    private final String name;
    private final String description;
    private Map<String, Room> exits;
    private List<Entity> entities;

    // Constructor
    public Room(String name, String description){
        this.name = name;
        this.description = description;
        exits = new HashMap<>();
        entities = new ArrayList<>();
    }

    // Getter
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public Room getExit(String direction){
        return exits.get(direction.toLowerCase());
    }
    public Entity getEntity(String entityName) throws EntityNotFoundException{
        for (Entity entity : entities) {
            if (entity.getName().equalsIgnoreCase(entityName)) {
                return entity;
            }
        }
        throw new EntityNotFoundException("Error: There is no " + entityName + " here to interact with.");
    }

    /* Exits */
    public void addExit(String direction, Room room){
        exits.put(direction.toLowerCase(), room);
    }
    

    /* Entities */
    public void addEntity(Entity entity){
        entities.add(entity);
    }
    public List<Entity> getEntities(){
        return entities;
    }

}
