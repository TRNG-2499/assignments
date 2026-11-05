package java_assignment_01;

public class Solution {
    public static void main(String[] args) {
 //       System.out.println(getChange(3.67));

        System.out.println("Purchase result: " + purchase(8.67, new double[]{1.0, 0.5, 3.5, 1.43}));
    }

    public static String purchase(double amount, double[] price) {
        if (price == null || amount < 0) {
            return "Invalid input";
        }

        double totalPrice = 0;
        for (double itemPrice : price) {
            if (itemPrice < 0) {
                return "Invalid input";
            }
            totalPrice += itemPrice;
        }

        if (amount < totalPrice) {
            return "Insufficient funds";
        } else {
            double change = amount - totalPrice;
            String changeBreakdown = getChange(change);
            return "Purchase successful. Change: " + changeBreakdown;
        }
    }
    
    public static String getChange(double change) {
        int cents = (int) Math.round(change * 100);

        int dollars = cents / 100;
        cents %= 100;

        int quarters = cents / 25;
        cents %= 25;

        int dimes = cents / 10;
        cents %= 10;

        int nickels = cents / 5;
        cents %= 5;

        int pennies = cents;

        return "$1.00: " + dollars
                + ", $0.25: " + quarters
                + ", $0.10: " + dimes
                + ", $0.05: " + nickels
                + ", $0.01: " + pennies;
    }
    
}
