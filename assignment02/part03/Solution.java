package assignment02.part03;
import java.util.Scanner;
public class Solution {

    public static String tickCycle(String startColor, int ticks){
        String [] colors = {"Green", "Yellow", "Red"};
        if (!"Green".equals(startColor) && !"Yellow".equals(startColor) && !"Red".equals(startColor)) {
            return "Invalid input: '" + startColor + "' is not a recognized light color.";
        }
        if (ticks < 0) {
            return "Invalid input: tick count cannot be negative.";
        }
        int start = switch(startColor){
            case "Green" -> 0;
            case "Yellow" -> 1;
            case "Red" -> 2;
            default -> -1;
        };
        int cycle = (start + ticks) % 3;
        return colors[cycle];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your starting color: ");
        String color = sc.nextLine();
        System.out.println("What is the tick count: ");
        int tick = sc.nextInt();
        System.out.println(tickCycle(color, tick));
        sc.close();
    } 
}