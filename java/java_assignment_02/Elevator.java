
import java.util.Scanner;

public class Elevator{
   public void overload(int weightLimit, int[] passengerWeights) {
        int totalWeight = 0;

        if (passengerWeights == null || passengerWeights.length == 0) {
            System.out.println("No passengers to board.");
            return;
        }

        if (weightLimit <= 0) {
            System.out.println("Invalid weight limit.");
            return;
        }


        for (int i = 0; i < passengerWeights.length; i++) {
            if (passengerWeights[i] < 0) {
                System.out.println("Invalid passenger weight: " + passengerWeights[i]);
                return;
            }
            
            totalWeight += passengerWeights[i];

            if (totalWeight > weightLimit) {
                System.out.println("Passenger " + (i + 1) + " caused an overload. Total weight at that point: " + totalWeight);
                return;
            }
        }

        System.out.println("All passengers boarded safely. Total weight: " + totalWeight);
        
    }

    public static void main(String[] args) {

    }
}