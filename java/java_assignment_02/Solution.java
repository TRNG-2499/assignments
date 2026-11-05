public class Solution {
    public static String solutionAnswer(double limit, double[] passweights) {
        // Implementation for the solution
        double total = 0;

        for (int i = 0; i < passweights.length; i++) {
            total += passweights[i];
            if (total >= limit) {
                return "Passenger " + (i + 1) + " caused an overload. Total weight is: " + total;
            }
        }
        return "All weights are within the limit. Total: " + total;
    }
}
