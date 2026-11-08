
// Author: Tyler Pyrzenski


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;


public class solution {
    static int runningTotal = 0;

    // used by the stretch goals
    static List<String> commandHistory = new ArrayList<>();
    static Deque<Integer> undoStack = new ArrayDeque<>();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a command: ");

            // reads the whole line, then splits it into the command and its argument
            String line = scan.nextLine().trim();
            String[] parts = line.split("\\s+");
            String commandInput = parts[0];

            if (line.isEmpty()) {
                continue;
            }

            if (commandInput.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye! Final total: " + runningTotal);
                break;
            }

            // stretch goal commands
            if (commandInput.equalsIgnoreCase("history")) {
                System.out.println(printHistory());
            } else if (commandInput.equalsIgnoreCase("undo")) {
                System.out.println(undoLastCommand());
            } else {
                // saves the total before the command runs so it can be undone later
                int totalBefore = runningTotal;
                System.out.println(handleCommand(parts));
                recordCommand(parts, totalBefore);
            }

            System.out.println();
        }
        scan.close();

    }

    // handles a single command and returns the message to show
    public static String handleCommand(String[] parts) {

        String commandInput = parts[0];

        if (commandInput.equalsIgnoreCase("add") || commandInput.equalsIgnoreCase("subtract")) {

            // missing number
            if (parts.length < 2) {
                return "'" + commandInput + "' requires a valid number. Please try again.";
            }

            // non-numeric number
            int numInput;
            try {
                numInput = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                return "'" + commandInput + "' requires a valid number. Please try again.";
            }

            return calculationsMethod(commandInput, numInput);

        } else if (commandInput.equalsIgnoreCase("total")) {
            return "Current total: " + runningTotal;
        } else if (commandInput.equalsIgnoreCase("reset")) {
            runningTotal = 0;
            return "Running total has been reset to 0.";
        } else {
            return "Unrecognized command: '" + commandInput + "'";
        }
    }

    public static String calculationsMethod(String commandInput, int numInput) {

        String message = "";

        if (commandInput.equalsIgnoreCase("add")) {
            runningTotal = runningTotal + numInput;
            message = "Added " + numInput + ". Running total: " + runningTotal;
        } else if (commandInput.equalsIgnoreCase("subtract")) {
            runningTotal = runningTotal - numInput;
            message = "Subtracted " + numInput + ". Running total: " + runningTotal;
        }
        return message;

    }

    // stretch goals: command history and undo

    // checks if a command was valid so only valid ones get recorded
    public static boolean isValidCommand(String[] parts) {

        String commandInput = parts[0].toLowerCase();

        switch (commandInput) {
            case "add":
            case "subtract":
                if (parts.length < 2) {
                    return false;
                }
                try {
                    Integer.parseInt(parts[1]);
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            case "total":
            case "reset":
                return true;
            default:
                return false;
        }
    }

    // adds valid commands to the history, and saves the old total for anything undo can reverse
    public static void recordCommand(String[] parts, int totalBefore) {

        if (!isValidCommand(parts)) {
            return;
        }

        String commandInput = parts[0].toLowerCase();

        if (commandInput.equals("total")) {
            commandHistory.add(commandInput);
        } else if (commandInput.equals("reset")) {
            commandHistory.add(commandInput);
            undoStack.push(totalBefore);
        } else {
            commandHistory.add(commandInput + " " + Integer.parseInt(parts[1]));
            undoStack.push(totalBefore);
        }
    }

    // prints every valid command in the order it was entered
    public static String printHistory() {

        if (commandHistory.isEmpty()) {
            return "No commands in history yet.";
        }

        String output = "Command history:";

        for (int i = 0; i < commandHistory.size(); i++) {
            output = output + "\n" + (i + 1) + ". " + commandHistory.get(i);
        }
        return output;
    }

    // restores the total to what it was before the last add, subtract, or reset
    public static String undoLastCommand() {

        if (undoStack.isEmpty()) {
            return "Nothing to undo.";
        }

        runningTotal = undoStack.pop();
        commandHistory.add("undo");
        return "Undid last command. Running total: " + runningTotal;
    }
}