import java.util.Scanner;

public class ZooAnimalSoundBoard {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                printMenu();

                if (!scanner.hasNextLine()) {
                    return;
                }

                // Read the whole line so invalid input is cleared before the next prompt.
                String selection = scanner.nextLine().trim();
                Animal animal;

                switch (selection) {
                    case "1":
                        animal = new Dog();
                        break;
                    case "2":
                        animal = new Cat();
                        break;
                    case "3":
                        animal = new Bird();
                        break;
                    case "0":
                        System.out.println("Goodbye! Thanks for visiting the zoo.");
                        return;
                    default:
                        System.out.println("'" + selection
                                + "' is not a valid selection. Please choose a number from the menu.");
                        System.out.println();
                        continue;
                }

                animal.display();
                System.out.println();
            }
        }
    }

    private static void printMenu() {
        System.out.println("1. Dog");
        System.out.println("2. Cat");
        System.out.println("3. Bird");
        System.out.println("0. Exit");
        System.out.print("Enter your selection: ");
    }
}