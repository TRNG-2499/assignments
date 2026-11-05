
public class TrafficLight {
    public static void main(String[] args) {
        colourTick("Green", 1);
        colourTick("Green", 3);
        colourTick("Red", 5);
        colourTick("Green", 0);
        colourTick("Purple", 1);
        colourTick("Green", -3);
    }

    public static void colourTick(String startColour, int ticks) {
        if (ticks<0) {
            System.out.println("Invalid input: tick count cannot be negative.");
            return;
        }

        int startIdx;
        int next;
        switch (startColour.toLowerCase()) {
            case "green" -> startIdx = 0;
            case "yellow" -> startIdx = 1;
            case "red" -> startIdx = 2;
            default -> {
                System.out.println("Invalid input: "+ startColour +" is not a recognized light color.");
                return;
            }
        }

        next = Math.floorMod(ticks + startIdx, 3);

        switch (next) {
            case 0 -> System.out.println("Green");
            case 1 -> System.out.println("Yellow");
            case 2 -> System.out.println("Red");
            default -> {
                System.out.println("Math Error?");
            }
        }

        
    }

    public static String[] cycleLog(String startColour, int ticks) {
        String[] logArr = new String[ticks];
        
        if (ticks<0) {
            System.out.println("Invalid input: tick count cannot be negative.");
            return null;
        }

        int startIdx;
        int next;
        switch (startColour.toLowerCase()) {
            case "green" -> startIdx = 0;
            case "yellow" -> startIdx = 1;
            case "red" -> startIdx = 2;
            default -> {
                System.out.println("Invalid input: "+ startColour +" is not a recognized light color.");
                return null;
            }
        }

        for (int i = 0; i < ticks; i++) {
            next = Math.floorMod(i + startIdx + 1, 3);
            switch (next) {
                case 0 -> logArr[i] = "Green";
                case 1 -> logArr[i] = "Yellow";
                case 2 -> logArr[i] = "Red";
            default -> {
                System.out.println("Math Error?");
                return null;
                }
            }
        }

        return logArr;
    }
    

    public static void variTicks(String startColour, int ticks) {
        int greenTick = 1;
        int yellowTick = 1;
        int redTick = 1;
        if (ticks<0) {
            System.out.println("Invalid input: tick count cannot be negative.");
            return;
        }

        int startIdx;
        int next;
        int cycleTime = greenTick + yellowTick + redTick;
        switch (startColour.toLowerCase()) {
            case "green" -> startIdx = 0;
            case "yellow" -> startIdx = greenTick;
            case "red" -> startIdx = greenTick+yellowTick;
            default -> {
                System.out.println("Invalid input: "+ startColour +" is not a recognized light color.");
                return;
            }
        }

        next = Math.floorMod(startIdx + ticks, cycleTime);
        
        switch ((0 <= next && next < greenTick) ? 0 : 
        (greenTick <= next && next < greenTick + yellowTick) ? 1 : 2) {
            case 0 -> System.out.println("Green");
            case 1 -> System.out.println("Yellow");
            case 2 -> System.out.println("Red");
            default -> {
                System.out.println("Math Error?");
            }
        }
    }

}