import java.util.Arrays;

public class WeightLimit {
    public static void main(String[] args) {
        CheckLimit(1000, 150, 200, 300, 250, 180);
        CheckLimit(1000, 150, 200, 300);
        CheckLimit(500, 200, 300);
        CheckLimit(100, 150, 200);
        CheckLimit(1000);

        MaxPassengers(1000, 150, 200, 300, 250, 180);
        MaxPassengers(1000, 150, 200, 300);
        MaxPassengers(500, 200, 300);
        MaxPassengers(100, 150, 200);
        MaxPassengers(1000);

        ReportWeights(1000, 150, 200, 300, 250, 180);
        ReportWeights(1000, 150, 200, 300);
        ReportWeights(500, 200, 300);
        ReportWeights(100, 150, 200);
        ReportWeights(1000);

    }


    public static void CheckLimit(double weightLimit, double... passengerWeights) {
        double currentWeight = 0;
        if (passengerWeights.length == 0) {
            System.out.println("No passengers boarding.");
            return;
            }
        for (int i = 0; i < passengerWeights.length; i++) {
            currentWeight += passengerWeights[i];
            if (currentWeight >= weightLimit) {
                System.out.println("Passenger " + (i + 1) + " casued an overload. Total current weight: " + currentWeight + ".");
                return;
            }

        }
        System.out.println("All passengers boarded safely. Total weight: " + currentWeight + ".");
        
    }

    public static void MaxPassengers(double weightLimit, double... passengerWeights) {
        Arrays.sort(passengerWeights);
        double currentWeight = 0;
        if (passengerWeights.length == 0) {
            System.out.println("No passengers.");
            return;
        }
        for (int i = 0; i < passengerWeights.length; i++) {
            currentWeight += passengerWeights[i];
            if (currentWeight >= weightLimit) {
                System.out.println("Maximum Passenger Count: " + (i) + ", Total Weight: " + (currentWeight - passengerWeights[i]));
                return;
            }
        }

        System.out.println("All " + passengerWeights.length +" Passengers Accommodated, Total Weight: " + currentWeight);

    }

    public static void ReportWeights(double weightLimit, double... passengerWeights) {
        double currentWeight = 0;
        int lightest = 0;
        int heaviest = 0;
        if (passengerWeights.length == 0) {
            System.out.println("No passengers boarding.");
            return;
            }
        for (int i = 0; i < passengerWeights.length; i++) {
            currentWeight += passengerWeights[i];
            if (passengerWeights[lightest] > passengerWeights[i])
                lightest = i;
            if (passengerWeights[heaviest] < passengerWeights[i])
                heaviest = i;
            if (currentWeight >= weightLimit) {
                System.out.println("Passenger " + (i + 1) + " casued an overload. Total current weight: " + currentWeight + ".");
                System.out.println("Heaviest Passenger: " + (heaviest + 1) + ", Weight: " + passengerWeights[heaviest] + ".");
                System.out.println("Lightest Passenger: " + (lightest + 1) + ", Weight: " + passengerWeights[lightest] + ".");
                return;
            }

        }
        System.out.println("All passengers boarded safely. Total weight: " + currentWeight + ".");
        System.out.println("Heaviest Passenger: " + (heaviest + 1) + ", Weight: " + passengerWeights[heaviest] + ".");
        System.out.println("Lightest Passenger: " + (lightest + 1) + ", Weight: " + passengerWeights[lightest] + ".");
        
        
    }

    // public static void MultiTrip(double weightLimit, double... passengerWeights) {
    //     int idx = 0;
    //     for (double p : passengerWeights) {
            
    //     }

    // }

    
}