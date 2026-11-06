public class Solution3 {
    public static String getNextLight(String currentLight) {
        switch (currentLight) {
            case "Red":
                return "Green";
            case "Green":
                return "Yellow";
            case "Yellow":
                return "Red";
            default:
                return "Invalid color";
        }
    }


    public static String simulateTrafficLight(String startColor, int ticks) {
        if (ticks < 0) {
            return "Invalid input: tick count cannot be negative.";
        }

        // Validaate the startColor
        if (!startColor.equals("Red") && !startColor.equals("Green") && !startColor.equals("Yellow")) {
            return "Invalid input: '" + startColor + "' is not a recognized light color.";
        }
        
        // handle repeating cycles using modulo Arithmetic
        int effectiveTicks = ticks % 3;
        
        // advance step by step for the remaining steps
        String current = startColor;
        for(int i = 0; i < effectiveTicks; i++) {
            current = getNextLight(current);
        }
        
        return current;

    }
    
    public static void main(String[] args) {
        System.out.println(simulateTrafficLight("Yellow", 8));
    
        
    }
}



