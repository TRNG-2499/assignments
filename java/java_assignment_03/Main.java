import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TrafficLight test = new TrafficLight();

        System.out.println(test.simulate("Green", 1));
        System.out.println(test.simulate("Green", 3));
        System.out.println(test.simulate("Red", 5));
        System.out.println(test.simulate("Green", 0));
        System.out.println(test.simulate("Purple", 2));
        System.out.println(test.simulate("Green", -3));

        System.out.println(Arrays.toString(test.simulateWithSteps("Green", 4)));
        System.out.println(Arrays.toString(test.simulateWithSteps("Purple", 2)));
        System.out.println(Arrays.toString(test.simulateWithSteps("Green", -3)));

        System.out.println(test.simulateVariableDuration("Green", 14));
    }
}

class TrafficLight {

    /**
     * Simulates the traffic light color after a given number of ticks starting from a specified color.
     * @param startColor The initial color of the traffic light ("Green", "Yellow", or "Red").
     * @param ticks The number of ticks to simulate.
     * @return The color of the traffic light after the specified number of ticks, or an error message for invalid input.
     */
    public String simulate(String startColor, int ticks) {
        if (!startColor.equals("Green") && !startColor.equals("Yellow") && !startColor.equals("Red")) {
            return String.format("Invalid input: \'%s\' is not a recognized light color.", startColor);
        }

        if (ticks < 0) {
            return "Invalid input: tick count cannot be negative.";
        }

        int currentColor;
        switch (startColor) {
            case "Green" -> currentColor = 0;
            case "Yellow" -> currentColor = 1;
            case "Red" -> currentColor = 2;
            default -> currentColor = -1;
        }

        int finalColor = (currentColor + ticks) % 3;

        return switch (finalColor) {
            case 0 -> "Green";
            case 1 -> "Yellow";
            case 2 -> "Red";
            default -> "Error";
        };
    }

    /**
     * Simulates the traffic light colors for a given number of ticks starting from a specified color.
     * @param startColor The initial color of the traffic light ("Green", "Yellow", or "Red").
     * @param ticks The number of ticks to simulate.
     * @return An array containing the colors of the traffic light for each tick.
     */
    public String[] simulateWithSteps(String startColor, int ticks) {
        if (!startColor.equals("Green") && !startColor.equals("Yellow") && !startColor.equals("Red")) {
            return new String[]{String.format("Invalid input: \'%s\' is not a recognized light color.", startColor)};
        }

        if (ticks < 0) {
            return new String[]{"Invalid input: tick count cannot be negative."};
        }

        int currentColor;
        switch (startColor) {
            case "Green" -> currentColor = 0;
            case "Yellow" -> currentColor = 1;
            case "Red" -> currentColor = 2;
            default -> currentColor = -1;
        }

        String[] result = new String[ticks];
        for (int i = 1; i <= ticks; i++) {
            int nextColor = (currentColor + i) % 3;
            switch (nextColor) {
                case 0 -> result[i - 1] = "Green";
                case 1 -> result[i - 1] = "Yellow";
                case 2 -> result[i - 1] = "Red";
                default -> result[i - 1] = "Error";
            }
        }
        return result;
    }

    /**
     * Simulates the traffic light color after a given number of ticks starting from a specified color.
     * @param startColor The initial color of the traffic light ("Green", "Yellow", or "Red").
     * @param ticks The number of ticks to simulate.
     * @return The color of the traffic light after the specified number of ticks, or an error message for invalid input.
     */
    public String simulateVariableDuration(String startColor, int ticks) {
        if (!startColor.equals("Green") && !startColor.equals("Yellow") && !startColor.equals("Red")) {
            return String.format("Invalid input: \'%s\' is not a recognized light color.", startColor);
        }

        if (ticks < 0) {
            return "Invalid input: tick count cannot be negative.";
        }

        int currentColor;
        switch (startColor) {
            case "Green" -> currentColor = 0;
            case "Yellow" -> currentColor = 3;
            case "Red" -> currentColor = 4;
            default -> currentColor = -1;
        }

        int greenDuration = 3;
        int yellowDuration = 1;
        int redDuration = 2;
        int totalDuration = greenDuration + yellowDuration + redDuration;

        int finalColor = (currentColor + ticks) % 3;
        if (finalColor < greenDuration) {
            return "Green";
        } else if (finalColor < (greenDuration + yellowDuration)) {
            return "Yellow";
        } else {
            return "Red";
        }
    }

    /**
     * Simulates the traffic light color after a given number of ticks starting from a specified color.
     * @param startColor The initial color of the traffic light ("Green", "Yellow", or "Red").
     * @param ticks The number of ticks to simulate.
     * @return The color of the traffic light after the specified number of ticks, or an error message for invalid input.
     */
    public String simulateThrowException(String startColor, int ticks) {
        if (!startColor.equals("Green") && !startColor.equals("Yellow") && !startColor.equals("Red")) {
            throw new IllegalArgumentException(String.format("Invalid input: \'%s\' is not a recognized light color.", startColor));
        }

        if (ticks < 0) {
            throw new IndexOutOfBoundsException("Invalid input: tick count cannot be negative.");
        }

        int currentColor;
        switch (startColor) {
            case "Green" -> currentColor = 0;
            case "Yellow" -> currentColor = 1;
            case "Red" -> currentColor = 2;
            default -> currentColor = -1;
        }

        int finalColor = (currentColor + ticks) % 3;

        return switch (finalColor) {
            case 0 -> "Green";
            case 1 -> "Yellow";
            case 2 -> "Red";
            default -> "Error";
        };
    }
}