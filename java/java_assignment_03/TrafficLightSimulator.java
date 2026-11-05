public class TrafficLightSimulator {

    // Determines the final light color after the specified number of ticks.
    public static String simulateLight(String startColor, int ticks) {
        // Validate inputs before processing transitions.
        if (ticks < 0) {
            return "Invalid input: tick count cannot be negative.";
        }

        if (!"Green".equals(startColor)
                && !"Yellow".equals(startColor)
                && !"Red".equals(startColor)) {
            return "Invalid input: '" + startColor
                    + "' is not a recognized light color.";
        }

        // A full cycle takes three ticks, so only the remainder affects the result.
        int remainingTicks = ticks % 3;
        String currentColor = startColor;

        for (int i = 0; i < remainingTicks; i++) {
            switch (currentColor) {
                case "Green":
                    currentColor = "Yellow";
                    break;

                case "Yellow":
                    currentColor = "Red";
                    break;

                case "Red":
                    currentColor = "Green";
                    break;
            }
        }

        return currentColor;
    }

    // Demonstrates normal transitions, cycle boundaries, and invalid inputs.
    public static void main(String[] args) {
        System.out.println(simulateLight("Green", 1));
        System.out.println(simulateLight("Green", 3));
        System.out.println(simulateLight("Red", 5));
        System.out.println(simulateLight("Green", 0));
        System.out.println(simulateLight("Purple", 2));
        System.out.println(simulateLight("Green", -3));
    }
}