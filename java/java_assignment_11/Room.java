import java.util.HashMap;
import Entities.Entity;

public abstract class Room {

    // Each subclass gets its own copy of roomDirections which can be
    // individually modified when calling connectRooms()
    private final HashMap<String, Room> roomDirections = new HashMap<>();
    private final HashMap<String, Entity> allEntities = new HashMap<>();

    public abstract String getName();
    public abstract String getDesc();

    // Used to link rooms together
    public void connectRooms(String direction, Room room) {
        roomDirections.put(direction, room);
    }

    public HashMap<String, Room> getRoomDirections() {
        return roomDirections;
    }

    public void addEntities(String entityName, Entity entity) {
        allEntities.put(entityName, entity);
    }

    public HashMap<String, Entity> getEntities() {
        return allEntities;
    }
}
