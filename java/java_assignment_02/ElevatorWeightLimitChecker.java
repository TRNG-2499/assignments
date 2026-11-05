import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Elevator Weight Limit Checker.
 *
 * Base method: checkWeight(weightLimit, passengerWeights)
 * Stretch goals: maxSafePassengerCount, checkWeightWithHeaviestAndLightest, planTrips
 */
public class ElevatorWeightLimitChecker {

    /**
     * Boards passengers in order and stops at the first one whose weight brings the
     * running total to or above the limit.
     */
    public static String checkWeight(int weightLimit, int[] passengerWeights) {
        if (passengerWeights == null || passengerWeights.length == 0) {
            return "No passengers to board. Total weight: 0 lbs.";
        }
        int total = 0;
        for (int i = 0; i < passengerWeights.length; i++) {
            total += passengerWeights[i];
            if (total >= weightLimit) {
                return "Passenger " + (i + 1) + " caused an overload. Total weight at that point: "
                        + total + " lbs.";
            }
        }
        return "All passengers boarded safely. Total weight: " + total + " lbs.";
    }

    /**
     * Stretch goal: the most passengers from the array that can ride together while the
     * total stays under the limit. Taking the lightest first gives the largest count.
     */
    public static String maxSafePassengerCount(int weightLimit, int[] passengerWeights) {
        if (passengerWeights == null || passengerWeights.length == 0) {
            return "Maximum safe passenger count: 0 (no passengers).";
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
        return "Maximum safe passenger count: " + count + " (total weight: " + total + " lbs).";
    }

    /**
     * Stretch goal: the base result plus the heaviest and lightest of the passengers who
     * boarded (up to and including the one who caused an overload).
     */
    public static String checkWeightWithHeaviestAndLightest(int weightLimit, int[] passengerWeights) {
        String result = checkWeight(weightLimit, passengerWeights);
        if (passengerWeights == null || passengerWeights.length == 0) {
            return result;
        }
        int total = 0;
        int heaviest = Integer.MIN_VALUE;
        int lightest = Integer.MAX_VALUE;
        for (int weight : passengerWeights) {
            total += weight;
            heaviest = Math.max(heaviest, weight);
            lightest = Math.min(lightest, weight);
            if (total >= weightLimit) {
                break;
            }
        }
        return result + " Heaviest: " + heaviest + " lbs. Lightest: " + lightest + " lbs.";
    }

    /**
     * Stretch goal: split passengers, in their original order, into consecutive trips
     * where no trip's total meets or exceeds the limit.
     */
    public static String planTrips(int weightLimit, int[] passengerWeights) {
        if (passengerWeights == null || passengerWeights.length == 0) {
            return "No passengers, so no trips are needed.";
        }
        List<List<Integer>> trips = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        int currentTotal = 0;

        for (int i = 0; i < passengerWeights.length; i++) {
            int weight = passengerWeights[i];
            if (weight >= weightLimit) {
                return "Passenger " + (i + 1) + " (" + weight
                        + " lbs) cannot ride alone without reaching the limit, so no trip plan works.";
            }
            if (currentTotal + weight >= weightLimit) {
                trips.add(current);
                current = new ArrayList<>();
                currentTotal = 0;
            }
            current.add(i + 1);
            currentTotal += weight;
        }
        trips.add(current);

        StringBuilder result = new StringBuilder("Trips required: " + trips.size());
        for (int t = 0; t < trips.size(); t++) {
            int tripTotal = 0;
            StringBuilder riders = new StringBuilder();
            for (int passenger : trips.get(t)) {
                if (riders.length() > 0) {
                    riders.append(", ");
                }
                riders.append("Passenger ").append(passenger);
                tripTotal += passengerWeights[passenger - 1];
            }
            result.append(String.format("%n  Trip %d: %s (%d lbs)", t + 1, riders, tripTotal));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("--- Base method ---");
        System.out.println(checkWeight(1000, new int[]{150, 200, 300, 250, 180})); // Passenger 5, 1080
        System.out.println(checkWeight(1000, new int[]{150, 200, 300}));           // safe, 650
        System.out.println(checkWeight(500, new int[]{200, 300}));                 // Passenger 2, 500
        System.out.println(checkWeight(100, new int[]{150, 200}));                 // Passenger 1, 150
        System.out.println(checkWeight(1000, new int[]{}));                        // empty

        int[] line = {150, 200, 300, 250, 180};
        System.out.println("\n--- Stretch: maximum safe passenger count ---");
        System.out.println(maxSafePassengerCount(1000, line));

        System.out.println("\n--- Stretch: heaviest and lightest ---");
        System.out.println(checkWeightWithHeaviestAndLightest(1000, line));

        System.out.println("\n--- Stretch: multiple trips ---");
        System.out.println(planTrips(1000, line));
    }
}
