package assignment02.part02;
import java.util.Arrays;

public class Solution {

    public static String weightTrack(int weightLimit, int[] passengerWeights){
        int total = 0;
        int len = passengerWeights.length;
        if (len == 0){
            return String.format("No passengers are present.");
        }

        for(int i = 0; i < len; i++){
            total += passengerWeights[i];
            if(total >= weightLimit){
                return String.format("Passenger %d caused an overload. Total weight at that point: %d lbs.", i+1, total);
            }
        }
        return String.format("All passengers boarded safely. Total weight: %d lbs.", total);
    }

    public static String lightestHeaviest(int weightLimit, int[] passengerWeights){
        int total = 0;
        int len = passengerWeights.length;
        if (len == 0){
            return String.format("No passengers are present.");
        }
        
        int smallest = passengerWeights[0];
        for(int i = 1 ; i < len;i++){
            if (smallest > passengerWeights[i]){
                smallest = passengerWeights[i];
            }
        }

        int heaviest = passengerWeights[0];
        for(int i = 1; i < len; i++){
            if(heaviest < passengerWeights[i]){
                heaviest = passengerWeights[i];
            }
        }

        for(int i = 0; i < len; i++){
            total += passengerWeights[i];
            if(total >= weightLimit){
                return String.format("Passenger %d caused an overload. Total weight at that point: %d lbs. Heaviest Passenger weight: %d . Lightest Passenger Weight: %d", i+1, total, heaviest ,smallest);
            }
        }
        return String.format("All passengers boarded safely. Total weight: %d lbs. Heaviest Passenger weight: %d . Lightest Passenger Weight: %d", total, heaviest ,smallest);
    }
    

    public static int maxSafeCount(int maxWeight, int [] passengerWeight){ 
        Arrays.sort(passengerWeight);
        int count = 0;
        int total = 0;
        while(total < maxWeight){ 
            total += passengerWeight[count];
            if (total > maxWeight){
                return count;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println(weightTrack(1000, new int[] {150, 200, 300, 250, 180}));
        System.out.println(weightTrack(1000, new int[] {150, 200, 300}));
        System.out.println(weightTrack(100, new int[] {150, 200}));
        System.out.println(weightTrack(100, new int[] {50, 150}));
        System.out.println(weightTrack(500, new int[] {200, 300}));
        System.out.println(weightTrack(100, new int[] {}));

        System.out.println(lightestHeaviest(1000, new int[] {150, 200, 300, 250, 180}));
        System.out.println(lightestHeaviest(1000, new int[] {150, 200, 300}));
        System.out.println(lightestHeaviest(100, new int[] {150, 200}));
        System.out.println(lightestHeaviest(100, new int[] {50, 150}));
        System.out.println(lightestHeaviest(500, new int[] {200, 300}));
        System.out.println(lightestHeaviest(100, new int[] {}));

        int maxSafeCount = maxSafeCount(1000, new int[] {950, 200, 300, 250, 180});
        System.out.printf("Maximum number of passengers that could board the elevator without meeting or exceeding the weight limit is %d%n", maxSafeCount);
    }
}
