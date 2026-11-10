import java.util.Scanner;

public class Calculator {

    public static int handleCommand(String line, int total) {
        String[] parts = line.split(" ");
        String command = parts[0];

        if (command.equals("add")) {
            if (parts.length < 2) {
                System.out.println("'add' requires a valid number. Please try again.");
                return total;
            }
            try {
                int number = Integer.parseInt(parts[1]);
                total = total + number;
                System.out.println("Added " + number + ". Running total: " + total);
            } catch (NumberFormatException e) {
                System.out.println("'add' requires a valid number. Please try again.");
            }
        } else if (command.equals("subtract")) {
            if (parts.length < 2) {
                System.out.println("'subtract' requires a valid number. Please try again.");
                return total;
            }
            try {
                int number = Integer.parseInt(parts[1]);
                total = total - number;
                System.out.println("Subtracted " + number + ". Running total: " + total);
            } catch (NumberFormatException e) {
                System.out.println("'subtract' requires a valid number. Please try again.");
            }
        } else if (command.equals("reset")) {
            total = 0;
            System.out.println("Running total has been reset to 0.");
        } else if (command.equals("total")) {
            System.out.println("Current total: " + total);
        } else {
            System.out.println("Unrecognized command: '" + command + "'");
        }

        return total;
    }

    public static void main(String[] args) {
        int total = 0;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a command: ");
            String line = sc.nextLine();

            if (line.equals("exit")) {
                System.out.println("Goodbye! Final total: " + total);
                break;
            }

            total = handleCommand(line, total);
        }

        sc.close();
    }
}
