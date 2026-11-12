import java.util.Scanner;

public class Solution {
    public static void zoo()
    {
        Animal dog = new Dog();
        Animal cat = new Cat();
        Animal bird = new Bird();
       
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n1. Dog");
            System.out.println("2. Cat");
            System.out.println("3. Bird");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();

                switch (choice) {
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
                        System.out.println("Exiting the zoo. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); 
            }
            
        } while (true);
        
    }
    public static void main(String[] args) {
        zoo();
    }
}
