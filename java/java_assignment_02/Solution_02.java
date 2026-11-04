public class Solution_02 {

    public static void main(String[] args) {
        // Testing Rq. 
        System.out.println("--- Standard Requirements ---");

        System.out.println("Example 1: " + Check_Elevator_Weight(1000, new double[]{150, 200, 300, 250, 180}));

        System.out.println("Example 2: " + Check_Elevator_Weight(1000, new double[]{150, 200, 300}));

        System.out.println("Example 3: " + Check_Elevator_Weight(500, new double[]{200, 300}));

        System.out.println("Example 4: " + Check_Elevator_Weight(100, new double[]{150, 200}));

        // Edge Case: Empty list
        System.out.println("Empty List: " + Check_Elevator_Weight(1000, new double[]{}));

        // Stretch Goals Tests
        System.out.println("\n--- Stretch Goals ---");
        double limit = 1000;
        double[] weights = {150, 200, 300, 250, 180};

        // Stretch Goal 1
         System.out.println("Stretch 1 (Max Safe): " + get_Max_Safe_Passengers(limit, weights));

         // Stretch Goal 2
         System.out.println("Stretch 2 (Heaviest/Lightest): " + get_Heaviest_And_Lightest(limit, weights));

         // Stretch Goal 3
         System.out.println("Stretch 3 (Multiple Trips):\n" + get_Multiple_Elevator_Trips(limit, weights));
    }

    // Req method for assigment 
    public  static  String Check_Elevator_Weight(double weightLimit, double[] passengerWeights) {
        double currentTotal = 0;

        for (int i = 0; i < passengerWeights.length; i++) {
            currentTotal += passengerWeights[i];

            if (currentTotal >= weightLimit) {

                return "Passenger" + (i + 1) + " caused an overload. Total weight at that point: " + currentTotal + " lbs.";

            }
        }
        return  "All passengers boarded safely. Total weight: " + currentTotal + " lbs.";
    }

    // Stretch Goal 1 
    public static  String get_Max_Safe_Passengers(double weightLimit, double[] passengerWeights) {
        int count = 0;
        double runningTotal = 0;

        for (double weight : passengerWeights) {
            if (runningTotal + weight < weightLimit) {
                runningTotal += weight;
                count++;
            }
            else {
                break;
            }
        }
        return "Maximum safe passengers: " + count;
    }

    // Stretch Goal 2
    public static String get_Heaviest_And_Lightest(double weightLimit, double[] passengerWeights) {
        if (passengerWeights.length == 0) {
            return "No passengers to evaluate.";
        }

        double max = -Double.MAX_VALUE;
        double min = Double.MAX_VALUE;
        double currentTotal = 0;

        for (double weight : passengerWeights) {
            if (currentTotal + weight >= weightLimit) {

                if (weight > max) max = weight;
                if (weight < min) min = weight;
                break;
            }

            currentTotal += weight;
            if (weight > max) max = weight;
            if (weight < min) min = weight;
        }

        return  "Heaviest: " + max + " lbs, Lightest: " + min + " lbs.";
    }

    // Stretch Goal 3
    public static String get_Multiple_Elevator_Trips(double weightLimit, double[] passengerWeights) {
        java.util.List<java.util.List<Double>> trips = new java.util.ArrayList<>();
        java.util.List<Double> currentTrip = new java.util.ArrayList<>();
        double currentTripWeight = 0;

        for (double weight : passengerWeights) {
            if (currentTripWeight + weight >= weightLimit && !currentTrip.isEmpty()) {
                trips.add(new java.util.ArrayList<>(currentTrip));
                currentTrip.clear();
                currentTripWeight = 0;
            }
            currentTrip.add(weight);
            currentTripWeight += weight;
        }

        if (!currentTrip.isEmpty()) {
            trips.add(currentTrip);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Total trips required: ").append(trips.size()).append("\n");
        for (int i = 0; i < trips.size(); i++) {
            sb.append("Trip ").append(i + 1).append(": ").append(trips.get(i)).append("\n");
        }
        return sb.toString();
    }
    
}


