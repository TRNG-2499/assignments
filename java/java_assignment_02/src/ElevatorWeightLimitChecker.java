public class ElevatorWeightLimitChecker {
    public static void main(String[] args) {
        elevatorBoardingSimulator(1000, 150, 110, 300, 210, 170, 150, 120);
        elevatorBoardingSimulator(1200, 150, 110, 300, 210, 170, 150, 120);
    }

    private static void elevatorBoardingSimulator(int weightLimit, int... passengerWeights) {
        int currentWeight = 0;
        int passengersLeft = passengerWeights.length;
        int maxPassengers = passengersLeft;
        int lastPassengerOnboard = 0;

        System.out.println("Passengers begin boarding...");
        while (passengersLeft > 0 && currentWeight < weightLimit) {
            lastPassengerOnboard = maxPassengers - passengersLeft;
            currentWeight += passengerWeights[lastPassengerOnboard];

            System.out.printf("Passenger %d boarded. Elevator weight: %d / %d\n",
                    lastPassengerOnboard + 1, currentWeight, weightLimit);

            passengersLeft--;
        }

        if (currentWeight >= weightLimit) { // overloaded
            System.out.printf("""
                Overload detected after Passenger %d boarded.
                %sTotal weight: %d / %d
                
                """,
            lastPassengerOnboard + 1,
            passengersLeft > 0 ? passengersLeft + " will have to wait for the next elevator.\n" : "",
            currentWeight, weightLimit);
        } else {
            System.out.printf("All passengers boarded safely. Total weight: %d\n", currentWeight);
        }
    }
}
