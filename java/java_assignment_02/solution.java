public class solution {
    public void weightCheck(double maxWeight, double[] passengerWeights){
        // no array clause
        if(passengerWeights.length == 0){
            System.out.println("No passengers entered the elevator.");
            return;
        }
        // start of the actual solution
        double total = 0;
        for(int i = 0; i < passengerWeights.length; i++){
            // for each passenger, adds the weight to the total and checks it with the maxWeight
            total += passengerWeights[i];
            if(total >= maxWeight){
                System.out.println("Passenger " + (i+1) + " caused an overload. Total weight at that point: " + total + " lbs.");
                return;
            }
        }
        System.out.println("All passengers boarded safely. Total weight: " + total + " lbs.");
    }

    public static void main(String args[]){
        solution s = new solution();
        s.weightCheck(1000, new double[]{150, 200, 300, 250, 180}); // overload overflow
        s.weightCheck(1000, new double[]{100, 200, 300}); // safe passage
        s.weightCheck(500, new double[]{200,300}); // exact overload
        s.weightCheck(100, new double[]{150,200}); // overload on first
        s.weightCheck(1000, new double[]{120.55,230.97,200.12}); // decimals
        s.weightCheck(500, new double[]{50,50,50,50,50,50,50,50,50,50}); // length check
        s.weightCheck(100, new double[]{}); // no passengers
    }
}