package assignments.java.java_assignment_01;
import java.util.Scanner;

public class java_assignment_01 {
    public static void makeChange(double price, double paid){
        if (paid < 0) {
            System.out.println("Invalid input: amount inserted cannot be negative.");
        } else if (price < 0) {
            System.out.println("Invalid input: price cannot be negative.");
        } else if (paid < price) {
            double difference = price - paid;
            System.out.printf("Insufficient funds. Please insert $%.2f more.", difference);
        } else if (paid >= price) {
            double change = paid - price;
            System.out.printf("Purchase successful. Change due: $%.2f", change);
        }
    }

    // Stretch Goal 1: Multiple Items
    public static double MultipleItems(double[] prices){
        // Sum array of doubles
        double sum_prices = 0;
        for (int i = 0; i < prices.length; i++){
            sum_prices = sum_prices + prices[i];
        }
        // Return sum
        return sum_prices;
    }

    public static void main(String[] args){
        // Flag for switching between base requirements and stretch goal 1:
        // True for single item; false for multiple items
        Boolean Mode = false;
        
        // Need to declare this out here
        double price;
        Scanner scanner = new Scanner(System.in);
        
        if (Mode == true){
            // Base requirement
            System.out.println("Enter item price: ");
            price = scanner.nextDouble();
        } else {
            // Stretch Goal 1: Multiple Items
            double[] prices = {10.00, 43.00, 80.00, 11.45};
            price = MultipleItems(prices);
        }

        System.out.println("Enter amount inserted: ");
        double paid = scanner.nextDouble();

        scanner.close();
        
        makeChange(price, paid);
    }
}