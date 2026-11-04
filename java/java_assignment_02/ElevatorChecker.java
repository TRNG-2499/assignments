import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ElevatorChecker {

    public static void main(String[] args) {
        System.out.println("Elevator Weight Limit Checker");

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter weight limit: ");
            int limit = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter passenger weights: ");
            int[] weights = parseWeights(scanner.nextLine());

            System.out.println();
            System.out.println(checkElevator(limit, weights));
            System.out.println(heaviestAndLightest(limit, weights));
            System.out.println(maxSafePassengers(limit, weights));
            System.out.println(planTrips(limit, weights));

        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }
    }

    private static int[] parseWeights(String line) {
        String inner = line.replace("[", "").replace("]", "").trim();
        if (inner.isEmpty()) {
            return new int[0];
        }
        String[] parts = inner.split("\\s*,\\s*");
        int[] weights = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            weights[i] = Integer.parseInt(parts[i]);
        }
        return weights;
    }

    // Base requirement
    public static String checkElevator(int limit, int[] weights) {
        int total = 0;
        for (int i = 0; i < weights.length; i++) {
            total += weights[i];
            if (total >= limit) {
                return String.format("Passenger %d caused an overload. Total weight at that point: %d lbs.",i + 1, total);
            }
        }
        return String.format("All passengers boarded safely. Total weight: %d lbs.", total);
    }

    // Stretch goal 1: most passengers that can fit
    public static String maxSafePassengers(int limit, int[] weights) {
        int[] sorted = weights.clone();
        Arrays.sort(sorted);

        int total = 0, count = 0;
        for (int w : sorted) {
            if (total + w >= limit) break;
            total += w;
            count++;
        }
        return String.format("Maximum safe passengers: %d (total weight: %d lbs).", count, total);
    }

    // Stretch goal 2: heaviest and lightest
    public static String heaviestAndLightest(int limit, int[] weights) {
        if (weights.length == 0) {
            return "No passengers, so there is no heaviest or lightest weight.";
        }
        int total = 0, heaviest = Integer.MIN_VALUE, lightest = Integer.MAX_VALUE;
        for (int w : weights) {
            total += w;
            heaviest = Math.max(heaviest, w);
            lightest = Math.min(lightest, w);
            if (total >= limit) break;
        }
        return String.format("Heaviest passenger: %d lbs. Lightest passenger: %d lbs.",heaviest, lightest);
    }

    // Stretch goal 3: consecutive trips
    public static String planTrips(int limit, int[] weights) {
        if (weights.length == 0) {
            return "No passengers, so no trips are needed.";
        }
        List<String> trips = new ArrayList<>();
        StringBuilder riders = new StringBuilder();
        int total = 0;

        for (int i = 0; i < weights.length; i++) {
            if (weights[i] >= limit) {
                return "Passenger " + (i + 1) + " alone meets or exceeds the limit and cannot ride.";
            }
            if (total + weights[i] >= limit) {
                trips.add(riders + " (" + total + " lbs)");
                riders.setLength(0);
                total = 0;
            }
            riders.append(riders.length() == 0 ? "Passengers " : ", ").append(i + 1);
            total += weights[i];
        }
        trips.add(riders + " (" + total + " lbs)");

        StringBuilder result = new StringBuilder("Trips required: " + trips.size());
        for (int t = 0; t < trips.size(); t++) {
            result.append("\n  Trip ").append(t + 1).append(": ").append(trips.get(t));
        }
        return result.toString();
    }
}