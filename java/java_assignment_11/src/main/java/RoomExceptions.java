/// exceptions for invalid rooms and the entities inside them
/// usage: throw new RoomExceptions.nullRoomException();
class RoomExceptions {

    static class roomException extends Exception {
        roomException(String msg) {
            super(msg);
        }
    }

    static class nullRoomException extends roomException {
        nullRoomException() {
            super("Given instance of Room.class cannot be null");
        }
    }

    static class takenRoomException extends roomException {
        takenRoomException(Room room) {
            super("Room.class object '" + room.getName() + "' already exists within collection");
        }
    }

    static class entityNotFoundException extends roomException {
        entityNotFoundException(String name) {
            super("There is no '" + name + "' here to interact with.");
        }
    }
}
