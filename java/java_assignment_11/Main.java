import java.util.Scanner;

public class Main {

    static Room currentRoom;

    public static void main(String[] args) {

        Room kitchen = new Room("Kitchen", "A small kitchen with a coffee maker.",
            new Entity[] { new Entity("CoffeeMaker", "You make a fresh cup of coffee.") });
        Room dining = new Room("Dining", "A dining room with a table set for dinner.",
            new Entity[] { new Entity("Table", "You take a seat at the dining table.") });
        Room living = new Room("Living", "A cozy living room with a sofa.",
            new Entity[] { new Entity("Sofa", "You sit on the sofa and relax.") });
        Room bedroom = new Room("Bedroom", "A quiet bedroom with a comfortable bed.",
            new Entity[] { new Entity("Bed", "You rest on the comfortable bed.") });

        kitchen.addExit("east", dining);
        dining.addExit("west", kitchen);
        dining.addExit("east", living);
        living.addExit("west", dining);
        living.addExit("north", bedroom);
        bedroom.addExit("south", living);

        currentRoom = kitchen;

        System.out.println("Welcome to the home tour!");
        System.out.println("Commands: move [direction], look, interact [entity name], exit / quit");
        currentRoom.look();

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            while (running) {
                System.out.print("\nEnter a command: ");

                if (!scanner.hasNextLine()) {
                    break;
                }

                String input = scanner.nextLine();
                String[] parts = input.split(" ");
                String command = parts[0].toLowerCase();

                try {
                    switch (command) {
                        case "move":
                            if (parts.length < 2) {
                                System.out.println("Use: move [direction]");
                            } else {
                                move(parts[1]);
                            }
                            break;
                        case "look":
                            currentRoom.look();
                            break;
                        case "interact":
                            if (parts.length < 2) {
                                System.out.println("Use: interact [entity name]");
                            } else {
                                Entity entity = currentRoom.getEntity(parts[1]);
                                System.out.println(entity.interact());
                            }
                            break;
                        case "exit":
                        case "quit":
                            running = false;
                            break;
                        default:
                            System.out.println("Unknown command. Use move, look, interact, exit, or quit.");
                    }
                } catch (InvalidDirectionException | EntityNotFoundException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }

        System.out.println("Thanks for visiting! Goodbye.");
        
        
    }


    public static void move(String direction) throws InvalidDirectionException {
        currentRoom = currentRoom.getExit(direction);
        currentRoom.look();
    }
}
