package java_assignment_06;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        runCalculator();
    }

    private static void runCalculator() {
        Scanner scan = new Scanner(System.in);
        int runningTotal = 0;
        System.out.println("Commands:");
        System.out.println("  add [number]      - Add a number to the running total");
        System.out.println("  subtract [number] - Subtract a number from the running total");
        System.out.println("  reset             - Set the running total to 0");
        System.out.println("  total             - Display the current running total");
        System.out.println("  exit              - Quit and display the final total");
        System.out.println();

        while (true) {
            System.out.print("Enter a command: ");
            if (!scan.hasNextLine()) {
                System.out.println();
                System.out.println("Goodbye! Final total: " + runningTotal);
                break;
            }

            String input = scan.nextLine().trim();
            String[] parts = input.split("\\s+");
            if (parts.length == 1 && parts[0].equals("exit")) {
                System.out.println("Goodbye! Final total: " + runningTotal);
                break;
            }

            runningTotal = handleCommand(parts, runningTotal);
            System.out.println();
        }
    }

    private static int handleCommand(String[] parts, int runningTotal) {
        String command = parts[0];

        switch (command) {
            case "add":
            case "subtract":
                if (parts.length != 2) {
                    System.out.println("'" + command
                            + "' requires a valid number. Please try again.");
                    return runningTotal;
                }

                int number;
                try {
                    number = Integer.parseInt(parts[1]);
                } catch (NumberFormatException exception) {
                    System.out.println("'" + command
                            + "' requires a valid number. Please try again.");
                    return runningTotal;
                }

                if (command.equals("add")) {
                    runningTotal += number;
                    System.out.println("Added " + number + ". Running total: " + runningTotal);
                } else {
                    runningTotal -= number;
                    System.out.println("Subtracted " + number + ". Running total: " + runningTotal);
                }
                return runningTotal;
            case "reset":
                System.out.println("Running total has been reset to 0.");
                return 0;
            case "total":
                System.out.println("Current total: " + runningTotal);
                return runningTotal;
            default:
                System.out.println("Unrecognized command: '" + command + "'");
                return runningTotal;
        }
    }

}
