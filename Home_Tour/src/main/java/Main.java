import java.util.Scanner;
import java.util.ArrayList;

public class Main {
        static void main(String[] args) throws InvalidDirectionException {
            Scanner scanner = new Scanner(System.in);
            // Let's Create rooms

            Room foyer = new Room(
                    "Foyer",
                    "A small entryway with a coat rack and a stairway leading up."
            );

            Room kitchen = new Room(
                    "Kitchen",
                    "A bright kitchen with the smell of fresh coffee."
            );

            Room bedroom = new Room(
                    "Bedroom",
                    "A comfortable bedroom with a large window."
            );

            Room livingRoom = new Room(
                    "LivingRoom",
                    "A cozy living room with a television and sofa."
            );

            // Connect rooms (both directions)
            foyer.addExit("north", kitchen);
            kitchen.addExit("south", foyer);

            foyer.addExit("up", bedroom);
            bedroom.addExit("down", foyer);

            kitchen.addExit("east", livingRoom);
            livingRoom.addExit("west", kitchen);

            // Create entities
            Entity coatRack = new Entity(
                    "CoatRack",
                    "An old wooden coat rack.",
                    "You check the CoatRack. There's an old raincoat hanging on it."
            );

            Entity coffeeMaker = new Entity(
                    "CoffeeMaker",
                    "A machine that makes fresh coffee.",
                    "You make yourself a fresh cup of coffee.");

            Entity refrigerator = new Entity(
                    "Refrigerator",
                    "A large refrigerator full of food.",
                    "You open the refrigerator and find some fresh milk."
            );

            Entity wallet = new Entity(
                    "Wallet",
                    "A small leather wallet.",
                    "You open the wallet. It contains some money."
            );

            Entity television = new Entity(
                    "Television",
                    "A large flat-screen television.",
                    "You turn on the television. The news is playing."
            );

            Entity book = new Entity(
                    "Book",
                    "An interesting Java programming book.",
                    "You read a few pages about object-oriented programming."
            );

            // Add entities to rooms
            foyer.addEntity(coatRack);

            kitchen.addEntity(coffeeMaker);
            kitchen.addEntity(refrigerator);
            kitchen.addEntity(wallet);

            livingRoom.addEntity(television);

            bedroom.addEntity(book);

            // Player inventory
            ArrayList<Entity> inventory = new ArrayList<>();

            // Starting room
            Room currentRoom = foyer;

            currentRoom.displayRoom();

            boolean running = true;

            // Command loop
            while (running) {

                System.out.print("\nEnter a command: ");

                String command = scanner.nextLine().trim();

                if (command.isEmpty()) {
                    continue;
                }

                String[] parts = command.split("\\s+", 2);

                String action = parts[0].toLowerCase();

                String argument = "";

                if (parts.length > 1) {
                    argument = parts[1].trim();
                }

                try {

                    switch (action) {

                        case "move":

                            if (argument.isEmpty()) {
                                System.out.println(
                                        "Please specify a direction."
                                );
                                break;
                            }

                            currentRoom = currentRoom.move(argument);

                            currentRoom.displayRoom();

                            break;

                        case "look":

                            currentRoom.displayRoom();

                            break;

                        case "interact":

                            if (argument.isEmpty()) {
                                System.out.println(
                                        "Please specify an entity."
                                );
                                break;
                            }

                            Entity entity = currentRoom.findEntity(argument);

                            System.out.println(entity.interact());

                            break;

                        case "take":

                            if (argument.isEmpty()) {
                                System.out.println(
                                        "Please specify an item to take."
                                );
                                break;
                            }

                            Entity item = currentRoom.findEntity(argument);

                            if (!item.isTakeable()) {

                                System.out.println(
                                        "You cannot take the " + item.getName() + "."
                                );

                            } else {

                                inventory.add(item);
                                currentRoom.removeEntity(item);

                                System.out.println(
                                        "You picked up the " + item.getName() + "."
                                );
                            }

                            break;

                        case "inventory":

                            System.out.println("\nYour inventory:");

                            if (inventory.isEmpty()) {

                                System.out.println("Your inventory is empty.");

                            } else {

                                for (Entity ownedItem : inventory) {
                                    System.out.println(
                                            "- " + ownedItem.getName()
                                    );
                                }
                            }

                            break;

                        case "exit":
                        case "quit":

                            running = false;

                            System.out.println(
                                    "Thanks for visiting! Goodbye."
                            );

                            break;

                        default:

                            System.out.println(
                                    "Unknown command. Try move, look, interact, "
                                            + "take, inventory, or exit."
                            );
//                    } catch (InvalidDirectionException e) {
//                    throw new RuntimeException(e);
//                } catch (EntityNotFoundException e) {
//                    throw new RuntimeException(e);
//                }
//            } catch (InvalidDirectionException e) {
//                    throw new RuntimeException(e);
//                } catch (EntityNotFoundException e) {
//                    throw new RuntimeException(e);
//                }

                            scanner.close();

                    }
                } catch (EntityNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }}