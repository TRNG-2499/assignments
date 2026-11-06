import java.util.Scanner;

public class HeaviestLightestPassengers {
    // Stretch Goal 2 method
    public static String findHeaviestAndLightest(
            int weightLimit, int[] passengerWeights) {

        if (passengerWeights == null || passengerWeights.length == 0) {
            return "No passenger weights available.";
        }

        int totalWeight = 0;

        // Start with first passenger
        int heaviest = passengerWeights[0];
        int lightest = passengerWeights[0];

        for (int i = 0; i < passengerWeights.length; i++) {

            // Add current passenger weight
            totalWeight += passengerWeights[i];

            // Find heaviest
            if (passengerWeights[i] > heaviest) {
                heaviest = passengerWeights[i];
            }

            // Find lightest
            if (passengerWeights[i] < lightest) {
                lightest = passengerWeights[i];
            }

            // Stop after including overload passenger
            if (totalWeight >= weightLimit) {
                break;
            }
        }

        return "Heaviest passenger weight: " + heaviest + " lbs."
                + "\nLightest passenger weight: " + lightest + " lbs.";
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
        String result = findHeaviestAndLightest(
                weightLimit, passengerWeights);

        System.out.println("\n" + result);

        scanner.close();
    }
}
