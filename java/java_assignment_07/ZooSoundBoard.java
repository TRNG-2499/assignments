package assignments.java.java_assignment_07;
import java.util.Scanner;


public class ZooSoundBoard {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Dog d = new Dog();
        // Cat c = new Cat();
        // Bird b = new Bird();

        Animal animal = null;

        while (running) {
            printMenu();

            System.out.print("Enter your selection: ");
            String input = scanner.nextLine();

            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue; // back to start of loop

            }

            switch(choice) {
            case 0:
                System.out.println("Goodbye. Thanks for visiting the Zoo!");
                running = false;
                break;
            case 1:
                animal = new Dog();
                animal.perform();
                break;
            case 2:                
                animal = new Cat();
                animal.perform();
                break;
            case 3:
                animal = new Bird();
                animal.perform();
                break;
            default:
                System.out.println(choice + " is not a valid selection");
                break;
            }
        }

        scanner.close();

    }

    public static void printMenu() {
        System.out.println("Menu:");
        System.out.println("1. Dog");
        System.out.println("2. Cat");
        System.out.println("3. Bird");
        System.out.println("0. Exit");
    }
    
}
