import java.util.Scanner;

public class SafePassengerCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the maximum weight of the elevator: ");
        int weightLimit = scanner.nextInt();
        System.out.println("Please enter the number of passengers: ");
        int numberOfPassenger = scanner.nextInt();

        int [] passengerWeights = new int[numberOfPassenger];

        for (int i=0; i<numberOfPassenger; i++){
            System.out.println("Enter Weight of Passenger " + (i+1) + " : ");
            passengerWeights[i] = scanner.nextInt();
        }
        // Call method
        int safeCount = maximumSafePassengers( weightLimit, passengerWeights);

        // Calculate total safe weight
        int totalWeight = 0;

        for (int i = 0; i < safeCount; i++) {
            totalWeight += passengerWeights[i];
        }

        System.out.println("\nMaximum safe passengers: " + safeCount);
        System.out.println("Total safe weight: " + totalWeight + " lbs.");

        if (safeCount < numberOfPassenger) {
            System.out.println("Passenger " + (safeCount + 1)
                    + " cannot board.");
        } else {
            System.out.println("All passengers can board safely.");
        }

        scanner.close();
    }

    public static int maximumSafePassengers( int weightLimit, int[] passengerWeights) {

        int totalWeight = 0;
        int count = 0;

        if (passengerWeights == null || passengerWeights.length == 0) {
            return 0;
        }

        for (int i = 0; i < passengerWeights.length; i++) {

            // Check before adding passenger
            if (totalWeight + passengerWeights[i] >= weightLimit) {
                break;
            }

            // Add passenger weight
            totalWeight += passengerWeights[i];

            // Count safe passenger
            count++;
        }

        return count;
    }
}
