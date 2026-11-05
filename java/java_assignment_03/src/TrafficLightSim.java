public class TrafficLightSim {
    public static void main(String[] args) {
        System.out.println(getLightAfterTicks("Green", 0)); // Green
        System.out.println(getLightAfterTicks("Red", 1)); // Green
        System.out.println(getLightAfterTicks("Yellow", 2)); // Green
        System.out.println(getLightAfterTicks("Green", 3)); // Green
        System.out.println(getLightAfterTicks("Red", 4)); // Green

        System.out.println(getLightAfterTicks("Blue", 2)); // error
        System.out.println(getLightAfterTicks("Green", -3)); // error
    }

    private static String getLightAfterTicks(String initialLight, int ticks) {
        if (!initialLight.equals("Green") && !initialLight.equals("Yellow") && !initialLight.equals("Red"))
            return "Invalid input: '%s' is not a recognized color.".formatted(initialLight);
        if (ticks < 0)
            return "Invalid input: tick count cannot be negative.";

        if (ticks == 0) // light unchanged
            return initialLight;
        // else
        int offset = ticks % 3;
        return switch (offset) {
            case 0 -> initialLight;
            case 1 -> switch (initialLight) {
                case "Green" -> "Yellow";
                case "Yellow" -> "Red";
                case "Red" -> "Green";
                default -> throw new IllegalStateException("Unexpected value: " + initialLight);
            };
            case 2 -> switch (initialLight) {
                case "Green" -> "Red";
                case "Yellow" -> "Green";
                case "Red" -> "Yellow";
                default -> throw new IllegalStateException("Unexpected value: " + initialLight);
            };
            default -> throw new IllegalStateException("Unexpected value: " + offset);
        };
    }
}
