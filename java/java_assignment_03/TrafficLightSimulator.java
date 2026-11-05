package assignments.java.java_assignment_03;
import java.util.Arrays;

public class TrafficLightSimulator {
    public static class InvalidColorException extends RuntimeException {
        public InvalidColorException(String message) {
            super(message);
        }
    }

    private static final int CYCLE_LENGTH = 3;

    //Return the color that comes immediately after the given
    //return null if the input color is not recognized
    public static String nextColor(String color) {
        if (color == null) {
            return null;
        }
        switch (color) {
            case "Green":
                return "Yellow";
            case "Yellow":
                return "Red";
            case "Red":
                return "Green";
            default:
                return null;
        }
    }
    /**
     * Return color of light after given number of ticks
     * or error message if input is invalid
     */
    public static String simulate(String startColor, int ticks) {
        String error = validate(startColor, ticks);
        if (error != null) {
            return error;
        }
        // reduce ticks using modulo to advance only 0-2 steps
        int steps  = ticks % CYCLE_LENGTH;
        String currentColor = startColor;
        for (int i = 0; i < steps; i++) {
            currentColor = nextColor(currentColor);
        }
        return currentColor;
    }
    //returns how many ticks the given color lasts
    public static int duration(String color) {
        switch (color) {
            case "Green":
                return 3;
            case "Yellow":
                return 1;
            case "Red":
                return 2;
            default:
                return 0;
        }
    }

    //returns the lights color after given ticks where each color
    //has its own duration.
    public static String simulateVariable(String startColor, int ticks) {
        String currentColor = startColor;
        String error = validate(startColor, ticks);
        if (error != null) {
            return error;
        }
        //compute full cycle from three durations
        int fullCycle = duration("Green") + duration("Yellow") + duration("Red");
        int remaining = ticks % fullCycle;
        while (remaining > 0) {
            int currentDuration = duration(currentColor);
            if (remaining >= currentDuration) {
                remaining -= currentDuration;
                currentColor = nextColor(currentColor);
            } else {
                break;
            }
        }
        return currentColor;
    }
    
    // returns array of light colors for each tick
    public static String[] cycleLog(String startColor, int ticks) {
        // validate input (same two checks as simulate)
        String error = validate(startColor, ticks);
        if (error != null) {
            return new String[] {error};
        }
        String[] log = new String[ticks];
        String currentColor = startColor;
        for (int i = 0; i < ticks; i++) {
            currentColor = nextColor(currentColor);
            log[i] = currentColor;
        }
        return log;
    }
    
    // validates the start color and tick count, returns error message if invalid, otherwise null
    private static String validate(String startColor, int ticks) {
        if (ticks < 0) {
            return "Invalid input: tick count cannot be negative.";
        }
        if (nextColor(startColor) == null) {
            return "Invalid input: '" + startColor + "' is not a recognized light color.";
        }
        return null;
    }

    // simulates the traffic light with strict input validation, throws exceptions for invalid input
    public static String simulateStrict(String startColor, int ticks) {
        if (ticks < 0) {
            throw new IllegalArgumentException("Invalid input: tick count cannot be negative.");
        }
        if (nextColor(startColor) == null) {
            throw new InvalidColorException("Invalid input: '" + startColor + "' is not a recognized light color.");
        }
        return simulate(startColor, ticks);
    }

    public static void main(String[] args) {
        // test cases for simulateStrict and simulate methods
        String[][] tests = { {"Green", "4"}, {"Purple", "3"}, {"Red", "-1"}, {"Blue", "2"} };
        try {
            System.out.println(simulateStrict("Purple", 4));
        } catch (InvalidColorException e) {
            System.out.println("Color error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Argument error: " + e.getMessage());
        }

        System.out.println(simulate("Green", 5));
        System.out.println(simulate("Yellow", 4));
        System.out.println(simulate("Red", 7));
        System.out.println(simulate("Blue", 3));
        System.out.println(simulate("Red", -1));
        System.out.println(simulate("Green", 0));
        System.out.println(simulate("Yellow", -2));
        System.out.println(Arrays.toString(cycleLog("Green", 5)));
        System.out.println(Arrays.toString(cycleLog("Red", 1)));
        System.out.println(Arrays.toString(cycleLog("Blue", 3)));
        System.out.println(simulateVariable("Green", 5));
    }
}
