import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.ArrayList;

public class Elevator {

    public static void checkWeightLimit(double maxWeight, double[] passengerWeights) {
        double totalWeight = 0;

        for (int i = 0; i < passengerWeights.length; i++) {
            totalWeight += passengerWeights[i];
            if (totalWeight >= maxWeight) {
                System.out.println("Passenger " + (i + 1) + " had caused a weight overload!");
                System.out.println("Current total weight: " + totalWeight + " lbs");
                return;
            }
        }

        // If it reaches here, the for loop definitely finished gracefully so
        // we know all passengers have boarded
        System.out.println("All passengers boarded safely");
        System.out.println("Final weight: " + totalWeight + " lbs");
    }


    public static void maxSafePassengerCount(double maxWeight, double[] passengerWeights) {
        double[] sortedWeights = Arrays.copyOf(passengerWeights, passengerWeights.length);
        Arrays.sort(sortedWeights);

        double totalWeight = 0;
        int count = 0;

        for (int i = 0; i < sortedWeights.length; i++) {
            if (totalWeight + sortedWeights[i] >= maxWeight) {
                break;
            }
            totalWeight += sortedWeights[i];
            count += 1;
        }

        System.out.println("Max safe passenger count: " + count);
    }


    public static void getHeaviestAndLightest(double maxWeight, double[] passengerWeights) {
        double totalWeight = 0;

        for (int i = 0; i < passengerWeights.length; i++) {
            totalWeight += passengerWeights[i];
            if (totalWeight >= maxWeight) {
                double[] subArray = Arrays.copyOfRange(passengerWeights, 0, i + 1);

                // index 0 represents weight of passenger
                // index 1 represents passenger number
                double[] lightest = new double[] {0.0, 1};
                double[] heaviest = new double[] {0.0, 1};
                for (int j = 0; j < subArray.length; j++) {
                    if (j == 0) {
                        lightest[0] = subArray[j];
                        lightest[1] = j+1;
                        heaviest[0] = subArray[j];
                        heaviest[1] = j+1;
                        continue;
                    }
                    
                    if (subArray[j] < lightest[0]) {
                        lightest[0] = subArray[j];
                        lightest[1] = j+1;
                    }
                    if (subArray[j] > heaviest[0]) {
                        heaviest[0] = subArray[j];
                        heaviest[1] = j+1;
                    }
                }
                int lightestPassNumber = (int)lightest[1];
                int heaviestPassNumber = (int)heaviest[1];
                System.out.println("Passenger " + lightestPassNumber + " is the lightest, weighing: " + lightest[0]);
                System.out.println("Passenger " + heaviestPassNumber + " is the heaviest, weighing: " + heaviest[0]);

                return;
            }
        }

        double[] lightest = new double[] {0.0, 1};
        double[] heaviest = new double[] {0.0, 1};
        for (int j = 0; j < passengerWeights.length; j++) {
            if (j == 0) {
                lightest[0] = passengerWeights[j];
                lightest[1] = j+1;
                heaviest[0] = passengerWeights[j];
                heaviest[1] = j+1;
                continue;
            }
            
            if (passengerWeights[j] < lightest[0]) {
                lightest[0] = passengerWeights[j];
                lightest[1] = j+1;
            }
            if (passengerWeights[j] > heaviest[0]) {
                heaviest[0] = passengerWeights[j];
                heaviest[1] = j+1;
            }
        }

        int lightestPassNumber = (int)lightest[1];
        int heaviestPassNumber = (int)heaviest[1];
        System.out.println("Passenger " + lightestPassNumber + " is the lightest, weighing: " + lightest[0]);
        System.out.println("Passenger " + heaviestPassNumber + " is the heaviest, weighing: " + heaviest[0]);
    }


    public static void multipleElevatorTrips(double maxWeight, double[] passengerWeights) {
        // Hashmap mapping: trip number -> array list of passenger numbers
        LinkedHashMap<Integer, ArrayList<Integer>> trips = new LinkedHashMap<Integer, ArrayList<Integer>>();

        double currWeight = 0.0;    // running weight on the current trip
        ArrayList<Integer> currTrip = new ArrayList<Integer>();     // list of passengers on the current trip
        int tripNumber = 1;

        for (int i = 0; i < passengerWeights.length; i++) {
            // Handles case where one passenger alone exceeds the elevator weight limit
            if (passengerWeights[i] >= maxWeight) {
                System.out.println("This passenger alone exceeds max elevator weight. Cannot board on any trip.");
                continue;
            }

            // If next passenger were to exceed the weight, snapshot the current
            // trip and its list of passengers into a key-value pair inside trips
            //
            // Then start initializing the next trip with the current passenger that
            // caused the weight overflow
            if (currWeight + passengerWeights[i] >= maxWeight) {
                trips.put(tripNumber, currTrip);
                tripNumber += 1;

                currWeight = passengerWeights[i];
                currTrip = new ArrayList<Integer>();
                currTrip.add(i + 1);
                continue;
            }

            currWeight += passengerWeights[i];
            currTrip.add(i + 1);
        }

        if (currTrip.size() != 0) {
            trips.put(tripNumber, currTrip);
        }

        System.out.printf("Number of trips required: %d %n", trips.size());
        for (var entry : trips.entrySet()) {
            System.out.printf("Trip %d has the following passengers: %s %n", entry.getKey(), entry.getValue());
        }
    }


    public static void main(String[] args) {
        // Base features test cases
        //
        // checkWeightLimit(1000, new double[] {150, 200, 300, 250, 180});
        // System.out.println('\n');
        // checkWeightLimit(1000, new double[] {150, 200, 300});
        // System.out.println('\n');
        // checkWeightLimit(500, new double[] {200, 300});
        // System.out.println('\n');
        // checkWeightLimit(100, new double[] {150, 200});
        
        // Stretch goal test cases
        maxSafePassengerCount(100, new double[] {30, 40, 32});
        System.out.println('\n');
        getHeaviestAndLightest(1000, new double[] {150, 200, 300, 250, 180});
        System.out.println('\n');
        multipleElevatorTrips(100, new double[] {50, 30, 40, 60, 70, 20});
    }
}
