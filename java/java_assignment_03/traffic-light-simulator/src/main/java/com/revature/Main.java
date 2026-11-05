package com.revature;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter starting color (Green, Yellow, Red): ");
        String color = scanner.next();

        System.out.print("Enter number of ticks: ");
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Please enter a whole number: ");
        }

        int ticks = scanner.nextInt();

        System.out.println(trafficLightSim(color, ticks));

        System.out.println();
        System.out.println("-----Strech Goal 1-----");
        // stretch goal 1
        System.out.println(Arrays.toString(cycleLog(color, ticks)));

        System.out.println();
        System.out.println("-----Strech Goal 2-----");
        // stretch goal 2
        System.out.println(variableDurationLight(color, ticks));

        // stretch goal 3
        try {
            System.out.println(trafficLightSimWithExceptions(color, ticks));
        } catch (IllegalArgumentException | UnrecognizedColorException e) {
            System.out.println("Invalid input: " + e.getMessage());
        }

        scanner.close();
    }

    // normal solution
    public static String trafficLightSim(String startColor, int ticks){
        if (ticks < 0) {
            return "Invalid input: tick count cannot be negative.";
        }
        if (nextColor(startColor) == null) {
            return "Invalid input: '" + startColor + "' is not a recognized light color.";
        }

        // the cycle repeats every 3 ticks, so only the remainder changes the color
        String current = startColor;
        for (int i = 0; i < ticks % 3; i++) {
            current = nextColor(current);
        }
        return current;
    }

    public static String nextColor(String color) {
        switch (color) {
            case "Green": return "Yellow";
            case "Yellow": return "Red";
            case "Red": return "Green";
            default: return null;
        }
    }

    // stretch goal 1
    public static String[] cycleLog(String startColor, int ticks) {
        if (ticks < 0 || nextColor(startColor) == null) {
            // reuse the normal solution's error message
            return new String[] { trafficLightSim(startColor, ticks) };
        }

        String[] log = new String[ticks];
        String current = startColor;
        for (int i = 0; i < ticks; i++) {
            current = nextColor(current);
            log[i] = current;
        }
        return log;
    }

    // stretch goal 2
    public static String variableDurationLight(String startColor, int ticks) {
        if (ticks < 0) {
            return "Invalid input: tick count cannot be negative.";
        }

        // green lasts 3 ticks, Yellow 1, Red 2, so one full cycle is 6 ticks.
        int start;
        switch (startColor) {
            case "Green": start = 0; break;
            case "Yellow": start = 3; break;
            case "Red": start = 4; break;
            default: return "Invalid input: '" + startColor + "' is not a recognized light color.";
        }

        int position = (start + ticks) % 6;
        if (position < 3) {
            return "Green";
        } else if (position < 4) {
            return "Yellow";
        }
        return "Red";
    }

    // stretch goal 3
    public static String trafficLightSimWithExceptions(String startColor, int ticks) throws UnrecognizedColorException {
        if (ticks < 0) {
            throw new IllegalArgumentException("tick count cannot be negative.");
        }
        if (nextColor(startColor) == null) {
            throw new UnrecognizedColorException(startColor);
        }
        return trafficLightSim(startColor, ticks);
    }

    // checked, so the compiler forces callers to decide how to handle a bad color
    public static class UnrecognizedColorException extends Exception {
        public UnrecognizedColorException(String color) {
            super("'" + color + "' is not a recognized light color.");
        }
    }
}