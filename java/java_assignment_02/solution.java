public class solution {
    public static void main(String[] args) {
        int [] passengers = {300, 100, 1000, 150, 500};
        //minMaxWeightCheck(500, passengers);
        //maxPassCount(451, passengers);
        multiElevatorTrip(451, passengers);
    }

    public static void elevatorWeightCheck(int maxWeight, int[]passWeights){
        if(passWeights.length == 0){
            System.out.println("There are no passengers");
            return;
        }
        int curWeight = 0;
        for(int i = 0; i < passWeights.length; i++){
            curWeight += passWeights[i];
            if(curWeight >= maxWeight){
                System.out.println("Passenger " + (i+1) + " caused an overload. Total weight at that point: " 
                + curWeight + "lbs.");
                return;
            }
        }
        System.out.println("All passengers boarded safely. Total weight: " + curWeight + " lbs.");
    }

    //Stretch Goal Maximum Safe Passenger Count
    public static void maxPassCount(int maxWeight, int[]passWeights){
        int curWeight = 0;
        int countMaxPass = 0;
        insertionSort(passWeights); //sort to get max passengers
        while(countMaxPass < passWeights.length && curWeight + passWeights[countMaxPass] < maxWeight){
            curWeight += passWeights[countMaxPass];
            countMaxPass++;
        }
        System.out.println(countMaxPass + " passengers can board the elevator.");
    }

    //Helper sort method for stretch goal Maximum Safe Passenger Count
    public static void insertionSort(int [] passWeights){
        for(int i = 1; i < passWeights.length; i++){
            int j = i;
            while(j >= 1 && passWeights[j] < passWeights[j-1]){
                //System.out.println("Test");
                int temp = passWeights[j];
                passWeights[j] = passWeights[j-1];
                passWeights[j-1] = temp;
                j = j-1;
            }
        }
    }

    //Stretch Goal Heaviest and Lightest Passengers
    public static void minMaxWeightCheck(int maxWeight, int[]passWeights){
        if(passWeights.length == 0){
            System.out.println("There are no passengers");
            return;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int curWeight = 0;
        for(int i = 0; i < passWeights.length; i++){
            curWeight += passWeights[i];
            if(passWeights[i] < min)
                min = passWeights[i];
            if(passWeights[i] > max)
                max = passWeights[i];

            if(curWeight >= maxWeight){
                System.out.println("Passenger " + (i+1) + " caused an overload. Total weight at that point: " 
                + curWeight + "lbs. The lightest passenger is " + min + " lbs and the heaviest passenger is " 
            + max + " lbs.");
                return;
            }
        }
        System.out.println("All passengers boarded safely. Total weight: " + curWeight + 
        " lbs. The lightest passenger is " + min + " lbs and the heaviest passenger is " 
        + max + " lbs.");
    }

    //Stretch Goal Multiple Elevator Trips
    public static void multiElevatorTrip(int maxWeight, int[]passWeights){
        int numOfTrip = 0;
        int curWeight = 0;
        String passTripString = ""; //keep track of passenger in each trip
        String overLimitPass = ""; //keep track of passenger unable to board due to weight limit
        for(int i = 0; i < passWeights.length; i++){
            //If we have a passenger that is over the weight limit we skip them
            if(passWeights[i] >= maxWeight){
                overLimitPass += "Passenger " + (i+1) + " weight is " + passWeights[i] + 
                " lbs which is over the weight limit. They can't board the elevator.\n";
                continue;
            }
            if(curWeight + passWeights[i] >= maxWeight){
                curWeight = passWeights[i];
                numOfTrip++;
                System.out.print("In trip " + numOfTrip + " the following passengers boarded: " + passTripString + "\n");
                passTripString = (i+1) + " ";
                continue;
            }
            curWeight += passWeights[i];
            passTripString += (i+1) + " ";
        }
        numOfTrip++;
        System.out.println("In trip " + numOfTrip + " the following passengers boarded: " + passTripString);
        System.out.print(overLimitPass);
    }
}
