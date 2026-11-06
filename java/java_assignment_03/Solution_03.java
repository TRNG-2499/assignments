import java.util.Arrays;

public class Solution_03 {
    
    public static void main(String[] args) {
        // Test cases based on the requirements
        System.out.println("Example 1 (Green, 1): " + trafficLightSimulator("Green", 1));
        System.out.println("Example 2 (Green, 3): " + trafficLightSimulator("Green", 3));
        System.out.println("Example 3 (Red, 5): " + trafficLightSimulator("Red", 5));
        System.out.println("Example 4 (Green, 0): " + trafficLightSimulator("Green", 0));
        System.out.println("Example 5 (Purple, 2): " + trafficLightSimulator("Purple", 2));
        System.out.println("Example 6 (Green, -3): " + trafficLightSimulator("Green", -3));

        // Tests for fullCycleLog 
        System.out.println("--- Stretch Goal Results (Full Cycle Log) ---");
        System.out.println("Example 1: " + Arrays.toString(fullCycleLog("Green", 1)));     // ["Yellow"]
        System.out.println("Example 2: " + Arrays.toString(fullCycleLog("Green", 3)));     // ["Yellow", "Red", "Green"]
        System.out.println("Example 3: " + Arrays.toString(fullCycleLog("Red", 5)));       // ["Green", "Yellow", "Red", "Green", "Yellow"]
        System.out.println("Example 4: " + Arrays.toString(fullCycleLog("Green", 0)));     // [] (Empty list)
        System.out.println("Example 5: " + Arrays.toString(fullCycleLog("Purple", 2)));    // ["Invalid input..."]
        System.out.println("Example 6: " + Arrays.toString(fullCycleLog("Green", -3)));    // ["Invalid input..."]

        // variableDurationSimulator 
        System.out.println("Green + 4 ticks: " + variableDurationLights("Green", 4)); 
        System.out.println("Red + 1 tick: " +  variableDurationLights("Red", 1));
        System.out.println("Yellow + 2 ticks: " + variableDurationLights("Yellow", 2));

        // exceptionHandlingSimulator 
        try {
            System.out.println("Valid Input: " + exceptionHandlingSimulator("Green", 5));
        }
        catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

        try {
            System.out.println(exceptionHandlingSimulator("Purple", 2));
        }
        catch (Exception e) {
            System.out.println("Caught expected exception for color: " + e.getMessage());
        }
        try {
            System.out.println(exceptionHandlingSimulator("Green", -5));
        }
        catch (Exception e) {
            System.out.println(exceptionHandlingSimulator("Green", -5));
        }
    }


    // Basic Req
    public static String trafficLightSimulator(String lightColor, int ticks) {
        
        if (ticks < 0) {
            return "Invalid input: tick count cannot be negative";
        }
        if  (!lightColor.equals("Green") && !lightColor.equals("Yellow") && !lightColor.equals("Red" )) {
            return "Invalid input: '" + lightColor + "' is not a recognized light color.";
        }

        int currentPosition = -1; // This will hold our number (0, 1, or 2)

        switch (lightColor) {
            case "Green":
                currentPosition = 0;
                break;
            case "Yellow":
                currentPosition = 1;
                break;
            case "Red":
                currentPosition = 2;
                break;
        }

        currentPosition = (currentPosition + ticks) % 3;
        
        switch (currentPosition) {
            case 0:
                return "Green";
            case 1:
                return "Yellow";
            case 2:
                return "Red";
            default:
                return  "Something went wrong!";
        }   
    }

    // Stretch Goal 1
    public static String[] fullCycleLog(String lightColor, int ticks) {
        if (ticks < 0) {
            return  new String[]{"Invalid input: tick count cannot be negative"};
        }

        if  (!lightColor.equals("Green") && !lightColor.equals("Yellow") && !lightColor.equals("Red" )) {
            return  new String[] {"Invalid input: '" + lightColor + "' is not a recognized light color."};
        }

        int currentPosition = -1; // This will hold our number (0, 1, or 2)

        switch (lightColor) {
            case "Green":
                currentPosition = 0;
                break;
            case "Yellow":
                currentPosition = 1;
                break;
            case "Red":
                currentPosition = 2;
                break;
        }

        String[] logs = new String[ticks];

        for (int i = 0; i < ticks; i++) {
            currentPosition = (currentPosition + 1) % 3;

            String currentColor;
            if (currentPosition == 0) {
                currentColor = "Green";
            }
            else if(currentPosition == 1) {
                currentColor = "Yellow";
            }
            else {
                currentColor = "Red";
            }
            logs[i] = currentColor;
        }
        
        return logs;
    }

    // Stretch Goal 2   
    public  static String variableDurationLights(String lightColor, int ticks) {
        if (ticks < 0) {
            return "Invalid input: tick count cannot be negative";
        }
        if  (!lightColor.equals("Green") && !lightColor.equals("Yellow") && !lightColor.equals("Red" )) {
            return "Invalid input: '" + lightColor + "' is not a recognized light color.";
        }

        int currentState = -1;
        if (lightColor.equals("Green")) {
            currentState = 0;
        }
        else if (lightColor.equals("Yellow")) {
            currentState = 1;
        }
        else {
            currentState = 2;
        }

        int[] durations= {3, 1, 2};
        int timeRemainingInState = durations[currentState];

        for (int i = 0; i < ticks; i++) {
            if (timeRemainingInState <= 1) {
                currentState = (currentState + 1) % 3;
                timeRemainingInState = durations[currentState];
            }
            else {
                timeRemainingInState--;
            }
        }

        if (currentState == 0)
                return "Green";
        
        if (currentState == 1)
                return "Yellow";

        return "Red";
    }

    public static String exceptionHandlingSimulator(String lightColor, int ticks) {
        if (!lightColor.equals("Green") && !lightColor.equals("Yellow") && !lightColor.equals("Red")) {
            throw new IllegalArgumentException("Invalid input: '" + lightColor + "' is not a recognized light color.");
        }

        if (ticks < 0) {
            throw new IllegalStateException("Invalid input: tick count cannot be negative.");
        }

        // The logic below only runs if no exceptions were thrown.
        int currentPosition = -1;
        switch (lightColor) {
            case "Green":  
            currentPosition = 0;
             break;
            case "Yellow": 
            currentPosition = 1; 
            break;
            case "Red":    
            currentPosition = 2; 
            break;
        }

        // Since we've handled exceptions, this math is guaranteed to be safe.
        int finalPosition = (currentPosition + ticks) % 3;

        if (finalPosition == 0) 
            return "Green";
        if (finalPosition == 1) 
            return "Yellow";
        return "Red";
    }
}
