package assignments.java.java_assignment_02;

public class Elevator {
    public static void main(String[] args) {
        int[] passengerWeights1 = {150, 200, 300, 250, 180};
        int[] passengerWeights2 = {150, 200, 300};
        int[] passengerWeights3 = {200, 300};
        int[] passengerWeights4 = {150, 200};
        int[] passengerWeights5 = {};

        weightTester(1000, passengerWeights1);
        weightTester(1000, passengerWeights2);
        weightTester(500, passengerWeights3);
        weightTester(100, passengerWeights4);
        weightTester(100, passengerWeights5);
    }

    public static void weightTester(int limit, int[] weights) {
        if (weights.length == 0) {
            System.out.println("No passegers to board. Total weight: 0 lbs.");
        }else {
            int total = 0;
            int x = 0;
            while(total < limit && x < weights.length) {
                total += weights[x];
                x++;
                if (total >= limit) {
                    System.out.println("Passeger "+ x +" caused an overload. Total weight at that point: "+ total +" lbs.");
                }else if (x == weights.length) {
                    System.out.println("All passengers boarded safely. Total weight: "+ total +" lbs.");
                }
            }
        }

    }
}
