
import java.util.Scanner;


enum Operation {
    ADD("add"),
    SUBTRACT("subtract"),
    RESET("reset"),
    TOTAL("total"),
    EXIT("exit");

    private final String command;

    Operation(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}

public class CommandBasedCalculator {
    private int runningNumber = 0;

    public void parseCommand() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Current running number: " + runningNumber);
            System.out.println("Enter a command:");
            String command = scanner.nextLine();

            String[] parts = command.split(" ");
            String operation = parts[0];
            switch (operation) {
                case "add":
                    if (parts.length < 2) {
                        System.out.println("'add' requires a valid number. Please try again.");
                        continue;
                    }
                    try {
                        int numberToAdd = Integer.parseInt(parts[1]);
                        this.runningNumber += numberToAdd;
                        System.out.println("Added " + numberToAdd + ". Running total: " + this.runningNumber);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number format. Please enter a valid integer.");
                    }
                    break;
                case "subtract":
                    if (parts.length < 2) {
                        System.out.println("'subtract' requires a valid number. Please try again.");
                        continue;
                    }
                    try {
                        int numberToSubtract = Integer.parseInt(parts[1]);
                        this.runningNumber -= numberToSubtract;
                        System.out.println("Subtracted " + numberToSubtract + ". Running total: " + this.runningNumber);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number format. Please enter a valid integer.");
                    }
                    break;
                case "reset":
                    this.runningNumber = 0;
                    break;
                case "total":
                    System.out.println("Current total: " + this.runningNumber);
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Unknown command. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        CommandBasedCalculator calculator = new CommandBasedCalculator();
        calculator.parseCommand();
    }
}