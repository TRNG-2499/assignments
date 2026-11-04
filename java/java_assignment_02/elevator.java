package java_assignment_02;

import java.util.*;

public class elevator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the weight limit: ");
        int weightLimit = scanner.nextInt();

        // Check for invalid weight
        if (weightLimit <= 0) {
            System.out.println("Invalid input: weight limit cannot be zero or negative");
            scanner.close();
            return;
        }

        System.out.println("Please enter the program mode");
        System.out.println("1 for default");
        System.out.println("2 for Maximum Safe Passenger Count");
        System.out.println("3 for Heaviest and Lightest Passengers");
        System.out.println("4 for Multiple Elevator Trips");
        int mode = scanner.nextInt();

        System.out.print("Please enter the number of passengers:");
        int numPassengers = scanner.nextInt();

        // handle 0 passenger cases
        if (numPassengers <= 0) {
            System.out.println("Invalid input: number of passengers cannot be zero or negative");
            scanner.close();
            return;
        }

        List<Integer> passengers = new ArrayList<>();

        for (int i = 0; i < numPassengers; i++) {
            System.out.print("Please enter the weight of passenger " + (i + 1) + ": ");
            int weight = scanner.nextInt();

            if (weight < 0) {
                System.out.println("Invalid input: weight cannot be negative");
                scanner.close();
                return;
            }
            passengers.add(weight);
        }

        switch (mode) {
            case 1:
                defaultMode(weightLimit, passengers);
                break;
            case 2:
                maximumSafePassengerCount(weightLimit, passengers);
                break;
            case 3:
                heaviestAndLightestPassengers(weightLimit, passengers);
                break;
            case 4:
                multipleElevatorTrips(weightLimit, passengers);
                break;
            default:
                System.out.println("Invalid mode selected.");
                break;
        }
        scanner.close();
    }

    // default mode
    public static void defaultMode(int weightLimit, List<Integer> passengers) {
        System.out.println("Default mode selected.");

        int totalWeight = 0;
        int index = 1;
        // loop through passengers and check for overload
        for (int weight : passengers) {
            totalWeight += weight;

            if (totalWeight >= weightLimit) { // when overload happens
                System.out.println("Passenger " + index + " caused an overload. Total weight at that point: "
                        + totalWeight + " lbs");
                return;
            }
            index++;
        }
        System.out.println("All passengers boarded safely. Total weight: " + totalWeight + " lbs");
    }

    // find safe limit
    public static void maximumSafePassengerCount(int weightLimit, List<Integer> passengers) {
        System.out.println("Maximum safe passenger count mode selected.");

        if (passengers.isEmpty() || passengers.size() < 3) {
            System.out.println("List size is not sufficient for this computation.");
            return;
        }

        int totalWeight = 0;
        int index = 1;
        int prev = 0;

        // loop through passengers and check for overload
        for (int weight : passengers) {
            prev = totalWeight; // store previous total weight
            totalWeight += weight;

            if (totalWeight >= weightLimit) {// When overload happens
                System.out.println("Passenger " + index + " caused an overload. Total weight at that point: "
                        + totalWeight + " lbs");
                System.out.println("Maximum safe passenger count: " + (index - 1)
                        + " passengers with a total weight of " + prev + " lbs");
                return;
            }
            index++;
        }
        System.out.println("All passengers boarded safely. Total weight: " + totalWeight + " lbs");
    }

    // helper to find heaviest passenger
    public static int findHeavy(List<Integer> passengers, int index) {

        int heaviest = 0;

        for (int i = 0; i <= index - 1; i++) {
            if (passengers.get(i) > heaviest) {
                heaviest = passengers.get(i);
            }
        }

        return heaviest;

    }

    // helper to find lightest passenger
    public static int findLight(List<Integer> passengers, int index) {

        int lightest = Integer.MAX_VALUE;

        for (int i = 0; i <= index - 1; i++) {
            if (passengers.get(i) < lightest) {
                lightest = passengers.get(i);
            }
        }

        return lightest;

    }

    // find heaviest adn lightest passenger
    public static void heaviestAndLightestPassengers(int weightLimit, List<Integer> passengers) {
        System.out.println("Heaviest and lightest passengers mode selected.");

        int totalWeight = 0;
        int index = 1;
        int heaviest = 0;
        int lightest = Integer.MAX_VALUE;

        if (passengers.size() < 2) {
            System.out.println("List size is not sufficient for this computation.");
            return;
        }

        // loop through passengers and check for overload
        for (int weight : passengers) {
            totalWeight += weight;

            if (totalWeight >= weightLimit) { // when overload happens
                System.out.println("Passenger " + index + " caused an overload. Total weight at that point: "
                        + totalWeight + " lbs");

                heaviest = findHeavy(passengers, index);
                lightest = findLight(passengers, index);

                System.out.println("Heaviest passenger: " + heaviest + " lbs");
                System.out.println("Lightest passenger: " + lightest + " lbs");
                return;
            }
            index++;
        }
        System.out.println("All passengers boarded safely. Total weight: " + totalWeight + " lbs");
        heaviest = findHeavy(passengers, index);
        lightest = findLight(passengers, index);

        System.out.println("Heaviest passenger: " + heaviest + " lbs");
        System.out.println("Lightest passenger: " + lightest + " lbs");
    }

    // Multiple trip
    public static void multipleElevatorTrips(int weightLimit, List<Integer> passengers) {

        System.out.println("Multiple elevator trips mode selected.");
        int trips = 1;
        int totalWeight = 0;
        int index = 1; // Variable to track lass passenger for the trip
        int passengerPointer = 1; // variable to track start passenger for trip

        for (int weight : passengers) {

            if ((weight + totalWeight) >= weightLimit) {

                // handle case where single passenger weight exceeed weight limit
                if (weight >= weightLimit) {
                    System.out.println("Elevator capacity cannot accommodate oversized passenger");
                    return;
                }

                System.out.println("Passenger " + index + " caused an overload. Total weight at that point: "
                        + (totalWeight + weight) + " lbs");

                System.out.println("Elevator trip " + trips + " completed. Total weight: " + totalWeight + " lbs");
                System.out.println("Trip " + trips + " passengers: " + passengerPointer + " to " + (index - 1));
                passengerPointer = index; // move start passenger to next passenger for next trip
                trips++; // increment trip after last one
                totalWeight = weight;
                System.out.println();
                System.out.println("Starting elevator trip " + trips + " with passenger " + index);
                index++; // increment index

            } else {
                totalWeight += weight;
                index++;
            }

        }
        System.out.println(
                "All passengers boarded safely. Total weight: " + totalWeight + " lbs");
        System.out.println("Trip " + trips + " passengers: " + passengerPointer + " to " + (index - 1));
        System.out.println("Total elevator trips: " + trips);

    }
}
