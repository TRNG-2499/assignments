package assignment02.part02;

public class Solution {

    public static String weightTrack(int weightLimit, int[] passengerWeights){
        int total = 0;

        if (passengerWeights.length == 0){
            return String.format("No passengers are present.");
        }
        
        for(int i = 0; i < passengerWeights.length; i++){
            total += passengerWeights[i];
            if(total >= weightLimit){
                return String.format("Passenger %d caused an overload. Total weight at that point: %d lbs.", i+1, total);
            }
        }
        return String.format("All passengers boarded safely. Total weight: %d lbs.", total);
    }

    public static void main(String[] args) {
        System.out.println(weightTrack(1000, new int[] {150, 200, 300, 250, 180}));
        System.out.println(weightTrack(1000, new int[] {150, 200, 300}));
        System.out.println(weightTrack(100, new int[] {150, 200}));
        System.out.println(weightTrack(100, new int[] {50, 150}));
        System.out.println(weightTrack(500, new int[] {200, 300}));
        System.out.println(weightTrack(100, new int[] {}));
    }
}
