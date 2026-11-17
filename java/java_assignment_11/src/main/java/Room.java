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
        } catch (DirectionExceptions.directionTakenException e) {
            System.out.println("directionTakenException: " + e.getMessage());
        } catch (DirectionExceptions.directionException e) {
            System.out.println("directionException: " + e.getMessage());
        }
    }

    private void processConnection(Room otherRoom, Direction direction) throws DirectionExceptions.directionException {
        if(this.exits.containsKey(direction)) {
            throw new DirectionExceptions.directionTakenException(direction);
        }
        if (Arrays.stream(Direction.values()).anyMatch(direction::equals) != true) {
            throw new DirectionExceptions.invalidDirectionException(direction);
        }
        if (direction == null) {
            throw new DirectionExceptions.nullDirectionException();
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

    /// returns the room through the given exit
    /// @throws noExitException if this room has no exit that way
    Room move(Direction dir) throws DirectionExceptions.noExitException {
        Room next = exits.get(dir);
        if (next == null) {
            throw new DirectionExceptions.noExitException(dir);
        }
        return next;
    }

    /// finds an entity in this room by name, ignoring case
    /// @throws entityNotFoundException if no entity has that name
    Entity findEntity(String name) throws RoomExceptions.entityNotFoundException {
        for (Entity entity : entities) {
            if (entity.getName().equalsIgnoreCase(name)) {
                return entity;
            }
        }
        throw new RoomExceptions.entityNotFoundException(name);
    }

    /// the text shown whenever the player enters or looks around this room
    String describe() {
        ArrayList<String> names = new ArrayList<>();
        for (Entity entity : entities) {
            names.add(entity.getName());
        }
        return "You are in the " + Name + ".\n"
             + Description + "\n"
             + "Interactable entities: " + (names.isEmpty() ? "none" : String.join(", ", names));
    }
}
