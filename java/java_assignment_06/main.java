
import java.util.Scanner;

class Main {

    private static int calculate(String cmd, int currentTotal, int value) {
        switch (cmd) {
            case "add":
                currentTotal += value;
                break;

            case "subtract":
                currentTotal -= value;
                break;

            case "reset":
                currentTotal = 0;
                break;

            case "total":
                break;

            default:
                System.out.println("Invalid command, try again.");
        }

        return currentTotal;
    }

    private static void runCalculator() {
        Scanner scanner = new Scanner(System.in);
        int total = 0;

        while (true) {
            Result result = getResult(scanner);

            if (result.cmd().equals("exit")) {
                break;
            }

            String cmd = result.cmd();
            int num = result.num();

            switch (cmd) {
                case "add":
                    total = calculate(cmd, total, num);
                    System.out.println("Added " + num +
                            ". Running total: " + total);
                    break;

                case "subtract":
                    total = calculate(cmd, total, num);
                    System.out.println("Subtracted " + num +
                            ". Running total: " + total);
                    break;

                case "reset":
                    total = calculate(cmd, total, 0);
                    System.out.println("Running total has been reset to 0.");
                    break;

                case "total":
                    System.out.println("Current total: " + total);
                    break;

                default:
                    System.out.println("Unrecognized command: '" + cmd + "'");
            }
        }

        System.out.println("Goodbye! Final total: " + total);
        scanner.close();
    }

    private static Result getResult(Scanner scanner) {
        System.out.print("Enter a command: ");
        String nxt = scanner.nextLine().trim();

        String[] parts = nxt.split("\\s+");
        String cmd = parts[0];

        if (cmd.equals("exit")) {
            return new Result(0, "exit");
        }

        if (cmd.equals("reset") || cmd.equals("total")) {
            return new Result(0, cmd);
        }

        if (cmd.equals("add") || cmd.equals("subtract")) {
            if (parts.length != 2) {
                System.out.println("'" + cmd +
                        "' requires a valid number. Please try again.");
                return new Result(0, "invalid");
            }

            try {
                int num = Integer.parseInt(parts[1]);
                return new Result(num, cmd);
            } catch (NumberFormatException e) {
                System.out.println("'" + cmd +
                        "' requires a valid number. Please try again.");
                return new Result(0, "invalid");
            }
        }

        return new Result(0, cmd);
    }

    private record Result(int num, String cmd) {}

    public static void main(String[] args) {
        runCalculator();
    }
}
