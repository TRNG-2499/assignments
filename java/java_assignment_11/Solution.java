package java_assignment_11;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Room foyer = new Room("Foyer", "A small entryway with a coat rack.");
        Room kitchen = new Room("Kitchen", "A bright kitchen with the smell of fresh coffee.");
        Room livingRoom = new Room("LivingRoom", "A comfortable room with a large window.");
        Room diningRoom = new Room("DiningRoom", "A quiet room centered around a wooden table.");

        foyer.addExit("north", kitchen);
        foyer.addExit("east", livingRoom);
        kitchen.addExit("east", diningRoom);
        livingRoom.addExit("north", diningRoom);

        foyer.addEntity(new Entity(
                "CoatRack",
                "A wooden coat rack with several empty hooks.",
                "You check the CoatRack. There's an old raincoat hanging on it."));
        kitchen.addEntity(new Entity(
                "CoffeeMaker",
                "A small coffee maker sits on the counter.",
                "The coffee maker is broken."));
        kitchen.addEntity(new Entity(
                "Refrigerator",
                "A white refrigerator hums quietly.",
                "The refrigerator is empty."));
        livingRoom.addEntity(new Entity(
                "Sofa",
                "A soft sofa faces the window.",
                "You sit on the Sofa."));
        diningRoom.addEntity(new Entity(
                "DiningTable",
                "A wooden table with four chairs.",
                "You sit at the dining table. There is nothing to eat."));

        play(foyer);
    }

    private static void play(Room startingRoom) {
        Room currentRoom = startingRoom;
        displayRoom(currentRoom);
        try (Scanner scanner = new Scanner(System.in)) {
            boolean flag = true;
            while (flag) {
                System.out.print("\nEnter a command: ");
                String input = scanner.nextLine().trim();
                String[] parts = input.split("\\s+", 2);
                String command = parts[0].toLowerCase();
                String argument = parts.length > 1 ? parts[1].trim() : "";
                
                try {
                    switch (command) {
                        case "move":
                            currentRoom = currentRoom.getExit(argument);
                            displayRoom(currentRoom);
                            break;
                        case "look":
                            displayRoom(currentRoom);
                            break;
                        case "interact":
                            System.out.println(currentRoom.getEntity(argument).interact());
                            break;
                        case "exit":
                        case "quit":
                            flag = false;
                            break;
                        default:
                            System.out.println("Unknown command. Use move, look, interact, or exit.");
                    }
                } catch (InvalidDirectionException | EntityNotFoundException | IllegalArgumentException exception) {
                    System.out.println("Error: " + exception.getMessage());
                }
            }
        }

        System.out.println("Thanks for visiting! Goodbye.");
    }

    private static void displayRoom(Room room) {
        System.out.println("\nYou are in the " + room.getName() + ".");
        System.out.println(room.getDescription());

        if (room.getEntities().isEmpty()) {
            System.out.println("Interactable entities: none");
            return;
        }

        StringBuilder entityNames = new StringBuilder();
        for (Entity entity : room.getEntities()) {
            if (entityNames.length() > 0) {
                entityNames.append(", ");
            }
            entityNames.append(entity.getName());
        }
        System.out.println("Interactable entities: " + entityNames);
    }
}
