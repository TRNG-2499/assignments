import java.util.Scanner;
import java.util.Arrays;

public class House {
    public static void main(String[] args) {
        Entity coatRack = new Entity("CoatRack", "An old coat rack", "You check the CoatRack. There's an old raincoat hanging on it.");
        Entity coffeeMaker =  new Entity("CoffeeMaker", "An old coffee maker", "You try using the coffee maker but it breaks down and explodes.");
        Entity refrigerator = new Entity("Refrigerator", "A refrigerator with a led screen?", "You open the door and a strong smell of fish comes at you.");
        Entity teleporter = new Entity("Teleporter", "???", "It doesn't work.");

        Room kitchen = new Room("Kitchen", "A bright kitchen with the smell of fresh coffee.", Arrays.asList(coffeeMaker, refrigerator));
        Room foyer = new Room("Foyer", "A small entryway with a coat rack and a stairway leading up.", Arrays.asList(coatRack));
        Room bathroom = new Room("Bathroom", "A normal looking bathroom. Or is it?", Arrays.asList(teleporter));
        Room room = new Room("Room", "Yes, it is an empty room.", Arrays.asList());

        foyer.setExit("north", kitchen);
        kitchen.setExit("south", foyer);

        foyer.setExit("west", bathroom);
        bathroom.setExit("east", foyer);

        bathroom.setExit("south", room);
        room.setExit("north", bathroom);

        Room currentRoom = foyer;
        Scanner scan = new Scanner(System.in);

        currentRoom.display();
        boolean isPlay = true;
        while (isPlay) {
            System.out.println("\nEnter a command: ");
            String input = scan.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            }

            String[] parts = input.split("\\s+", 2);
            String command = parts[0].toLowerCase();
            String argument = parts.length > 1 ? parts[1].trim() : "";

            switch(command) {
                case "exit":
                    System.out.println("Thanks for visiting! Goodbye.");
                    isPlay = false;
                    break;
                case "quit":
                    System.out.println("Thanks for visiting! Goodbye.");
                    isPlay = false;
                    break;
                case "move":
                    if (argument.isEmpty()) {
                        System.out.println("Please specify a direction");
                        break;
                    }
                    try {
                        currentRoom = currentRoom.getExit(argument);
                        currentRoom.display();
                    } catch (InvalidDirectionException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "interact":
                    if (argument.isEmpty()) {
                        System.out.println("Please specify an entity");
                        break;
                    }
                    try {
                        Entity e = currentRoom.getEntity(argument);
                        System.out.println(e.interact());
                    } catch (EntityNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "look":
                    currentRoom.display();
                    break;
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }
        scan.close();
    }
}