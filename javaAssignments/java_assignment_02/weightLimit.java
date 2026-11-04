package javaAssignments.java_assignment_02;

public class weightLimit {
    
    public static void main(String[] args) {
        //TEST STATEMENTS
        /* 
        //under limit
        System.out.println(overloadCheck(new double[]{50.0, 50.0, 50.0}, 200.0));

        //over limit
        System.out.println(overloadCheck(new double[]{100.0, 20.0, 50.0, 100.0}, 200.0));

        //extreme values
        System.out.println(overloadCheck(new double[]{0.0, 100000.0, 0.0}, 200.0));

        //null entry
        System.out.println(overloadCheck(new double[]{}, 200.0));

        //exactly at limit
        System.out.println(overloadCheck(new double[]{100.0, 100.0}, 200.0));
        
        //within params maximum passengers
        System.out.println(maximumPassengers(new double[]{50.0, 50.0, 50.0}, 200.0));

        //empty passengers
        System.out.println(maximumPassengers(new double[]{}, 200.0));

        //over limit
        System.out.println(maximumPassengers(new double[]{100.0, 20.0, 50.0, 100.0}, 200.0));

        //extreme values
        System.out.println(maximumPassengers(new double[]{1.0, 100000.0, 1.0}, 200.0));
        
        //heaviest and lowest passenger
        System.out.println(heaviestAndLowest(new double[]{50.0, 50.0, 50.0}, 200.0));

        //heaviest and lowest passenger with extreme values
        System.out.println(heaviestAndLowest(new double[]{1.0, 100000.0, 1.0}, 200.0));

        //heaviest and lowest passenger with empty list
        System.out.println(heaviestAndLowest(new double[]{}, 200.0));

        //heaviest and lowest with reasonable vals
        System.out.println(heaviestAndLowest(new double[]{100.0, 50.0, 75.5, 45.6}, 2000.0));
        */

        //break into trips
        System.out.println(breakIntoTrips(new double[]{50.0, 50.0, 50.0, 50.0, 50.0, 50.0, 50.0}, 200.0));

        //break into trips with extreme values
        System.out.println(breakIntoTrips(new double[]{1.0, 100000.0, 1.0}, 200.0));

        //break into trips with empty list
        System.out.println(breakIntoTrips(new double[]{}, 200.0));

        //break into trips with one trip
        System.out.println(breakIntoTrips(new double[]{50.0}, 200.0));
    }

    //checking for overload
    public static String overloadCheck(double[] weights, double limit) {
        //checking for empty passengers
        if (weights.length == 0){
            return "No passengers to check.";
        }

        //calculating total weight and checking for overload
        double totalWeight = 0.0;

        //using a for loop to iterate through each passenger's weight and add it to the total weight
        for (int i = 0; i < weights.length; i++) {
            double weight = weights[i];

            //increases total weight
            totalWeight += weight; 

            //checking for overload
            if (totalWeight >= limit) {
                //Added a + 1 because humans don't think in terms of 0-indexing
                return "Overloaded. Overloaded at passenger " + (i + 1);
            }
        }
        return "Within limit, all passengers boarded safely. Total weight: " + totalWeight + ", Limit: " + limit;
    }

    public static String maximumPassengers(double[] weights, double limit){

        //checking for empty passengers
        if (weights.length == 0){
            return "No passengers to check.";
        }

        //calculating total weight and checking for overload
        double totalWeight = 0.0;
        
        //new goal is to optimize how many of the total passengers could go onto the elevator, so we will iterate through the list 
        //after we sort it from low to high
        java.util.Arrays.sort(weights);
        int maxPassengers = 0;
        for (int i = 0; i < weights.length; i++) {
            double weight = weights[i];

            //increases total weight
            totalWeight += weight; 

            //checking for overload
            if (totalWeight >= limit) {
                totalWeight -= weight; //subtract the weight that caused the overload
                break;
            }
            maxPassengers++;
        }
        return "Maximum passengers that can board within the limit: " + maxPassengers + ". Total weight: " + totalWeight;
    }

    public static String heaviestAndLowest(double[] weights, double limit) {
        //check for empty passenges
        if (weights.length == 0){
            return "No passengers to check.";
        }

        //adding a double weight value for tracking
        double totalWeight = 0.0;

        //sorting the weights from low to high
        java.util.Arrays.sort(weights);

        //we now want the smallest passenger and the largest passenger for a given trip
        for (int i = 0; i < weights.length; i++) {
            double weight = weights[i];
            totalWeight += weight;

            if (totalWeight >= limit) {
                return "Overloaded. Overloaded at passenger " + (i + 1) + ". Smallest Passenger: " + weights[0] + ", Heaviest Passenger: " + weights[weights.length - 1];
            }
        }
        //default case when all passengers can board safely
        return "All passengers boarded safely. Total weight: " + totalWeight + ". Smallest Passenger: " + weights[0] + ", Heaviest Passenger: " + weights[weights.length - 1];
    }

    public static String breakIntoTrips(double[] weights, double limit) {
        //check for empty passengers
        if (weights.length == 0){
            return "No passengers to check.";
        }

        //check for any passengers who individually exceed limit
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > limit) {
                return "Passenger " + (i + 1) + " exceeds the limit individually.";
            }
        }

        //now we will break the passengers into trips
        //per the problem criteria the passengers cannot be sorted
        int trips = 1;
        double tripWeight = 0.0;
        for (int i = 0; i < weights.length; i++) {
            double weight = weights[i];
            if (tripWeight + weight > limit) {
                trips++;
                tripWeight = weight;
            } else {
                tripWeight += weight;
            }
        }
        return "Passengers can be divided into " + trips + " trips while preserving their order.";
    }
}
