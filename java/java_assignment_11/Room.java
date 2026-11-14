import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private String description;
    private List<Entity> entities = new ArrayList<>();
    private List<Exit> exits = new ArrayList<>();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addEntity(Entity entity) {
        this.entities.add(entity);
    }

    // overloaded method to handle adding an exit easily
    public void addExit(String direction, Room destination) {
        this.exits.add(new Exit(direction, destination));
    }

    public String getName() { 
        return  name; 
    }

    public String getDescription() {
        return description;
    }

   public List<Entity> getEntities() {
    return this.entities;
   }
    public List<Exit> getExits() { 
        return exits; 
    }
}
