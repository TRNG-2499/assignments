import java.util.Scanner;

public class ElevatorWeightCheckerwithScanner {

    public static void main(String[] args) {
        //Create scanner object
        Scanner scanner = new Scanner(System.in);

        //Ask user for elevator's weight limit
        System.out.println("Enter Elevator's weight Limit: ");
        int weightLimit = scanner.nextInt();

        //Ask user for how many passengers are there
        System.out.println("How many passengers are there: ");
        int numberOfPassengers = scanner.nextInt();

        //Create array based on passenger's count
        int [] passengerWeight = new int [numberOfPassengers]; //This one declares and initializes an array


        //Let's get each passenger's weight
        for (int i =0; i < numberOfPassengers; i++){
            System.out.println("Enter Weight of Passenger" + (i+1) + " :");
            passengerWeight[i] = scanner.nextInt();
        }

        //Let's call the method now.

       String result = checkLoad(weightLimit, passengerWeight);


        //Let's display the result
        System.out.println("\n " + result);

        scanner.close();

    }
    public static String checkLoad (int weightLimit, int [] passengerWeight){
        int totalWeight = 0;

        //Handle an empty Array.
        if (passengerWeight.length == 0){
            return "None of the passengers are trying to board.";
        }

        //Check each passenger..
        for (int i =0; i<passengerWeight.length; i++){
            totalWeight = totalWeight + passengerWeight[i];

            if(totalWeight >= weightLimit){
                return "Passenger " + (i+1) + " is causing overload. Total weight is: " + totalWeight + " lbs.";
            }

        }
        return "All passengers boarded successfully. Have a great trip.";


    }


}
