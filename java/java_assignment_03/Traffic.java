package java.java_assignment_03;

public class Traffic {
    public static String traffic_light(String color, int ticks){
        if (ticks < 0){
            return "Error: tick count cannot be negative";
        }
        if (!color.equals("Green") && !color.equals("Yellow") && !color.equals("Red")){
            return "Error: color is invalid";
        }
        int steps = ticks % 3;
        String current = color;
        for (int i =0; i <steps; i++){
            switch(current) {
                case "Green":
                    current = "Yellow";
                    break;
                case "Yellow":
                    current = "Red";
                    break;
                case "Red":
                    current = "Green";
                    break;
            }
        }
        return current;
    }
    public static void main(String[] args) {
        System.out.println(traffic_light("Green", 4));
    }
}
    