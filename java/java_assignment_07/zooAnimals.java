package java_assignment_07;

import java.util.Scanner;

abstract class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    abstract void makeSound();
    abstract void describe();
}

class Dog extends Animal {
    String breed;

    public Dog(String name) {
        super(name);
    }

    public Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    @Override
    void makeSound() {
        System.out.println(name + " says Woof!");
    }

    @Override
    void describe() {
        if (breed == null || breed.isEmpty()) {
            System.out.println(name + " wags its tail excitedly and looks up at you.");
        } else {
            System.out.println(name + " (" + breed + ") wags its tail excitedly and looks up at you.");
        }
    }
}

class Cat extends Animal {
    boolean hasYarnBall;
    public Cat(String name) {
        super(name);
        this.hasYarnBall = false;
    }
    public Cat(String name, boolean hasYarnBall) {
        super(name);
        this.hasYarnBall = hasYarnBall;
    }

    @Override
    void makeSound() {
        System.out.println(name + " says Meow!");
    }

    @Override
    void describe() {
        if (hasYarnBall) {
            System.out.println(name + " plays with a yarn ball.");
        } else {
            System.out.println(name + " knocks a glass of water off the table.");
        }
    }
}

class Bird extends Animal {
    boolean canFly;

    public Bird(String name) {
        super(name);
        this.canFly = false; 
    }

    public Bird(String name, boolean canFly) {
        super(name);
        this.canFly = canFly;
    }

    @Override
    void makeSound() {
        System.out.println(name + " says Tweet!");
    }

    @Override
    void describe() {
        if (canFly) {
            System.out.println(name + "  flutters its wings and soars through the air.");
        } else {
            System.out.println(name + "  tilts its head and hops along its perch.");
        }
    }
}



public class zooAnimals {

    public static void displayMenu() {
        System.out.println("1. Dog");
        System.out.println("2. Cat");
        System.out.println("3. Bird");
        System.out.println("0. Exit");
        System.out.print("Enter your selection: ");
    }

    public static void runAnimals() {
        Scanner scanner = new Scanner(System.in);
        int selection = -1;
        

        Animal dog = new Dog("Dog");
        Animal cat = new Cat("Cat");
        Animal bird = new Bird("Bird");

        while (selection != 0) {
            displayMenu();
            selection = scanner.nextInt();
            if (selection != 1 && selection != 2 && selection != 3 && selection != 0) {
                System.out.println(selection + " is not a valid selection. Please choose a number from the menu.");
            } else {
                switch (selection) {
                    case 1:
                        dog.makeSound();
                        dog.describe();
                        break;
                    case 2:
                        cat.makeSound();
                        cat.describe();
                        break;
                    case 3:
                        bird.makeSound();
                        bird.describe();
                        break;
                    case 0:
                        System.out.println("Goodbye! Thanks for visiting the zoo.");
                        break;
                }
            }
            System.out.println();
        }
        scanner.close();
    }

    public static void randomizer() {
        Scanner scanner = new Scanner(System.in);
        int selection = -1;
        

        Animal dog = new Dog("Dog", "Golden Retriever");
        Animal cat = new Cat("Cat", true);
        Animal bird = new Bird("Bird", true);

        while (selection != 0) {
            System.out.println("1. Dog");
            System.out.println("2. Cat");
            System.out.println("3. Bird");
            System.err.println("-1. Random!");
            System.out.println("0. Exit");
            System.out.print("Enter your selection: ");
            selection = scanner.nextInt();
            if (selection != 1 && selection != 2 && selection != 3 && selection != 0 && selection != -1) {
                System.out.println(selection + " is not a valid selection. Please choose a number from the menu.");
                break;
            } else {
                if (selection == -1) {selection = (int) (Math.random() * (3 - 1 + 1)) + 1;}
                switch (selection) {
                    case 1:
                        dog.makeSound();
                        dog.describe();
                        break;
                    case 2:
                        cat.makeSound();
                        cat.describe();
                        break;
                    case 3:
                        bird.makeSound();
                        bird.describe();
                        break;
                    case 0:
                        System.out.println("Goodbye! Thanks for visiting the zoo.");
                        break;
                }
            }
            System.out.println();
        }
        scanner.close();
    }

    public static void additionalAttributes() {
        Scanner scanner = new Scanner(System.in);
        int selection = -1;
        

        Animal dog = new Dog("Dog", "Golden Retriever");
        Animal cat = new Cat("Cat", true);
        Animal bird = new Bird("Bird", true);

        while (selection != 0) {
            
            selection = scanner.nextInt();
            if (selection != 1 && selection != 2 && selection != 3 && selection != 0) {
                System.out.println(selection + " is not a valid selection. Please choose a number from the menu.");
            } else {
                switch (selection) {
                    case 1:
                        dog.makeSound();
                        dog.describe();
                        break;
                    case 2:
                        cat.makeSound();
                        cat.describe();
                        break;
                    case 3:
                        bird.makeSound();
                        bird.describe();
                        break;
                    case 0:
                        System.out.println("Goodbye! Thanks for visiting the zoo.");
                        break;
                }
            }
            System.out.println();
        }

        scanner.close();
    }

    public static void main(String[] args) {
        // runAnimals();
        // additionalAttributes();
        randomizer();
    }
    
}
