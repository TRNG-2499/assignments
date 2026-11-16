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
        System.out.println("Welcome to the house");
        String input = scan.nextLine();
        String [] s = input.split(" ");
        while(true) {
        if (input.equalsIgnoreCase("look") ){

        }
        else if (input.equalsIgnoreCase("exit")) {
            System.out.println("Thanks for visiting! Goodbye.");
            break;
        }
        switch(input) {
            case "move":
                if (input.length() > 1) {
                    String dir = s[1];

                }
            case "interact":


            
        }
        input = scan.nextLine();
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
}