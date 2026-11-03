public class ElevatorWeightLimitChecker {
    public static String check(double[] passengerWeights, double weightLimit){
        double checkWeight = 0;
        for(int i = 0; i < passengerWeights.length; i++){
            checkWeight += passengerWeights[i];
            if(checkWeight > weightLimit){
                return "Passenger " + (i + 1) + "cause an overload. Total weight at that point: " + checkWeight + "lbs.";
            }
        }
        return "All passengers boarded safely. Total weight: " + checkWeight + "lbs.";
    }
}
