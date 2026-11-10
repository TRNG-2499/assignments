import java.util.Scanner;

public class Solution_07 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Dog");
            System.out.println("2. Cat");
            System.out.println("3. Bird");
            System.out.println("4. Surprise Me");
            System.out.println("0. Exit");
            System.out.println("Enter your selection");

            int choice;
            try {
                String input = scanner.nextLine().trim();  
                choice = Integer.parseInt(input);       
            } 
            catch (NumberFormatException e) {
                System.out.println("'Input' is not a valid selection. Please choose a number from the menu.");
                continue;  // Re-show menu without crashing
            }
            Animal animal = null;

            switch (choice) {
                case 1 -> animal = new Dog("Buddy", "Golden Retriever");
                case 2 -> animal = new Cat("Bolt", true);
                case 3 -> animal = new Bird("Tweety", true);
                case 4 -> {
                    Animal[] pool = new Animal[] {
                        new Dog("Buddy", "Golden Retriever"),
                        new Cat("Bolt", true),
                        new Bird("Tweety", true)
                    };
                    animal = pool[(int) (Math.random() * pool.length)];
                }
                case 0 -> {
                    System.out.println("Goodbye! Thanks for visiting the zoo.");
                    running = false;
                }
                default -> {
                    System.out.println("'" + choice + "' is not a valid selection. Please choose a number from the menu.");
                    animal = null;
                }
            }

            if (animal != null) {
                animal.makeSound();
                animal.describe();
            }
        }
        scanner.close();
    }
}
