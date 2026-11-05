public class trafficLight {

    protected enum LightColor {
        GREEN,
        YELLOW,
        RED
    }

    public static String simulateLight(String startColor, int ticks) {
        if (ticks < 0) {
            return "Invalid input: tick count cannot be negative.";
        }

        LightColor currentColor;

        if (startColor == null ||
            (!startColor.equalsIgnoreCase("Green")
            && !startColor.equalsIgnoreCase("Yellow")
            && !startColor.equalsIgnoreCase("Red"))) {

            return "Invalid input: '" + startColor + "' is not a recognized light color.";
        }

        currentColor = LightColor.valueOf(startColor.toUpperCase());

        int steps = ticks % 3;

        for (int i = 0; i < steps; i++) {

            switch (currentColor) {
                case GREEN:
                    currentColor = LightColor.YELLOW;
                    break;
                case YELLOW:
                    currentColor = LightColor.RED;
                    break;
                case RED:
                    currentColor = LightColor.GREEN;
                    break;
            }
        }

        return currentColor.toString();
    }

    public static String[] fullCycle(String startColor, int ticks) {
        if (ticks < 0) {
            return new String[]{"Invalid input: tick count cannot be negative."};
        }

        if (startColor == null ||
            (!startColor.equalsIgnoreCase("Green")
            && !startColor.equalsIgnoreCase("Yellow")
            && !startColor.equalsIgnoreCase("Red"))) {

            return new String[]{"Invalid input: '" + startColor + "' is not a recognized light color."};
        }

        
        String[] cycle = new String[ticks + 1];
        cycle[0] = simulateLight(startColor, 1);


        for (int i = 1; i <= ticks; i++) {
            cycle[i] = simulateLight(cycle[i - 1], 1);
        }

        return cycle;
    }

    public static String variableDurationLights(String startColor, int ticks) {
        if (ticks < 0) {
            return "Invalid input: tick count cannot be negative.";
        }

        if (startColor == null ||
            (!startColor.equalsIgnoreCase("Green")
            && !startColor.equalsIgnoreCase("Yellow")
            && !startColor.equalsIgnoreCase("Red"))) {

            return "Invalid input: '" + startColor + "' is not a recognized light color.";
        }

        LightColor currentColor = LightColor.valueOf(startColor.toUpperCase());


        while (ticks > 0) {

            switch (currentColor) {
                case GREEN:
                    if (ticks >= 3) {
                        ticks -= 3;
                        currentColor = LightColor.YELLOW;
                    } else {
                        ticks = 0;
                    }
                    break;
                case YELLOW:
                    if (ticks >= 1) {
                        ticks -= 1;
                        currentColor = LightColor.RED;
                    } else {
                        ticks = 0;
                    }
                    break;
                case RED:
                    if (ticks >= 2) {
                        ticks -= 2;
                        currentColor = LightColor.GREEN;
                    } else {
                        ticks = 0;
                    }
                    break;
            }
        }

        return currentColor.toString();
    }

        public static String throwingErrs(String startColor, int ticks) {
        if (ticks < 0) {
            throw new IllegalArgumentException("Tick count cannot be negative." );
        }

        LightColor currentColor;

        try {
            currentColor = LightColor.valueOf(startColor.toUpperCase());

        } catch (IllegalArgumentException | NullPointerException e) {
            throw new IllegalStateException("'" + startColor + "' is not a recognized light color.");
        }


        currentColor = LightColor.valueOf(startColor.toUpperCase());

        int steps = ticks % 3;

        for (int i = 0; i < steps; i++) {

            switch (currentColor) {
                case GREEN:
                    currentColor = LightColor.YELLOW;
                    break;
                case YELLOW:
                    currentColor = LightColor.RED;
                    break;
                case RED:
                    currentColor = LightColor.GREEN;
                    break;
            }
        }

        return currentColor.toString();
    }

    public static void main(String[] args) {

        System.out.println(simulateLight("Green", 1));
        System.out.println(simulateLight("Green", 3));
        System.out.println(simulateLight("Red", 5));
        System.out.println(simulateLight("Green", 0));
        System.out.println(simulateLight("Purple", 2));
        System.out.println(simulateLight("Green", -3));

        System.out.println("\nFull Cycle:");
        System.out.println(java.util.Arrays.toString(fullCycle("Green", 4)));

        System.out.println("\nVariable Duration Lights:");
        System.out.println(variableDurationLights("Green", 10));
        System.out.println(variableDurationLights("Yellow", 5));
        System.out.println(variableDurationLights("Red", 1));
        System.out.println(variableDurationLights("Blue", 3));

        System.out.println("\nThrowing Errors:");
        try {
            System.out.println(throwingErrs("Green", 0));
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.err.println(e.getMessage());
        }
        try {
            System.out.println(throwingErrs("Purple", 2));
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.err.println(e.getMessage());
        }
        try {
            System.out.println(throwingErrs("Green", -3));
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.err.println(e.getMessage());
        }

    }
}
