package assignments.java.java_assignment_06;
import java.util.Scanner;
import java.util.ArrayList;

public class CommandCalculator {
    private static int runningTotal = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("Enter a command: ");
            String line = scanner.nextLine();

            if (line.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye! Final total: " + runningTotal);
                running = false;
            } else {
                handleCommand(line);
            }
        }
    }

    public static void add(int number) {
        runningTotal += number;
        System.out.println("Added " + number);
    }

    public static void subtract(int number) {
        runningTotal -= number;
        System.out.println("Subtracted " + number);
    }

    public static void reset() {
        runningTotal = 0;
        System.out.println("Running total has been reset to 0.");
    }
    
    //Command History — Add support for a history command, which prints every valid command entered so far, in the order they were entered.
    private static StringBuilder commandHistory = new StringBuilder();
    private static ArrayList<String> commandHistoryList = new ArrayList<>();


    public static void handleCommand(String line) {
        line = line.trim();
        String[] parts = line.split("\\s+");
        String command = parts[0];
        if (!command.equalsIgnoreCase("history")) {
            commandHistory.append(line).append("\n");
            commandHistoryList.add(line);
        }
        switch (command) {
            case "add":
                if (parts.length < 2) {
                    System.out.println("Error: 'add' command requires a number");
                    break;
                }
                try {
                    int number = Integer.parseInt(parts[1]);
                    add(number);
                } catch (NumberFormatException e) {
                    System.out.println("Error: '" + parts[1] + "' is not a valid number");
                }
                break;
            case "subtract":
                if (parts.length < 2) {
                    System.out.println("Error: 'subtract' command requires a number");
                    break;
                }
                try {
                    int number = Integer.parseInt(parts[1]);
                    subtract(number);
                } catch (NumberFormatException e) {
                    System.out.println("Error: '" + parts[1] + "' is not a valid number");
                }
                break;
            case "reset":
                reset();
                break;
            case "total":
                System.out.println("Running total: " + runningTotal);
                break;
            case "history":
                System.out.println("Command history:");
                for (String cmd : commandHistoryList) {
                    System.out.println(cmd);
                }
                break;
            default: 
                System.out.println("Unrecognized command: " + command);
                break;
        }
    }
    
}
