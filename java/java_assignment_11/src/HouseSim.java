import java.util.HashMap;
import java.util.Scanner;
import java.util.StringJoiner;

public class HouseSim {
    public static void main(String[] args) {
        Room currentRoom = buildHouse();
        Scanner scanner = new Scanner(System.in);
        describeRoom(currentRoom);

        while (true) {
            System.out.print("\nEnter a command: ");
            if (!scanner.hasNextLine()) {
                break; // input stream closed
            }

            String[] parts = scanner.nextLine().trim().split("\\s+", 2);
            String command = parts[0].toLowerCase();
            String argument = parts.length > 1 ? parts[1].trim() : "";
            try {
                switch (command) {
                    case "move":
                        if (argument.isEmpty()) {
                            System.out.println("Move where? Try: move [north/east/south/west/up/down]");
                            break;
                        }
                        currentRoom = currentRoom.getExit(argument);
                        describeRoom(currentRoom);
                        break;
                    case "look":
                        describeRoom(currentRoom);
                        break;
                    case "interact":
                        if (argument.isEmpty()) {
                            System.out.println("Interact with what? Try: interact [entity name]");
                            break;
                        }
                        System.out.println(currentRoom.findEntity(argument).interact());
                        break;
                    case "exit":
                    case "quit":
                        System.out.println("Thanks for visiting! Goodbye.");
                        scanner.close();
                        return;
                    case "":
                        break; // blank line, just re-prompt
                    default:
                        System.out.println("Unknown command. Try: move [direction], look, interact [entity], exit");
                }
            } catch (InvalidDirectionException | EntityNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static Room buildHouse() {
        Room foyer = new Room("Foyer",
                "A small entryway with a coat rack and a stairway leading up.",
                new HashMap<>(),
                new Entity("CoatRack", "A wooden coat rack by the door.",
                        "You check the coat rack. There's an old raincoat hanging on it."));

        Room kitchen = new Room("Kitchen",
                "A bright kitchen with the smell of fresh coffee.",
                new HashMap<>(),
                new Entity("CoffeeMaker", "A drip coffee maker with a half-full pot.",
                        "You pour a cup from the coffee maker. It's still hot."),
                new Entity("Refrigerator", "A humming stainless steel refrigerator.",
                        "You open the refrigerator. Leftover pizza and a jar of pickles."));

        Room livingRoom = new Room("Living Room",
                "A cozy room with a worn sofa facing a television.",
                new HashMap<>(),
                new Entity("Television", "A flat-screen TV mounted on the wall.",
                        "You turn on the television. A cooking show is playing."),
                new Entity("Bookshelf", "A tall bookshelf crammed with paperbacks.",
                        "You browse the bookshelf. Mostly mystery novels, all well-read."));

        Room bedroom = new Room("Bedroom",
                "A quiet upstairs bedroom with a neatly made bed.",
                new HashMap<>(),
                new Entity("Lamp", "A small bedside lamp.",
                        "You click the lamp on. The room fills with warm light."),
                new Entity("Dresser", "A dresser with a mirror on top.",
                        "You open the dresser. Socks, sorted by color."));

        Room basement = new Room("Basement",
                "A cool, dim basement that smells faintly of laundry detergent.",
                new HashMap<>(),
                new Entity("Washer", "A dusty washing machine.",
                        "You peek inside the washer. Someone forgot a load of towels."));

        connect(foyer, Room.Exit.NORTH, kitchen, Room.Exit.SOUTH);
        connect(foyer, Room.Exit.EAST, livingRoom, Room.Exit.WEST);
        connect(foyer, Room.Exit.UP, bedroom, Room.Exit.DOWN);
        connect(kitchen, Room.Exit.DOWN, basement, Room.Exit.UP);

        return foyer;
    }

    private static void connect(Room from, Room.Exit direction, Room to, Room.Exit opposite) {
        from.exits.put(direction, to);
        to.exits.put(opposite, from);
    }

    private static void describeRoom(Room room) {
        System.out.println("You are in the " + room.name + ".");
        System.out.println(room.description);

        StringBuilder names = new StringBuilder();
        for (Entity entity : room.entities) {
            names.append(entity.name).append(", ");
        }
        System.out.println("Interactable entities: " + names);
    }
}
