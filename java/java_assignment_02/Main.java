public class Main {
    public static void main(String[] args) {
        ElevatorLimit test = new ElevatorLimit();

        System.out.println(test.checkLimit(1000, new int[]{150, 200, 300, 250, 180}));
        System.out.println(test.checkLimit(1000, new int[]{150, 200, 300}));
        System.out.println(test.checkLimit(500, new int[]{200, 300}));
        System.out.println(test.checkLimit(100, new int[]{150, 200}));

        System.out.println(test.checkCapacity(1000, new int[]{150, 200, 300, 250, 180}));
        System.out.println(test.checkCapacity(1000, new int[]{150, 200, 300}));
        System.out.println(test.checkCapacity(500, new int[]{200, 300}));
        System.out.println(test.checkCapacity(100, new int[]{150, 200}));

        System.out.println(test.getHeaviestLightest(1000, new int[]{150, 200, 300, 250, 180}));
        System.out.println(test.getHeaviestLightest(1000, new int[]{150, 200, 300}));
        System.out.println(test.getHeaviestLightest(500, new int[]{200, 300}));
        System.out.println(test.getHeaviestLightest(100, new int[]{150, 200}));

        System.out.println(test.getTripsRequired(1000, new int[]{150, 200, 300, 250, 180}));
        System.out.println(test.getTripsRequired(1000, new int[]{150, 200, 300}));
        System.out.println(test.getTripsRequired(500, new int[]{200, 300}));
        System.out.println(test.getTripsRequired(100, new int[]{150, 200}));
    }
}

class ElevatorLimit{
    public ElevatorLimit() {}

    /**
     * Checks to see if boarding passengers will make the elevator go over the weight limit.
     * @param maxWeight The max weight the elevator can hold.
     * @param passengerWeights The list of weight of passengers boarding the elevator.
     * @return A message indicating whether the elevator is overloaded or not. If it is overloaded, include the total weight at the time of overloading and passenger who overloaded.
     */
    public String checkLimit(int maxWeight, int[] passengerWeights) {
        int totalWeight = 0;
        for (int i = 0; i < passengerWeights.length; i++) {
            totalWeight += passengerWeights[i];
            if (totalWeight >= maxWeight) {
                return String.format("Passenger %d caused an overload. Total weight at that point: %d lbs.", i + 1, totalWeight);
            }
        }

        return String.format("All passengers boarded safely. Total weight: %d lbs.", totalWeight);
    }

    /**
     * Checks to see how many passengers can board without overloading the elevator.
     * @param maxWeight The max weight the elevator can hold.
     * @param passengerWeights The list of weight of passengers boarding the elevator.
     * @return The number of passenger that can board the elevator.
     */
    public int checkCapacity(int maxWeight, int[] passengerWeights) {
        int totalWeight = 0;
        int count = 0;
        for (int i = 0; i < passengerWeights.length; i++) {
            totalWeight += passengerWeights[i];
            if (totalWeight >= maxWeight) {
                return count;
            }
            count++;
        }

        return count;
    }

    /**
     * Checks to see the heaviest and lightest passengers that can board the elevator.
     * @param maxWeight The max weight the elevator can hold.
     * @param passengerWeights The list of weight of passengers boarding the elevator.
     * @return A message indicating the heaviest and lightest passengers that can board.
     */
    public String getHeaviestLightest(int maxWeight, int[] passengerWeights) {
        int totalWeight = 0;
        int heaviest = Integer.MIN_VALUE;
        int lightest = Integer.MAX_VALUE;
        for (int i = 0; i < passengerWeights.length; i++) {
            totalWeight += passengerWeights[i];
            if (totalWeight >= maxWeight) {
                return String.format("Heaviest passenger: %d lbs. Lightest passenger: %d lbs.", heaviest, lightest);
            }
            heaviest = Math.max(heaviest, passengerWeights[i]);
            lightest = Math.min(lightest, passengerWeights[i]);
        }

        return String.format("Heaviest passenger: %d lbs. Lightest passenger: %d lbs.", heaviest, lightest);
    }

    /**
     * Checks to see how many trips is required for all passengers to ride the elevator.
     * @param maxWeight The max weight the elevator can hold.
     * @param passengerWeights The list of weight of passengers boarding the elevator.
     * @return The number of trips required. Returns -1 if it is not ever possible (e.g. when a single person overloads the elevator).
     */
    public int getTripsRequired(int maxWeight, int[] passengerWeights) {
        int trips = 0;
        int totalWeight = 0;

        for (int i = 0; i < passengerWeights.length; i++) {
            if (totalWeight + passengerWeights[i] <= maxWeight) {
                totalWeight += passengerWeights[i];
            } else {
                if (passengerWeights[i] >= maxWeight) {
                    return -1;
                }
                trips++;
                totalWeight = passengerWeights[i];
            }
        }

        if (totalWeight > 0) {
            trips++;
        }

        return trips;
    }
}