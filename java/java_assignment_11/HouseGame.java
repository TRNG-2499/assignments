import java.util.Scanner;

public class HouseGame {
    private Room currentRoom;
    private boolean running = true;

    public static void main(String[] args) {
        new HouseGame().play();
    }

    private void play(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the house: Type 'help' for a list of commands.");
        currentRoom = House.build();
        System.out.println(currentRoom.describe());

        while (running){
            System.out.print("\n> ");
            if (!scan.hasNextLine()){
                break;
            }
            String input = scan.nextLine();

            try{
                handleCommand(input);
            } catch (InvalidDirectionException e){
                System.out.println(e.getMessage());
            } catch (EntityNotFoundException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Thanks for exploring the house. Goodbye!");
        scan.close();
    }

    private void handleCommand(String input)
            throws InvalidDirectionException, EntityNotFoundException, InvalidCommandException {

        String trimmed = input.trim();
        if (trimmed.isEmpty()) {
            throw new InvalidCommandException("Please type a command. Type 'help' to see them.");
        }
        String[] parts = trimmed.split("\\s+", 2);
        String command = parts[0].toLowerCase();
        String argument = (parts.length > 1) ? parts[1].trim() : "";

        switch (command) {
            case "move":
                requireArgument(argument, "Move where? Example: move north");
                currentRoom = currentRoom.getExit(argument);
                System.out.println(currentRoom.describe());
                break;

            case "look":
                System.out.println(currentRoom.describe());
                break;

            case "interact":
                requireArgument(argument, "Interact with what? Example: interact CoatRack");
                Entity entity = currentRoom.findEntity(argument);
                System.out.println(entity.interact());
                break;

            case "help":
                printHelp();
                break;

            case "exit":
            case "quit":
                running = false;
                break;

            default:
                throw new InvalidCommandException("Unknown command: \"" + parts[0]
                        + "\". Type 'help' to see the commands.");
        }
    }

    private void requireArgument(String argument, String message) throws InvalidCommandException {
        if (argument.isEmpty()) {
            throw new InvalidCommandException(message);
        }
    }

    private void printHelp() {
        System.out.println("Commands:");
        System.out.println("  move [direction]   - north, south, east, west, up, down");
        System.out.println("  look               - describe this room again");
        System.out.println("  interact [entity]  - interact with something you see");
        System.out.println("  exit / quit        - leave the game");
    }

}
