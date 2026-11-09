import java.util.Scanner;

public class ZooSimulator {
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Booting up zoo simulator...");
        for (int i = 0; i < 15; i++) {
            System.out.print(".");
            Thread.sleep(100);
        }
        System.out.println();

        boolean programIsRunning = true;
        int selection;
        Animal animal;
        while (programIsRunning) {
            System.out.print("""
                1. Chicken
                2. Goat
                3. Platypus
                0. Exit
                Select an animal or exit:\s""");
            String input = scan.next();
            try {
                selection = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.printf("Invalid input '%s', please try again.\n", input);
                continue;
            }

            if (selection < 0 || selection > 3) {
                System.out.printf("Invalid selection '%d', please try again.\n\n", selection);
                continue;
            }

            if (selection == 0) {
                programIsRunning = false;
                System.out.println("Thanks for running the zoo simulator. Shutting down...");
                continue;
            }
            // else
            animal = switch (selection) {
                case 1 -> new Chicken();
                case 2 -> new Goat();
                case 3 -> new Platypus();
                default ->
                        throw new IllegalStateException("Illegal selection value was uncaught, and it's your fault.");
            };
            System.out.println(animal.makeSound());
            System.out.println(animal.describe());
            System.out.println();
        }
    }
}
