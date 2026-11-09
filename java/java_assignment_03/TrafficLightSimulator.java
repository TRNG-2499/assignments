import java.util.Arrays;

public class TrafficLightSimulator {

    private static final int CYCLE_LENGTH = 3;

    // ---------- Base activity ----------
    // Returns the color of the light after the given number of ticks,
    // or an error message string if the input is invalid.
    public static String simulateLight(String startColor, int ticks) {
        if (!isValidColor(startColor)) {
            return "Invalid input: '" + startColor + "' is not a recognized light color.";
        }
        if (ticks < 0) {
            return "Invalid input: tick count cannot be negative.";
        }

        // Every 3 ticks the light returns to where it started, so only the
        // remainder matters. This avoids looping through every single tick.
        int remainingSteps = ticks % CYCLE_LENGTH;

        String color = normalizeColor(startColor);
        for (int i = 0; i < remainingSteps; i++) { // at most 2 iterations
            color = nextColor(color);
        }
        return color;
    }

    // The single color-to-color transition, written as a switch statement.
    private static String nextColor(String color) {
        switch (color) {
            case "Green":
                return "Yellow";
            case "Yellow":
                return "Red";
            case "Red":
                return "Green";
            default:
                throw new IllegalStateException("Unexpected color: " + color);
        }
    }

    // Accepts "green", "GREEN", " Green " and so on.
    private static boolean isValidColor(String color) {
        if (color == null) {
            return false;
        }
        String normalized = normalizeColor(color);
        return normalized.equals("Green") || normalized.equals("Yellow") || normalized.equals("Red");
    }

    // Converts input such as "gREEN" into "Green".
    private static String normalizeColor(String color) {
        String trimmed = color.trim();
        if (trimmed.isEmpty()) {
            return trimmed;
        }
        return trimmed.substring(0, 1).toUpperCase() + trimmed.substring(1).toLowerCase();
    }

    // ---------- Stretch 1: Full Cycle Log ----------
    // Returns every color the light passes through, one entry per tick
    // (the starting color is not included).
    public static String[] fullCycleLog(String startColor, int ticks) {
        if (!isValidColor(startColor)) {
            throw new UnrecognizedLightColorException(startColor);
        }
        if (ticks < 0) {
            throw new NegativeTickCountException(ticks);
        }

        String[] log = new String[ticks];
        String color = normalizeColor(startColor);
        for (int i = 0; i < ticks; i++) {
            color = nextColor(color);
            log[i] = color;
        }
        return log;
    }

    // ---------- Stretch 2: Variable Duration Lights ----------
    // Green lasts 3 ticks, Yellow lasts 1 tick, Red lasts 2 ticks.
    // The light is assumed to have just turned startColor at tick 0.
    private static final int GREEN_DURATION = 3;
    private static final int YELLOW_DURATION = 1;
    private static final int RED_DURATION = 2;
    private static final int VARIABLE_CYCLE_LENGTH = GREEN_DURATION + YELLOW_DURATION + RED_DURATION;

    public static String simulateVariableDurationLight(String startColor, int ticks) {
        if (!isValidColor(startColor)) {
            return "Invalid input: '" + startColor + "' is not a recognized light color.";
        }
        if (ticks < 0) {
            return "Invalid input: tick count cannot be negative.";
        }

        // Position of the start color within one full 6-tick cycle (Green starts at 0).
        int startOffset;
        switch (normalizeColor(startColor)) {
            case "Green":
                startOffset = 0;
                break;
            case "Yellow":
                startOffset = GREEN_DURATION;
                break;
            default: // "Red"
                startOffset = GREEN_DURATION + YELLOW_DURATION;
                break;
        }

        // Use long so very large tick counts cannot overflow.
        int position = (int) ((startOffset + (long) ticks) % VARIABLE_CYCLE_LENGTH);

        if (position < GREEN_DURATION) {
            return "Green";
        } else if (position < GREEN_DURATION + YELLOW_DURATION) {
            return "Yellow";
        } else {
            return "Red";
        }
    }

    // ---------- Stretch 3: Exception Handling for Invalid Input ----------
    // Same result as simulateLight, but invalid input throws an exception
    // instead of returning a message. The caller decides how to handle it.
    public static String simulateLightOrThrow(String startColor, int ticks) {
        if (!isValidColor(startColor)) {
            throw new UnrecognizedLightColorException(startColor);
        }
        if (ticks < 0) {
            throw new NegativeTickCountException(ticks);
        }

        String color = normalizeColor(startColor);
        for (int i = 0; i < ticks % CYCLE_LENGTH; i++) {
            color = nextColor(color);
        }
        return color;
    }

    // A bad color value: the argument is not one of the allowed values.
    public static class UnrecognizedLightColorException extends IllegalArgumentException {
        private static final long serialVersionUID = 1L;

        public UnrecognizedLightColorException(String color) {
            super("'" + color + "' is not a recognized light color.");
        }
    }

    // A bad tick count: the number is outside the allowed range (below 0).
    public static class NegativeTickCountException extends IndexOutOfBoundsException {
        private static final long serialVersionUID = 1L;

        public NegativeTickCountException(int ticks) {
            super("Tick count cannot be negative (was " + ticks + ").");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Base activity ===");
        System.out.println(simulateLight("Green", 1));   // Yellow
        System.out.println(simulateLight("Green", 3));   // Green
        System.out.println(simulateLight("Red", 5));     // Yellow
        System.out.println(simulateLight("Green", 0));   // Green
        System.out.println(simulateLight("Purple", 2));  // Invalid color
        System.out.println(simulateLight("Green", -3));  // Negative ticks

        System.out.println("\n=== Stretch 1: Full Cycle Log ===");
        System.out.println(Arrays.toString(fullCycleLog("Green", 4))); // [Yellow, Red, Green, Yellow]
        System.out.println(Arrays.toString(fullCycleLog("Red", 0)));   // []

        System.out.println("\n=== Stretch 2: Variable Duration Lights (G=3, Y=1, R=2) ===");
        for (int t = 0; t <= 7; t++) {
            System.out.println("Green after " + t + " ticks: " + simulateVariableDurationLight("Green", t));
        }
        System.out.println("Yellow after 1 tick: " + simulateVariableDurationLight("Yellow", 1)); // Red
        System.out.println("Red after 2 ticks: " + simulateVariableDurationLight("Red", 2));      // Green

        System.out.println("\n=== Stretch 3: Exception Handling ===");
        runAndHandle("Red", 5);
        runAndHandle("Purple", 2);
        runAndHandle("Green", -3);
    }

    // The caller (not the simulation method) is responsible for catching
    // the exceptions and deciding what to show the user.
    private static void runAndHandle(String startColor, int ticks) {
        try {
            System.out.println(startColor + " after " + ticks + " ticks: "
                    + simulateLightOrThrow(startColor, ticks));
        } catch (UnrecognizedLightColorException e) {
            System.out.println("Color error: " + e.getMessage());
        } catch (NegativeTickCountException e) {
            System.out.println("Tick error: " + e.getMessage());
        }
    }
}
