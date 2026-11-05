


public class ElevatorWeightChecker {

    public void checkWeight(double weightlimit, double[] passengerWeights) {

        if (weightlimit < 0) {
            System.out.println("Invalid Input: Weight limit cannot be negative");
            return;
        }
        if (passengerWeights == null || passengerWeights.length == 0) {
            System.out.println("No passengers yet, please board the elevator.");
            return;
        }

        double totalWeight = 0;
        for (int i = 0; i < passengerWeights.length; i++) {
            int passengerNumber = i + 1;
            double weight = passengerWeights[i];
            if (weight < 0) {
                System.out.println("Invalid Input: Passenger weight cannot be negative");
                return;
            }
            totalWeight += weight;
            if (totalWeight >= weightlimit) {
                System.out.println("Passenger " + passengerNumber + " caused an overload. Total weight at that point: " + totalWeight + " lbs.");
                return;
            }

        }
        System.out.println("All passengers boarded safely. Total weight: " + totalWeight + " lbs.");

    }

    public void maximumSafePassengerCount(double weightlimit, double[] passengerWeights) {
        if (weightlimit < 0) {
            System.out.println("Invalid Input: Weight limit cannot be negative");
            return;
        }
        if (passengerWeights == null || passengerWeights.length == 0) {
            System.out.println("No passengers yet, please board the elevator.");
            return;
        }

        double totalWeight = 0;
        int safePassengerCount = 0;

        for (int i = 0; i < passengerWeights.length; i++) {
            double weight = passengerWeights[i];
            if (weight < 0) {
                System.out.println("Invalid Input: Passenger weight cannot be negative");
                return;
            }
            totalWeight += weight;
            if (totalWeight >= weightlimit) {
                break;
            }
            safePassengerCount++;
        }

        System.out.println("Maximum number of passengers that can safely board: " + safePassengerCount);
    }

    public static void main(String[] args) {
        ElevatorWeightChecker myElevator = new ElevatorWeightChecker();

        double[] passengerWeights1 = {150, 200, 180};
        myElevator.checkWeight(500, passengerWeights1);
        myElevator.maximumSafePassengerCount(500, passengerWeights1);

        double[] passengerWeights2 = {150, 200, 180, 100};
        myElevator.checkWeight(500, passengerWeights2);
        myElevator.maximumSafePassengerCount(500, passengerWeights2);

        double[] passengerWeights3 = {150, -200, 180};
        myElevator.checkWeight(500, passengerWeights3);
        myElevator.maximumSafePassengerCount(500, passengerWeights3);



        double[] passengerWeights4 = {};
        myElevator.checkWeight(500, passengerWeights4);
        myElevator.maximumSafePassengerCount(500, passengerWeights4);

        myElevator.checkWeight(-500, passengerWeights1);
        myElevator.maximumSafePassengerCount(500, passengerWeights1);

        double[] passengerWeights5 = {};
        myElevator.checkWeight(500, passengerWeights5);
        myElevator.maximumSafePassengerCount(500, passengerWeights1);
    }
}