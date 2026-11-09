/**
     * @param args the command line arguments
     * Java assignment 06 - Command Based Calculator
     * Objective: Practice using Scanner to read repeated input from the console inside a loop, parsing a line of input into a command and an argument, and maintaining state (a running value) across iterations until an exit condition is met.
     * 1. This program maintains a running numeric value as a into starting at 0. Inside a loop, prompt user to enter a command. The command includes add [number], subtract [number], reset,total and exit.
     * 2. After each command (other than exit), print a confirmation message along with the updated running value. total should simply print the current value, without implying any change occurred.
     * 3. The loop should continue until the user enters exit, at which point the program should print a final farewell message along with the final running value, and then stop.
*/

import java.util.Scanner;

public class CommandCalculator {

    public static int[] handleCommand(String input, int total) {
        String[] parts = input.trim().split("\\s+");
        String command = parts[0].toLowerCase();

        switch (command) {
            case "add":
                if (parts.length < 2) {
                    System.out.println("'add' requires a valid number. Please enter a valid number.");
                    break;
                }
                try {
                    int number = Integer.parseInt(parts[1]);
                    total += number;
                    System.out.println("Added " + number +
                            ". Running total: " + total);
                } catch (NumberFormatException e) {
                    System.out.println("'add' requires a valid number. Please enter a valid number.");
                }
                break;
            case "subtract":
                if (parts.length < 2) {
                    System.out.println("'subtract' requires a valid number. Please enter a valid number.");
                    break;
                }
                try {
                    int number = Integer.parseInt(parts[1]);
                    total -= number;
                    System.out.println("Subtracted " + number +
                            ". Running total: " + total);

                } catch (NumberFormatException e) {
                    System.out.println("'subtract' requires a valid number. Please enter a valid number.");
                }
                break;
            case "reset":
                total = 0;
                System.out.println("Running total has been reset to 0.");
                break;
            case "total":
                System.out.println("Current total: " + total);
                break;
            case "exit":
                System.out.println("Goodbye! Final total: " + total);
                return new int[]{total, 0};
            default:
                System.out.println("Unrecognized command: '" + command + "'");
                break;
        }
        return new int[]{total, 1};
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int total = 0;
        boolean running = true;

        while (running) {
            System.out.print("Enter a command: ");
            String input = scan.nextLine();

            int[] result = handleCommand(input, total);
            total = result[0];
            running = result[1] == 1;
        }
        scan.close();
    }
}
