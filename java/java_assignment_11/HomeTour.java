import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomeTour {
    private static Room currentRoom;
    private static List<Entity> inventory = new ArrayList<>(); 
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        setupWorld();
        displayCurrentRoom();

        while(true) {
            System.out.println("\nEnter a command: ");
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                continue;
            }

            String[] parts = input.split(" ", 2);
            String command = parts[0].toLowerCase();

            try {
                switch(command) {
                    case "move":
                        handleMove(parts.length > 1 ? parts[1].trim() : "");
                        break;
                    case "look":
                        displayCurrentRoom();
                        break;
                    case "interact":
                        handleInteract(parts.length > 1 ? parts[1].trim() : "");
                        break;
                    case "take":
                        handleTake(parts.length > 1 ? parts[1].trim() : "");
                        break;
                    case "inventory":
                        handleInventory();
                        break;
                    case "exit":
                    case "quit":
                        System.out.println("Thanks for visting! Goodbye.");
                        return;
                    default:
                        System.out.println("I don't understand that command.");

                }   
            }
            catch (GameException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void setupWorld() {
        Room foyer = new Room("Foyer", "A small entryway with a coat rack.");
        Room kitchen = new Room("Kitchen", "A bright kitchen smelling of coffee.");
        Room livingRoom = new Room("Living Room", "A cozy room with a large sofa.");
        Room attic = new Room("Attic", "A dusty space filled with old trunks.");

        foyer.addEntity(new Entity("CoatRack", "There's an old raincoat hanging on it.", false));
        foyer.addEntity(new Entity("Key", "A heavy brass key with a rusty handle.", true)); 
        kitchen.addEntity(new  Entity("CoffeeMaker", "It is warm to the touch.", false));
        kitchen.addEntity(new Entity("Refrigerator", "It hums quietly.", false));
        kitchen.addEntity(new Entity("Mug", "A ceramic mug with coffee stains.", true));

        // adding exits 
        foyer.addExit("north", kitchen);
        kitchen.addExit("south", foyer);
        foyer.addExit("east", livingRoom);
        livingRoom.addExit("west", foyer);
        foyer.addExit("up", attic);
        attic.addExit("down", foyer);

        currentRoom = foyer;
    }

    private static void handleMove(String directionInput) {
        if (directionInput.isEmpty()) {
            System.out.println("Please specify a direction.");
            return;
        }

        String direction = directionInput.toLowerCase();
        Room nextRoom = null;

        for (Exit exit : currentRoom.getExits()) {
            if (exit.getDirection().equals(direction)) {
                nextRoom = exit.getDestination();
                break;
            }
        }

        if (nextRoom == null) {
            throw new InvalidDirectionException(direction);
        }

        currentRoom = nextRoom;
        displayCurrentRoom();
    }

    private static void handleInteract(String entityName) {
        if (entityName.isEmpty()) {
            System.out.println("What do you want to interact with?");
            return;
        }

        Entity target = null;

        for (Entity e : currentRoom.getEntities()) {
            if (e.getName().equalsIgnoreCase(entityName)) {
                target = e;
                break;
            }
        }

        if (target == null) {
            for (Entity e : inventory) {
                if (e.getName().equalsIgnoreCase(entityName)) {
                    target = e;
                    break;
                }
            }
        }
        if (target != null) {
            System.out.println(target.interact());
        }
        else {
            throw new EntityNotFoundException(entityName);
        }
    }

    private static void handleTake(String itemName) {
        if (itemName.isEmpty()) return;

        Entity foundItem = null;
        for (Entity e : currentRoom.getEntities()) {
            if (e.getName().equalsIgnoreCase(itemName)) {
                foundItem = e;
                break;
            }
        }

        if (foundItem == null) {
            throw new EntityNotFoundException(itemName);
        }

        if (!foundItem.isTakeable()) {
            System.out.println("You can't pick up that " + foundItem.getName() + "(it's too heavy or part of the room).");
            return;
        }

        currentRoom.getEntities().remove(foundItem);

        inventory.add(foundItem);
        System.out.println("You picked up the " + foundItem.getName() + ".");
    }

    private static void  handleInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        }
        else {
            System.out.println("Items in your possession: ");
            for (int i = 0; i < inventory.size(); i++) {
                System.out.println(inventory.get(i).getName());
                if (i < inventory.size() - 1) System.out.println(",");
            }
            System.out.println();
        }
    }

    private static void displayCurrentRoom() {
        System.out.println("You are in the " + currentRoom.getName() + ".");
        System.out.println(currentRoom.getDescription());
        
        if (!currentRoom.getEntities().isEmpty()) {
            System.out.print("Interactable entities: ");
            for (int i = 0; i < currentRoom.getEntities().size(); i++) {
                System.out.print(currentRoom.getEntities().get(i).getName());
                if (i < currentRoom.getEntities().size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

}
