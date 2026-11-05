import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args){
        System.out.println(simulateTrafficLight("Green", 1));
        System.out.println(simulateTrafficLight("Green", 3));
        System.out.println(simulateTrafficLight("Red", 5));
        System.out.println(simulateTrafficLight("Green", 0));
        System.out.println(simulateTrafficLight("Purple", 2));
        System.out.println(simulateTrafficLight("Green", -3));
    }

    public static String simulateTrafficLight(String originalTrafficLightColor, int ticks){
        if(ticks < 0){
            return "Invalid input: tick count cannot be negative.";
        }
        String light = new String(originalTrafficLightColor);
        for(int i = 0; i < ticks; i++){
            light = nextTrafficLightColor(light);
            if(!(light.equals("Green") || light.equals("Yellow") || light.equals("Red"))){
                break;
            }
        }
        return light;
    }

    private static String nextTrafficLightColor(String currentTrafficLightColor){
        switch(currentTrafficLightColor){
            case "Green":
                return "Yellow";
            case "Yellow":
                return "Red";
            case "Red":
                return "Green";
            default:
                return "Invalid input: /'" + currentTrafficLightColor + "/' is not a recognized light color.";
        }
    }
}