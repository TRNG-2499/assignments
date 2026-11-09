import java.util.Scanner;

public class Calculator {

    private static int total = 0;

    public static void main(String[] args) {
        System.out.println("Command-Based Calculator");
        System.out.println("Commands: add [n], subtract [n], reset, total, exit");

        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                System.out.print("\nEnter a command: ");
                String line = scanner.nextLine().trim();

                if (line.equalsIgnoreCase("exit")) {
                    System.out.println("Done. Final total: " + total);
                    break;
                }
                System.out.println(processCommand(line));
            }
        }
    }

    public static String processCommand(String line) {
        String[] parts = line.split("\\s+");
        String command = parts[0].toLowerCase();

        switch (command) {
            case "add":
            case "subtract":
                if (parts.length != 2 || !isNumber(parts[1])) {
                    return "'" + command + "' requires a valid number. Please try again.";
                }
                int number = Integer.parseInt(parts[1]);
                if (command.equals("add")) {
                    total += number;
                    return "Added " + number + ". Running total: " + total;
                }
                total -= number;
                return "Subtracted " + number + ". Running total: " + total;

            case "reset":
                total = 0;
                return "Running total has been reset to 0.";

            case "total":
                return "Current total: " + total;

            default:
                return "Unrecognized command: '" + parts[0] + "'";
        }
    }

    private static boolean isNumber(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

