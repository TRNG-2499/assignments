import java.util.Scanner;

public class Solution {
    
    public static void calculate()
    {
        int total = 0;
        Scanner scanner = new Scanner(System.in);
        String command;
        int number = 0;

        do {
            System.out.println("\nCommands: ");
            System.out.println("add [number] - Adds a number to the total");
            System.out.println("subtract [number] - Subtracts a number from the total");
            System.out.println("reset - Resets the total to 0");
            System.out.println("total - Displays the current total");
            System.out.println("exit - Exits the program");

            System.out.print("Enter command: ");

            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            command = parts[0].toLowerCase();
            if (parts.length > 1) {
                number = Integer.parseInt(parts[1]);
            }
           if (command.equals("add")) {
                total += number;
                System.out.println("Added " + number + ". New total: " + total);
            } else if (command.equals("subtract")) {
                total -= number;
                System.out.println("Subtracted " + number + ". New total: " + total);
            } else if (command.equals("reset")) {
                total = 0;
                System.out.println("Total reset to 0.");
            } else if (command.equals("total")) {
                System.out.println("Current total: " + total);
            } else if (!command.equals("exit")) {
                System.out.println("Invalid command. Please try again.");
            }

        } while (!command.equals("exit"));
        System.out.println("Exiting the program. Final total: " + total);
    }
    public static void main(String[] args) {
        calculate();
    }


}
