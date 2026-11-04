
public class ElevatorWeightChecker {
    public static void main(String[] args) {
    //int weightLimit = 1000;
    //int weightLimit = 500;

    int weightLimit = 100;
    //int [] passengerWeights = {};
    //int [] passengerWeights = {150, 200, 300, 250, 180};
    //int[] passengerWeights = {150, 200, 300};
    //int [] passengerWeights = {200, 300};
     int [] passengerWeights = {150, 200};

    String result = checkLoad(weightLimit, passengerWeights);
        System.out.println(result);

    }


    public static String checkLoad(double weightLimit, int[] passengerWeights){
        int totalWeight = 0;

        //Let's say there is no passenger to be boarded (empty array)
        if (passengerWeights == null || passengerWeights.length == 0){
            return "No passengers are waiting to be board.";
        }

        //Let's process one passenger at a time

        for(int i = 0; i<passengerWeights.length; i++){

            //Add the current passenger's weight
            totalWeight += passengerWeights[i];

            //Now, check whether the weight limit is reached or exceeeded
            if(totalWeight >= weightLimit){
                return "Passenger " + (i+1) + " caused an overload. Total weight at this point is : " + totalWeight + " lbs.";
            }


        }
        //If the loop completes without having overload, then
        return "All passengers boarded safely. Total weight is : " + totalWeight + "lbs. Thank you very much for the ride";
    }
}