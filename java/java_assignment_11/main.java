import java.util.Scanner;
import java.util.Random;

class Main {

    public static void main(String[] args) {
        Entity slotMachine = new SlotMachine();
        SlotMachine.interact();
        Room kitchen, bedroom, bathroom, livingRoom, basement;
        kitchen = new Room("Kitchen", "The Kitchen");
        basement = new Room("Basement", "The Basement");
        bedroom = new Room("Bedroom", "The Bedroom");
        bathroom = new Room("Bathroom", "The Bathroom");
        livingRoom = new Room("Living Room", "The Living Room");

        kitchen.connectRoom(bedroom, Direction.EAST);
        bedroom.connectRoom(basement, Direction.DOWN);
        kitchen.connectRoom(livingRoom, Direction.SOUTH);
        bedroom.connectRoom(bathroom, Direction.EAST);


        HouseBuilder houseBuilder = new HouseBuilder();
        houseBuilder.addAllConnectedRooms(kitchen);

        houseBuilder.printRooms();
    }

}
