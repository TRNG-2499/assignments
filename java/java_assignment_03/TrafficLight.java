import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class TrafficLight {

    public static String computeTrafficLight(String startColor, int ticks) {  
        HashSet<String> validStringSet = new HashSet<>(List.of("Green", "Yellow", "Red"));
        if (!validStringSet.contains(startColor)) {
            String returnStr = "Input startColor is invalid";
            return returnStr;
        }

        if (ticks < 0) {
            String returnStr = "Input ticks cannot be negative";
            return returnStr;
        }
        
        String finalColor;

        String[] colors = new String[] {"Green", "Yellow", "Red"};
        int idx = 0;

        switch (startColor) {
            case "Green":
                idx = (ticks) % 3;
                break;

            case "Yellow":
                idx = (ticks + 1) % 3;
                break;

            case "Red":
                idx = (ticks + 2) % 3;
                break;
        }

        finalColor = colors[idx];
        return String.valueOf(finalColor);
    } 


    // Stretch goal #1
    public static ArrayList<String> getFullCycleLog(String startColor, int ticks) {
        String[] colors = new String[] {"Green", "Yellow", "Red"};
        ArrayList<String> log = new ArrayList<String>();

        int idx = 0;
        switch (startColor) {
            case "Green":
                idx = 0;
                break;
            case "Yellow":
                idx = 1;
                break;
            case "Red":
                idx = 2;
                break;
        }

        for (int i = 1; i <= ticks; i++) {
            int nextColorIdx = (i + idx) % 3;
            log.add(colors[nextColorIdx]);
        }

        return log;
    }


    // Stretch goal #2
    public static String computeLightWithDurations(String startColor, int ticks) {
        String[] colors = new String[] {"Green", "Yellow", "Red"};

        // Mapping: Integer corresponding to a color -> Duration for that color
        HashMap<Integer, Integer> durationMap = new HashMap<Integer, Integer>();
        durationMap.put(0, 3);
        durationMap.put(1, 1);
        durationMap.put(2, 2);

        int offset = 0;
        switch (startColor) {
            case "Green":
                offset = 0;
                break;
            case "Yellow":
                offset = 1;
                break;
            case "Red":
                offset = 2;
                break;
        }

        int colorIdx = offset;
        String currColor = colors[colorIdx];
        int waitTime = durationMap.get(colorIdx);

        for (int i = 0; i < ticks; i++) {
            waitTime -= 1;
            if (waitTime == 0) {
                // Key idea is that we're shifting to the next color, relative to the
                // previous color (instead of by i), here we're doing it in terms of colorIdx
                colorIdx = (colorIdx + 1) % 3;
                currColor = colors[colorIdx];
                waitTime = durationMap.get(colorIdx);
            }
        }

        return currColor;
    }


    // Stretch goal #3
    public static String exceptionHandling(String startColor, int ticks) {  
        HashSet<String> validStringSet = new HashSet<>(List.of("Green", "Yellow", "Red"));
        if (!validStringSet.contains(startColor)) {
            throw new IllegalArgumentException("Input startColor is invalid!");
        }

        if (ticks < 0) {
            throw new IllegalArgumentException("Input ticks cannot be negative!");
        }
        
        String finalColor;

        String[] colors = new String[] {"Green", "Yellow", "Red"};
        int idx = 0;

        switch (startColor) {
            case "Green":
                idx = (ticks) % 3;
                break;

            case "Yellow":
                idx = (ticks + 1) % 3;
                break;

            case "Red":
                idx = (ticks + 2) % 3;
                break;
        }

        finalColor = colors[idx];
        return String.valueOf(finalColor);
    } 



    public static void main(String[] args) {
        // String result = computeTrafficLight("Green", 1);
        // System.out.println(result);

        // ArrayList<String> result2 = getFullCycleLog("Red", 7);
        // System.out.println(result2);

        // String result3 = computeLightWithDurations("Green", 5);
        // System.out.println(result3);
    }
}
