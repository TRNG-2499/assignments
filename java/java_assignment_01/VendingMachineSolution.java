public class VendingMachineSolution {

    // Original: single item price and amount inserted
    public static String vendingMachine(double price, double inserted) {
        if (inserted < 0) {
            return "Invalid input: inserted amount must be non-negative.";
        }
        if (price < 0) {
            return "Invalid input: price must be non-negative.";
        }
        if (inserted < price) {
            return String.format("Insufficient funds. Please insert $%.2f more.", (price - inserted));
        }
        return String.format("Purchase successful. Change due: $%.2f", (inserted - price));
    }

    // Stretch goal 1: multiple item prices, one amount inserted
    public static String vendingMachineMultiple(double[] prices, double inserted) {
        double totalPrice = 0;
        for (double p : prices) {
            if (p < 0) {
                return "Invalid input: price must be non-negative.";
            }
            totalPrice += p;
        }
        return vendingMachine(totalPrice, inserted);
    }

    // Stretch goal 2: break change into the fewest bills and coins
    public static String makeChange(double change) {
        if (change < 0) {
            return "Invalid input: change amount must be non-negative.";
        }
        change = Math.round(change * 100) / 100.0;
        int dollars = (int) change;
        int cents = (int) Math.round((change - dollars) * 100);
        int quarters = cents / 25;
        cents %= 25;
        int dimes = cents / 10;
        cents %= 10;
        int nickels = cents / 5;
        cents %= 5;
        int pennies = cents;
        return String.format("Change breakdown: Dollars: %d, Quarters: %d, Dimes: %d, Nickels: %d, Pennies: %d",
                dollars, quarters, dimes, nickels, pennies);
    }

    public static void main(String[] args) {
        // Original method
        System.out.println(vendingMachine(1.50, 2.00));   
        System.out.println(vendingMachine(1.50, 1.00)); 
        System.out.println(vendingMachine(1.50, 1.50));  
        System.out.println(vendingMachine(1.50, -1.00)); 
        System.out.println(vendingMachine(-1.00, 2.00));  

        // Multiple items
        System.out.println(vendingMachineMultiple(new double[]{1.50, 0.75, 2.00}, 5.00)); 
        System.out.println(vendingMachineMultiple(new double[]{1.50, 0.75, 2.00}, 3.00)); 
        System.out.println(vendingMachineMultiple(new double[]{3.00, -1.00}, 2.00));      
        System.out.println(vendingMachineMultiple(new double[]{1.50, 0.75}, -2.00));      

        // Making change
        System.out.println(makeChange(0.41));         
        System.out.println(makeChange(2.99));         
        System.out.println(makeChange(0.00));          
        System.out.println(makeChange(0.9999999999));  
        System.out.println(makeChange(-0.50));         
    }
}