package java_assignment_03;

public class Solution {
    public static void main (String[] args) {
        String color = "Green";
        int ticks = 5;

        String result = trafficLightSimulator(color, ticks);
        System.out.println(result);

    }

    public static String trafficLightSimulator(String color, int ticks) {
        if (ticks < 0) {
            return "Invalid input: tick count cannot be negative.";
        }

        switch (color) {
            case "Green":
            case "Yellow":
            case "Red":
                break;
            default:
                return "Invalid input: '" + color + "' is not a recognized light color.";
        }

        int remainingTicks = ticks % 3;

        for (int i = 0; i < remainingTicks; i++) {
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
                default:
                    return "Invalid input: '" + color + "' is not a recognized light color.";
            }
        }

        return color;
    }
}
