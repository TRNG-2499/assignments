import java.util.*;

public class Elevator {

    static String checkElevator(int limit, int[] weights) {
       
        if (weights.length == 0) return "No passengers. Total: 0 lbs.";
        int total = 0;
        for (int i = 0; i < weights.length; i++) {
            total += weights[i];
            if (total >= limit)
                return "Passenger " + (i + 1) + " caused an overload. Total weight at that point: " + total + " lbs.";
        }

        return "All passengers boarded safely. Total weight: " + total + " lbs.";
    }

    public static void main(String[] args) {
        System.out.println(checkElevator(1000, new int[]{150, 200, 300, 250, 180}));
        System.out.println(checkElevator(1000, new int[]{150, 200, 300}));
        System.out.println(checkElevator(500, new int[]{200, 300}));
        System.out.println(checkElevator(100, new int[]{150, 200}));
        System.out.println(checkElevator(1000, new int[]{}));
    }
}