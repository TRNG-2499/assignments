public class House {
    private final Room startingRoom;

    public House() {
        Room kitchen = new Room("Kitchen", "A kitchen with modern appliances.");
        Room livingRoom = new Room("Living Room", "A cozy living room with a fireplace.");
        Room bedroom = new Room("Bedroom", "A comfortable bedroom with a large bed.");
        Room foyer = new Room("Foyer", "A small entryway with a coat rack.");

        startingRoom = foyer;
        kitchen.addEntity(new Entity("Fridge", "A large refrigerator", "You open the fridge. It's full of fresh ingredients."));
        livingRoom.addEntity(new Entity("Fireplace", "A warm fireplace", "You feel the warmth from the fireplace."));
        bedroom.addEntity(new Entity("Bed", "A large bed", "You lie down on the bed. It's very comfortable. You feel relaxed."));
        foyer.addEntity(new Entity("CoatRack", "A sturdy wooden rack", "You check the CoatRack. There's an old raincoat hanging on it."));

        //Connect all 4 rooms
        foyer.addExit("north", livingRoom);
        livingRoom.addExit("south", foyer);
        livingRoom.addExit("east", kitchen);
        kitchen.addExit("west", livingRoom);
        kitchen.addExit("north", bedroom);
        bedroom.addExit("south", kitchen);
    }



    public Room getStartingRoom() {
        return startingRoom;
    }
}
