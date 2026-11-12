/*
normally you would do seperate files for the animals but this time i will put it in one file
 */

public abstract class Animal {
    private final String name;

    protected Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String makeSound();
    public abstract String describe();

    // Shared
    public void present() {
        System.out.println(makeSound());
        System.out.println(describe());
    }
}

public class Dog extends Animal {
    public Dog() {
        super("Dog");
    }

    @Override
    public String makeSound() {
        return "Woof! Woof!";
    }

    @Override
    public String describe() {
        return "The dog wags its tail excitedly and looks up at you.";
    }
}
public class Cat extends Animal {
    public Cat() {
        super("Cat");
    }

    @Override
    public String makeSound() {
        return "Meow!";
    }

    @Override
    public String describe() {
        return "The cat stretches lazily and blinks slowly at you.";
    }
}
public class Bird extends Animal {
    public Bird() {
        super("Bird");
    }

    @Override
    public String makeSound() {
        return "Tweet! Tweet!";
    }

    @Override
    public String describe() {
        return "The bird tilts its head and hops along its perch.";
    }
}

//zoo logic
import java.util.Scanner;

public class Zoo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            System.out.print("Enter your selection: ");

            if (!scanner.hasNextLine()) {
                break; // 
            }
            String input = scanner.nextLine().trim();

            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("'" + input + "' is not a valid selection. Please choose a number from the menu.");
                System.out.println();
                continue;
            }

            if (choice == 0) {
                System.out.println("Goodbye! Thanks for visiting the zoo.");
                break;
            }

            Animal animal = createAnimal(choice);
            if (animal == null) {
                System.out.println("'" + input + "' is not a valid selection. Please choose a number from the menu.");
            } else {
                animal.present();
            }
            System.out.println();
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("1. Dog");
        System.out.println("2. Cat");
        System.out.println("3. Bird");
        System.out.println("0. Exit");
    }

    private static Animal createAnimal(int choice) {
        switch (choice) {
            case 1: return new Dog();
            case 2: return new Cat();
            case 3: return new Bird();
            default: return null;
        }
    }
}