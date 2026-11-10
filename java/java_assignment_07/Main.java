import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String menuPick = "1. Dog\n2. Cat\n3. Bird\n4. Surprise Me\n0. Exit\nEnter a number: ";

        while (true) {
            System.out.print(menuPick);
            String line = scanner.nextLine();
            int menuChoice;

            try {
                menuChoice = Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("'" + line + "' is not a valid selection. Please choose a number from the menu.");
                System.out.println("");
                continue;
            }

            if (menuChoice == 0) {
                System.out.println("Goodbye! Thanks for coming to the ZOO!");
                break;
            } else if (menuChoice >= 1 && menuChoice <= 3) {
                createAnimal(menuChoice).display();
            } else if (menuChoice == 4) {
                surpriseMe().display();
            } else {
                System.out.println("'" + menuChoice + "' is not a valid selection. Please choose a number from the menu.");
            }
            System.out.println("");

        }
        scanner.close();

    }

    // builds the animal for a menu number, using the detailed versions with extra fields
    public static Animal createAnimal(int choice) {
        switch (choice) {
            case 1:
                return new DetailedDog("Golden Retriever");
            case 2:
                return new DetailedCat(true);
            default:
                return new DetailedBird(true);
        }
    }

    // picks a random animal from the menu options
    public static Animal surpriseMe() {
        Random random = new Random();
        int pick = random.nextInt(3) + 1; // 1, 2, or 3
        System.out.println("Surprise!");
        return createAnimal(pick);
    }
}