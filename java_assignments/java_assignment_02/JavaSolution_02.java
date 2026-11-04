package java_assignments.java_assignment_02;
import java.util.ArrayList;
import java.util.Arrays;
public class JavaSolution_02 {
    public static void main(String[] args) {
        ArrayList<Double> passengers = new ArrayList<>(Arrays.asList(200.0, 350.0, 150.0));
        //checkWeightLimit(200.0, passengers);

        checkWeightLimitStrech(150.0, passengers);
    }

    public static void checkWeightLimit(Double limit, ArrayList<Double> passWeights){
        Double totalWeight = 0.0;
        for(int i=0; i < passWeights.size(); i++){
            totalWeight+=passWeights.get(i);
            if(totalWeight >= limit){
                System.out.println("Passenger "+(i+1)+" caused an overload. Total weight: "+totalWeight+" lbs.");
                return;
            } 
        }
        System.out.println("All passengers boarded safely. Total weight: "+totalWeight+" lbs.");
    }

    public static void checkWeightLimitStrech(Double limit, ArrayList<Double> passWeights){
        Double totalWeight = 0.0;
        int possiblePassengers = 0;
        for(int i=0; i < passWeights.size(); i++){
            if(passWeights.get(i)+totalWeight >= limit){
                continue;
            } else {
                totalWeight+=passWeights.get(i);
                possiblePassengers++;
            }
        }
        System.out.println("Possible passengers: "+possiblePassengers);
    }
}
