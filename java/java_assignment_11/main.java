import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class main {
   

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Room kitchen = new Room("There is food here", "Kitchen");
        Room living_room = new Room("The living room has a couch", "Living Room");
        Room bedroom = new Room("This is the bedroom with a King sized bed.", "Bedroom");
        Room dining_room = new Room("Kitchen", "Dining Room");
        Room foyer = new Room("Entranceway of home", "Foyer");
        Entity coffeemachine = new Entity("Make some coffee yum", "You made some black coffee, dont forget to add sugar", "CoffeeMachine");
        Entity microwave = new Entity("Time to cook", "Microwaving hot pockets", "microwave");
        Entity door = new Entity("Home Sweet Home", "Closing the door before heading in", "door");
        Entity tv = new Entity("The TV is showing a football match between US and Haiti", "Switching the station over to the news", "tv");
        Entity bed = new Entity("A very cozy king sized bed", "Time to take a nap", "bed");
        Entity table = new Entity("A dining table to eat", "Let's set up the table", "table");
        foyer.addExit("north", living_room);
        foyer.addExit("east", bedroom);
        living_room.addExit("south", foyer);
        living_room.addExit("west",kitchen);
        kitchen.addExit("east", living_room);
        kitchen.addExit("west", dining_room);
        dining_room.addExit("east", kitchen);
        bedroom.addExit("west",foyer);
        kitchen.addEntity(coffeemachine);
        kitchen.addEntity(microwave);
        foyer.addEntity(door);
        living_room.addEntity(tv);
        bedroom.addEntity(bed);
        dining_room.addEntity(table);
        Room currentRoom = foyer;
        System.out.println("Welcome to the house");
        currentRoom.displayRoom();

        while (true) {
            System.out.print("\nEnter a command: ");
            String input = scan.nextLine().trim();
            if (input.isEmpty()) {
                continue;
            }

            String[] s = input.split("\\s+", 2);
            String command = s[0].toLowerCase();
            String arg = s.length > 1 ? s[1] : "";

            try {
                switch (command) {
                    case "look":
                        currentRoom.displayRoom();
                        break;

                    case "move":
                        if (arg.isEmpty()) {
                            System.out.println("Move where? Try: move north");
                            break;
                        }
                        currentRoom = currentRoom.move(arg);
                        currentRoom.displayRoom();
                        break;

                    case "interact":
                        if (arg.isEmpty()) {
                            System.out.println("Interact with what? Try: interact tv");
                            break;
                        }
                        Entity entity = currentRoom.findEntity(arg);
                        System.out.println(entity.interact());
                        break;

                    case "exit":
                    case "quit":
                        System.out.println("Thanks for visiting! Goodbye.");
                        scan.close();
                        return;

                    default:
                        System.out.println("Unknown command. Try: move, look, interact, exit");
                }
            }
            catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    

    }
}

class Room {
    private String name;
    private String description;
    private HashMap<String, Room> exit;
    private ArrayList<Entity> entities;

    public Room(String description, String name) {
        this.description = description;
        this.name = name;
        this.entities = new ArrayList<>();
        this.exit = new HashMap<>();
    }
    public String getName() {
        return name;
    }

    public void addExit(String direction, Room room) {
        exit.put(direction, room);
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }
     public Room move(String direction) {
        Room next = exit.get(direction.toLowerCase());
        if (next == null) {
            throw new Error("There is no exit to the " + direction + " from here.");
        }
        return next;
    }

    public Entity findEntity(String entityName)  {
        for (Entity e : entities) {
            if (e.getName().equalsIgnoreCase(entityName)) {
                return e;
            }
        }
        throw new Error("There is no '" + entityName + "' here to interact with.");
    }

    public void displayRoom() {
    System.out.println("You are in the " + name + ".");
    System.out.println(description);

    ArrayList<String> names = new ArrayList<>();
    for (Entity e : entities) {
        names.add(e.getName());
    }
    System.out.println("Interactable entities: " + String.join(", ", names));
}
}

class Entity {
    private String name;
    private String description;
    private String response;

    public Entity(String description, String response, String name) {
        this.description = description;
        this.response = response;
        this.name = name;
    }

    public String interact() {
        return response;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
}