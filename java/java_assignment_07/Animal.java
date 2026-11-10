import java.util.Scanner;
abstract class Animal {

    public abstract void makeSound();
    public abstract void describe();
    
    public static void main(String[] args) {
     Animal d = new Dog();
     Animal c = new Cat();
     Animal b = new Bird();
    Scanner scan = new Scanner(System.in);
    System.out.println(" 1. Dog\n 2. Cat \n 3. Bird\n 0. Exit \nEnter your selection:");
    int input = scan.nextInt();
    while (true) {
        if (input == 0 ) {
            System.out.println("Goodbye! Thanks for visiting the zoo.");
            break;
        }
    switch(input) {
        case 1:
            d.makeSound();
            d.describe();
            break;
        case 2:
            c.makeSound();
            c.describe();
            break;
        case 3:
            b.makeSound();
            b.describe();
            break;
        default:
            System.out.println(input +" is not a valid selection. Please choose a number from the menu.");
            break;
    }
    System.out.println("Please select another animal (or 0 to exit):");
    input = scan.nextInt();
    }
    
}
}
class Dog extends Animal {
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }
    public void describe() {
        System.out.println("The dog wags its tail excitedly and looks up at you.");
    }
}
class Cat extends Animal {
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }
    public void describe() {
        System.out.println("The cat looks up at you.");
    }
}
class Bird extends Animal {
    public void makeSound() {
        System.out.println("Tweet! Tweet!");
    }
    public void describe() {
        System.out.println("The bird tilts its head and hops along its perch.");
    }
}

