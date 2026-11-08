import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int total = 0;
        boolean programRunning = true;
        while (programRunning) {
            System.out.print("Enter a command: ");

            String[] command;
            while ((command = validateCommand(scan.nextLine())) == null) {
                System.out.println("\n");
                System.out.print("Enter a valid command: ");
            }

            switch (command[0]) {
                case "add":
                    int addAmount = Integer.parseInt(command[1]);
                    total += addAmount;
                    System.out.printf("Added %d. Running total: %d", addAmount, total);
                    break;
                case "subtract":
                    int subAmount = Integer.parseInt(command[1]);
                    total -= subAmount;
                    System.out.printf("Subtracted %d. Running total: %d", subAmount, total);
                    break;
                case "reset":
                    total = 0;
                    System.out.print("Running total has been reset to 0");
                    break;
                case "total":
                    System.out.printf("Current total: %d", total);
                    break;
                case "exit":
                    System.out.printf("Final total: %d --- shutting down...", total);
                    programRunning = false;
                    break;
                default:
                    throw new RuntimeException("Invalid command '%s' wasn't caught by validator, closing program.".formatted(command[0]));
            }
            System.out.println("\n");
        }
    }

    private static String[] validateCommand(String input) {
        String[] inputs = input.split(" ");
        switch (inputs.length) {
            case 2:
                switch (inputs[0]) {
                    case "add": case "subtract":
                        try {
                            Integer.parseInt(inputs[1]);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.printf("'%s' requires a valid number. Try again.", inputs[0]);
                            return null;
                        }
                    default:
                        System.out.printf("Unrecognized command '%s'", inputs[0]);
                        return null;
                }
                break;
            case 1:
                switch (inputs[0]) {
                    case "reset": case "total": case "exit":
                        break;
                    default:
                        System.out.printf("Unrecognized command '%s'", inputs[0]);
                        return null;
                }
                break;
            default:
                System.out.print("Number of arguments doesn't match any valid commands.");
                return null;
        }
        return inputs;
    }
}