/**
 * Builds the house layout and returns the starting room.
 * Needs at least 4 rooms with consistent two-way exits.
 */
public class House {

    private House() {
    }

    public static Room build() {
        Room foyer = new Room("Foyer", "A small entryway with a coat rack and a stairway leading up.");
        Room kitchen = new Room("Kitchen", "A place to cook meals for a family");
        Room bedroom = new Room("Bedroom", "A place to sleep after a long day of work");
        Room basement = new Room("Basement", "A place to store things that you aren't in need of currently");
        Room mainBathroom = new Room("MainBathroom", "This the bathroom that guests use in the house");

        foyer.addEntity(new Entity("CoatRack", "A wooden coat rack.",
                "You check the CoatRack. There's an old raincoat hanging on it."));
        kitchen.addEntity(new Entity("DishWasher", "You open the DishWasher.", "It's full of dirty dishes."));
        bedroom.addEntity(new Entity("Bed", "You rest on the bed.", "You notice how comfortable the bed is."));
        basement.addEntity(new Entity("WaterHeater",
                "This machine keeps all of your water cool or warm depending on what you need.",
                "You make it so that the WaterHeater makes you water super hot."));
        mainBathroom.addEntity(
                new Entity("Sink", "This is very clean and modern looking sink", "You've cleaned your hands"));

        foyer.connect("west", kitchen);
        bedroom.connect("south", kitchen);
        kitchen.connect("down", basement);
        foyer.connect("north", mainBathroom);

        return kitchen;
    }
}
