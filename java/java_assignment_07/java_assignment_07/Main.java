package java_assignment_07.java_assignment_07;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Dog");
            System.out.println("2. Cat");
            System.out.println("3. Bird");
            System.out.println("0. Exit");
            System.out.print("Enter your selection: ");

            if (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.println("'" + input + "' is not a number. Please try again. \n");
                continue;
            }
            int selection = scanner.nextInt();
            Animal animal = null;

            switch (selection) {
                case 1:
                    animal = new Dog();
                    break;
                case 2:
                    animal = new Cat();
                    break;
                case 3:
                    animal = new Bird();
                    break;
                case 0:
                    System.out.println("Goodbye! Thanks for visiting the Zoo!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
        }

        if (animal != null) {
            System.out.println(animal.makeSound());
            System.out.println(animal.describe() + "\n");
        }
    }

        scanner.close();
    }
}