package java_assignments.java_assignment_03;

import java.util.Set;

public class JavaSolution_03 {
    public static void main(String[] args) {
        System.out.println(trafficLight("Blue", 3));
    }

    public static String trafficLight(String color, int ticks){
        if(!Set.of("Green", "Yellow", "Red").contains(color)){
            return "Invalid color: "+color;
        } else if(ticks < 0) {
            return "Invalid tick count: "+ticks;
        }
        while(ticks%3 > 0) {
            switch(color) {
                case "Green":
                    color = "Yellow";
                    break;
                case "Yellow":
                    color = "Red";
                    break;
                case "Red":
                    color = "Green";
                    break;
            }
            ticks--;
        }
        return color;

    }

}


