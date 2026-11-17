import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomeTour {
    private static Room currentRoom;
    private static List<Entity> inventory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        currentRoom = buildHouse();
        boolean running = true;

        currentRoom.show();

        while (running) {
            System.out.print("\nEnter a command: ");
            String line = scanner.nextLine().trim().toLowerCase();

            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+", 2);
            String command = parts[0];
            String argument = parts.length > 1 ? parts[1].trim() : "";

            try {
                switch (command) {
                    case "move" -> move(argument);
                    case "look" -> currentRoom.show();
                    case "interact" -> interact(argument);
                    case "take" -> take(argument);
                    case "inventory" -> showInventory();
                    case "exit", "quit" -> {
                        System.out.println("Thanks for visiting! Goodbye.");
                        running = false;
                    }
                    default -> System.out.println("Error: Unknown command '" + command
                            + "'. Try move, look, interact, take, inventory, or exit.");
                }
            } catch (InvalidDirectionException | EntityNotFoundException | NotTakeableException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static void move(String direction) throws InvalidDirectionException {
        if (direction.isEmpty()) {
            System.out.println("Error: Move where? Example: move north");
            return;
        }
        currentRoom = currentRoom.getExit(direction);
        currentRoom.show();
    }

    private static void interact(String name) throws EntityNotFoundException {
        if (name.isEmpty()) {
            System.out.println("Error: Interact with what? Example: interact CoatRack");
            return;
        }
        Entity entity = currentRoom.findEntity(name, "interact with");
        System.out.println(entity.interact());
    }

    private static void take(String name) throws EntityNotFoundException, NotTakeableException {
        if (name.isEmpty()) {
            System.out.println("Error: Take what? Example: take Umbrella");
            return;
        }
        Entity entity = currentRoom.findEntity(name, "take");
        if (!entity.isTakeable()) {
            throw new NotTakeableException(entity.getName());
        }
        currentRoom.removeEntity(entity);
        inventory.add(entity);
        System.out.println("You take the " + entity.getName() + ".");
    }

    private static void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
            return;
        }
        System.out.println("You are carrying:");
        for (Entity item : inventory) {
            System.out.println("- " + item.getName() + ": " + item.getDescription());
        }
    }

    private static Room buildHouse() {
        Room foyer = new Room("Foyer", "A small entryway with a coat rack and a stairway leading up.");
        Room kitchen = new Room("Kitchen", "A bright kitchen with the smell of fresh coffee.");
        Room livingRoom = new Room("LivingRoom", "A cozy room with a big sofa and a TV.");
        Room bedroom = new Room("Bedroom", "A quiet bedroom with soft light coming through the window.");
        Room basement = new Room("Basement", "A cool, dusty basement full of tools.");

        foyer.connect("north", kitchen);
        foyer.connect("east", livingRoom);
        foyer.connect("up", bedroom);
        kitchen.connect("down", basement);

        foyer.addEntity(new Entity("CoatRack", "A sturdy wooden coat rack.",
                "You check the CoatRack. There's an old raincoat hanging on it.", false));
        foyer.addEntity(new Entity("Umbrella", "A black umbrella.",
                "You open the Umbrella. It still works.", true));

        kitchen.addEntity(new Entity("CoffeeMaker", "A shiny coffee maker.",
                "You press the button and fresh coffee starts brewing.", false));
        kitchen.addEntity(new Entity("Refrigerator", "A tall silver refrigerator.",
                "You open the Refrigerator. There is milk, eggs, and leftover pizza.", false));
        kitchen.addEntity(new Entity("Apple", "A red apple.",
                "You polish the Apple on your sleeve.", true));

        livingRoom.addEntity(new Entity("Sofa", "A big comfy sofa.",
                "You sink into the Sofa. Very comfortable.", false));
        livingRoom.addEntity(new Entity("Television", "A large flat-screen TV.",
                "You turn on the Television. A cooking show is playing.", false));
        livingRoom.addEntity(new Entity("Remote", "A TV remote control.",
                "You press a few buttons on the Remote. The volume goes up.", true));

        bedroom.addEntity(new Entity("Bed", "A neatly made bed.",
                "You sit on the Bed. It is soft and warm.", false));
        bedroom.addEntity(new Entity("Book", "A worn paperback novel.",
                "You flip through the Book. The bookmark is on page 212.", true));

        basement.addEntity(new Entity("Workbench", "A heavy workbench covered in tools.",
                "You look over the Workbench. Everything is neatly organized.", false));
        basement.addEntity(new Entity("Flashlight", "A small flashlight.",
                "You click the Flashlight on and off. It works.", true));

        return foyer;
    }
}