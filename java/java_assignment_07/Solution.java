package java_assignment_07;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        runZooSoundBoard(scan);
        scan.close();
    }

    private static void runZooSoundBoard(Scanner scan) {
        while (true) {
            printMenu();
            System.out.print("Enter your selection: ");

            if (!scan.hasNextLine()) {
                System.out.println();
                System.out.println("Goodbye! Thanks for visiting the zoo.");
                return;
            }

            String selection = scan.nextLine().trim();
            if (selection.equals("0")) {
                System.out.println("Goodbye! Thanks for visiting the zoo.");
                return;
            }

            Animal animal = createAnimal(selection);
            if (animal == null) {
                System.out.println("'" + selection
                        + "' is not a valid selection. Please choose a number from the menu.");
            } else {
                animal.displayInformation();
            }

            System.out.println();
        }
        
    }

    private static void printMenu() {
        System.out.println("1. Dog");
        System.out.println("2. Cat");
        System.out.println("3. Bird");
        System.out.println("0. Exit");
    }

    private static Animal createAnimal(String selection) {
        switch (selection) {
            case "1":
                return new Dog();
            case "2":
                return new Cat();
            case "3":
                return new Bird();
            default:
                return null;
        }
    }
}
