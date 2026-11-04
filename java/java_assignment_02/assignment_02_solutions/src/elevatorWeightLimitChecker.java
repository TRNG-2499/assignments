import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class elevatorWeightLimitChecker {
    public static void main(String[] args) {
        List<Integer> passengerWeights = List.of(200, 100, 300, 500);
        List<Integer> emptyPassengerWeights = List.of();

        /*
           Main test
         */
        // Test emtpy list
        //String testOne = weightLimitCheck(0, emptyPassengerWeights);
        //System.out.println(testOne);
        // Test passengerWeights sum > max weight
        //String testTwo = weightLimitCheck(100, passengerWeights);
        //System.out.println(testTwo);
        // Test successful boarding
        //String testThree = weightLimitCheck(1000, passengerWeights);
        //System.out.println(testThree);

        /*
           Stretch test
         */
        // Empty weights
        //String testFour = stretchWeightLimitCheck(10000, emptyPassengerWeights);
        //System.out.println(testFour);

        String testFive = stretchWeightLimitCheck(501, passengerWeights);
        System.out.println(testFive);
    }

    // Returns a message that confirms or
    public static String weightLimitCheck(int maxWeight, List<Integer> passengerWeights) {
        if (passengerWeights.isEmpty()) {
           return "Error: Passenger list is empty, please enter a valid list.";
        }
        int i = 1; // Passenger id
        int totalWeight = 0;
        for (int passengerWeight : passengerWeights) {
            totalWeight += passengerWeight;
            // Check if met or exceeded max weight, if so then return a notifying message
            if (totalWeight >= maxWeight) {
                return "Passenger " +
                        i +
                        " caused a weight overload. Total weight at that point: " +
                        passengerWeight +
                        " lbs.";
            }
            i += 1;
        }

        // All passengers boarded successfully, return a success message
        return "All passengers boarded safely. Total weight: " +
                totalWeight +
                " lbs.";
    }
    public static String stretchWeightLimitCheck(int maxWeight, List<Integer> passengerWeights) {
        if (passengerWeights.isEmpty()) {
            return "Error: Passenger list is empty, please enter a valid list.";
        }
        List<Integer> sortedPassengerWeights = new ArrayList<>(passengerWeights);
        sortedPassengerWeights.sort(null);
        StringBuilder sb = new StringBuilder("\nElevator Stretch Statistics");
        sb.append("\n-------------------------\n");

        int i = 0; // Passenger id
        int totalWeight = 0;
        int maxPassengerWeight = Integer.MIN_VALUE;
        int minPassengerWeight = Integer.MAX_VALUE;
        for (int passengerWeight : sortedPassengerWeights) {
            totalWeight += passengerWeight;
            if (passengerWeight > maxPassengerWeight) {
                maxPassengerWeight = passengerWeight;
            }
            if (passengerWeight < minPassengerWeight) {
                minPassengerWeight = passengerWeight;
            }
            if (totalWeight >= maxWeight) {
                break;
            }
            i += 1;
        }
        sb.append("Maximum number of passengers that can board at once: ");
        sb.append(i);
        sb.append("\nMinimum passenger weight: ");
        sb.append(minPassengerWeight);
        sb.append("\nMaximum passenger weight: ");
        sb.append(maxPassengerWeight);

        // Find number of elevator trips given firt-to-last boarding in the unsorted list
        int curPassengersInElevator = 0;
        int currentWeight = 0;
        int numTrips = 1;

        i = 1;
        List<Integer> passengersStartingInElevator = new ArrayList<Integer>();
        for (int passengerWeight: passengerWeights) {
            if (passengerWeight >= maxWeight) {
                return "Error: Passenger " + i + " exceeds max weight. Please ensure all entries are within the max weight.";
            }
            if ((passengerWeight + currentWeight) < maxWeight) {
                // Passenger can be added
                currentWeight += passengerWeight;
                curPassengersInElevator += 1;
            }
            else {
                // Passenger can't be added, start loading new elevator
                passengersStartingInElevator.add(i);
                curPassengersInElevator = 1;
                currentWeight = passengerWeight;
                numTrips += 1;
            }
            i += 1;
        }

        sb.append("\nTotal number of trips: ");
        sb.append(numTrips);
        for (int trip = 1; trip <= numTrips; trip++) {
            sb.append("\nTrip ");
            sb.append(trip);
            sb.append(": Passengers ");
            if (trip == 1) {
                sb.append("1 through ");
                if (passengersStartingInElevator.isEmpty()) {
                    sb.append(passengerWeights.size());
                    return sb.toString();
                }
                sb.append(passengersStartingInElevator.getFirst() - 1);
            }
            else {
                sb.append(passengersStartingInElevator.get(trip-2));
                sb.append(" through ");
                if (trip == numTrips) {
                    sb.append(passengerWeights.size());
                }
                else {
                    sb.append(passengersStartingInElevator.get(trip-1) - 1);
                }
            }
        }
        return sb.toString();
    }
}
