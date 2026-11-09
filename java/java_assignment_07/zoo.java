package java_assignment_07;

import java.util.*;

abstract class Animal {

    abstract void makeNoise();

    abstract void describe();

}

class Dog extends Animal {

    String breed;

    public Dog(String breed) {
        this.breed = breed;
    }

    @Override
    void makeNoise() {
        System.out.println("Woof! Woof!");
    }

    @Override
    void describe() {
        System.out.println("The " + this.breed + " wags its tail excitedly and looks up at you.");
    }
}

class Cat extends Animal {

    String breed;

    public Cat(String breed) {
        this.breed = breed;
    }

    @Override
    void makeNoise() {
        System.out.println("Meow~");
    }

    @Override
    void describe() {
        System.out.println("The " + this.breed + " curls up and purrs softly.");
    }
}

class Bird extends Animal {

    Boolean canFly;

    public Bird(Boolean canFly) {
        this.canFly = canFly;
    }

    @Override
    void makeNoise() {
        System.out.println("Tweet! Tweet!");
    }

    @Override
    void describe() {
        System.out.println(
                "The " + (this.canFly ? "flying" : "flightless") + " bird tilts its head and hops along its perch.");
    }
}

public class zoo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int choice = -1;

        while (choice != 0) {

            System.out.println("1. Dog");
            System.out.println("2. Cat");
            System.out.println("3. Bird");
            System.out.println("4. Surprise Me");
            System.out.println("0. Exit");
            choice = scanner.nextInt();
            if (choice == 4) {
                choice = (int) (Math.random() * 3) + 1;
            }
            System.out.println("------------------------");

            switch (choice) {
                case 1:
                    Dog dog = new Dog("Labrador");
                    dog.makeNoise();
                    dog.describe();
                    break;
                case 2:
                    Cat cat = new Cat("Siamese");
                    cat.makeNoise();
                    cat.describe();
                    break;
                case 3:
                    Bird bird = new Bird(true);
                    bird.makeNoise();
                    bird.describe();
                    break;

                case 0:
                    System.out.println("Goodbye! Thanks for visiting the zoo.");
                    return;
                default:
                    System.out.println(choice + " is not a valid selection. Please choose a number from the menu.");
                    break;
            }

        }
        System.out.println("Goodbye! Thanks for visiting the zoo.");
        scanner.close();
        return;

    }
}
