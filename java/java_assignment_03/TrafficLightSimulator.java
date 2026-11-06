import java.util.Arrays;
import java.util.Scanner;

public class TrafficLightSimulator {

    public static void main(String[] args) {
        System.out.println("Traffic Light Simulator");

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter starting color (Green, Yellow, Red): ");
            String color = scanner.nextLine().trim();

            System.out.print("Enter number of ticks: ");
            int ticks = Integer.parseInt(scanner.nextLine().trim());

            System.out.println();
            System.out.println("Final color: " + simulateLight(color, ticks));
            System.out.println("Cycle log: " + Arrays.toString(cycleLog(color, ticks)));
            System.out.println("With variable durations: " + colorAtTick(color, ticks));
            try {
                System.out.println("Strict version: " + simulateLightStrict(color, ticks));
            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println("Strict version failed: " + e.getMessage());
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Tick count must be a whole number.");
        }
    }

    // Base requirement
    public static String simulateLight(String startColor, int ticks) {
        String error = validate(startColor, ticks);
        if (error != null) {
            return error;
        }
        String color = startColor;
        for (int i = 0; i < ticks % 3; i++) {
            color = nextColor(color);
        }
        return color;
    }

    // Stretch goal 1
    public static String[] cycleLog(String startColor, int ticks) {
        String error = validate(startColor, ticks);
        if (error != null) {
            return new String[] { error };
        }
        String[] log = new String[ticks];
        String color = startColor;
        for (int i = 0; i < ticks; i++) {
            color = nextColor(color);
            log[i] = color;
        }
        return log;
    }

    // Stretch goal 2
    public static String colorAtTick(String startColor, int ticksElapsed) {
        String error = validate(startColor, ticksElapsed);
        if (error != null) {
            return error;
        }
        int cycleLength = durationOf("Green") + durationOf("Yellow") + durationOf("Red");
        int remaining = ticksElapsed % cycleLength;
        String color = startColor;

        while (remaining >= durationOf(color)) {
            remaining -= durationOf(color);
            color = nextColor(color);
        }
        return color;
    }

    // Stretch goal 3
    public static String simulateLightStrict(String startColor, int ticks) {
        if (!isColor(startColor)) {
            throw new IllegalArgumentException(
                    "'" + startColor + "' is not a recognized light color.");
        }
        if (ticks < 0) {
            throw new ArithmeticException("tick count cannot be negative.");
        }
        return simulateLight(startColor, ticks);
    }

    private static String nextColor(String color) {
        switch (color) {
            case "Green":  return "Yellow";
            case "Yellow": return "Red";
            default:       return "Green";
        }
    }

    private static int durationOf(String color) {
        switch (color) {
            case "Green":  return 3;
            case "Yellow": return 1;
            default:       return 2;
        }
    }

    private static boolean isColor(String color) {
        if (color == null) return false;
        switch (color) {
            case "Green":
            case "Yellow":
            case "Red":
                return true;
            default:
                return false;
        }
    }

    private static String validate(String color, int ticks) {
        if (!isColor(color)) {
            return "Invalid input: '" + color + "' is not a recognized light color.";
        }
        if (ticks < 0) {
            return "Invalid input: tick count cannot be negative.";
        }
        return null;
    }
}