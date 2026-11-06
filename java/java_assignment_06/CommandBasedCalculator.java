import java.util.Scanner;

public class CommandBasedCalculator {

    public static void main(String[] args) {
        int total = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter a command: ");
                if (!scanner.hasNextLine()) {
                    break;
                }

                // Split once so the rest of the line can be checked as one argument.
                String[] parts = scanner.nextLine().trim().split("\\s+", 2);
                String command = parts[0];
                String argument = parts.length == 2 ? parts[1] : "";

                if (command.equals("exit")) {
                    System.out.println("Goodbye! Final total: " + total);
                    return;
                }

                total = handleCommand(command, argument, total);
            }
        }
    }

    private static int handleCommand(String command, String argument, int total) {
        switch (command) {
            case "add":
            case "subtract":
                int number;

                // A missing or invalid number leaves the total unchanged.
                try {
                    number = Integer.parseInt(argument);
                } catch (NumberFormatException e) {
                    System.out.println("'" + command + "' requires a valid number. Please try again.");
                    return total;
                }

                if (command.equals("add")) {
                    total += number;
                    System.out.println("Added " + number + ". Running total: " + total);
                } else {
                    total -= number;
                    System.out.println("Subtracted " + number + ". Running total: " + total);
                }
                return total;

            case "reset":
                System.out.println("Running total has been reset to 0.");
                return 0;

            case "total":
                System.out.println("Current total: " + total);
                return total;

            default:
                System.out.println("Unrecognized command: '" + command + "'");
                return total;
        }
    }
}