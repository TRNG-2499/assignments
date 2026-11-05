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
            ChangeOptimizer(change);
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

    // Stretch Goal 2: Making Change
    public static void ChangeOptimizer(double change){
        double[] denominations = {100.00, 50.00, 20.00, 10, 5.00, 1.00, 0.25, 0.10, 0.05, 0.01};
        
        System.out.println(" in the following denominations:\n");

        /* Bad approach. Didn't cast properly and used wrong printf placeholders.         
        for (int i = 0; i < denominations.length; i++){
            double bill_count = 0;
            if (change >= denominations[i]) {
                bill_count = change / denominations[i];
                System.out.printf("(%d%x) $%d bills \n", bill_count, denominations[i]);
                change = change - (bill_count * denominations[i]);
            }
        } */

        int i = 0;
        while (change > 0.01){
            double bill_count;
            if(change > denominations[i]){
                bill_count = (int)(change / denominations[i]);
                System.out.printf("(%d) $%.2f\n", (int)bill_count, denominations[i]);
                change = change - (bill_count * denominations[i]);
            }
            i++;
        }
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