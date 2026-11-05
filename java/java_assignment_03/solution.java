

//Author: Tyler Pyrzenski


public class solution {
    public static void main(String[] args) {

        System.out.println(lightCalculator("Green", 1));
        System.out.println(lightCalculator("Green", 3));
        System.out.println(lightCalculator("Red", 5));
        System.out.println(lightCalculator("Green", 0));
        System.out.println(lightCalculator("Purple", 2));
        System.out.println(lightCalculator("Green", -3));


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

}