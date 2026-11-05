//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class solution {
    public static void main(String[] args) {
        int[] weights = {200, 300};
        System.out.println(elevatorStats(weights, 100));
    }


    public static String elevatorStats(int[] passengerWeights, int limit) {
        if (passengerWeights.length == 0) {
            return "No passengers aboard the elevator.";
        }

        int weightCounter = 0;
        int stepCounter = 1;


        for (int i = 0; i <= passengerWeights.length-1; i++) {
            weightCounter = passengerWeights[i] + weightCounter;
            if (weightCounter < limit) {
                stepCounter++;
            } else {
                return "Passenger " + stepCounter + " caused an overload. Total weight at that point: "+ weightCounter + " lbs.";
            }

        } return "All passengers boarded safely. Total weight: " + weightCounter + " lbs.";
    }
}