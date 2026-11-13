package com.revature;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Room currentRoom = buildHouse();
        // stretch goal 1
        List<Entity> inventory = new ArrayList<>();

        currentRoom.display();

        boolean running = true;
        while (running) {
            System.out.println();
            System.out.print("Enter a command: ");
            // stops cleanly if input ends (Ctrl+Z / Ctrl+D) instead of crashing on nextLine
            if (!scanner.hasNextLine()) {
                break;
            }

            // split into the command word and everything after it, so "move north" -> "move", "north"
            String[] parts = scanner.nextLine().trim().split("\\s+", 2);
            String command = parts[0].toLowerCase();
            String argument = parts.length > 1 ? parts[1] : "";

            if (argument.isEmpty() && (command.equals("move") || command.equals("interact")
                    || command.equals("take"))) {
                System.out.println("Error: '" + command + "' needs a target, like 'move north' or 'interact CoatRack'");
                continue;
            }

            // the try is inside the loop, so a bad command only ends that command, not the whole game
            try {
                switch (command) {
                    case "move":
                        currentRoom = currentRoom.getExit(argument);
                        currentRoom.display();
                        break;
                    case "look":
                        currentRoom.display();
                        break;
                    case "interact":
                        System.out.println(findEntity(argument, currentRoom, inventory).interact());
                        break;
                    case "take":
                        // stretch goal 1
                        takeItem(argument, currentRoom, inventory);
                        break;
                    case "inventory":
                        // stretch goal 1
                        showInventory(inventory);
                        break;
                    case "exit":
                    case "quit":
                        System.out.println("Thanks for stopping by");
                        running = false;
                        break;
                    default:
                        System.out.println("Unknown command, try: move, look, interact, take, inventory, or quit");
                }
            } catch (InvalidDirectionException | EntityNotFoundException | ItemNotTakeableException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }

    // normal solution
    // builds every room and returns the one the player starts in
    public static Room buildHouse() {
        Room foyer = new Room("Foyer", "A small entryway with a coat rack and a stairway leading up");
        Room kitchen = new Room("Kitchen", "A bright kitchen with the smell of fresh coffee");
        Room livingRoom = new Room("Living Room", "A cozy room with a worn couch facing the TV");
        Room bedroom = new Room("Bedroom", "A quiet bedroom at the top of the stairs");

        foyer.connect("north", kitchen);
        foyer.connect("east", livingRoom);
        foyer.connect("up", bedroom);

        foyer.addEntity(new Entity("CoatRack", "A wooden coat rack by the door",
                "You check the CoatRack, there's an old raincoat hanging on it", false));
        foyer.addEntity(new Entity("Umbrella", "A black umbrella",
                "You open the Umbrella, luckily it isn't raining inside", true));

        kitchen.addEntity(new Entity("CoffeeMaker", "A coffee maker on the counter",
                "You press the button on the CoffeeMaker, it gurgles and starts brewing", false));
        kitchen.addEntity(new Entity("Refrigerator", "A tall, humming refrigerator",
                "You open the Refrigerator, there's milk, eggs, and some leftover pizza", false));
        kitchen.addEntity(new Entity("Mug", "A plain white coffee mug",
                "You look into the Mug, it's empty but still warm", true));

        livingRoom.addEntity(new Entity("Couch", "A worn but comfortable couch",
                "You sit on the Couch, it's even comfier than it looks", false));
        livingRoom.addEntity(new Entity("Remote", "A TV remote",
                "You press the power button on the Remote, the TV flickers on to a cooking show", true));

        bedroom.addEntity(new Entity("Bed", "A neatly made bed",
                "You sit on the Bed, it's tempting to take a nap", false));
        bedroom.addEntity(new Entity("Book", "A mystery novel",
                "You flip through the Book, someone left a bookmark halfway through", true));

        return foyer;
    }

    // stretch goal 1
    // carried items can still be used after leaving their room, so the inventory is checked before the room
    public static Entity findEntity(String entityName, Room room, List<Entity> inventory)
            throws EntityNotFoundException {
        for (Entity item : inventory) {
            if (item.getName().equalsIgnoreCase(entityName)) {
                return item;
            }
        }
        return room.findEntity(entityName);
    }

    // stretch goal 1
    public static void takeItem(String entityName, Room room, List<Entity> inventory)
            throws EntityNotFoundException, ItemNotTakeableException {
        Entity item = room.findEntity(entityName);
        if (!item.isTakeable()) {
            throw new ItemNotTakeableException(item.getName());
        }
        // removed from the room so it can't be taken twice and no longer shows up in look
        room.removeEntity(item);
        inventory.add(item);
        System.out.println("You take the " + item.getName());
    }

    // stretch goal 1
    public static void showInventory(List<Entity> inventory) {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
            return;
        }
        System.out.println("You are carrying:");
        for (Entity item : inventory) {
            System.out.println("  " + item.getName() + " - " + item.getDescription());
        }
    }
}
