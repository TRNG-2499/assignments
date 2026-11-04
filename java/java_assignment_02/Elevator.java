public class Elevator{
  public static void main(String[] args) {
      
    elevatorWeightCheck(1000, new int[]{120,140,240,30,600});
  }
  
  public static void elevatorWeightCheck(int weightLimit, int [] passengerWeights){
    int totalWeight = 0;
    
    for(int i = 0; i < passengerWeights.length; i++){
        
        if (totalWeight + passengerWeights[i] >= weightLimit) {
                System.out.println("Passenger " + (i + 1) + " caused an overload, will not move. Total weight: " + (totalWeight + passengerWeights[i]) + "lbs");
                return;
            }

            totalWeight += passengerWeights[i];
    }
        
        if (totalWeight > 0){
            System.out.println("passenger/s boarded safely, weight is " + totalWeight + "lbs");
        }
        else{
            System.out.println("Empty, waiting on request");
        }

    }  
}
