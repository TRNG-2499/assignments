import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/// a house is just a bunch of rooms
class HouseBuilder {
    private final ArrayList<Room> roomArrayList = new ArrayList<>();
    private final Room startingRoom;
    private final Direction defaultExit;   // the direction the starting room connects out of

    /**
     * new HouseBuilder()                       -> starts with a default empty room, default exit NORTH
     * new HouseBuilder(Direction.EAST)         -> starts with a default empty room, default exit EAST
     * new HouseBuilder("Foyer", "A small...")  -> builds the first room from a name and description
     * new HouseBuilder(someRoom)               -> starts with the given room
     **/
    public HouseBuilder() {
        this(Direction.NORTH);
    }

    public HouseBuilder(Direction defaultExit) {
        this(new Room("Empty Room", "An empty room with nothing in it."), defaultExit);
    }

    public HouseBuilder(String name, String description) {
        this(new Room(name, description), Direction.NORTH);
    }

    public HouseBuilder(Room firstRoom) {
        this(firstRoom, Direction.NORTH);
    }

    public HouseBuilder(Room firstRoom, Direction defaultExit) {
        this.startingRoom = firstRoom;
        this.defaultExit = defaultExit;
        try {
            checkRoom(firstRoom);
            roomArrayList.add(firstRoom);
        } catch (RoomExceptions.roomException e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }

    public ArrayList<Room> getRoomArrayList() { return roomArrayList; }
    public Room getStartingRoom() { return startingRoom; }
    public Direction getDefaultExit() { return defaultExit; }

    /// adds a room connected to the starting room through its default exit
    /// @param room - the new room
    public void addRoom(Room room) {
        try {
            if (startingRoom.getExits().containsKey(defaultExit)) {
                throw new HouseExceptions.houseOccupiedException();
            }
            addRoom(room, startingRoom, defaultExit);
        } catch (HouseExceptions.houseException e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }

    /// adds a room connected to an existing room
    /// @param room - the new room
    /// @param connectedRoom - a room already in the house
    /// @param dir - the direction you travel from connectedRoom to reach the new room
    public void addRoom(Room room, Room connectedRoom, Direction dir) {
        try {
            checkRoom(room);
            roomArrayList.add(room);
            connectedRoom.connectRoom(room, dir);
        } catch (RoomExceptions.roomException e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }

    private void checkRoom(Room room) throws RoomExceptions.roomException {
        if (room == null) {
            throw new RoomExceptions.nullRoomException();
        }
        if (roomArrayList.contains(room)) {
            throw new RoomExceptions.takenRoomException(room);
        }
    }

    /// cycles through connected rooms recursively
    /// whilst adding them to a house's layout
    /// @param room - the room to start from
    public void addAllConnectedRooms(Room room) {
        addAllConnectedRooms(room, new HashSet<>());
    }

    /// visited stops the recursion from looping forever, since every exit
    /// has a way back (Kitchen -> Bedroom -> Kitchen -> ...)
    private void addAllConnectedRooms(Room room, Set<Room> visited) {
        if (room == null || !visited.add(room)) {   // add() returns false if already visited
            return;
        }
        if (!roomArrayList.contains(room)) {
            roomArrayList.add(room);
        }
        for (Room nextRoom : room.getExits().values()) {
            addAllConnectedRooms(nextRoom, visited);
        }
    }

    public void printRooms() {
        for (Room room : roomArrayList) {
            System.out.println("Room: " + room.getName());
            if (room.getExits().isEmpty()) {
                System.out.println("  (no exits)");
            }
            room.getExits().forEach((direction, otherRoom) ->
                System.out.println("  " + direction.name().toLowerCase() + " -> " + otherRoom.getName())
            );
            ArrayList<String> names = new ArrayList<>();
            for (Entity entity : room.getEntities()) {
                names.add(entity.getName());
            }
            System.out.println("  items: " + (names.isEmpty() ? "(none)" : String.join(", ", names)));
        }
    }
}
