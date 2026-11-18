import java.util.HashMap;

public class Room {
    String name;
    String description;

    HashMap<String, Room> exits = new HashMap<>();
    Entity[] entities;

    public Room(String name, String description, Entity[] entities){
        this.name = name;
        this.description = description;
        this.entities = entities;
    }

    public void addExit(String direction, Room room) {
        this.exits.put(direction, room);
    }

    public Room getExit(String direction) throws InvalidDirectionException{
        direction = direction.toLowerCase();
        if(!exits.containsKey(direction)) {
            throw new InvalidDirectionException("There is no exit to the " + direction + " from here.");
        } else {
            return exits.get(direction);
        }
    }

    public Entity getEntity(String entityName) throws EntityNotFoundException
    {
        for(Entity entity : entities)
        {

            if(entity.name.equalsIgnoreCase(entityName))
            {
                return entity;
            }
        }
        throw new EntityNotFoundException("There is no " + entityName + " to interact with.");
    }

    public void look() {
        System.out.println(description);
        System.out.println("Interactable entites: ");
        for(Entity entity : entities)
        {
            System.out.println(entity.name);
        }
    }


}
