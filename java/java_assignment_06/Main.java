import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        calculator(scan);
        calculatorWithHistory(scan);
        calculatorWithUndo(scan);
        scan.close();
    }

    /**
     * Runs a command-line calculator loop.
     */
    public static void calculator(Scanner scan) {
        int runningValue = 0;

        while (true) {
            System.out.println("Enter a command: ");
            String input = scan.nextLine().trim();
            String[] parts = input.split("\\s+");
            String command = parts[0];

            switch (command) {
                case "add" -> {
                    if (parts.length > 1) {
                        try {
                            int number = Integer.parseInt(parts[1]);
                            runningValue += number;
                            System.out.println("Added " + number + ". Running total: " + runningValue);
                        } catch (NumberFormatException e) {
                            System.out.println("'add' requires a valid number. Please try again.");
                        }
                    } else {
                        System.out.println("'add' requires a valid number. Please try again.");
                    }
                }
                case "subtract" -> {
                    if (parts.length > 1) {
                        try {
                            int number = Integer.parseInt(parts[1]);
                            runningValue -= number;
                            System.out.println("Subtracted " + number + ". Running total: " + runningValue);
                        } catch (NumberFormatException e) {
                            System.out.println("'subtract' requires a valid number. Please try again.");
                        }
                    } else {
                        System.out.println("'subtract' requires a valid number. Please try again.");
                    }
                }
                case "reset" -> {
                    runningValue = 0;
                    System.out.println("Running total has been reset to 0.");
                }
                case "total" -> System.out.println("Current total: " + runningValue);
                case "exit" -> {
                    System.out.println("Goodbye! Final total: " + runningValue);
                    return;
                }
                default -> System.out.println("Unrecognized command: '" + command + "'");
            }
        }
    }

    /**
     * Runs a command-line calculator loop with history.
     */
    public static void calculatorWithHistory(Scanner scan) {
        int runningValue = 0;
        ArrayList<String> history = new ArrayList<>();

        while (true) {
            System.out.println("Enter a command: ");
            String input = scan.nextLine().trim();
            history.add(input);
            String[] parts = input.split("\\s+");
            String command = parts[0];

            switch (command) {
                case "add" -> {
                    if (parts.length > 1) {
                        try {
                            int number = Integer.parseInt(parts[1]);
                            runningValue += number;
                            System.out.println("Added " + number + ". Running total: " + runningValue);
                        } catch (NumberFormatException e) {
                            System.out.println("'add' requires a valid number. Please try again.");
                        }
                    } else {
                        System.out.println("'add' requires a valid number. Please try again.");
                    }
                }
                case "subtract" -> {
                    if (parts.length > 1) {
                        try {
                            int number = Integer.parseInt(parts[1]);
                            runningValue -= number;
                            System.out.println("Subtracted " + number + ". Running total: " + runningValue);
                        } catch (NumberFormatException e) {
                            System.out.println("'subtract' requires a valid number. Please try again.");
                        }
                    } else {
                        System.out.println("'subtract' requires a valid number. Please try again.");
                    }
                }
                case "reset" -> {
                    runningValue = 0;
                    System.out.println("Running total has been reset to 0.");
                }
                case "total" -> System.out.println("Current total: " + runningValue);
                case "exit" -> {
                    System.out.println("Goodbye! Final total: " + runningValue);
                    return;
                }
                case "history" -> {
                    System.out.println("Past Commands: ");
                    for (String pastCommand : history) {
                        System.out.println(pastCommand);
                    }
                }
                default -> System.out.println("Unrecognized command: '" + command + "'");
            }
        }
    }

    /**
     * Runs a command-line calculator loop with undo features.
     */
    public static void calculatorWithUndo(Scanner scan) {
        int runningValue = 0;
        Deque<Integer> history = new ArrayDeque<>();

        while (true) {
            System.out.println("Enter a command: ");
            String input = scan.nextLine().trim();
            String[] parts = input.split("\\s+");
            String command = parts[0];

            switch (command) {
                case "add" -> {
                    if (parts.length > 1) {
                        try {
                            int number = Integer.parseInt(parts[1]);
                            runningValue += number;
                            System.out.println("Added " + number + ". Running total: " + runningValue);
                            history.push(runningValue);
                        } catch (NumberFormatException e) {
                            System.out.println("'add' requires a valid number. Please try again.");
                        }
                    } else {
                        System.out.println("'add' requires a valid number. Please try again.");
                    }
                }
                case "subtract" -> {
                    if (parts.length > 1) {
                        try {
                            int number = Integer.parseInt(parts[1]);
                            runningValue -= number;
                            System.out.println("Subtracted " + number + ". Running total: " + runningValue);
                            history.push(runningValue);
                        } catch (NumberFormatException e) {
                            System.out.println("'subtract' requires a valid number. Please try again.");
                        }
                    } else {
                        System.out.println("'subtract' requires a valid number. Please try again.");
                    }
                }
                case "reset" -> {
                    runningValue = 0;
                    System.out.println("Running total has been reset to 0.");
                    history.push(runningValue);
                }
                case "total" -> System.out.println("Current total: " + runningValue);
                case "exit" -> {
                    System.out.println("Goodbye! Final total: " + runningValue);
                    return;
                }
                case "undo" -> {
                    if (history.isEmpty()) {
                        System.out.println("No past command to undo.");
                    } else {
                        history.pop();
                        runningValue = !history.isEmpty() ? history.peek() : 0;
                        System.out.println("Undid last command. Running total: " + runningValue);
                    }
                }
                default -> System.out.println("Unrecognized command: '" + command + "'");
            }
        }
    }
}