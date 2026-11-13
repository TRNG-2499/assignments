import java.util.Map;

import javax.swing.text.html.parser.Entity;


public class House {
    private static final Map<String, String> OPPOSITE = Map.of (
        "north", "south", "south", "north",
        "east", "west", "west", "east",
        "up", "down", "down", "up"
    );

    public static Room build(){
        Room foyer = new Room("Foyer", "A bright entryway with a tiled floor. Stairs lead up, and doorways open north and east.");
        Room kitchen = new Room("Kitchen", "A spacious kitchen with a large island and modern appliances.");
        Room livingRoom = new Room("Living Room",
                "A cozy room with soft lamps and a big rug.");
        Room bedroom = new Room("Bedroom",
                "A quiet upstairs bedroom with curtains drawn halfway.");
        Room basement = new Room("Basement",
                "A cool, dim basement with a concrete floor. Something hums in the corner.");

        foyer.addEntity(new Entity("CoatRack", "a wooden rack with a raincoat hanging on it",
                "You check the raincoat's pockets and find a crumpled bus ticket."));
        foyer.addEntity(new Entity("Mirror", "a tall mirror in a brass frame",
                "You look in the mirror. Your reflection looks ready for adventure."));

        kitchen.addEntity(new Entity("CoffeeMaker", "a coffee maker with a full pot",
                "You pour a cup of coffee. It's still hot."));
        kitchen.addEntity(new Entity("Fridge", "a humming white fridge covered in magnets",
                "You open the fridge: milk, leftover pizza and a single lemon."));

        livingRoom.addEntity(new Entity("Couch", "a soft green couch",
                "You sink into the couch and find 35 cents between the cushions."));
        livingRoom.addEntity(new Entity("Television", "an old TV with a remote on top",
                "You turn on the TV. A cooking show is halfway through a cake recipe."));

        bedroom.addEntity(new Entity("Bed", "a neatly made bed",
                "You sit on the bed. It creaks loudly."));
        bedroom.addEntity(new Entity("Wardrobe", "a tall oak wardrobe",
                "You open the wardrobe. A row of sweaters, and a flashlight on the shelf."));

        basement.addEntity(new Entity("Furnace", "an old furnace, humming steadily",
                "You hold your hands near the furnace. It's pleasantly warm."));
        basement.addEntity(new Entity("Toolbox", "a red metal toolbox",
                "You open the toolbox: a hammer, screwdrivers and a tape measure."));

        connect(foyer, "north", kitchen);
        connect(foyer, "east", livingRoom);
        connect(foyer, "up", bedroom);
        connect(kitchen, "down", basement);

        return foyer;
    }

    public static void connect(Room from, String direction, Room to){
        from.setExit(direction, to);
        to.setExit(OPPOSITE.get(direction), from);
    }

}
