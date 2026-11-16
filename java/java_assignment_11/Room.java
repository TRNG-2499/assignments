import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Room {
    private String name;
    private String description;
    private Map<String, Room> directions;
    private List<Entity> objectsInRoom;

    public Room(String name, String description, Map<String, Room> directions, List<Entity> objectsInRoom){
        this.name = name;
        this.description = description;
        this.directions = directions;
        this.objectsInRoom = objectsInRoom;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Room> getDirections() {
        return directions;
    }

    public List<Entity> getObjectsInRoom() {
        return objectsInRoom;
    }

    public List<String> getObjectNames() {
        List<String> objects = new ArrayList<>();
        for(Entity e: objectsInRoom ){
            objects.add(e.getName());
        }
        return objects;
    }
}
