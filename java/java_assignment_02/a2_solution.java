public class a2_solution {
    public void weightCheck(double maxWeight, double[] passengerWeights){ // i guess we're assuming no negative weights
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
public void maxNumber(double maxWeight, double[] passengerWeights){ // unsure if it wants the absolute lowest, or to skip the overload causer
        int passengerNumber = 0;
        double total = 0;
        for(int i = 0; i < passengerWeights.length; i++){
            passengerNumber++;
            total += passengerWeights[i];
            if(total >= maxWeight){
                total -= passengerWeights[i];
            }
        }
        System.out.println("Max number of passengers: " +  passengerNumber);
}
public void highLowWeights(double maxWeight, double[] passengerWeights){
    double lowest = 99999;
    double highest = 0;
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
        lowest = Math.min(lowest,passengerWeights[i]); // check if passenger has lower weight than current lowest
        highest = Math.max(highest,passengerWeights[i]); // ditto, but higher
        if(total >= maxWeight){
            System.out.println("Passenger " + (i+1) + " caused an overload. Total weight at that point: " + total + " lbs.");
            System.out.println("Lowest weight: " + lowest + " lbs. Highest weight: " + highest + " lbs.");
            return;
        }
    }
    System.out.println("All passengers boarded safely. Total weight: " + total + " lbs.");
    System.out.println("Lowest weight: " + lowest + " lbs. Highest weight: " + highest + " lbs.");
}
public void multipleTrips(double maxWeight, double[] passengerWeights){
    // no array clause
    if(passengerWeights.length == 0){
        System.out.println("No passengers entered the elevator.");
        return;
    }
    // start of the actual solution
    double completeTotal = 0;
    int tripNumber = 0;
    int currentPassenger = 0;
    boolean finished = false;
    while(!finished){ // loops until max weight is too high, or all passengers are through
        double total = 0;
        tripNumber++;
        if(passengerWeights[currentPassenger] > maxWeight){ // in the event a single passenger is larger than the max Weight
            System.out.println("Impossible to safely board.");
            return;
        }
        for(int i = currentPassenger; i < passengerWeights.length; i++) {
            currentPassenger = i;
            // for each passenger, adds the weight to the total and checks it with the maxWeight
            total += passengerWeights[i];
            completeTotal += passengerWeights[i];
            if (total >= maxWeight) {
                System.out.println("Passenger " + (i + 1) + " caused an overload. Total weight at that point: " + total + " lbs.");
                completeTotal -= passengerWeights[i];
                break;
            }else{
                if(currentPassenger == passengerWeights.length-1){
                    finished = true;
                }
            }
        }

    }
    System.out.println("All passengers boarded safely. Total weight: " + completeTotal + " lbs.");
    System.out.println("Number of trips: " + tripNumber);
}
    public static void main(String[] args){
        a2_solution s = new a2_solution();
        s.weightCheck(1000, new double[]{150, 200, 300, 250, 180}); // overload overflow
        s.weightCheck(1000, new double[]{100, 200, 300}); // safe passage
        s.weightCheck(500, new double[]{200,300}); // exact overload
        s.weightCheck(100, new double[]{150,200}); // overload on first
        s.weightCheck(1000, new double[]{120.55,230.97,200.12}); // decimals
        s.weightCheck(500, new double[]{50,50,50,50,50,50,50,50,50,50}); // length check
        s.weightCheck(100, new double[]{}); // no
        System.out.println("---------------- Stretch Goals Here ----------------");
        s.maxNumber(1000,new double[]{150, 200, 300, 250, 180}); // overload
        s.maxNumber(500, new double[]{50,5000,50,50,50,50,50,50,50,50}); // checking flowing over
        s.highLowWeights(1000, new double[]{150, 200, 300, 250, 180}); // overload overflow
        s.highLowWeights(1000, new double[]{100, 120, 131}); // safe passage
        s.highLowWeights(1000, new double[]{120.55,230.97,200.12}); // decimals
        s.multipleTrips(1000, new double[]{150, 200, 300, 250, 180}); //overload, 2
        s.multipleTrips(1000, new double[]{150, 200, 300, 250, 180, 300, 250, 230, 200}); //overload, 3 trips
        s.multipleTrips(200,new double[]{100,150,250}); // too heavy
    }
}