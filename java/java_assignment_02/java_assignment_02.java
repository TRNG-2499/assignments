package assignments.java.java_assignment_02;
import java.util.Scanner;
import java.util.Arrays;

public class java_assignment_02 {
    public static void checkLimit(int max_weight, int[] passengers){
        int running_total = 0;
        for (int i = 0; i < passengers.length; i++){
            running_total = running_total + passengers[i];
            if (running_total >= max_weight){
                System.out.println("Passenger " + (i+1) + " caused an overload. Total weight at that point: " + running_total + "lbs.");
                break;
            }
        }
        if (running_total < max_weight){
            System.out.println("All passengers boarded safely. Total weight: " + running_total + "lbs.");
        }
    }

    // Stretch Goal 1: Max Safe Passenger Count
    public static void CalcMaxPassengers(int max_weight, int[] passengers){
        // Sort low to high
        Arrays.sort(passengers);
        int running_weight = 0;
        // Tally additions until max
        int i;
        for (i = 0; i < passengers.length; i++){
            if ((passengers[i] + running_weight) >= max_weight){
                break;
            } else {
                running_weight = running_weight + passengers[i];
            }
        }
        System.out.printf("Maximum of %d passengers from this group can board.\n", i);
    }

    public static void main(String[] args){
        int[] passenger_weights = new int[] {150, 200, 300, 250, 180};
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter weight limit (in lbs): ");
        int limit = scanner.nextInt();

        scanner.close();

        // Stretch Goal 1: Max Safe Passenger Count
        CalcMaxPassengers(limit, passenger_weights);
        
        checkLimit(limit, passenger_weights);
    }
}
