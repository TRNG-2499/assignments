import javax.lang.model.type.NullType;
import java.util.Scanner;

public class Main {

    public static void basicElevator(int maxWeight, int... passengerWeights){

        int totalWeight = 0;
        int i = 0;
        boolean emptyLine = false;

        //base case, empty array
        if(passengerWeights.length == 0){
            System.out.println("No Passengers in line\n");
            emptyLine = true;
        }

        while(i < passengerWeights.length){
            totalWeight += passengerWeights[i];

            //check to see if elevator is overloaded
            if (maxWeight <= totalWeight) {
                System.out.println("Passenger " + String.valueOf(i+1) + " cause an overload. " +
                        "Total weight at this point " + String.valueOf(totalWeight) + " lbs.\n");
                break;
            }
            i++;
        }

        //all passengers are good
        if(!emptyLine && i == passengerWeights.length){
            System.out.println("All passengers boarded safely. Total weight: " +
                    String.valueOf(totalWeight) + " lbs.\n");
        }



    }

    public static void main(String[] args) {

        //No passengers
        System.out.println("weightLimit = 1000, passengerWeights = none given");
        basicElevator(1000);

        //Overload occurs
        System.out.println("weightLimit = 1000, passengerWeights = [150, 200, 300, 250, 180");
        basicElevator(1000, 150, 200, 300, 250, 180);

        //All passengers board safely
        System.out.println("weightLimit = 1000, passengerWeights = [150, 200, 300]");
        basicElevator(1000, 150, 200, 300);

        //Exact match counts as overload
        System.out.println("weightLimit = 500, passengerWeights = [200, 300]");
        basicElevator(500, 200, 300);

        //First passenger alone exceeds the limit
        System.out.println("weightLimit = 100, passengerWeights = [150, 200]");
        basicElevator(100, 150, 200);
    }
}
