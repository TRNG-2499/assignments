package java_assignment_03;

import java.util.*;

public class traffic {

    public static void main(String[] args) {
        System.out.println("Traffic program is running...");
        Scanner scanner = new Scanner(System.in);

        // Select program mode
        System.out.println("1 for default");
        System.out.println("2 for full cycle log");
        System.out.println("3 for duration mode");
        System.out.print("Please enter the program mode: ");
        int mode = scanner.nextInt();

        // Get number of ticks from user
        System.out.print("Please enter the number of ticks: ");
        int tick = scanner.nextInt();

        // Check tick is valid
        if (tick < 0) {

            scanner.close();
            throw new NegativeTickCountException(tick);

        }

        // Get initial traffic light color from user
        System.out.print("Please enter the traffic light color (r for red, y for yellow, g for green): ");
        scanner.nextLine();
        String color = scanner.nextLine().toLowerCase();

        switch (color) {
            case "r":
                System.out.println("Red light entered.");
                color = "Red";
                break;
            case "y":
                System.out.println("Yellow light entered.");
                color = "Yellow";
                break;
            case "g":
                System.out.println("Green light entered.");
                color = "Green";
                break;
            default:
                scanner.close();
                throw new InvalidLightColorException(color);

        }

        switch (mode) {
            case 1:
                DefaultMode(color, tick);
                break;
            case 2:
                List<String> cycle = FullCycle(color, tick);
                System.out.println(cycle);
                break;
            case 3:
                Duration(color, tick);
                break;
            default:
                System.out.println("Invalid program mode.");
                scanner.close();
                return;
        }

        scanner.close();

    }

    public static void DefaultMode(String color, int tick) {

        for (int i = 0; i < tick % 3; i++) {
            switch (color) {
                case "Green":
                    color = "Yellow";
                    break;
                case "Yellow":
                    color = "Red";
                    break;
                case "Red":
                    color = "Green";
                    break;
            }
        }
        System.out.println(color);

    }

    public static List<String> FullCycle(String color, int tick) {

        List<String> cycle = new ArrayList<>();

        for (int i = 0; i < tick; i++) {
            switch (color) {
                case "Green":
                    cycle.add(color);
                    color = "Yellow";
                    break;
                case "Yellow":
                    cycle.add(color);
                    color = "Red";
                    break;
                case "Red":
                    cycle.add(color);
                    color = "Green";
                    break;
            }
        }

        return cycle;

    }

    public static void Duration(String color, int tick) {

        System.out.println("Duration mode selected");
        System.out.println("Default duration: Green 4 ticks, Yellow 2 ticks, Red 3 ticks");

        // cycle through the traffic light colors based on their default durations
        while (tick > 0) {
            switch (color) {
                case "Green":
                    tick -= 4;
                    if (tick >= 0) {
                        System.out.println("4 ticks passed, Green duration completed");
                        System.out.println("Remaining ticks: " + tick);
                        color = "Yellow";
                    }
                    break;
                case "Yellow":
                    tick -= 2;
                    if (tick >= 0) {
                        System.out.println("2 ticks passed, Yellow duration completed");
                        System.out.println("Remaining ticks: " + tick);
                        color = "Red";
                    }
                    break;
                case "Red":
                    tick -= 3;
                    if (tick >= 0) {
                        System.out.println("3 ticks passed, Red duration completed");
                        System.out.println("Remaining ticks: " + tick);
                        color = "Green";
                    }
                    break;

            }
        }
        System.out.println("Final color: " + color);

    }

    // Custom exception for invalid traffic light color
    public static class InvalidLightColorException extends IllegalArgumentException {
        public InvalidLightColorException(String color) {
            super(color + " is not a valid light color");
        }
    }

    // Custom exception for negative tick count
    public static class NegativeTickCountException extends IllegalArgumentException {
        public NegativeTickCountException(int tick) {
            super("Negative tick count: " + tick + " is not accepted");
        }
    }

}
