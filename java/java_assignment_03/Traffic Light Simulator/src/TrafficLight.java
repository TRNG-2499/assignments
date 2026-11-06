/**
     * @param args the command line arguments
     * Java assignment 03 - Traffic Light Simulator
     * Objective: Practice using switch statements to represent state transitions, modulo arithmetic for cyclical logic, and reasoning through repeating sequences over a number of steps.
     * Steps:
     * 1. A method that accepts two params. A starting light color (String) and a number of ticks (time) that pass.
     * 2. The light goes green to yellow to red then back to green based on the given number or ticks that passed. The method should return the color of the light after the given number of ticks.
     * 3. Tick count of 0 leaves light unchanged. A loop that advances one tick at a time but a more simple solution can be found. If stating color is not a traffic light color then a message string should be returned indicating that the color is invalid. A neg. tick count is a error that would provide a error message.
     * 4. Use a switch statement to transition between the light colors. 
*/
public class TrafficLight {
    public static String getTrafficLightColor(String startColor, int ticks) {

        //check tick count is not neg.
        if (ticks < 0) {
            return "Tick count cannot be negative.";
        }

        //check the starting color
        if (!startColor.equals("Green") &&
            !startColor.equals("Yellow") &&
            !startColor.equals("Red")) {
            return "Error: '" + startColor +
                   "' is not a recognized traffic light color.";
        }

        //calculates and loop through the ticks that determine what color the light is
        int remainingTicks = ticks % 3;
        String currentColor = startColor;

        for (int i = 0; i < remainingTicks; i++) {
            switch(currentColor) {
                case "Green":
                    currentColor = "Yellow";
                    break;
                case "Yellow":
                    currentColor = "Red";
                    break;
                case "Red":
                    currentColor = "Green";
                    break;
            }
        }
        return currentColor;
    }

    public static void main(String[] args)  {
        System.out.println(getTrafficLightColor("Red", 5));
        System.out.println(getTrafficLightColor("Yellow", 1));
        System.out.println(getTrafficLightColor("Green", 0));
        System.out.println(getTrafficLightColor("Blue", 2));
        System.out.println(getTrafficLightColor("Green", -3));
    }
}
