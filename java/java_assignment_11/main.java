import java.util.Scanner;
import java.util.Random;

class Main {

    public static void main(String[] args) {
        Entity slotMachine = new SlotMachine();
        SlotMachine.interact();
        Room Kitchen, Bedroom, Bathroom, LivingRoom, Basement;
        Kitchen = new Room("Kitchen", "The Kitchen");
        Bedroom = new Room("Bedroom", "The Bedroom");
        Bathroom = new Room("Bathroom", "The Bathroom");
        LivingRoom = new Room("Living Room", "The Living Room");
        Kitchen.connectRoom(LivingRoom, Direction.SOUTH);
        LivingRoom.connectRoom(Bedroom, Direction.SOUTH);
        Bedroom.connectRoom(Bathroom, Direction.EAST);
        LivingRoom.listConnectedRoom();

    }

}
