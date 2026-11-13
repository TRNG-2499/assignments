import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class Room {

    private String name;
    private String description;
    private Map<String, Room> exits;
    private List<Entity> entities;

    public Room(String name, String description){
        this.name = name;
        this.description = description;
        exits = new HashMap<>();
        entities = new ArrayList<>();
    }

    public String getName(){return name;}
    public String getDescription(){return description;}

    //Add directional exits
    public void addExit(String direction, Room room){
        exits.put(direction.trim().toLowerCase(), room);
    }

    //Adding an entity into the room
    public void addEntity(Entity entity){
        entities.add(entity);
    }

    //Moving into another room
    public Room move(String direction) throws InvalidDirectionException {
        
        System.out.println("Attempting to move: " + direction);
        System.out.println("Available exits: " + exits.keySet());
        
        Room nextRoom = exits.get(direction.trim().toLowerCase());
        if(nextRoom == null){
            throw new InvalidDirectionException("There is no exit to the " + direction + " from here.");
        }
        return nextRoom;
    }

    public Entity findEntity(String entityName) throws EntityNotFoundException {
        for(Entity entity : entities){
            if(entity.getName().equalsIgnoreCase(entityName))
                return entity;
        }

        throw new EntityNotFoundException("There is no '" + entityName + "' here to interact with.");
    }

    public void displayRoom(){
        System.out.println("You are in the " + name + ".");
        System.out.println(description);
        System.out.println("Entites: ");

        if(entities.isEmpty()){
            System.out.println("None");
        }
        else{
            for(int i = 0; i < entities.size(); i++){
                System.out.print(entities.get(i).getName());
                
                if(i < entities.size() - 1){
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
