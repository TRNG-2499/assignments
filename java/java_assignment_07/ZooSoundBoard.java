import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;


abstract class Animal {
    public abstract void makeSound();
    public abstract void describe();

    public void doBoth() {
        makeSound();
        describe();
    }
}


class Dog extends Animal {
    private final String breed = "Golden doodle";

    public void makeSound() {
        System.out.println("Woof");
    }

    public void describe() {
        System.out.printf("The %s wags its tail%n", breed);
    }
}


class Cat extends Animal {
    private final String build = "Chunky";

    public void makeSound() {
        System.out.println("Meow");
    }

    public void describe() {
        System.out.printf("The %s cat is eating its food%n", build);
    }
}


class Bird extends Animal {
    private final String color = "Green";

    public void makeSound() {
        System.out.println("Chirp");
    }

    public void describe() {
        System.out.printf("The %s bird can fly%n", color);
    }
}


public class ZooSoundBoard {

    public static void main (String[] args) {
        boolean keepRunning = true;
        Scanner scanner = new Scanner(System.in);

        Dog dog = new Dog();
        Cat cat = new Cat();
        Bird bird = new Bird();

        Random rng = new Random();

        while (keepRunning) {
            System.out.println("");

            System.out.println("1. Dog");
            System.out.println("2. Cat");
            System.out.println("3. Bird");
            System.out.println("4. Surprise me");
            System.out.println("0. Exit");

            System.out.print("Selection: ");

            int userChoice = 0;
            try {
                userChoice = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid input provided");
                continue;
            }

            if (userChoice < 0 || userChoice > 4) {
                System.out.println("Invalid input provided");
                continue;
            }

            // Random animal selector condition
            if (userChoice == 4) {
                userChoice = rng.nextInt(1, 4);
            }

            switch (userChoice) {
                case 1:
                    dog.doBoth();
                    break;
                case 2:
                    cat.doBoth();
                    break;
                case 3:
                    bird.doBoth();
                    break;
                case 0:
                    System.out.println("Program has exited");
                    keepRunning = false;
                    break;
            }
        }

        scanner.close();
    }
}