import java.util.*;

public static void main(String[] args){
    //Scanner is just for testing
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Enter the max weight the elevator can take");
    int max = scanner.nextInt();

    System.out.println("Enter the number of passengers that will be boarding:");
    int p = scanner.nextInt();
    int[] passengers = new int[p];

    System.out.println("Enter the weights of the " + p + " passengers:");
    for (int i = 0; i < p; i++)
        passengers[i] = scanner.nextInt();

    weightChecker(max, passengers);

    scanner.close();
}

public static void weightChecker(int maxWeight, int... passengerWeights){
    int totalWeight = 0;
    for(int i = 0; i < passengerWeights.length; i++){
        totalWeight = totalWeight + passengerWeights[i];
        if(totalWeight >= maxWeight){
            System.out.println("Passenger " + (i+1) + " caused an overload. Total weight at that point: " + totalWeight + " lbs.");
            return;
        }
    }
    System.out.println("All passengers boarded safely. Total Weight: " + totalWeight + " lbs.");
}