

public class TrafficLightSimulator {

    String[] lightColors = {"Green", "Yellow", "Red"};

    public String getNextLightColor(String currentLightColor) {
        switch (currentLightColor) {
            case "Green" -> {
                return "Yellow";
            }
            case "Yellow" -> {
                return "Red";
            }
            case "Red" -> {
                return "Green";
            }
            default -> {
                return "Invalid input: " + "'" + currentLightColor + "' is not a recognized light color.";
            }
        }
    }

    public void simulateTraffic(String startingLightColor, int ticks) {
        if (ticks < 0) {
            System.out.println("Invalid input: Number of ticks cannot be negative.");
            return;
        }
        int duration = ticks % 3;

        if (duration == 0) {
            System.out.println(startingLightColor);
            return;
        }

        for (int i = 0; i < duration; i++) {
            startingLightColor = getNextLightColor(startingLightColor);
        }

        System.out.println(startingLightColor);
    }

    public String[] fullCycleLog(String startingLightColor, int ticks) {
        if (ticks < 0) {
            System.out.println("Invalid input: Number of ticks cannot be negative.");
            return new String[0];
        }

        String[] log = new String[ticks + 1];
        log[0] = startingLightColor;

        for (int i = 1; i <= ticks; i++) {
            startingLightColor = getNextLightColor(startingLightColor);
            log[i] = startingLightColor;
        }

        return log;
    }

    

    public static void main(String[] args) {
        TrafficLightSimulator simulator = new TrafficLightSimulator();
        simulator.simulateTraffic("Green", 1);
        simulator.simulateTraffic("Green", 3);
        simulator.simulateTraffic("Red", 5);
        simulator.simulateTraffic("Green", 0);
        simulator.simulateTraffic("Purple", 2);
        simulator.simulateTraffic("Green", -3);

        // Stretch Goals
        // Full cycle log
        String[] log = simulator.fullCycleLog("Yellow", 5);
        System.out.println("Full cycle: " + java.util.Arrays.toString(log));
    }

}