package com.revature;

import java.util.Random;
import java.util.Scanner;

public class Main {
    // menu numbers 1 to ANIMAL_COUNT are animals, the option after them is Surprise Me
    private static final int ANIMAL_COUNT = 3;
    private static final int SURPRISE_ME = ANIMAL_COUNT + 1;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int selection = -1;
        while (selection != 0) {
            printMenu();
            System.out.print("Enter your selection: ");
            String input = scanner.nextLine().trim();

            try {
                selection = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                // -1 isn't a menu option, so it falls through to the invalid message below
                selection = -1;
            }

            if (selection == 0) {
                System.out.println("Goodbye! Thanks for visiting the zoo.");
            } else if (selection >= 1 && selection <= ANIMAL_COUNT) {
                showAnimal(selection);
            } else if (selection == SURPRISE_ME) {
                // stretch goal 2
                surpriseMe(random);
            } else {
                System.out.println("'" + input + "' is not a valid selection. Please choose a number from the menu.");
            }
            System.out.println();
        }

        scanner.close();
    }

    public static void printMenu() {
        for (int i = 1; i <= ANIMAL_COUNT; i++) {
            System.out.println(i + ". " + createAnimal(i).getName());
        }
        System.out.println(SURPRISE_ME + ". Surprise Me");
        System.out.println("0. Exit");
    }

    // normal solution
    public static Animal createAnimal(int selection) {
        switch (selection) {
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

    public static void showAnimal(int selection) {
        Animal animal = createAnimal(selection);
        animal.perform();

        System.out.println("-----Stretch Goal 1-----");
        // stretch goal 1
        System.out.println(animal.describeWithDetails());
    }

    // stretch goal 2
    public static void surpriseMe(Random random) {
        System.out.println("-----Stretch Goal 2-----");
        
        // nextInt(ANIMAL_COUNT) gives 0 to ANIMAL_COUNT - 1, so add 1 to match the menu numbers
        int randomSelection = random.nextInt(ANIMAL_COUNT) + 1;
        System.out.println("Surprise! You got the " + createAnimal(randomSelection).getName() + ".");
        showAnimal(randomSelection);
    }
}
