package assignments.java.java_assignment_02;
import java.util.Scanner;

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

    public static void main(String[] args){
        int[] passenger_weights = new int[] {};

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter weight limit (in lbs): ");
        int limit = scanner.nextInt();

        scanner.close();
        
        checkLimit(limit, passenger_weights);
    }
}
