

public class Solution_01 {
    public static void main(String[] args) {

        // Testing  --> Basic Req. 
        System.out.println("--- Example 1: Successful purchase with change ---");
        Vending_Machine_Change(1.50, 2.00);

        System.out.println("\n-- Example 2: Insufflicient funds --");
        Vending_Machine_Change(1.50, 1.00);

        System.out.println("\n--- Example 3: Exact payment, no change ---");
        Vending_Machine_Change(1.50, 1.50);

        System.out.println("\n--- Example 4: Invalid input ---");
        Vending_Machine_Change(1.50, -1.00);

        // Stretch Goal 1 
        System.out.println("\n--- Stretch Goal 1: Multi-Item Purchase (Success) ---");
        Vending_Machine_Change_Stretch(4.00, 1.50, 1.00, 0.50);

        System.out.println("\n--- Stretch Goal 1: Multi-Item Purchase (Insufficient) ---");
        Vending_Machine_Change_Stretch(2.00, 1.50, 1.00, 0.50);

        // Stretch Goal 2 
        System.out.println("\n--- Stretch Goal 2: Breakdown of Coins ($0.87) ---");
        Vending_Machine_Change_Stretch2(0.87);

        System.out.println("\n--- Stretch Goal 2: Breakdown of Coins ($1.45) ---");
        Vending_Machine_Change_Stretch2(1.45);


    }

    // This for Basic Requirements of the Assignment
    public static void Vending_Machine_Change(double price, double amount) {
        if ( price <= 0 || amount <= 0) {
            System.out.println("Invalid Input");
        }
        else if (amount < price) {
            double difference = price - amount;
            System.out.println("Insufficient Amount Needed: " + difference);
        }
        if (amount >= price) {
            double change = amount - price;
            System.out.println(" Successful Sale Change Owned: " + change);
        }
    }

    // Stretch Goal 1
    public  static void Vending_Machine_Change_Stretch(double amount, double... prices) {
        double total = 0;
        for (double num: prices) {
            total = total + num;
        }

        if (total <= 0 || amount <= 0) {
            System.out.println("Invalid Input");
        }
        else if (amount < total) {
            double difference = total - amount;
            System.out.println("Insufficient Amount Needed: " + difference);
        }
        if (amount >= total) {
            double change = amount - total;
            System.out.println(" Successful Sale Change Owned: " + change);
        }
    }

    // Stretch Goal 2
    public static void Vending_Machine_Change_Stretch2(double amount) {

        double[] denominations = {1.00, 0.25, 0.10, 0.05, 0.01};
        

        for (double coin : denominations) {
            int count = (int) (amount / coin);

            amount %= coin;

            if (count > 0) {
                System.out.println(count + " x $" + String.format("%.2f", coin));
            }
        }
    }

}