import java.util.*;

public class trafficLightSimulator {
    public static void main (String[] args) {

        trafficLightSimulator trafficLightSimulatorInstance = new trafficLightSimulator();

        /*
            trafficLight() test cases
         */
        // Empty Test
//        System.out.println(trafficLightSimulatorInstance.trafficLight(null, 10));
//        // Invalid color test
//        System.out.println(trafficLightSimulatorInstance.trafficLight("Purple", 10));
//        // Negative ticks test
//        System.out.println(trafficLightSimulatorInstance.trafficLight("Green", -10));
//        // Correct test
//        System.out.println(trafficLightSimulatorInstance.trafficLight("yellow", 5));

        /*
            trafficLightStretch() test cases
         */
        int[] colorDurations = {2, 1, 1};
        try {
            // Invalid color test
//            System.out.println(Arrays.toString(trafficLightSimulatorInstance.trafficLightStretch("Purple", 10, colorDurations)));
            // Negative ticks test
//            System.out.println(Arrays.toString(trafficLightSimulatorInstance.trafficLightStretch("Green", -10, colorDurations)));
            // Correct test
            System.out.println(Arrays.toString(trafficLightSimulatorInstance.trafficLightStretch("yellow", 11, colorDurations)));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            for (StackTraceElement element : e.getStackTrace()) {
                System.err.println(element);
            }
        }

    }
    public String trafficLight(String startColor, int ticks) {
        if (startColor == null || startColor.isEmpty()) {
            return "Error: starting color was not given. Please enter 'Green', 'Yellow', or 'Red'";
        } else if (ticks < 0) {
            return "Error: Invalid Input: Ticks cannot be negative.";
        }
        // Capitalize input so it matches the lightStates capitalization format
        startColor = Character.toUpperCase(startColor.charAt(0)) + startColor.substring(1);

        Map<String, Integer> lightStatesMap = Map.of("Green", 0, "Yellow", 1, "Red", 2);
        if (!lightStatesMap.containsKey(startColor)) {
            return "Error: starting color " + startColor + " is not valid. Please enter 'Green', 'Yellow', or 'Red'";
        }

        int startTickState = lightStatesMap.get(startColor);
        int finalTickState = (startTickState + ticks) % 3;

        return switch (finalTickState) {
            case 0 -> "green";
            case 1 -> "yellow";
            case 2 -> "red";
            default -> "internal error: invalid final tick state";
        };
    }

    /*
        Stretch Goal.
        It takes in an integer array of colorDurations and uses that to set the duration of ticks for each color before
        transitioning to the next color.
        It returns a String[] that represents each
     */
    public String[] trafficLightStretch(String startColor, int ticks, int[] colorDurations){
        // Confirm startColor & ticks argument
        if (startColor == null || startColor.isEmpty()) {
            throw new NullPointerException("Error: Starting color was not given. Please enter 'Green', 'Yellow' or 'Red'");
        } else if (ticks < 0) {
            throw new ArithmeticException("Error: Invalid Input: Ticks cannot be negative.");
        }
        startColor = Character.toUpperCase(startColor.charAt(0)) + startColor.substring(1);
        Map<String, Integer> lightStatesMap = Map.of("Green", 0, "Yellow", 1, "Red", 2);
        if (!lightStatesMap.containsKey(startColor)) {
            String exception = "Error: starting color " + startColor + " is not valid. Please enter 'Green', 'Yellow', or 'Red'";
            throw new IllegalArgumentException(exception);
        }
        // Confirm integer array
        if (colorDurations.length != 3 || Arrays.stream(colorDurations).anyMatch(dur -> dur <= 0)) {
            throw new IllegalArgumentException("Error: Must enter 3 valid color durations longer than zero, in order of: green, yellow, red.");
        }

        List<String> colorCycleLog = new ArrayList<String>();
        List<String> lightStates = List.of("Green", "Yellow", "Red");
        int curState = lightStatesMap.get(startColor);
        int ticksSinceLastState = 0;
        for (int i = 0; i < ticks; i++) {
            if (ticksSinceLastState >= colorDurations[curState]) {
                // New state/color
                curState = (curState + 1) % 3;
                colorCycleLog.add(lightStates.get(curState));
                ticksSinceLastState = 0;
            }
            ticksSinceLastState += 1;
        }
        return colorCycleLog.toArray(String[]::new);
    }
}
