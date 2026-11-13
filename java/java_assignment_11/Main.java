package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Room livingroom = new Room("Living Room", "Cozy tiny area. Fireplace burning and gentle music playing.");
        Room kitchen = new Room("Kitchen", "Spotless. No dishes in the sink, and fresh mopped floors shining.");
        Room bedroom = new Room("Bedroom", "Simplistic room with minimal furniture and a queen bed. Clothes on floor.");
        Room bathroom = new Room("Bathroom", "Tiny but gets the job done. Sliding glass doors on shower, and sink accompanied by a vanilla soap.");

        Entity fishtank = new Entity("Fishtank", "13 fish inside, mostly small fish...", "The fish food is almost empty!");
        Entity cabinet = new Entity("Cabinet", "Slightly opened cabinet....", "There is pots and pans in here.");
        Entity computer = new Entity("Computer", "Beautiful gaming pc... Glass case to show off components.", "The GPU is an NVIDIA 5090.");
        Entity trashcan = new Entity("Trashcan", "The trashcan is overflowing...", "Filled with garbage and old tissue.");

        // these ones can be picked up
        Entity remote = new Entity("Remote", "TV remote with a sticky button...", "The volume button is stuck on max.", true);
        Entity mug = new Entity("Mug", "Coffee mug that says World's Okayest Coder...", "Still a little warm.", true);
        Entity headphones = new Entity("Headphones", "Wireless headphones on the desk...", "Battery is at 12%.", true);
        Entity soap = new Entity("Soap", "Bar of vanilla soap...", "Smells like a candle store.", true);

        livingroom.addEntity(fishtank);
        livingroom.addEntity(remote);
        kitchen.addEntity(cabinet);
        kitchen.addEntity(mug);
        bedroom.addEntity(computer);
        bedroom.addEntity(headphones);
        bathroom.addEntity(trashcan);
        bathroom.addEntity(soap);

        livingroom.addExit("north", kitchen);
        livingroom.addExit("south", bedroom);
        livingroom.addExit("east", bathroom);

        kitchen.addExit("south", livingroom);

        bedroom.addExit("north", livingroom);

        bathroom.addExit("west", livingroom);

        Room currentRoom = livingroom;
        ArrayList<Entity> inventory = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        currentRoom.display();

        while (true) {
            System.out.println("Enter a command: ");
            String input = scanner.nextLine().toLowerCase();
            String[] parts = input.split(" ");

            if (parts[0].equals("look")) {
                currentRoom.display();
            } else if (parts[0].equals("move") && parts.length > 1) {
                try {
                    currentRoom = currentRoom.getExit(parts[1]);
                    currentRoom.display();
                } catch (InvalidDirectionException e) {
                    System.out.println("Error: " + e.getMessage());
                }

            } else if (parts[0].equals("interact") && parts.length > 1) {
                try {
                    // check your inventory first so you can still use stuff you picked up
                    Entity entity = null;
                    for (Entity item : inventory) {
                        if (item.getName().equalsIgnoreCase(parts[1])) {
                            entity = item;
                        }
                    }
                    if (entity == null) {
                        entity = currentRoom.getEntities(parts[1]);
                    }
                    System.out.println(entity.getDescription());
                    System.out.println(entity.interact());
                } catch (EntityNotFoundException e) {
                    System.out.println("Error: " + e.getMessage());
                }

            } else if (parts[0].equals("take") && parts.length > 1) {
                try {
                    Entity entity = currentRoom.getEntities(parts[1]);
                    if (!entity.isTakeable()) {
                        throw new NotTakeableException("You can't pick up the " + entity.getName() + ".");
                    }
                    currentRoom.removeEntity(entity);
                    inventory.add(entity);
                    System.out.println("You took the " + entity.getName() + ".");
                } catch (EntityNotFoundException | NotTakeableException e) {
                    System.out.println("Error: " + e.getMessage());
                }

            } else if (parts[0].equals("inventory")) {
                if (inventory.isEmpty()) {
                    System.out.println("Your inventory is empty.");
                } else {
                    System.out.print("Inventory: ");
                    for (int i = 0; i < inventory.size(); i++) {
                        System.out.print(inventory.get(i).getName());
                        if (i < inventory.size() - 1) {
                            System.out.print(", ");
                        }
                    }
                    System.out.println();
                }

            } else if (parts[0].equals("exit") || parts[0].equals("quit")) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Unknown command.");
            }
        }

    }




}