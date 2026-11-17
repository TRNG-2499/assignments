import java.util.ArrayList;

/// a house is just a bunch of rooms
class HouseBuilder {
    private ArrayList<Room> roomArrayList;
    public HouseBuilder(Room initRoom) {
        roomArrayList.add(initRoom)
    }
}


class roomException extends Exception {
    roomException(String msg) {
        super(msg);
    }
}

class nullRoomException extends roomException {
    nullRoomException(Room room) {

    }
}