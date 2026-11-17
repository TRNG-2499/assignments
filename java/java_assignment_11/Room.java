import java.util.ArrayList;
import java.util.Map;
import java.util.EnumMap;
import java.util.Arrays;

public class Room {
    private String Name = "room name";
    private String Description = "room description";
    private ArrayList<Entity> entities = new ArrayList<>();
    private final Map<Direction, Room> exits = new EnumMap<>(Direction.class);

    public String getName() { return Name; }
    public String getDescription() { return Description; }
    public ArrayList<Entity> getEntities() { return entities; }

    public Map<Direction, Room> getExits() { return exits; }

    public void addEntityList(ArrayList<Entity> entities_) { entities = entities_; }
    public void addEntities(Entity obj) { entities.add(obj); }

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

    public void connectRoom(Room otherRoom, Direction dir) {
        try {
            this.processConnection(otherRoom, dir);
        } catch (directionTakenException e) {
            System.out.println("directionTakenException: " + e.getMessage());
        } catch (directionException e) {
            System.out.println("directionException: " + e.getMessage());
        }
    }

    private void processConnection(Room otherRoom, Direction direction) throws directionException {
        if(this.exits.containsKey(direction)) {
            throw new directionTakenException(direction);
        }
        if (Arrays.stream(Direction.values()).anyMatch(direction::equals) != true) {
            throw new invalidDirectionException(direction);
        }
        if (direction == null) {
            throw new nullDirectionException(direction);
        }
            exits.put(direction, otherRoom);
            otherRoom.exits.put(oppositeDir(direction), this);
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
}

class directionException extends Exception {
    directionException(String msg) {
        super(msg);
    }
}

class directionTakenException extends directionException {
    directionTakenException(Direction dir) {
        super("Direction '" + dir.name() + "' already leads to another Room.class instance");
    }
}

class invalidDirectionException extends directionException {
    invalidDirectionException(Direction dir) {
        super("Specified direction '" + dir.name() + "' is not a valid Direction.enum value");
    }
}

class nullDirectionException extends directionException {
    nullDirectionException(Direction dir) {
        super("Specified direction cannot be null");
    }
}