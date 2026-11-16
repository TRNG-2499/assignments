package assignments.java.java_assignment_11;

import java.util.Scanner;

import assignments.java.java_assignment_11.Exceptions.EntityNotFoundException;
import assignments.java.java_assignment_11.Exceptions.InvalidDirectionException;

public class CommandLoop {

    private Room currentRoom;
    private Scanner scanner = new Scanner(System.in);
    private boolean running = true;

    public CommandLoop() throws InvalidDirectionException {
        House house = new House();
        currentRoom = house.getStartingRoom();
    }

    public void start() {
        currentRoom.getDisplay();
        while (running) {
            System.out.print("\nEnter a command: ");
            String input = scanner.nextLine().trim();
            try {
                processCommand(input);
            } catch (InvalidDirectionException | EntityNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private void processCommand(String input) throws InvalidDirectionException, EntityNotFoundException {
        if (input.isBlank()) {
            System.out.println("Please enter a command.");
            return;
        }
        String[] parts = input.split("\\s+", 2);
        String command = parts[0].toLowerCase();
        String argument = parts.length > 1 ? parts[1].trim() : "";
        switch (command) {
            case "move" -> move(argument);
            case "look" -> currentRoom.getDisplay();
            case "interact" -> currentRoom.interactEntity(argument);
            case "exit", "quit" -> running = false;
            default -> System.out.println("Unknown command: " + command);
        }
    }

    private void move(String direction) throws InvalidDirectionException {
        currentRoom = currentRoom.getExit(direction);
        currentRoom.getDisplay();
    }

}