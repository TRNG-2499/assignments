import java.util.Scanner;
import java.util.Set;

public class HouseTour {
    private static final Set<String> NO_ARG = Set.of("help", "quit", "exit", "q", "inventory");
    private static final Set<String> ONE_ARG = Set.of("move", "interact", "take", "put");
    private static final Set<String> DIRECTIONS = Set.of("north", "south", "east", "west", "up", "down");
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, type 'help' for a list of commands if you need it.");
        Player.changeRoom(HouseBuilder.build());
        look(Player.getLocation());

        while (true) {
            try {
                System.out.print("Enter a command: ");
                String[] commandArgs = parse(scanner.nextLine());

                switch (commandArgs[0]) {
                    case "help" -> { printHelpMessage(); }
                    case "move" -> { move(Player.getLocation(), Direction.valueOf(commandArgs[1].toUpperCase())); }
                    case "look" -> {
                        if (commandArgs.length == 2) {
                            lookAtEntity(Player.getLocation(), commandArgs[1]);
                        } else { look(Player.getLocation()); }
                    }
                    case "interact" -> { interactWithEntity(Player.getLocation(), commandArgs[1]);}
                    case "take" -> { takeEntity(Player.getLocation(), commandArgs[1]);}
                    case "put" -> { putEntity(Player.getLocation(), commandArgs[1]);}
                    case "inventory" -> { listInventory();}

                    case "quit","q","exit" -> {
                        scanner.close();
                        System.out.println("Thank you for coming!");
                        return;
                    }
                    default -> throw new CommandParseException("Unknown command '" + commandArgs[0] + "'. Type 'help' for a list of valid commands.");
                }
            } catch (CommandParseException | EntityNotFoundException | InvalidDirectionException e) {
                System.out.println(e.getMessage());
            }

            
        }
    }
    
    public static String[] parse(String s) {
        if (s == null || s.isBlank()) throw new CommandParseException("Please enter a command. Enter 'help' for a list of commands.");
        String[] args = s.trim().toLowerCase().split("\\s+", 2);
        String verb = args[0];

        if (NO_ARG.contains(verb)) {
            return new String[]{verb};
        }

        if (verb.equals("look")) {
            if (args.length > 2) throw new CommandParseException("Too many arguments for 'look'.");
            return args.length == 1 ? new String[] { verb } : new String[] { verb, args[1] };
        }

        if (ONE_ARG.contains(verb)) {
            if (args.length < 2) throw new CommandParseException("'" + verb + "' needs an argument.");
            if (args.length > 2) throw new CommandParseException("Too many arguments for '" + verb + "'.");
            if (verb.equals("move") && !DIRECTIONS.contains(args[1])) {
                throw new CommandParseException("'" + args[1] + "' is not a valid direction.");
            }
            return new String[] { verb, args[1] };
        }

        throw new CommandParseException("Unknown command '" + args[0] + "'. Type 'help' for a list of valid commands.");
    }
    

    public static void look(Room room) {
        System.out.printf("You are in the %s\n", room.getName());
        System.out.println(room.getDescription());
        listEntities(room);
    }
    public static void listEntities(Room room) {
        if (room.getEntities().isEmpty()) System.out.println("There's nothing in the room.");
        int count = 1;
        for (Entity e : room.getEntities()) {
            System.out.printf("%d. %s\n",count, e.getName());
            count++;
        }
    }

    public static void listInventory() {
        if (Player.getInventory().isEmpty()) System.out.println("There's nothing in your inventory.");
        int count = 1;
        for (Entity e : Player.getInventory()) {
            System.out.printf("%d. %s\n",count, e.getName());
            count++;
        }
    }

    public static void move(Room room, Direction dir) {
        Room dest = room.getExit(dir);
        if (dest == null) {
            throw new InvalidDirectionException("There's no room in that direction");
        }
        Player.changeRoom(dest);
        System.out.println("You moved " + dir.toString().toLowerCase() + " to the " + dest.getName() + ".");
        look(dest);
    }

    public static void lookAtEntity(Room room, String name) {
        Entity e = room.getEntityByName(name);
        if (e == null) {
            throw new EntityNotFoundException("Item "+ name + " not found in room.");
        }
        System.out.println(e.getDescription());
    }

    public static void interactWithEntity(Room room, String name) {
        Entity e = room.getEntityByName(name);
        if (e == null) {
            throw new EntityNotFoundException("Item "+ name + " not found in room.");
        }
        System.out.println(e.interact());
    }

    public static void printHelpMessage() {
        System.out.println("Here is a list of valid commands:");
        System.out.println("---------------------------------");
        System.out.println("move [direction]: move to a valid adjacent room (accepts cardinal directions + up and down)");
        System.out.println("look: look at the room you're currently in, and list the visible items");
        System.out.println("look [item]: look at an item in the room");
        System.out.println("interact [item]: interact with an item in the room");
        System.out.println("inventory: list the items in your inventory");
        System.out.println("take [item]: take an item from the room and place it in your inventory");
        System.out.println("put [item]: place an item from your inventory in the room");
        System.out.println("exit/quit/q: end the program");
    }

    public static void takeEntity(Room room, String name) {
        Entity e = room.getEntityByName(name);
        if (e == null) {
            throw new EntityNotFoundException("Item "+ name + " not found in room.");
        } else if (!Player.take(e)){
            System.out.println("You can't take the "+ e.name + ".");
        } else {
            System.out.println("You took the "+ e.name + " and put it in your inventory.");
        }
        
    }

    public static void putEntity(Room room, String name) {
        Entity e = Player.getEntityByName(name);
        if (e == null || !Player.place(e)) {
            throw new EntityNotFoundException("Item "+ name + " not found in inventory.");
        }

        System.out.println("You took the "+ e.name + " from your inventory and placed it in the room.");
    }

    public static class EntityNotFoundException extends RuntimeException {
        public EntityNotFoundException() { super(); }
        public EntityNotFoundException(String message) { super(message); }
    }

    public static class CommandParseException extends RuntimeException {
        public CommandParseException() { super(); }
        public CommandParseException(String message) { super(message); }
    }

    public static class InvalidDirectionException extends RuntimeException {
        public InvalidDirectionException() { super(); }
        public InvalidDirectionException(String message) { super(message); }
    }
}