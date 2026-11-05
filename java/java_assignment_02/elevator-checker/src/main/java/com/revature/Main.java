package com.revature;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter weight limit (lbs): ");
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Please enter a whole number: ");
        }
        int weightLimit = scanner.nextInt();

        System.out.print("How many passengers? ");
        // the count sizes an array, so it has to be checked here instead of in validateInputs
        int passengerCount = -1;
        while (passengerCount < 0) {
            if (scanner.hasNextInt()) {
                passengerCount = scanner.nextInt();
            } else {
                scanner.next();
            }
            if (passengerCount < 0) {
                System.out.print("Please enter a whole number of 0 or more: ");
            }
        }

        int[] passengerWeights = new int[passengerCount];
        for (int i = 0; i < passengerCount; i++) {
            System.out.print("Enter weight of passenger " + (i + 1) + ": ");
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.print("Please enter a whole number: ");
            }
            passengerWeights[i] = scanner.nextInt();
        }

        System.out.println(elevatorCheck(weightLimit, passengerWeights));

        // stretch goal 1
        System.out.println(maxSafePassengers(weightLimit, passengerWeights));

        // stretch goal 2
        System.out.println(heaviestAndLightest(weightLimit, passengerWeights));

        // stretch goal 3
        System.out.println(elevatorTrips(weightLimit, passengerWeights));

        scanner.close();
    }

    public static String validateInputs(int weightLimit, int[] passengerWeights) {
        if (weightLimit <= 0) {
            return "Invalid input: weight limit must be greater than 0";
        }
        for (int weight : passengerWeights) {
            if (weight < 0) {
                return "Invalid input: passenger weight cannot be negative";
            }
        }
        return null;
    }

    // normal solution
    public static String elevatorCheck(int weightLimit, int[] passengerWeights) {
        String error = validateInputs(weightLimit, passengerWeights);
        if (error != null) {
            return error;
        }
        if (passengerWeights.length == 0) {
            return "No passengers to board, total weight: 0 lbs";
        }

        int total = 0;
        for (int i = 0; i < passengerWeights.length; i++) {
            total += passengerWeights[i];
            if (total >= weightLimit) {
                return String.format("Passenger %d caused an overload, total weight at that point: %d lbs", i + 1, total);
            }
        }
        return String.format("All passengers boarded safely, total weight: %d lbs", total);
    }

    // stretch goal 1
    public static String maxSafePassengers(int weightLimit, int[] passengerWeights) {
        String error = validateInputs(weightLimit, passengerWeights);
        if (error != null) {
            return error;
        }

        // lightest passengers first fits the most people, sorted copy keeps the original order
        int[] sorted = Arrays.copyOf(passengerWeights, passengerWeights.length);
        Arrays.sort(sorted);

        int total = 0;
        int count = 0;
        for (int weight : sorted) {
            if (total + weight >= weightLimit) {
                break;
            }
            total += weight;
            count++;
        }
        return String.format("Maximum safe passengers: %d of %d, total weight: %d lbs", count, passengerWeights.length, total);
    }

    // stretch goal 2
    public static String heaviestAndLightest(int weightLimit, int[] passengerWeights) {
        String output = elevatorCheck(weightLimit, passengerWeights);
        if (validateInputs(weightLimit, passengerWeights) != null || passengerWeights.length == 0) {
            return output;
        }

        int heaviest = passengerWeights[0];
        int lightest = passengerWeights[0];
        int total = 0;
        for (int weight : passengerWeights) {
            heaviest = Math.max(heaviest, weight);
            lightest = Math.min(lightest, weight);
            total += weight;
            // stop at the passenger who caused the overload
            if (total >= weightLimit) {
                break;
            }
        }
        return output + String.format("\nHeaviest: %d lbs, lightest: %d lbs", heaviest, lightest);
    }

    // stretch goal 3
    public static String elevatorTrips(int weightLimit, int[] passengerWeights) {
        String error = validateInputs(weightLimit, passengerWeights);
        if (error != null) {
            return error;
        }
        if (passengerWeights.length == 0) {
            return "No passengers to board, trips needed: 0";
        }

        // a passenger who meets the limit alone can't ride on any trip
        for (int i = 0; i < passengerWeights.length; i++) {
            if (passengerWeights[i] >= weightLimit) {
                return String.format("Passenger %d meets or exceeds the weight limit alone and cannot ride", i + 1);
            }
        }

        String trips = "";
        String currentTrip = "";
        int tripCount = 0;
        int tripTotal = 0;

        for (int i = 0; i < passengerWeights.length; i++) {
            // send the current trip if this passenger would overload it
            if (!currentTrip.isEmpty() && tripTotal + passengerWeights[i] >= weightLimit) {
                tripCount++;
                trips += String.format("\n  Trip %d: %s (%d lbs)", tripCount, currentTrip, tripTotal);
                currentTrip = "";
                tripTotal = 0;
            }
            if (!currentTrip.isEmpty()) {
                currentTrip += ", ";
            }
            currentTrip += "Passenger " + (i + 1);
            tripTotal += passengerWeights[i];
        }

        // send the last trip
        tripCount++;
        trips += String.format("\n  Trip %d: %s (%d lbs)", tripCount, currentTrip, tripTotal);

        return "Trips needed: " + tripCount + trips;
    }
}
