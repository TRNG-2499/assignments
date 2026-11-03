/*
Write a method that accepts two parameters: a maximum weight limit (an int or double, your choice) and an array (or list) of passenger weights, 
representing passengers boarding an elevator one at a time, in the order given.
Track the running total weight as each passenger boards, one at a time, in order.
If adding a passenger would cause the running total to meet or exceed the weight limit, the elevator is overloaded. At that point, your method should report:
Which passenger (by position in line) caused the overload — for readability, passenger positions should be reported starting from 1, not 0 
(e.g., the passenger at index 0 of your input array should be reported as "Passenger 1")
The running total weight at the point the overload occurred (i.e., including that passenger's weight)
No further passengers should be considered once the overload is detected
If every passenger boards without the running total ever meeting or exceeding the limit, report that all passengers boarded safely, along with the final total weight.
Consider what your method should do if it is given an empty array of passengers — this should not throw an error or crash.
Consider what your method should do if the very first passenger's weight alone meets or exceeds the limit.
You will need to decide how to represent and return your result (for example, a formatted String message, a custom result object, 
or printed output directly from the method) — there is no single required approach, but your design should clearly communicate both the outcome and the relevant numbers. */


public class ElevatorWeightChecker {
    public static String checkElevatorWeight(double maxWeight, double[] passengerWeights) {
        double totalWeight = 0;
        for (int i = 0; i < passengerWeights.length; i++) {
            totalWeight += passengerWeights[i];
            if (totalWeight >= maxWeight) {
                return String.format("Overload! Passenger %d caused the overload. Total weight: %.2f.", (i + 1), totalWeight);
            }
        }
        return String.format("All passengers boarded safely. Total weight: %.2f.", totalWeight);
    }

    public static void main(String[] args) {
        double[] passengerWeights = {150.0, 160.0, 170.0};
        System.out.println(checkElevatorWeight(400.0, passengerWeights));

        double[] passengerWeights2 = {200.0, 210.0};
        System.out.println(checkElevatorWeight(400.0, passengerWeights2));

        double[] passengerWeights3 = {};
        System.out.println(checkElevatorWeight(400.0, passengerWeights3));

        double[] passengerWeights4 = {400.0};
        System.out.println(checkElevatorWeight(400.0, passengerWeights4));
    }
    
}
