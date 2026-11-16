import java.util.Scanner;



public class HomeTour {
    private Room currentRoom;
    private boolean running;

    public HomeTour() {
        buildHouse();
        this.running = true;
    }

    private void buildHouse() {
        Room foyer = new Room("Foyer", "A small entryway with a coat rack and a stairway leading up.");
        Room kitchen = new Room("Kitchen", "A bright kitchen with the smell of fresh coffee.");
        Room livingRoom = new Room("LivingRoom", "A cozy room with a comfortable sofa and a bookshelf.");
        Room bedroom = new Room("Bedroom", "A quiet upstairs room featuring a large bed and a nightstand.");


        foyer.setExit("north", kitchen);
        kitchen.setExit("south", foyer);

        foyer.setExit("east", livingRoom);
        livingRoom.setExit("west", foyer);

        livingRoom.setExit("north", bedroom);
        bedroom.setExit("south", livingRoom);


        foyer.addEntity(new Entity("CoatRack", "An old raincoat hanging on it.", "You check the CoatRack. There's an old raincoat hanging on it."));
        
        kitchen.addEntity(new Entity("CoffeeMaker", "A gleaming machine brewing fresh coffee.", "You pour yourself a cup of hot, fresh coffee. Delicious!"));
        kitchen.addEntity(new Entity("Refrigerator", "A stainless steel fridge hums quietly.", "You open the refrigerator. It's stocked with snacks and cold drinks."));
        
        livingRoom.addEntity(new Entity("Bookshelf", "Packed with dusty adventure novels.", "You scan the bookshelf and pull out a leather-bound volume on ancient history."));
        
        bedroom.addEntity(new Entity("Bed", "A neatly made queen-sized bed.", "You sit on the bed. It feels very soft and comfortable."));


        this.currentRoom = foyer;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        
        currentRoom.displayRoom();
        System.out.println();

        while (running) {
            System.out.print("Enter a command: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            }

            String[] parts = input.split("\\s+", 2);
            String command = parts[0].toLowerCase();
            String argument = parts.length > 1 ? parts[1].trim() : "";

            switch (command) {
                case "exit":
                case "quit":
                    System.out.println("Thanks for visiting! Goodbye.");
                    running = false;
                    break;

                case "look":
                    currentRoom.displayRoom();
                    break;

                case "move":
                    try {
                        if (argument.isEmpty()) {
                            System.out.println("Error: Specify a direction to move (e.g., move north).");
                            break;
                        }
                        Room nextRoom = currentRoom.getExit(argument);
                        if (nextRoom == null) {
                            throw new InvalidDirectionException("Error: There is no exit to the " + argument + " from here.");
                        }
                        currentRoom = nextRoom;
                        currentRoom.displayRoom();
                    } catch (InvalidDirectionException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "interact":
                    try {
                        if (argument.isEmpty()) {
                            System.out.println("Error: Specify an entity to interact with (e.g., interact CoatRack).");
                            break;
                        }
                        Entity entity = currentRoom.getEntity(argument);
                        System.out.println(entity.interact());
                    } catch (EntityNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Unknown command. Valid commands: move [direction], look, interact [entity], exit");
                    break;
            }
            System.out.println();
        }
        scanner.close();
    }

    public static void main(String[] args) {
        HomeTour tour = new HomeTour();
        tour.start();
    }
}