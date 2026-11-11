// package java.java_assignment_07;

import java.util.Random;
import java.util.Scanner;

public class ZooSoundBoard {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Enter your selection: ");
            String input = scanner.nextLine().trim();

            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("'" + input + "' is not a valid selection. Please choose a number from the menu.\n");
                continue;
            }

            if (choice == 0) {
                System.out.println("Goodbye! Thanks for visiting the zoo.");
                running = false;
            } else if (choice == 4) {
                showRandomAnimal(random);
            } else {
                Animal animal = createAnimal(choice);
                if (animal == null) {
                    System.out.println("'" + choice + "' is not a valid selection. Please choose a number from the menu.\n");
                } else {
                    animal.show();
                }
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("1. Dog");
        System.out.println("2. Cat");
        System.out.println("3. Bird");
        System.out.println("4. Surprise Me");
        System.out.println("0. Exit");
    }

    private static Animal createAnimal(int choice) {
        switch (choice) {
            case 1:
                return new Dog();
            case 2:
                return new Cat();
            case 3:
                return new Bird();
            default:
                return null;
        }
    }

    private static void showRandomAnimal(Random random) {
        Animal animal = createAnimal(random.nextInt(3) + 1);
        animal.show();
    }
}