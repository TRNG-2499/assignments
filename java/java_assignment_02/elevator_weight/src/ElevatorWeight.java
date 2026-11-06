/**
     * @param args the command line arguments
     * Java assignment 02 - Elevator Weight Limit Checker
     * Objective: Practice iterating through a collection while maintaining a running total, using conditional logic to detect when a threshold has been reached or exceeded, and exiting a loop early once that condition is met.
     * Steps:
     * 1. A method that accepts 2 params. A max weight limit and a array of passenger weights that boards a elevator one at a time in the order given. Track the running total weight.
     * 2. If adding a passenger makes the total meet or exceed the max weight limit, the method should report who caused the overload. The total weight and that no further passengers can be considered.
     * 3. If the running total weight never meets or exceeds the max weight limit, the method should report that all passengers were able to board and the total weight.
*/

import java.util.Scanner;

public class ElevatorWeight {

    public static String checkWeightLimit(int weightLimit, int[] passengerWeights) {
        int totalWeight = 0;

        //a empty passenger array just returns an empty string, won't break the program
        if (passengerWeights.length == 0) {
            return "";
        }

        //adding passengers one at a time
        for (int i = 0; i < passengerWeights.length; i++) {
            totalWeight += passengerWeights[i];
            //checks to see if weight limit is reached or exceeded
            if (totalWeight >= weightLimit) {
                return "Passenger " + (i + 1) +
                       " caused an overload. Total weight at that point: " +
                       totalWeight + " lbs.";
            }
        }

        //returns that all passengers were boarded without exceeding the weight limit
        return "All passengers boarded safely. Total weight: " +
               totalWeight + " lbs.";
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter elevator weight limit: ");
        int weightLimit = scanner.nextInt();

        System.out.print("Enter number of passengers: ");
        int numberOfPassengers = scanner.nextInt();

        int[] passengerWeights = new int[numberOfPassengers];

        //add every passenger's weight
        for (int i = 0; i < numberOfPassengers; i++) {
            System.out.print("Enter weight for Passenger " + (i + 1) + ": ");
            passengerWeights[i] = scanner.nextInt();
        }

        //pass user inputs into the method
        String result = checkWeightLimit(weightLimit, passengerWeights);
        System.out.println("\n" + result);
        scanner.close();
    }
}
