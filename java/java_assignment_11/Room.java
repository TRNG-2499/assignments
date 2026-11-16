import java.util.ArrayList;
import java.util.HashMap;


public class Room {

    private String name;
    private String description;

    private ArrayList<Entity> entities;
    private HashMap<String, Room> exits;

    public Room(String name, String description){

        this.name = name;
        this.description = description;

        this.entities = new ArrayList<>();
        this.exits = new HashMap<>();

    }

    public void addEntity(Entity entity){
        entities.add(entity);
    }

    public void addExit(String direction ,Room room){
        exits.put(direction, room);
    }

    public Room getExit(String direction) throws InvalidDirectionException{

        Room destination = exits.get(direction);

        if(destination == null){
            throw new InvalidDirectionException("Invalid direction.");
        }

        return destination;

    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public ArrayList<Entity> getEntities(){
        return entities;
    }

    public Entity getEntity(String entityName) throws EntityNotFoundException {
        for (Entity entity: entities){
            if(entity.getName().equalsIgnoreCase(entityName)){
                return entity;
            }
        }
        throw new EntityNotFoundException("Entity not Found");
    }

    
}
