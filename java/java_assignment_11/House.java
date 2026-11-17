/**
 * Builds the house layout and returns the starting room.
 * Needs at least 4 rooms with consistent two-way exits.
 */
public class House {

    private House() {
    }

    public static Room build() {
        Room foyer = new Room("Foyer", "A small entryway with a coat rack and a stairway leading up.");
        // TODO: create at least 3 more rooms (e.g. Kitchen, LivingRoom, Bedroom, Basement)

        // TODO: add entities to each room, e.g.
        // foyer.addEntity(new Entity("CoatRack", "A wooden coat rack.",
        //         "You check the CoatRack. There's an old raincoat hanging on it."));

        // TODO: connect rooms, e.g. foyer.connect("north", kitchen);

        return foyer;
    }
}
