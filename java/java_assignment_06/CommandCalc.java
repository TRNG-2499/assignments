import java.util.Scanner;

public class CommandCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] value = {0};
        boolean running = true;

        while (running) {
            System.out.print("Enter a command: ");
            running = handleCommand(scanner.nextLine().trim(), value);
        }

        scanner.close();
    }

    private static boolean handleCommand(String input, int[] value) {
        String[] parts = input.split("\\s+", 2);
        String command = parts[0].toLowerCase();

        if (command.equals("quit")) {
            System.out.println("Session ended. Final value: " + value[0]);
            return false;
        }

        switch (command) {
            case "add":
                if (parts.length < 2) {
                    System.out.println("Enter a number after 'add'.");
                    break;
                }
                try {
                    int points = Integer.parseInt(parts[1]);
                    value[0] += points;
                    System.out.println("Running value: " + value[0]);
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid whole number.");
                }
                break;

            case "subtract":
                if (parts.length < 2) {
                    System.out.println("Enter a number after 'subtract'.");
                    break;
                }
                try {
                    int points = Integer.parseInt(parts[1]);
                    value[0] -= points;
                    System.out.println("Running value: " + value[0]);
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid whole number.");
                }
                break;

            case "reset":
                if (parts.length > 1) { // reset takes no number
                    System.out.println("'reset' does not take a number.");
                    break;
                }
                value[0] = 0; // reset the running value
                System.out.println("Running value has been reset to 0.");
                break;

            case "total":
                System.out.println("Current value: " + value[0]);
                break;

            case "exit":
                System.out.println("Goodbye! Final value: " + value[0]);
                return false;

            default:
                System.out.println("Unknown command: '" + command + "'");
        }

        return true;
    }
}