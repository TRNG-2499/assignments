public class TrafficLight{

    public static String nextColor(String color) {
        switch (color) {
            case "Green":  return "Yellow";
            case "Yellow": return "Red";
            case "Red":    return "Green";
            default:       return null;
        }
    }

    public static String simulate(String startColor, int ticks) {
        if (startColor == null || nextColor(startColor) == null) {
            return "Invalid input: '" + startColor + "' is not a recognized light color.";
        }
        if (ticks < 0) {
            return "Invalid input: tick count cannot be negative.";
        }

        String color = startColor;
        for (int i = 0; i < ticks % 3; i++) {
            color = nextColor(color);
        }
        return color;
    }

    public static void main(String[] args) {
        System.out.println(simulate("Green", 1));   
        System.out.println(simulate("Green", 3));  
        System.out.println(simulate("Red", 5));   
        System.out.println(simulate("Green", 0));   
        System.out.println(simulate("Purple", 2));  
        System.out.println(simulate("Green", -3));  
    }
}
