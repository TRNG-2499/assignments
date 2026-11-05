package assignments.java.java_assignment_02;
import java.util.Scanner;
import java.util.Arrays;

public class java_assignment_02 {
    public static void checkLimit(int max_weight, int[] passengers){
        int running_total = 0;
        int i = 0;
        for (i = 0; i < passengers.length; i++){
            running_total = running_total + passengers[i];
            if (running_total >= max_weight){
                System.out.println("Passenger " + (i+1) + " caused an overload. Total weight at that point: " + running_total + "lbs.");
                break;
            }
        }
        if (running_total < max_weight){
            System.out.println("All passengers boarded safely. Total weight: " + running_total + "lbs.");
        }
        
        // Stretch Goal 2
        extremes(i, passengers);
    }

    // Stretch Goal 1: Max Safe Passenger Count
    public static void CalcMaxPassengers(int max_weight, int[] passengers){
        // Need a local copy to avoid sorting the original array
        int[] sorted_passengers = Arrays.copyOf(passengers, passengers.length);
        // Sort low to high
        Arrays.sort(sorted_passengers);
        int running_weight = 0;
        // Tally additions until max
        int i;
        for (i = 0; i < sorted_passengers.length; i++){
            if ((sorted_passengers[i] + running_weight) >= max_weight){
                break;
            } else {
                running_weight = running_weight + sorted_passengers[i];
            }
        }
        System.out.printf("Maximum of %d passengers from this group can board.\n", i);
    }
    
    // Stretch Goal 2
    public static void extremes(int i, int[] passengers){
        int lightest;
        int heaviest;
        if (i == 0){
            System.out.println(Arrays.toString(passengers));
            lightest = passengers[0];
            heaviest = passengers[0];
        } else {
            int[] subArray = Arrays.copyOfRange(passengers, 0, i);
            Arrays.sort(subArray);
            lightest = subArray[0];
            heaviest = subArray[subArray.length - 1];
        }

        System.out.printf("Lightest: %d \nHeaviest: %d", lightest, heaviest);
    }

    public static void main(String[] args){
        int[] passenger_weights = new int[] {300, 100, 250, 180};
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter weight limit (in lbs): ");
        int limit = scanner.nextInt();

        scanner.close();

        // Stretch Goal 1: Max Safe Passenger Count
        CalcMaxPassengers(limit, passenger_weights);
        
        checkLimit(limit, passenger_weights);
    }
}
