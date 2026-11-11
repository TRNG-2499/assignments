package ZooAnimal;

import java.util.Scanner;

public class Zoo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Dog");
            System.out.println("2. Cat");
            System.out.println("3. Bird");
            System.out.println("0. Exit");
            System.out.print("Enter your selection: ");
            String input = sc.nextLine();

            if (input.equals("0")) {
                System.out.println("Goodbye! Thanks for visiting the zoo.");
                break;
            } else if (input.equals("1")) {
                Dog myDog = new Dog();
                myDog.makeSound();
                myDog.describe();
            } else if (input.equals("2")) {
                Cat myCat = new Cat();
                myCat.makeSound();
                myCat.describe();
            } else if (input.equals("3")) {
                Bird myBird = new Bird();
                myBird.makeSound();
                myBird.describe();
            } else {
                System.out.println("'" + input + "' is not a valid selection. Please choose a number from the menu.");
            }

            System.out.println();
        }

        sc.close();
    }
}
