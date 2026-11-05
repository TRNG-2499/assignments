package java_assignment_02;

public class Solution {
    public static void main(String[] args) {
        System.out.println(overload(2000, new double[]{150, 200, 300, 600, 250, 180, 15}));
    }

    public static String overload(double limit, double[] weights) {
        if (!Double.isFinite(limit) || limit < 0 || weights == null) {
            return "Invalid input";
        }

        double total = 0;
        double heaviest = 0;
        double lightest = 0;
        for (int i = 0; i < weights.length; i++) {
            double weight = weights[i];
            if (!Double.isFinite(weight) || weight < 0) {
                return "Invalid input";
            }

            if (i == 0) {
                heaviest = weight;
                lightest = weight;
            } else {
                heaviest = Math.max(heaviest, weight);
                lightest = Math.min(lightest, weight);
            }

            total += weight;
            if (total >= limit) {
                return "Passenger " + (i + 1) + " caused an overload. Total weight at that point: "
                        + total + " lbs. Heaviest passenger: " + heaviest
                        + " lbs. Lightest passenger: " + lightest + " lbs.";
            }
        }

        String result = "All passengers boarded safely. Total weight: " + total + " lbs.";
        if (weights.length == 0) {
            return result + " No passenger weights to compare.";
        }
        return result + " Heaviest passenger: " + heaviest
                + " lbs. Lightest passenger: " + lightest + " lbs.";
    }
}
