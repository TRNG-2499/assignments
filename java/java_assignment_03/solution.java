//Author: Tyler Pyrzenski

import java.util.Arrays;

public class solution {
    public static void main(String[] args) {

        // original test cases using lightCalculator

        System.out.println(lightCalculator("Green", 1));
        System.out.println(lightCalculator("Green", 3));
        System.out.println(lightCalculator("Red", 5));
        System.out.println(lightCalculator("Green", 0));
        System.out.println(lightCalculator("Purple", 2));
        System.out.println(lightCalculator("Green", -3));

        System.out.println();

        // stretch goal 1 test cases using fullCycleLog
        // Arrays.toString is used so the array prints its values instead of its memory address

        System.out.println(Arrays.toString(fullCycleLog("Green", 4)));
        System.out.println(Arrays.toString(fullCycleLog("Red", 2)));
        System.out.println(Arrays.toString(fullCycleLog("Green", 0)));
        System.out.println(Arrays.toString(fullCycleLog("Purple", 2)));
        System.out.println(Arrays.toString(fullCycleLog("Green", -3)));

        System.out.println();

        // stretch goal 2 test cases using variableDurationCalculator
        // Green lasts 3 ticks, Yellow lasts 1 tick, Red lasts 2 ticks, so one full cycle is 6 ticks

        System.out.println(variableDurationCalculator("Green", 2));   // still Green, only 2 of its 3 ticks used
        System.out.println(variableDurationCalculator("Green", 3));   // Green is done, now Yellow
        System.out.println(variableDurationCalculator("Green", 4));   // Yellow only lasts 1, now Red
        System.out.println(variableDurationCalculator("Yellow", 1));  // Yellow is done, now Red
        System.out.println(variableDurationCalculator("Red", 2));     // Red is done, now Green
        System.out.println(variableDurationCalculator("Green", 6));   // full cycle, back to Green
        System.out.println(variableDurationCalculator("Purple", 2));
        System.out.println(variableDurationCalculator("Green", -3));

        System.out.println();

        // stretch goal 3 test cases using lightCalculatorWithExceptions
        // the method throws, and main is the one responsible for catching and deciding what to show the user

        runExceptionTest("Red", 5);
        runExceptionTest("Purple", 2);
        runExceptionTest("Green", -3);
    }

    public static String lightCalculator(String colorInput, int ticksInput) {

        if (nextColor(colorInput).equals("Invalid input")) {
            return "Invalid input: '" + colorInput + "' is not a recognized light color.";
        } else if (ticksInput < 0) {
            return "Invalid input: tick count cannot be negative.";
        }

        String currentColor = colorInput;

        for (int i = 0; i < ticksInput % 3; i++) {
            currentColor = nextColor(currentColor);
        }
        return currentColor;

    }
    public static String nextColor(String color) {

        switch (color) {
            case "Green":
                return "Yellow";
            case "Yellow":
                return "Red";
            case "Red":
                return "Green";
            default:
                return "Invalid input";
        }

    }

    // stretch goal 1: full cycle log
    // returns an array with every color the light passes through, one entry per tick
    // the starting color is not included

    public static String[] fullCycleLog(String colorInput, int ticksInput) {

        // same validation as lightCalculator, but since the return type is an array,
        // the error message is returned as the only entry in the array

        if (nextColor(colorInput).equals("Invalid input")) {
            return new String[]{"Invalid input: '" + colorInput + "' is not a recognized light color."};
        } else if (ticksInput < 0) {
            return new String[]{"Invalid input: tick count cannot be negative."};
        }

        // array is sized to the number of ticks since there is one entry per tick
        // modulo is not used here because every single tick needs to be recorded

        String[] colorLog = new String[ticksInput];
        String currentColor = colorInput;

        for (int i = 0; i < ticksInput; i++) {
            currentColor = nextColor(currentColor);
            colorLog[i] = currentColor;
        }
        return colorLog;
    }

    // stretch goal 2: variable duration lights
    // each color stays on for its own number of ticks before moving to the next one
    // Green = 3 ticks, Yellow = 1 tick, Red = 2 ticks, so one full cycle is 6 ticks
    // the starting color is assumed to have just turned on (it has its full duration left)
    //
    // laid out as positions in the 6 tick cycle:
    // position: 0     1     2     3      4    5
    // color:    Green Green Green Yellow Red  Red

    public static String variableDurationCalculator(String colorInput, int ticksInput) {

        // declaring each colors duration so they are easy to change later in one spot

        int greenDuration = 3;
        int yellowDuration = 1;
        int redDuration = 2;
        int cycleLength = greenDuration + yellowDuration + redDuration;

        // same validation as lightCalculator

        if (nextColor(colorInput).equals("Invalid input")) {
            return "Invalid input: '" + colorInput + "' is not a recognized light color.";
        } else if (ticksInput < 0) {
            return "Invalid input: tick count cannot be negative.";
        }

        // switch to find where in the cycle the starting color begins
        // Green starts at 0, Yellow starts after Green finishes, Red starts after Yellow finishes

        int startPosition;

        switch (colorInput) {
            case "Green":
                startPosition = 0;
                break;
            case "Yellow":
                startPosition = greenDuration;
                break;
            default: // Red, the only option left since invalid colors were already caught above
                startPosition = greenDuration + yellowDuration;
                break;
        }

        // moving forward by the number of ticks, modulo wraps it back around
        // once it passes the end of a full cycle, same idea as % 3 in lightCalculator

        int currentPosition = (startPosition + ticksInput) % cycleLength;

        // checking which colors section of the cycle the position landed in

        if (currentPosition < greenDuration) {
            return "Green";
        } else if (currentPosition < greenDuration + yellowDuration) {
            return "Yellow";
        } else {
            return "Red";
        }
    }

    // stretch goal 3: exception handling for invalid input
    // instead of returning an error message, each invalid case throws its own exception type
    // both are custom exceptions that extend IllegalArgumentException, since both errors come from a bad argument
    // being passed in, but having two separate types lets the caller handle each case differently if it wants to

    public static class UnrecognizedLightColorException extends IllegalArgumentException {
        public UnrecognizedLightColorException(String message) {
            super(message);
        }
    }

    public static class NegativeTickCountException extends IllegalArgumentException {
        public NegativeTickCountException(String message) {
            super(message);
        }
    }

    // same logic as lightCalculator, but throws instead of returning a message
    // the method itself does not catch anything, its job is only to report that the input was bad
    // the caller (main through runExceptionTest) decides what to do about it

    public static String lightCalculatorWithExceptions(String colorInput, int ticksInput) {

        if (nextColor(colorInput).equals("Invalid input")) {
            throw new UnrecognizedLightColorException("'" + colorInput + "' is not a recognized light color.");
        } else if (ticksInput < 0) {
            throw new NegativeTickCountException("tick count cannot be negative.");
        }

        String currentColor = colorInput;

        for (int i = 0; i < ticksInput % 3; i++) {
            currentColor = nextColor(currentColor);
        }
        return currentColor;
    }

    // helper for main so each test case doesnt need its own try/catch block
    // each exception type gets its own catch so they can be handled separately

    public static void runExceptionTest(String colorInput, int ticksInput) {

        try {
            System.out.println(lightCalculatorWithExceptions(colorInput, ticksInput));
        } catch (UnrecognizedLightColorException e) {
            System.out.println("Color error: " + e.getMessage());
        } catch (NegativeTickCountException e) {
            System.out.println("Tick error: " + e.getMessage());
        }
    }

}