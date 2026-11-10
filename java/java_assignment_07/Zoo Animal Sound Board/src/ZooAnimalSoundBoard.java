/**
     * @param args the command line arguments
     * Java assignment 07 - Zoo Animal Sound Board
     * Objective: Practice defining a class hierarchy using an abstract base class, overriding behavior in multiple subclasses, and selecting/instantiating the correct subclass based on user input read in a loop.
     * 1. Define an abstract class named Animal. This class should declare (at minimum) two abstract methods:
        makeSound() — returns or prints the animal's sound
        describe() — returns or prints a short description specific to that animal
     * 2. Create at least three subclasses of Animal (for example, Dog, Cat, Bird), each providing its own implementation of makeSound() and describe().
     * 3. Using Scanner, display a number-based menu of the available animals, along with an option to exit. 
     * 4. In a loop, prompt the user to enter a number corresponding to their selection. If the user selects a valid animal number, instantiate the corresponding subclass and call its makeSound() and describe() methods to display animal-specific output, then show the menu again for another selection. If the user enters 0, print a farewell message and end the program. If the user enters a number that does not correspond to any menu option, or a non-numeric value, handle this gracefully with a clear message, and show the menu again rather than crashing. Avoid duplicating shared logic across your subclasses where the abstract base class can hold it instead.
*/

import java.util.Scanner;

public class ZooAnimalSoundBoard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int selection = -1;
        while (selection != 0) {
            System.out.println("1. Dog");
            System.out.println("2. Cat");
            System.out.println("3. Bird");
            System.out.println("0. Exit");
            System.out.print("Enter your selection: ");

            if (scanner.hasNextInt()) {
                selection = scanner.nextInt();
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
                        System.out.println("Goodbye! Thanks for visiting the zoo.");
                        break;
                    default:
                        System.out.println(selection +
                        " is not a valid selection. Please choose a number from the menu.");
                        break;
                }
                
                if (animal != null) {
                    animal.makeSound();
                    animal.describe();
                }
            } else {
                String invalidInput = scanner.next();
                System.out.println("'" + invalidInput +
                        "' is not a valid selection. Please enter a number.");
            }
        }
        scanner.close();
    }
}
