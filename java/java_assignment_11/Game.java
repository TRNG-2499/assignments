import java.util.Scanner;

public class Game {
    private Room currentRoom;

    private final Scanner scanner = new Scanner(System.in);

    public Game(House house) {
        //TODO: set currentRoom to the house's starting room
        currentRoom = house.getStartingRoom();
    }

    public void start() {
        boolean running = true;
        System.out.println(currentRoom.describe());
        while (running) {
            //TODO immplement game loop logic
            System.out.print("Enter a command: ");
            String input = scanner.nextLine().trim().toLowerCase();

            String[] parts = input.split(" ", 2);
            String command = input.startsWith(" ") ? "" : parts[0];
            String argument = parts.length > 1 ? parts[1] : "";

            


            //TODO if input is exit or quit, set running to false
            if (input.equals("exit") || input.equals("quit")) {
                running = false;
                System.out.println("Thanks for visiting! Goodbye.");
            } else if (input.equals("look")) {
                System.out.println(currentRoom.describe());
            } else if (command.equals("move")) {
                try {
                    //TODO set currentRoom to the room returned by getExit(argument)
                    currentRoom = currentRoom.getExit(argument);
                    //TODO print the new rooms exception
                    System.out.println(currentRoom.describe());
                } catch (InvalidDirectionException e) {
                    System.out.println("Cannot move to " + argument + ": " + e.getMessage());
                }
            } else if (command.equals("interact")) {
                try {
                    currentRoom.findEntity(argument).interact();
                    System.out.println(currentRoom.findEntity(argument).interact());
                } catch (EntityNotFoundException  e) {
                    System.out.println("Cannot interact with " + argument + ": " + e.getMessage());
                }
            } else {
                System.out.println("Unknown command: " + input);
            }
        }

    }

}
