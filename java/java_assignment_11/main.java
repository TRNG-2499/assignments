import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;


class Main {
    public static void main(String[] args) {
        Room kitchen, bedroom, bathroom, livingRoom, basement;
        kitchen = new Room("Kitchen", "The Kitchen");
        basement = new Room("Basement", "The Basement");
        bedroom = new Room("Bedroom", "The Bedroom");
        bathroom = new Room("Bathroom", "The Bathroom");
        livingRoom = new Room("Living Room", "The Living Room");

        kitchen.connectRoom(bedroom, Direction.EAST);
        bedroom.connectRoom(basement, Direction.DOWN);
        kitchen.connectRoom(livingRoom, Direction.SOUTH);
        bedroom.connectRoom(bathroom, Direction.EAST);

        // items (no more than 4 per room)
        kitchen.addEntities(new Entity("CoffeeMaker", "A drip coffee maker with a half-full pot.", "You pour a cup of coffee. It's still warm."));
        kitchen.addEntities(new Entity("Refrigerator", "A humming stainless-steel fridge.", "You open the fridge. Leftover pizza and a carton of milk."));
        kitchen.addEntities(new Entity("Toaster", "A two-slot toaster with crumbs around it.", "You push the lever down. A minute later, toast pops up."));

        livingRoom.addEntities(new Entity("Couch", "A worn but comfy three-seat couch.", "You sink into the couch and find a remote between the cushions."));
        livingRoom.addEntities(new Entity("Television", "A flat-screen TV mounted on the wall.", "The TV flickers on to a cooking show."));
        livingRoom.addEntities(new Entity("Bookshelf", "A tall shelf packed with paperbacks.", "You pull out a mystery novel. Someone dog-eared page 112."));

        bedroom.addEntities(new Entity("Bed", "A neatly made queen-size bed.", "You sit on the bed. The mattress creaks."));
        bedroom.addEntities(new Entity("Dresser", "A wooden dresser with a mirror on top.", "You open a drawer. Socks, and a single mismatched glove."));
        bedroom.addEntities(new Entity("Lamp", "A small bedside lamp.", "You click the lamp on. The room fills with warm light."));

        bathroom.addEntities(new Entity("Mirror", "A foggy mirror above the sink.", "You wipe the mirror and see your reflection."));
        bathroom.addEntities(new Entity("Bathtub", "A clawfoot bathtub.", "You turn the faucet. The pipes groan, then water runs."));

        basement.addEntities(new Entity("Furnace", "An old furnace rumbling in the corner.", "You feel heat radiating from the furnace."));
        basement.addEntities(new Entity("Toolbox", "A rusty red toolbox.", "You open the toolbox: a hammer, screwdrivers, and duct tape."));
        basement.addEntities(new Entity("Boxes", "A stack of dusty cardboard boxes.", "You open a box and find old holiday decorations."));


        HouseBuilder houseBuilder = new HouseBuilder(kitchen);
        houseBuilder.addAllConnectedRooms(kitchen);

        Room currentRoom = houseBuilder.getStartingRoom();
        System.out.println(currentRoom.describe());

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("\nEnter a command: ");
            if (!scanner.hasNextLine()) {   // input ended (e.g. Ctrl+D)
                break;
            }

            // split "move north" into the command word and the rest
            String[] parts = scanner.nextLine().trim().split("\\s+", 2);
            String word = parts[0].toLowerCase();
            String argument = parts.length > 1 ? parts[1].trim() : "";

            if (word.isEmpty()) {
                continue;
            }

            Commands command;
            try {
                command = Commands.valueOf(word);   // enum constants are lowercase, so this matches the lowercased input
            } catch (IllegalArgumentException e) {
                System.out.println("Unknown command '" + word + "'. Try: move, look, interact, exit or quit.");
                continue;
            }

            try {
                switch (command) {
                    case move -> {
                        if (argument.isEmpty()) {
                            System.out.println("Move where? e.g. 'move north'");
                            break;
                        }
                        currentRoom = currentRoom.move(Direction.fromString(argument));
                        System.out.println(currentRoom.describe());
                    }
                    case look -> System.out.println(currentRoom.describe());
                    case interact -> {
                        if (argument.isEmpty()) {
                            System.out.println("Interact with what? e.g. 'interact CoffeeMaker'");
                            break;
                        }
                        System.out.println(currentRoom.findEntity(argument).interact());
                    }
                    case exit, quit -> running = false;
                }
            } catch (DirectionExceptions.directionException | RoomExceptions.entityNotFoundException e) {
                // the game keeps running after a bad action
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("Thanks for visiting! Goodbye.");
        scanner.close();
    }
}