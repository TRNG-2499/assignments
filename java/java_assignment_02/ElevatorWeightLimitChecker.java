public class ElevatorWeightLimitChecker {
    public static void main(String[] args){
        System.out.println(check(1000, 150, 200, 300, 250, 180));
        System.out.println(check(1000, 150, 200, 300));
        System.out.println(check(500, 200, 300));
        System.out.println(check(100, 150, 200));
    }

    public static String check(double weightLimit, double... passengerWeights){
        double checkWeight = 0;
        for(int i = 0; i < passengerWeights.length; i++){
            checkWeight += passengerWeights[i];
            if(checkWeight >= weightLimit){
                return "Passenger " + (i + 1) + " caused an overload. Total weight at that point: " + checkWeight + "lbs.";
            }
        }
        return "All passengers boarded safely. Total weight: " + checkWeight + "lbs.";
    }
}
