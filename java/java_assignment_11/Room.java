import java.util.ArrayList;
import java.util.Map;
import java.util.EnumMap;

//The base class for the 'Room' class hierarchy
enum Direction {
    NORTH, SOUTH, EAST, WEST, UP, DOWN;
}

public class Room {
    private static String Name = "room name";
    private static String Description = "room description";
    private static ArrayList<Entity> entities = new ArrayList<>();
    private final Map<Direction, Room> exits = new EnumMap<>(Direction.class);

    public Room(String name, String description) {
        this.Name = name;
        this.Description = description;
    }

    private Direction oppositeDir(Direction dir) {
        return switch(dir) {
            case Direction.UP -> Direction.DOWN;
            case Direction.DOWN -> Direction.UP;
            case Direction.EAST -> Direction.WEST;
            case Direction.WEST -> Direction.EAST;
            case Direction.NORTH -> Direction.SOUTH;
            case Direction.SOUTH -> Direction.NORTH;
            case null, default -> null;
        };
    }

    //connects one room to another
    public void connectRoom(Room otherRoom, Direction direction) {
        exits.put(direction, otherRoom);
        otherRoom.exits.put(direction, this);
    }

    //prints every exit from this room and the room it leads to
    public void listConnectedRooms() {
        if (exits.isEmpty()) {
            System.out.println(getName() + " has no exits.");
            return;
        }
        for (Map.Entry<Direction, Room> exit : exits.entrySet()) {
            Direction dir = exit.getKey();
            Room otherRoom = exit.getValue();
            System.out.println(getName() + " connects " + dir.name().toLowerCase() + " to " + otherRoom.getName());
        }
    }

    public static String getName() {
        return Name;
    }

    public static String getDescription() {
        return Description;
    }

    public static ArrayList<Entity> getEntities() {
        return entities;
    }

    public static void addEntityList(ArrayList<Entity> entities_) {
        entities = entities_;
    }

    public static void addEntities(Entity obj) {
        entities.add(obj);
    }
}