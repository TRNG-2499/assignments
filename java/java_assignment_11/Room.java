package assignments.java.java_assignment_11;

import java.util.HashMap;

public class Room {

    private String name;
    private String description;
    private HashMap<String, Room> exits;
    private Entity[] entities;

    public Room(String n, String d, HashMap<String, Room> e, Entity[] objs){
        name = n;
        description = d;
        exits = e;
        entities = objs;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public void addExit(String direction, Room room){
        exits.put(direction, room);
    }

    public Room getExit(String direction) throws InvalidDirectionException{
        if (!exits.containsKey(direction)){
            throw new InvalidDirectionException("There is not exit to the "+ direction +" of this room.");
        }
        
        return exits.get(direction);
    }

    public void showEntities(){
        System.out.print("Interactable entities: ");
        System.out.print(entities[0].getName());
        for (int x = 1; x < entities.length; x++){
            System.out.print(", "+entities[x].getName());
        }
        System.out.println();
    }

    public void interactWithEntity(String entity) throws EntityNotFoundException{
        for (Entity e : entities){
            if (e.getName().toLowerCase().equals(entity)){
                System.out.println(e.interact());
                return;
            }
        }
        throw new EntityNotFoundException("There is no interactable entity '"+ entity +"' in this room.");
    }
}
