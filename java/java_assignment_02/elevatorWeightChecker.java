import java.util.Arrays;

public class elevatorWeightChecker {
    
    public static String checkWeight(int weightLimit, int[] passengerWeights) {
        if (weightLimit < 0) {
            return "Invalid input: weight limit cannot be negative.";
        }

        if (passengerWeights == null || passengerWeights.length == 0) {
            return "No passengers to check.";
        }

        int totalWeight = 0;

        for (int i = 0; i < passengerWeights.length; i++) {

            int weight = passengerWeights[i];

            if (weight < 0) {
                return "Invalid input: passenger weight cannot be negative.";
            }

            totalWeight += weight;

            if (totalWeight >= weightLimit) {
                return "Passenger " + (i + 1) + " caused an overload. Total weight at that point: " + totalWeight + " lbs.";
            }
        }

        return "All passengers boarded safely. Total weight: " + totalWeight + " lbs.";
    }


    public static String MaxSafePassengers(int weightLimit, int[] passengerWeights) {
        if (weightLimit < 0) {
            return "Invalid input: weight limit cannot be negative.";
        }

        if (passengerWeights == null || passengerWeights.length == 0) {
            return "No passengers to check.";
        }

        int totalWeight = 0;
        int maxPassengers = 0;
        
        int[] sortedPassengerWeights = Arrays.copyOf(passengerWeights, passengerWeights.length);
        Arrays.sort(sortedPassengerWeights);

        for (int i = 0; i < sortedPassengerWeights.length; i++) {

            int weight = sortedPassengerWeights[i];

            if (weight < 0) {
                return "Invalid input: passenger weight cannot be negative.";
            }

            totalWeight += weight;

            if (totalWeight >= weightLimit) {
                return "Maximum safe passengers: " + maxPassengers + ". Total weight before overload: " + (totalWeight - weight) + " lbs.";
            }

            maxPassengers++;
        }

        return "All passengers boarded safely. Maximum safe passengers: " + maxPassengers + ". Total weight: " + totalWeight + " lbs.";
    }

    public static String bodyShaming(int weightLimit, int[] passengerWeights) {
        if (weightLimit < 0) {
            return "Invalid input: weight limit cannot be negative.";
        }

        if (passengerWeights == null || passengerWeights.length == 0) {
            return "No passengers to check.";
        }

        int totalWeight = 0;
        int lightestWeight = -1;
        int heaviestWeight = -1;
        

        for (int i = 0; i < passengerWeights.length; i++) {

            int weight = passengerWeights[i];

            if (weight < 0) {
                return "Invalid input: passenger weight cannot be negative.";
            }

            totalWeight += weight;

            if (lightestWeight == -1 || weight < lightestWeight) {
                lightestWeight = weight;
            }

            if (heaviestWeight == -1 || weight > heaviestWeight) {
                heaviestWeight = weight;
            }

            if (totalWeight >= weightLimit) {
                return "Passenger " + (i + 1) + " caused an overload. Total weight at that point: " + totalWeight + " lbs. \n Lightest passenger weight: " + lightestWeight + " lbs. Heaviest passenger weight: " + heaviestWeight + " lbs.";
            }
        }

        return "All passengers boarded safely. Total weight: " + totalWeight + " lbs. \n Lightest passenger weight: " + lightestWeight + " lbs. Heaviest passenger weight: " + heaviestWeight + " lbs.";
    }

    public static String multipleTrips(int weightLimit, int[] passengerWeights) {
        if (weightLimit < 0) {
            return "Invalid input: weight limit cannot be negative.";
        }

        if (passengerWeights == null || passengerWeights.length == 0) {
            return "No passengers to check.";
        }

        int totalWeight = 0;
        int trips = 0;
        String result = "";
        String currentTrip = "";
        String cannotRide = "";

        for (int i = 0; i < passengerWeights.length; i++) {

            int weight = passengerWeights[i];

            if (weight < 0) {
                return "Invalid input: passenger weight cannot be negative.";
            }

            if (weight >= weightLimit) {
                cannotRide += "Passenger " + (i + 1) + " cannot ride because their weight meets or exceeds the elevator limit.\n";
                continue;
            }

            if (totalWeight == 0) {
                trips++;
                currentTrip = "Trip " + trips + ": ";
            }


            if (totalWeight + weight >= weightLimit) {
                result += currentTrip + "Total weight: " + totalWeight + " lbs.\n";
                trips++;
                totalWeight = 0;
                currentTrip = "Trip " + trips + ": ";
            }
             
            totalWeight += weight;

            currentTrip += "Passenger " + (i + 1) + " (" + weight + " lbs)";
            
            if (i < passengerWeights.length - 1) currentTrip += ", ";
        }

        if (totalWeight > 0) {
            result += currentTrip
                + "Total weight: " + totalWeight + " lbs.\n";
        }


        return "Total trips needed: " + trips + ".\n" + result + cannotRide;
    }

    public static void main(String[] args) {
        System.out.println(checkWeight(1000, new int[]{150, 200, 300, 250, 180})); 
        System.out.println(checkWeight(1000, new int[]{150, 200, 300})); 
        System.out.println(checkWeight(500, new int[]{200, 300})); 
        System.out.println(checkWeight(100, new int[]{150, 200}));

        System.out.println("\nMaximum Safe Passengers: ");
        System.out.println(MaxSafePassengers(1000, new int[]{150, 200, 300, 250, 180}));
        System.out.println(MaxSafePassengers(1000, new int[]{150, 200, 300}));
        System.out.println(MaxSafePassengers(500, new int[]{200, 300}));
        System.out.println(MaxSafePassengers(100, new int[]{150, 200}));
        
        System.out.println("\nBody Shaming: ");
        System.out.println(bodyShaming(1000, new int[]{150, 200, 300, 250, 180}));
        System.out.println(bodyShaming(1000, new int[]{150, 200, 300}));
        System.out.println(bodyShaming(500, new int[]{200, 300}));          
        System.out.println(bodyShaming(100, new int[]{150, 200}));      

        System.out.println("\nMultiple Trips: ");
        System.out.println(multipleTrips(1000, new int[]{150, 200, 300, 250, 180}));
        System.out.println(multipleTrips(1000, new int[]{150, 200, 300}));
        System.out.println(multipleTrips(500, new int[]{200, 300}));
        System.out.println(multipleTrips(100, new int[]{150, 200}));
    }
}