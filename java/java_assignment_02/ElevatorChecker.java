import java.util.Arrays;

public class ElevatorChecker {

    // ---------- Base activity ----------
    public static String checkWeightLimit(int weightLimit, int[] passengerWeights) {
        if (passengerWeights == null || passengerWeights.length == 0) {
            return "No passengers to board. Total weight: 0 lbs.";
        }

        int total = 0;
        for (int i = 0; i < passengerWeights.length; i++) {
            total += passengerWeights[i];
            if (total >= weightLimit) {
                return "Passenger " + (i + 1) + " caused an overload. "
                        + "Total weight at that point: " + total + " lbs.";
            }
        }
        return "All passengers boarded safely. Total weight: " + total + " lbs.";
    }

    // ---------- Stretch 1: maximum safe passenger count ----------
    // Takes the lightest passengers first to fit as many as possible.
    public static String maxSafePassengerCount(int weightLimit, int[] passengerWeights) {
        if (passengerWeights == null || passengerWeights.length == 0) {
            return "No passengers provided. Maximum safe passenger count: 0.";
        }

        int[] sorted = passengerWeights.clone();
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
        return "Maximum safe passenger count: " + count + " of " + passengerWeights.length
                + " (total weight: " + total + " lbs).";
    }

    // ---------- Stretch 2: heaviest and lightest passengers ----------
    public static String checkWithHeaviestAndLightest(int weightLimit, int[] passengerWeights) {
        if (passengerWeights == null || passengerWeights.length == 0) {
            return "No passengers to board. Total weight: 0 lbs. No heaviest or lightest passenger.";
        }

        int total = 0;
        int heaviest = passengerWeights[0];
        int lightest = passengerWeights[0];

        for (int weight : passengerWeights) {
            total += weight;
            heaviest = Math.max(heaviest, weight);
            lightest = Math.min(lightest, weight);

            if (total >= weightLimit) {
                break; // stop after the passenger who caused the overload
            }
        }

        // Reuse the original method for the overload / safe message
        return checkWeightLimit(weightLimit, passengerWeights)
                + " Heaviest: " + heaviest + " lbs. Lightest: " + lightest + " lbs.";
    }

    // ---------- Stretch 3: multiple elevator trips ----------
    public static String planTrips(int weightLimit, int[] passengerWeights) {
        if (passengerWeights == null || passengerWeights.length == 0) {
            return "No passengers. 0 trips required.";
        }

        int tripCount = 1;
        int tripTotal = 0;
        String details = "  Trip 1 passengers:";

        for (int i = 0; i < passengerWeights.length; i++) {
            int weight = passengerWeights[i];

            if (weight >= weightLimit) {
                return "Cannot plan trips: Passenger " + (i + 1) + " (" + weight
                        + " lbs) alone meets or exceeds the limit of " + weightLimit + " lbs.";
            }

            // Adding this passenger would overload the current trip, so start a new one
            if (tripTotal + weight >= weightLimit) {
                tripCount++;
                tripTotal = 0;
                details += "\n  Trip " + tripCount + " passengers:";
            }

            details += " " + (i + 1);
            tripTotal += weight;
        }

        return "Trips required: " + tripCount + "\n" + details;
    }

    public static void main(String[] args) {
        // Base activity: examples from the assignment
        System.out.println(checkWeightLimit(1000, new int[] { 150, 200, 300, 250, 180 }));
        System.out.println(checkWeightLimit(1000, new int[] { 150, 200, 300 }));
        System.out.println(checkWeightLimit(500, new int[] { 200, 300 }));
        System.out.println(checkWeightLimit(100, new int[] { 150, 200 }));
        System.out.println(checkWeightLimit(1000, new int[] {}));

        // Stretch goals
        int[] line = { 150, 200, 300, 250, 180 };
        System.out.println(maxSafePassengerCount(1000, line));
        System.out.println(checkWithHeaviestAndLightest(1000, line));
        System.out.println(planTrips(1000, line));
    }
}