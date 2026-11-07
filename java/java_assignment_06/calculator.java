

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class calculator {
    
    protected enum Command {
        ADD, SUBTRACT, RESET, TOTAL, EXIT
    }

    protected enum ExtendedCommand {
        ADD, SUBTRACT, RESET, TOTAL, HISTORY, UNDO, EXIT
    }

    public static void calculate() {
        Scanner scanner = new Scanner(System.in);

        int total = 0;
        boolean running = true;

        while (running) {

            System.out.print("Enter a command: ");
            String input = scanner.nextLine().trim();

            String[] parts = input.split("\\s+");
            String commandText = parts[0].toUpperCase();
            Command command;

            try {
                command = Command.valueOf(commandText);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: Unrecognized command." + "\n");
                continue;
            }

            switch (command) {

                case ADD:
                case SUBTRACT:
                    if (parts.length < 2) {
                        System.out.println("Error: Please provide a number.");
                        break;
                    }

                    int number;

                    try {
                        number = Integer.parseInt(parts[1]);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Please enter a valid integer." + "\n");
                        break;
                    }

                    if (command == Command.ADD) {
                        total += number;
                        System.out.println("Added " + number + ". Current total: " + total + "\n");
                    } else {
                        total -= number;
                        System.out.println("Subtracted " + number + ". Current total: " + total);
                    }

                    break;

                case RESET:
                    total = 0;
                    System.out.println("Running total has been reset to 0." + "\n");
                    break;

                case TOTAL:
                    System.out.println("Current total: " + total + "\n");
                    break;

                case EXIT:
                    running = false;
                    System.out.println("Goodbye! Final total: " + total);
                    break;
            }
        }

        scanner.close();

    }

    public static void cmdHistory(List<String> history) {

        if (history.isEmpty()) {
            System.out.println("No commands have been entered yet.");
            return;
        }

        System.out.println("Command History:");

        for (int i = 0; i < history.size(); i++) {
            System.out.println((i + 1) + ". " + history.get(i));
        }
    }

    public static int undo(Deque<Integer> previousTotals, int total) {

        if (previousTotals.isEmpty()) {
            System.out.println("Nothing to undo. Current total: " + total);
            return total;
        }

        total = previousTotals.pop();

        System.out.println("Last command undone. Current total: " + total);

        return total;
    }

    public static void calculateWithHistory() {
        runExtendedCalculator(true, false);
    }

    public static void calculateWithUndo() {
        runExtendedCalculator(false, true);
    }


    public static void runExtendedCalculator(boolean enableHistory, boolean enableUndo) {

        Scanner scanner = new Scanner(System.in);

        int total = 0;
        boolean running = true;

        List<String> history = new ArrayList<>();
        Deque<Integer> previousTotals = new ArrayDeque<>();

        while (running) {

            System.out.print("Enter a command: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Error: Please enter a command.");
                continue;
            }

            String[] parts = input.split("\\s+");
            String commandText = parts[0].toUpperCase();

            ExtendedCommand command;

            try {
                command = ExtendedCommand.valueOf(commandText);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: Unrecognized command.");
                continue;
            }

            // Check whether this command is enabled
            if (command == ExtendedCommand.HISTORY && !enableHistory) {
                System.out.println("History is not enabled.");
                continue;
            }

            if (command == ExtendedCommand.UNDO && !enableUndo) {
                System.out.println("Undo is not enabled.");
                continue;
            }

            // Validate command arguments
            if ((command == ExtendedCommand.ADD ||
                command == ExtendedCommand.SUBTRACT) && parts.length != 2) {
                System.out.println("Error: Please provide exactly one integer.");
                continue;
            }

            if (command != ExtendedCommand.ADD &&
                command != ExtendedCommand.SUBTRACT && parts.length != 1) {
                System.out.println("Error: This command does not accept arguments.");
                continue;
            }

            int number = 0;

            if (command == ExtendedCommand.ADD ||
                command == ExtendedCommand.SUBTRACT) {

                try {
                    number = Integer.parseInt(parts[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Error: Please enter a valid integer.");
                    continue;
                }
            }

            // Record valid commands when history is enabled
            if (enableHistory) {
                history.add(input);
            }

            switch (command) {

                case ADD:
                    if (enableUndo) {
                        previousTotals.push(total);
                    }

                    total += number;
                    System.out.println("Added " + number +
                        ". Current total: " + total);
                    break;

                case SUBTRACT:
                    if (enableUndo) {
                        previousTotals.push(total);
                    }

                    total -= number;
                    System.out.println("Subtracted " + number +
                        ". Current total: " + total);
                    break;

                case RESET:
                    if (enableUndo) {
                        previousTotals.push(total);
                    }

                    total = 0;
                    System.out.println("Total reset. Current total: " + total);
                    break;

                case TOTAL:
                    System.out.println("Current total: " + total);
                    break;

                case HISTORY:
                    cmdHistory(history);
                    break;

                case UNDO:
                    total = undo(previousTotals, total);
                    break;

                case EXIT:
                    running = false;
                    System.out.println("Goodbye! Final total: " + total);
                    break;
            }
        }
    }


    public static void main(String[] args) {
        //calculate();
        calculateWithHistory();
        calculateWithUndo();
    }
}
