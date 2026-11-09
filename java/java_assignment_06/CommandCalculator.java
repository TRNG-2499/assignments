import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

/**
 * Command-Based Calculator.
 *
 * Run with no arguments to use the full calculator, which includes the
 * stretch-goal commands (history, undo).
 * Run with the argument "basic" to use only the original commands.
 */
public class CommandCalculator {

    private static int runningTotal = 0;

    // ---------- Base activity ----------
    // Reads commands until the user types "exit".
    public static void runCalculator(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.print("Enter a command: ");
            if (!scanner.hasNextLine()) {
                break; // input stream closed
            }
            running = handleCommand(scanner.nextLine());
            System.out.println();
        }
    }

    // Parses one line and runs it. Returns false when the user wants to exit.
    public static boolean handleCommand(String line) {
        String[] parts = parseLine(line);
        String command = parts[0];
        String argument = parts[1];

        switch (command) {
            case "add": {
                Integer number = parseNumber(command, argument);
                if (number == null) break;
                try {
                    runningTotal = Math.addExact(runningTotal, number);
                    System.out.println("Added " + number + ". Running total: " + runningTotal);
                } catch (ArithmeticException e) {
                    System.out.println("That would overflow the running total. Command ignored.");
                }
                break;
            }
            case "subtract": {
                Integer number = parseNumber(command, argument);
                if (number == null) break;
                try {
                    runningTotal = Math.subtractExact(runningTotal, number);
                    System.out.println("Subtracted " + number + ". Running total: " + runningTotal);
                } catch (ArithmeticException e) {
                    System.out.println("That would overflow the running total. Command ignored.");
                }
                break;
            }
            case "reset":
                runningTotal = 0;
                System.out.println("Running total has been reset to 0.");
                break;
            case "total":
                System.out.println("Current total: " + runningTotal);
                break;
            case "exit":
                System.out.println("Goodbye! Final total: " + runningTotal);
                return false;
            case "":
                System.out.println("Please enter a command.");
                break;
            default:
                System.out.println("Unrecognized command: '" + command + "'");
                break;
        }
        return true;
    }

    // Splits a line into { command, argument }. Argument is null if there isn't one.
    private static String[] parseLine(String line) {
        String trimmed = (line == null) ? "" : line.trim();
        String[] pieces = trimmed.split("\\s+", 2);
        String command = pieces[0].toLowerCase();
        String argument = pieces.length > 1 ? pieces[1].trim() : null;
        return new String[] { command, argument };
    }

    // Returns the parsed number, or prints an error and returns null.
    private static Integer parseNumber(String command, String argument) {
        if (argument == null || argument.isEmpty()) {
            System.out.println("'" + command + "' requires a number. Please try again.");
            return null;
        }
        try {
            return Integer.parseInt(argument);
        } catch (NumberFormatException e) {
            System.out.println("'" + command + "' requires a valid number. Please try again.");
            return null;
        }
    }

    // ---------- Stretch goals: Command History and Undo ----------
    private static final List<String> commandHistory = new ArrayList<>();
    private static final Deque<Integer> undoStack = new ArrayDeque<>(); // totals before each add/subtract/reset

    // Same loop as runCalculator, but also handles "history" and "undo".
    // Normal commands are still passed to the original handleCommand method.
    public static void runCalculatorWithHistoryAndUndo(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.print("Enter a command: ");
            if (!scanner.hasNextLine()) {
                break;
            }
            running = handleExtendedCommand(scanner.nextLine());
            System.out.println();
        }
    }

    // Handles history/undo here and sends everything else to handleCommand.
    // Records valid commands and saves the total so a change can be undone.
    public static boolean handleExtendedCommand(String line) {
        String[] parts = parseLine(line);
        String command = parts[0];

        if (command.equals("history")) {
            printHistory();
            commandHistory.add(command);
            return true;
        }
        if (command.equals("undo")) {
            if (undoLastCommand()) {
                commandHistory.add(command);
            }
            return true;
        }

        int totalBefore = runningTotal;
        boolean valid = isValidCommand(parts);
        boolean keepRunning = handleCommand(line);

        if (valid) {
            boolean changesTotal = command.equals("add") || command.equals("subtract") || command.equals("reset");
            // add/subtract may be refused if the result would overflow; a refused
            // command is left out of the history and gets no undo point.
            boolean applied = !changesTotal || command.equals("reset")
                    || runningTotal != totalBefore || Integer.parseInt(parts[1]) == 0;
            if (applied) {
                commandHistory.add(normalizeForHistory(parts));
                if (changesTotal) {
                    undoStack.push(totalBefore);
                }
            }
        }
        return keepRunning;
    }

    // Prints every valid command entered so far, oldest first.
    public static void printHistory() {
        if (commandHistory.isEmpty()) {
            System.out.println("No commands in history yet.");
            return;
        }
        System.out.println("Command history:");
        for (int i = 0; i < commandHistory.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + commandHistory.get(i));
        }
    }

    // Restores the total from before the last add/subtract/reset.
    // Returns false if there was nothing to undo.
    public static boolean undoLastCommand() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo.");
            return false;
        }
        runningTotal = undoStack.pop();
        System.out.println("Undid last change. Running total: " + runningTotal);
        return true;
    }

    // A command is valid if it is known and (for add/subtract) has a valid int argument.
    private static boolean isValidCommand(String[] parts) {
        String command = parts[0];
        String argument = parts[1];
        switch (command) {
            case "add":
            case "subtract":
                if (argument == null) return false;
                try {
                    Integer.parseInt(argument);
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            case "reset":
            case "total":
            case "exit":
                return true;
            default:
                return false;
        }
    }

    private static String normalizeForHistory(String[] parts) {
        return parts[1] == null ? parts[0] : parts[0] + " " + Integer.parseInt(parts[1]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (args.length > 0 && args[0].equalsIgnoreCase("basic")) {
            System.out.println("Commands: add [n], subtract [n], reset, total, exit\n");
            runCalculator(scanner);
        } else {
            System.out.println("Commands: add [n], subtract [n], reset, total, history, undo, exit\n");
            runCalculatorWithHistoryAndUndo(scanner);
        }

        scanner.close();
    }
}
