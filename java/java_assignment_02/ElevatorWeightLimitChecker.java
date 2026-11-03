public class ElevatorWeightLimitChecker {

    // This method takes the elevator's weight limit and the weights of
    // the passengers in line. It returns a message about what happened.
    public static String checkWeightLimit(int weightLimit, int[] passengerWeights) {
        // The elevator starts empty, so the total starts at zero.
        // A long can hold a bigger total than an int.
        long totalWeight = 0;

        // Start at index 0, the first spot in the array.
        // Move forward one spot each time to check passengers in order.
        for (int i = 0; i < passengerWeights.length; i++) {
            // Add this passenger's weight to the total so far.
            totalWeight += passengerWeights[i];

            // Check after adding the weight so the total includes this passenger.
            // The >= means hitting the limit exactly also counts as overload.
            if (totalWeight >= weightLimit) {
                // Array spots start at 0, but passenger numbers start at 1.
                int passengerNumber = i + 1;

                // Returning here ends the whole method, so nobody else is checked.
                return "Passenger " + passengerNumber
                        + " caused an overload. Total weight at that point: "
                        + totalWeight + " lbs.";
            }
        }

        // If we get here, nobody triggered an overload.
        // An empty array skips the loop, so the total stays at 0 lbs.
        return "All passengers boarded safely. Total weight: " + totalWeight + " lbs.";
    }

    public static void main(String[] args) {
        // Run the method with different inputs and print each result.

        // Passenger 5 brings the total above the limit.
        System.out.println(checkWeightLimit(1000, new int[]{150, 200, 300, 250, 180}));

        // Everyone boards safely.
        System.out.println(checkWeightLimit(1000, new int[]{150, 200, 300}));

        // Passenger 2 brings the total to exactly 500 lbs.
        System.out.println(checkWeightLimit(500, new int[]{200, 300}));

        // Passenger 1 is already over the limit, so passenger 2 is never checked.
        System.out.println(checkWeightLimit(100, new int[]{150, 200}));

        // No passengers board, so the total is 0 lbs.
        System.out.println(checkWeightLimit(1000, new int[]{}));
    }
}