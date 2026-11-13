import java.util.*;

public class Room {
    private Map<String, Room> exits = new HashMap<>();
    private Map<String, Entity> entities = new HashMap<>();
    private Map<String, String> reverseDirection = Map.of(
        "north", "south",
        "south", "north",
        "east", "west",
        "west", "east",
        "up", "down",
        "down", "up"
    );

    private String name;
    private String description;

    public Room(String n, String d){
        this.name = n;
        this.description = d;
    }

    public void addEntity(Entity e){
        entities.put(e.getName().toLowerCase(), e);
    }

    public void addExit(String direction, Room newRoom){
        exits.put(direction.toLowerCase(), newRoom);
        newRoom.addExit(reverseDirection.get(direction.toLowerCase()),this, true);
    }

    public void addExit(String direction, Room newRoom, Boolean isExtension){
        if(isExtension){
            exits.put(direction, newRoom);
        } else {
            addExit(direction, newRoom);
        }
    }

    public String getName(){
        return name;
    }

    public String getEntities(){
        StringBuilder result = new StringBuilder();
        String prefix = "";
        if(!entities.isEmpty()){
            for(Map.Entry<String, Entity> e : entities.entrySet()){
                result.append(prefix);
                prefix = ", ";
                result.append(e.getValue().getName());
            }
        }
        return result.toString();
    }

    public Boolean hasDirection(String direction){
        if(exits.containsKey(direction)){
            return true;
        } else {
            return false;
        }
    }

    public void look(){
        System.out.println(description+"\nInteractable entities: "+this.getEntities());
        
    }

    public void interact(String entity) throws EntityNotFoundException{
        if(entities.containsKey(entity.toLowerCase())){
            System.out.println(entities.get(entity.toLowerCase()).getInteractionResponse());
        } else {
            throw new EntityNotFoundException(entity);
        }
    }

    public Room move(String direction) throws InvalidDirectionException{
        if(this.hasDirection(direction.toLowerCase())){
            return exits.get(direction.toLowerCase());
        } else {
            throw new InvalidDirectionException(direction);
        }
    }
        
    
}
