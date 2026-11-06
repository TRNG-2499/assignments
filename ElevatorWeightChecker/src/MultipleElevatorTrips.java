/* 4. Stretch Goal 3: MultipleElevatorTrips.java
 Multiple elevator trips
 This program groups passengers into consecutive trips.

 Each trip must have a total weight strictly below the elevator's weight limit.
 Complete code */

import java.util.Scanner;

public class MultipleElevatorTrips {

    // Stretch Goal 3 method
    public static String calculateElevatorTrips(
            int weightLimit, int[] passengerWeights) {

        if (passengerWeights == null || passengerWeights.length == 0) {
            return "No passengers. No trips required.";
        }

        StringBuilder result = new StringBuilder();

        int tripNumber = 1;
        int totalWeight = 0;

        result.append("Trip 1: ");

        for (int i = 0; i < passengerWeights.length; i++) {

            int weight = passengerWeights[i];

            // Check if one passenger cannot fit
            if (weight >= weightLimit) {
                return "Passenger " + (i + 1)
                        + " cannot board because their weight meets "
                        + "or exceeds the elevator limit.";
            }

            // Start a new trip if necessary
            if (totalWeight + weight >= weightLimit) {

                tripNumber++;

                totalWeight = 0;

                result.append("\nTrip " + tripNumber + ": ");
            }

            // Add comma between passengers
            if (totalWeight > 0) {
                result.append(", ");
            }

            result.append("Passenger " + (i + 1));

            // Add passenger weight
            totalWeight += weight;

            // Display current trip total
            // (Added below after the loop)
        }

        result.append("\nTotal trips required: " + tripNumber);

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter elevator weight limit: ");
        int weightLimit = scanner.nextInt();

        System.out.print("Enter number of passengers: ");
        int numberOfPassengers = scanner.nextInt();

        int[] passengerWeights = new int[numberOfPassengers];

        for (int i = 0; i < numberOfPassengers; i++) {

            System.out.print("Enter weight of Passenger "
                    + (i + 1) + ": ");

            passengerWeights[i] = scanner.nextInt();
        }

        // Call method
        String result = calculateElevatorTrips(
                weightLimit, passengerWeights);

        System.out.println("\n" + result);

        scanner.close();
    }
}

