import java.util.Scanner;

import Entities.*;

import java.util.HashMap;
import java.util.Map;

public class HomeTour {
    
    public static void main(String[] args) {

        // So long as we dynamically update currRoom, the code will
        // become flexible enough to adapt to any subclass of Room
        LivingRoom livingRoom = new LivingRoom();
        Kitchen kitchen = new Kitchen();
        Basement basement = new Basement();
        BedRoom bedRoom = new BedRoom();

        // Initial room connection
        livingRoom.connectRooms("west", kitchen);
        livingRoom.connectRooms("east", basement);
        livingRoom.connectRooms("north", bedRoom);

        // Inverse room connections
        kitchen.connectRooms("east", livingRoom);
        basement.connectRooms("west", livingRoom);
        bedRoom.connectRooms("south", livingRoom);
        
        // Populate rooms with entities
        livingRoom.addEntities("couch", new Couch());
        kitchen.addEntities("microwave", new Microwave());
        basement.addEntities("washingmachine", new WashingMachine());
        bedRoom.addEntities("bed", new Bed());

        Room currRoom = livingRoom;
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("");

            // Repack entity names into a nicer printable format
            StringBuilder strBuild = new StringBuilder();
            for (Map.Entry<String, Entity> e : currRoom.getEntities().entrySet()) {
                strBuild.append(e.getValue().getName() + ", ");
            }
            strBuild.setLength(strBuild.length() - 2);

            System.out.printf("You are in the %s.%n", currRoom.getName());
            System.out.println(currRoom.getDesc());
            System.out.println("Interactable entities: " + strBuild);
            System.out.println("");

            HashMap<String, Room> rooms = currRoom.getRoomDirections();
            HashMap<String, Entity> roomItems = currRoom.getEntities();

            System.out.print("Enter a command: ");
            String fullCommand = scanner.nextLine().trim().toLowerCase();
            String[] commandParts = fullCommand.split(" ");

            try {
                switch (commandParts[0]) {
                    case "move":
                        if (rooms.containsKey(commandParts[1])) {
                            currRoom = rooms.get(commandParts[1]);
                        } else {
                            throw new InvalidDirectionException(commandParts[1]);
                        }
                        break;
                    case "look":
                        continue;
                    case "interact":
                        if (roomItems.containsKey(commandParts[1])) {
                            roomItems.get(commandParts[1]).interact();
                        } else {
                            throw new EntityNotFoundException(commandParts[1]);
                        }
                        break;
                    case "exit":
                        running = false;
                }

            } catch (InvalidDirectionException e) {
                System.out.println(e.getMessage());

            } catch (EntityNotFoundException e) {
                System.out.println(e.getMessage());
            }

        }

        scanner.close();
    }
}
