import java.util.Scanner;
import java.util.ArrayList;

// Store additional info per entry inserted into historyLog
// so that undo becomes easy and seamless
class HistoryLog {
    private ArrayList<String> log;
    private ArrayList<Integer> prevStack;

    public HistoryLog() {
        log = new ArrayList<String>();
        prevStack = new ArrayList<Integer>();
    }

    public void push(String[] splitText, int prevValue) {
        prevStack.add(prevValue);

        if (splitText.length == 1) {
            String formattedString = String.format("'%s'", splitText[0]);
            log.add(formattedString);
        } else {
            String formattedString = String.format("'%s: %s'", splitText[0], splitText[1]);
            log.add(formattedString);
        }
    }

    public int pop() {
        log.removeLast();
        int poppedVal = prevStack.removeLast();
        return poppedVal;
    }

    public ArrayList<String> getLog() {
        return this.log;
    }
}


public class Calculator {

    // Helper method that ensures the user provided correct
    // syntax for commands requiring 2 arguments
    public static boolean isValidArg(String[] splitText) { 

        // Verifies there's at least 2 arguments provided
        if (splitText.length != 2) {
            System.out.println("Incorrect number of arguments for this command");
            return false;
        }

        String arg1 = splitText[0];

        // Attempt to parse 2nd arg as integer, if an exception is caught,
        // then the result was not an integer
        try {
            Integer.parseInt(splitText[1]);

        } catch (NumberFormatException e) {
            System.out.printf("'%s' requires a valid number. Please try again.%n", arg1);
            return false;
        }

        return true;
    }   


    // Baseline features + stretch goals implemented here to avoid excessive
    // duplicate code (even though instruction says to separate them),
    //
    // The stretch goal functionalities do not interfere with the base features so
    // I think it should be fine
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;
        int total = 0;

        HistoryLog historyLog = new HistoryLog();
        boolean validCommand = true;

        while (keepRunning) {
            validCommand = true;
            System.out.println("");

            System.out.print("Enter a command: ");
            String inputText = scanner.nextLine();

            String[] splitText = inputText.split(" ");
            String command = splitText[0];

            int prevValue = total;

            switch (command) {
                case "add":
                    if (isValidArg(splitText)) {
                        int value = Integer.parseInt(splitText[1]);
                        total += value;
                        System.out.printf("Added %d. Running total: %d%n", value, total);
                    } else {
                        validCommand = false;
                    }
                    break;

                case "subtract":
                    if (isValidArg(splitText)) {
                        int value = Integer.parseInt(splitText[1]);
                        total -= value;
                        System.out.printf("Subtracted %d. Running total: %d%n", value, total);
                    } else {
                        validCommand = false;
                    }
                    break;

                case "reset":
                    total = 0;
                    System.out.printf("Running total has been reset to %d%n", total);
                    break;

                case "total":
                    System.out.printf("Current total: %d%n", total);
                    break;

                case "exit":
                    System.out.printf("Goodbye! Final total: %d%n", total);
                    keepRunning = false;
                    break;

                case "history":
                    for (String v : historyLog.getLog()) {
                        System.out.println(v);
                    }
                    break;

                case "undo":
                    if (!historyLog.getLog().isEmpty()) {
                        total = historyLog.pop();
                        System.out.println("Reverted previous change. New total: " + String.valueOf(total));
                    } else {
                        System.out.println("You have already reversed all previous commands made");
                    }
                    break;

                default:
                    System.out.printf("Unrecognized command: '%s'%n", command);
                    validCommand = false;
            }

            if (validCommand && !command.equals("history") && !command.equals("undo") && !command.equals("total")) {
                historyLog.push(splitText, prevValue);
            }
        }

        // Technically not needed because program exits here but might as well
        // for best practice
        scanner.close();
    }
}
