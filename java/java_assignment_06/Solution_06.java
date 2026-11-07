import java.util.ArrayList;
import java.util.Scanner;

public class Solution_06 {

    private static ArrayList<String> commandHistory = new ArrayList<>();
    private static ArrayList<Integer> valueHistory = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int runningValue = 0;

        valueHistory.add(runningValue);

        while (true) {
            System.out.println("Enter a command: ");
            String input = sc.nextLine();

            if (input.equals("exit")) {
                System.out.println("Goodbye! Final total: " + runningValue);
                break;
            }
            
            runningValue = paraseCommand(input, runningValue);
        }
    }

    public static int paraseCommand(String input, int currentTotal) {
        String[] parts = input.trim().split("\\s+", 2);
        String action = parts[0];

        switch (action) {
            case "add":
                int addResult = handleAdd(currentTotal, parts.length > 1 ? parts[1] : "");

                // if the value actually chnaged or was a valid command, it's recored for history fet. 
                if (addResult != currentTotal || action.equals("add")) {
                    // only adds to hist. if the input was not just an error/blank
                    if (parts.length > 1) {
                        commandHistory.add(input);
                        valueHistory.add(addResult);
                    }
                }
                return addResult;

            case "subtract": 
                int subResult = handleSubtract(currentTotal, parts.length > 1 ? parts[1] : "");
                if (subResult != currentTotal || action.equals("subtract")) {
                    if (parts.length > 1) {
                        commandHistory.add(input);
                        valueHistory.add(subResult);
                    }
                }
                return subResult;

            case "reset":
                // this is a diffrent state chnage
                int resetRes = handleReset();
                commandHistory.add(input);
                valueHistory.add(resetRes);
                return resetRes;

            case "total":
                return handleTotal(currentTotal);

            case "history":
                // hist. doesn't change the current total, so the code just return
                handleHistory();
                return currentTotal;
            case "undo":
                // changes the state, so the code need to pop from our lists
                return handleUndo(currentTotal);
        
            default:
                System.out.println("Unrecognized command: " + action + "");
                return currentTotal;
        }

    }

    // Method to handle add
    private static int handleAdd(int current, String amountStr) {
        if (amountStr.isEmpty()) {
            System.out.println("'add' requires a valid number.");
            return current;
        }
        
        try {
            int amount = Integer.parseInt(amountStr);
            int newTotal = current + amount;
            System.out.println("Added " + amount + ". Running total: "+ newTotal);
            return newTotal;
        }
        catch (NumberFormatException e) {
            System.out.println("'add' requires a valid number. Please try again.");
            return current;
        }
    }

    // Method to handle sub
    private static int handleSubtract(int current, String amountStr) {
        if (amountStr.isEmpty()) {
            System.out.println("'subtract' requires a valid number.");
            return current;
        }
        try {
            int amount = Integer.parseInt(amountStr);
            int newTotal = current - amount;
            System.out.println("Subtracted " + amount + ". Running total: " + newTotal);
            return newTotal;
        }
        catch (NumberFormatException e) {
            System.out.println("'subtract' requires a valid number. Please try again.");
            return current;
        }

    }

    // Method to handle reset
    private static int handleReset() {
        System.out.println("Running total has been reset to 0.");
        return 0;
    }

    // Method to handle total
    private static int handleTotal(int current) {
        System.out.println("Current total: " + current);
        return current;
    }

    // Method to handle history
    private static void handleHistory() {
        if (commandHistory.isEmpty()) {
            System.out.println("No valid commands in history.");
        }
        else {
            System.out.println("Command History:");
            for (String cmd : commandHistory) {
                System.out.println("-" + cmd);
            }
        }
    }

    // Method to handle undo
    private static int handleUndo(int currentTotal) {
        // first, need to check if there is a previous state to gp back to.
        // since the first element in valueHistory is always the starting 0, first need at least 2 elements to perfrom an undo. 
        if (valueHistory.size() <= 1) {
            System.out.println("Nothing to undo.");
            return currentTotal;
        }

        // removes the current state from stack
        valueHistory.remove(valueHistory.size() - 1);
        // removes the last command from hist.
        commandHistory.remove(commandHistory.size() - 1);

        // the new current total in the one now at the top of the stack
        int previousTotal = valueHistory.get(valueHistory.size() - 1);
        System.out.println("Undone last command. Restored to: " + previousTotal);
        return previousTotal;
    }

}


