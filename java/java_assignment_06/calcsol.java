import  java.util.Scanner;
/*
public class Calc {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("enter: num op num: ");
        double a = in.nextDouble();
        char op = in.next().charAt(0);
        double b = in.nextDouble();
        double r;
        switch (op)  {
            case '+': r = a + b; break;
            case '-': r = a - b; break;
            case '*': r = a * b; break;
            case '/':
                if (b == 0) {
                    System.out.println("you cant divide by zero");
                    return;
                }
                r = a / b;
                break;
            case '%': r = a % b; break;
            default:
                System.out.println("bad op");
        }
        System.out.println("= " + r);
    }
}
/*
this was the one shot version but did not meet reqs
 */
import java.util.Scanner;

public class RunningTotal {

    private static int total = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("Enter a command: ");
            if (!in.hasNextLine()) break;       // input ended unexpectedly
            String line = in.nextLine();
            running = handleCommand(line);
            if (running) System.out.println();  // blank line between commands
        }

        System.out.println("Goodbye! Final total: " + total);
        in.close();
    }

    // Processes one line of input
    private static boolean handleCommand(String line) {
        String[] parts = line.trim().split("\\s+");   // "add 5" -> ["add", "5"]
        String command = parts[0].toLowerCase();

        switch (command) {
            case "add": {
                Integer amount = parseAmount(parts, command);
                if (amount != null) {
                    total += amount;
                    System.out.println("Added " + amount + ". Running total: " + total);
                }
                return true;
            }
            case "subtract": {
                Integer amount = parseAmount(parts, command);
                if (amount != null) {
                    total -= amount;
                    System.out.println("Subtracted " + amount + ". Running total: " + total);
                }
                return true;
            }
            case "reset":
                total = 0;
                System.out.println("Running total has been reset to 0.");
                return true;
            case "total":
                System.out.println("Current total: " + total);
                return true;
            case "exit":
                return false;
            case "":
                System.out.println("Plase enter a command.");
                return true;
            default:
                System.out.println("not a command: '" + parts[0] + "'");
                return true;
        }
    }

    // Returns the number after the command, or null 
    private static Integer parseAmount(String[] parts, String command) {
        if (parts.length < 2) {
            System.out.println("'" + command + "' requires a valid number. Please try again.");
            return null;
        }
        try {
            return Integer.parseInt(parts[1]);
        } catch (NumberFormatException e) {
            System.out.println("'" + command + "' requires a valid number. Please try again.");
            return null;
        }
    }
}