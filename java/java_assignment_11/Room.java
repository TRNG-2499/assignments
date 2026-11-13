import java.util.Map;
import java.util.HashMap;
import java.util.List;
public class Room {
    private String name;
    private String description;
    private Map <String, Room> exits;
    private List <Entity>entities;

    public Room(String name, String description, List <Entity> entities){
        this.name = name;
        this.description = description;
        this.exits = new HashMap<>();
        this.entities = entities;
    }

    public String getName(){return name;}
    public String getDescription(){return description;}
    public Map <String, Room> getExits(){return exits;}
    public List<Entity> getEntities(){return entities;}

    public void addExit(String direction, Room r){
        exits.put(direction, r);
    }
}
