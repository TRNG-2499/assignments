package java_assignment_11;


import java.util.Scanner;

public class HomeTour {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create rooms
        Room foyer = new Foyer();
        Room kitchen = new Kitchen();
        Room livingRoom = new LivingRoom();
        Room bedroom = new Bedroom();

        // Add entities to the Foyer
        foyer.addEntity(new Entity(
            "CoatRack",
            "An old wooden coat rack.",
            "You check the CoatRack. There's an old raincoat hanging on it."
        ));

        // Add entities to the Kitchen
        kitchen.addEntity(new Entity(
            "CoffeeMaker",
            "A coffee maker sitting on the counter.",
            "You turn on the CoffeeMaker. Fresh coffee begins brewing."
        ));

        kitchen.addEntity(new Entity(
            "Refrigerator",
            "A large refrigerator full of food.",
            "You open the Refrigerator and find some fresh food inside."
        ));

        // Add entities to the Living Room
        livingRoom.addEntity(new Entity(
            "Television",
            "A large television.",
            "You turn on the Television. A news channel appears."
        ));

        livingRoom.addEntity(new Entity(
            "Sofa",
            "A comfortable sofa.",
            "You sit down on the Sofa and relax for a moment."
        ));

        // Add entities to the Bedroom
        bedroom.addEntity(new Entity(
            "Bed",
            "A comfortable bed.",
            "You sit on the Bed. It looks very comfortable."
        ));

        bedroom.addEntity(new Entity(
            "Lamp",
            "A small lamp on the bedside table.",
            "You turn on the Lamp. The room becomes brighter."
        ));

        // Connect rooms
        foyer.addExit("north", kitchen);
        kitchen.addExit("south", foyer);

        foyer.addExit("east", livingRoom);
        livingRoom.addExit("west", foyer);

        livingRoom.addExit("north", bedroom);
        bedroom.addExit("south", livingRoom);

        // Start the tour in the Foyer
        Room currentRoom = foyer;

        System.out.println("Welcome to the Home Tour!");
        currentRoom.display();

        // Command loop
        boolean running = true;

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
                            System.out.println("Please specify a direction.");
                            break;
                        }

                        currentRoom = currentRoom.move(argument);
                        currentRoom.display();
                        break;

                    case "look":
                        currentRoom.display();
                        break;

                    case "interact":
                        if (argument.isEmpty()) {
                            System.out.println("Please specify an entity.");
                            break;
                        }

                        Entity entity = currentRoom.findEntity(argument);
                        System.out.println(entity.interact());
                        break;

                    case "exit":
                    case "quit":
                        running = false;
                        System.out.println("Thanks for visiting! Goodbye.");
                        break;

                    default:
                        System.out.println(
                            "Invalid command. Try move, look, interact, or exit."
                        );
                        break;
                }

            } catch (InvalidDirectionException | EntityNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
