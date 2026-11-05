package javaAssignments.java_assignment_03;

import java.util.ArrayList;
import java.util.List;

public class traffic_light_sim {

        public static void main(String[] args) {

            // //TEST STATEMENTS
            // System.out.println(getColor(0, "red"));
            // System.out.println(getColor(1, "red")); 
            // System.out.println(getColor(2, "red")); 
            // System.out.println(getColor(3, "red")); 
            // System.out.println(getColor(-1, "red")); 
            // System.out.println(getColor(0, "blue")); 
            // System.out.println(printAllTicksGetColor(0, "green"));
            // System.out.println(printAllTicksGetColor(40, "yellow"));
            // System.out.println(printAllTicksGetColor(5, "red"));
            // System.out.println(printAllTicksGetColor(-10, "green"));
            // System.out.println(getColorVariableTicks(0, "green"));
            // System.out.println(getColorVariableTicks(1, "green"));
            // System.out.println(getColorVariableTicks(2, "green"));
            // System.out.println(getColorVariableTicks(3, "green"));
            // System.out.println(getColorVariableTicks(4, "green"));
            // System.out.println(getColorVariableTicks(5, "green"));
            // System.out.println(getColorVariableTicks(6, "green")); 
            // System.out.println(getColorVariableTicks(30, "green"));
        }
    
        public static String getColor(int tick, String startColor){

            List<String> colors = new ArrayList<>();
            colors.add("green");
            colors.add("yellow");
            colors.add("red");

            //Input validation on starting color
            if (!colors.contains(startColor)) {
                throw new IllegalArgumentException("Invalid color");
            }

            //input validation on tick
            if (tick < 0){
                throw new IllegalArgumentException("Invalid tick");
            }

            //Calculate the current color based on the tick and starting color
            return switch (startColor) {
                case "green" -> colors.get(tick % 3);
                case "yellow" -> colors.get((tick + 1) % 3);
                case "red" -> colors.get((tick + 2) % 3);
                default -> "Invalid color";
            };

        }

        public static List<String> printAllTicksGetColor(int tick, String startColor){

            List<String> colors = new ArrayList<>();
            colors.add("green");
            colors.add("yellow");
            colors.add("red");

            //Input validation on starting color
            if (!colors.contains(startColor)) {
                throw new IllegalArgumentException("Invalid color");
            }

            //input validation on tick
            if (tick < 0){
                throw new IllegalArgumentException("Invalid tick");
            }


            List<String> tickColors = new ArrayList<>();
            //Calculate the current color based on the tick and starting color and print each tick to the console
            for (int i = 0; i <= tick; i++) {
                String currentColor = getColor(i, startColor);
                tickColors.add(currentColor);
                //the below line of code can be uncommented to print each tick to the console, but it will be messy for large ticks.
                //System.out.println(tickColors.get(i));
            }

            //this returns a list of colors for each tick from 0 to the specified tick as a list<string>, printing it is a bit messy for large ticks.
            return tickColors;
        }

        public static String getColorVariableTicks(int tick, String startColor){

            List<String> colors = new ArrayList<>();
            colors.add("green");
            colors.add("yellow");
            colors.add("red");

            //Input validation on starting color
            if (!colors.contains(startColor)) {
                throw new IllegalArgumentException("Invalid color");
            }

            //input validation on tick
            if (tick < 0){
                throw new IllegalArgumentException("Invalid tick");
            }

            //in this alternate method green lasts for 3 ticks, yellow for 1 tick, and red for 2 ticks, so the cycle is 6 ticks long.
            return switch (startColor) {
                case "green" -> colors.get(tick % 6 < 3 ? 0 : (tick % 6 == 3 ? 1 : 2));
                case "yellow" -> colors.get(tick % 6 == 0 ? 1 : (tick % 6 < 4 ? 2 : 0));
                case "red" -> colors.get(tick % 6 < 2 ? 2 : (tick % 6 == 2 ? 0 : 1));
                default -> "Invalid color";
            };


        }
}
