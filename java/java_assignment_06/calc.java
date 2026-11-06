package java_assignment_06;

import java.util.*;

public class calc {
    public static void main(String[] args) {
        System.out.println("Calculator Program Running....");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose mode: 1 for Default Mode, 2 for History Mode, 3 fore undo mode");
        System.out.print("Please choose program mode: ");
        int mode = scanner.nextInt();
        if (mode == 1) {
            DefaultMode();
        } else if (mode == 2) {
            HistoryMode();
        } else if (mode == 3) {
            UndoMode();
        } else {
            System.out.println("Invalid mode selected");
        }
        scanner.close();
    }

    public static void DefaultMode() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Default mode activated");
        System.out.println("Enter exit to quit");
        System.out.println("Commands list: reset, total, add <number>, subtract <number>, exit");
        System.out.print("Please enter your command: ");

        String command = scanner.nextLine();

        // Split the command into parts
        String[] parts = command.split("\\s+");

        // Initialize the result variable
        int result = 0;

        while (!parts[0].equals("exit")) {

            switch (parts[0]) {
                case "reset":
                    result = 0;
                    System.out.println("Reset successful, running total: " + result);
                    break;
                case "total":
                    System.out.println("Current total: " + result);
                    break;
                case "add":
                    try {
                        result += Integer.parseInt(parts[1]);
                        System.out.println("Added " + Integer.parseInt(parts[1]) + ". Running total: " + result);
                    } catch (Exception e) {
                        System.out.println("Invalid number for add command");
                    }
                    break;
                case "subtract":
                    try {
                        result -= Integer.parseInt(parts[1]);
                        System.out.println("Subtracted " + Integer.parseInt(parts[1]) + ". Running total: " + result);
                    } catch (Exception e) {
                        System.out.println("Invalid number for subtract command");
                    }
                    break;
                default:
                    System.out.println("Unknown command: " + parts[0] + ". Please enter valid command");
                    break;

            }
            System.out.println("-------------------------------");
            System.out.println("Commands list: reset, total, add <number>, subtract <number>, exit");
            System.out.print("Please enter your command: ");
            command = scanner.nextLine();
            parts = command.split("\\s+");

        }
        System.out.println("Exiting...");
        scanner.close();

    }

    public static void HistoryMode() {

        Scanner scanner = new Scanner(System.in);
        // Intialize history list
        List<String> history = new ArrayList<>();

        System.out.println("History mode activated");
        System.out.println("Enter exit to quit");
        System.out.println("Commands list: add <number>, subtract <number>, reset, total, history, exit");
        System.out.print("Please enter your command: ");

        String command = scanner.nextLine();

        // Split the command into parts
        String[] parts = command.split("\\s+");

        // Initialize the result variable
        int result = 0;

        while (!parts[0].equals("exit")) {

            switch (parts[0]) {
                case "reset":
                    result = 0;
                    history.add(command);
                    System.out.println("Reset successful, running total: " + result);
                    break;
                case "total":
                    history.add(command);
                    System.out.println("Current total: " + result);
                    break;
                case "add":
                    try {
                        result += Integer.parseInt(parts[1]);
                        history.add(command);
                        System.out.println("Added " + Integer.parseInt(parts[1]) + ". Running total: " + result);
                    } catch (Exception e) {
                        System.out.println("Invalid number for add command");
                    }
                    break;
                case "subtract":
                    try {
                        result -= Integer.parseInt(parts[1]);
                        history.add(command);
                        System.out.println("Subtracted " + Integer.parseInt(parts[1]) + ". Running total: " + result);
                    } catch (Exception e) {
                        System.out.println("Invalid number for subtract command");
                    }
                    break;
                case "history":
                    history.add(command);
                    System.out.println("Command history:");
                    for (String cmd : history) {
                        System.out.println(cmd);
                    }
                    break;
                default:
                    System.out.println("Unknown command: " + parts[0] + ". Please enter valid command");
                    break;

            }

            System.out.println("-------------------------------");
            System.out.println("Commands list: add <number>, subtract <number>, reset, total, history, exit");
            System.out.print("Please enter your command: ");
            command = scanner.nextLine();
            parts = command.split("\\s+");

        }
        System.out.println("Exiting...");
        scanner.close();

    }

    public static void UndoMode() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Undo mode activated");
        System.out.println("Enter exit to quit");
        System.out.println("Commands list: reset, total, add <number>, subtract <number>, exit");
        System.out.print("Please enter your command: ");

        String command = scanner.nextLine();

        // Split the command into parts
        String[] parts = command.split("\\s+");

        // Store previous value
        int prev = -1;
        // Store the value before the previous one
        int prev2 = -1;

        // Initialize the result variable
        int result = 0;

        while (!parts[0].equals("exit")) {

            switch (parts[0]) {
                case "reset":
                    prev = result;
                    result = 0;
                    System.out.println("Reset successful, running total: " + result);
                    break;
                case "total":
                    System.out.println("Current total: " + result);
                    break;
                case "add":
                    try {
                        prev2 = prev;
                        prev = result;
                        result += Integer.parseInt(parts[1]);
                        System.out.println("Added " + Integer.parseInt(parts[1]) + ". Running total: " + result);
                    } catch (Exception e) {
                        System.out.println("Invalid number for add command");
                        // If invalid operation, revert to the previous value
                        prev = prev2;
                        break;
                    }

                    break;
                case "subtract":
                    try {
                        prev2 = prev;
                        prev = result;
                        result -= Integer.parseInt(parts[1]);
                        System.out.println("Subtracted " + Integer.parseInt(parts[1]) + ". Running total: " + result);
                    } catch (Exception e) {
                        System.out.println("Invalid number for subtract command");
                        // If invalid operation, revert to the previous value
                        prev = prev2;
                        break;
                    }

                    break;
                case "undo":
                    if (prev != -1) {
                        result = prev;
                        System.out.println("Undo successful, running total: " + result);
                    } else {
                        System.out.println("Cannot undo, no previous operation available");
                    }
                    prev = -1;
                    break;
                default:
                    System.out.println("Unknown command: " + parts[0] + ". Please enter valid command");
                    break;

            }
            System.out.println("-------------------------------");
            System.out.println("Commands list: reset, total, add <number>, subtract <number>, exit");
            System.out.print("Please enter your command: ");
            command = scanner.nextLine();
            parts = command.split("\\s+");

        }
        System.out.println("Exiting...");
        scanner.close();

    }
}
