public class Main {
    public static void main(String[] args) {
        VendingMachine test = new VendingMachine();
        System.out.println(test.calculateChange(1.50, 2));
        System.out.println(test.calculateChange(1.50, 1));
        System.out.println(test.calculateChange(1.50, 1.50));
        System.out.println(test.calculateChange(1.50, -1));
        System.out.println(test.calculateChange(-1.50, 1));

        System.out.println(test.calculateChange(new double[]{1.50, 2.00}, 1));
        System.out.println(test.calculateChange(new double[]{-1.5, 1.00}, 3));
        System.out.println(test.calculateChange(new double[]{1.50, 2.00}, 10));

        System.out.println(test.giveChange(1.67));
        System.out.println(test.giveChange(0.00));
        System.out.println(test.giveChange(-1.00));
    }
}

class VendingMachine {
    public VendingMachine() {}

    /**
     * Calculates the change for the vending machine.
     * @param price The price of the item.
     * @param payment The amount inseted by the user.
     * @return A message indicating the result of the transaction (e.g., invalid,  insufficient, successful). Additional amount needed/change returned is included in the message.
     * 
     */
    public String calculateChange(double price, double payment) {
        if (price < 0 || payment < 0) {
            return "Invalid input: amount inserted cannot be negative.";
        }

        if (payment < price) {
            double amountNeeded = price - payment;
            return String.format("Insufficient funds. Please insert $%.2f more.", amountNeeded);
        }

        return String.format("Purchase successful. Change due: $%.2f", payment - price);
    }

    /**
     * Calculates the change for the vending machine when user purchases a list of items.
     * @param prices The prices of the items.
     * @param payment The amount inserted by the user.
     * @return A message indicating the result of the transaction (e.g., invalid, insufficient, successful). Additional amount needed/change returned is included in the message.
     */
    public String calculateChange(double[] prices, double payment) {
        if (payment < 0) {
            return "Invalid input: amount inserted cannot be negative.";
        }

        double totalPrice = 0;
        for (double price : prices) {
            if (price < 0) {
                return "Invalid input: amount inserted cannot be negative.";
            }
            totalPrice += price;
        }

        if (payment < totalPrice) {
            double amountNeeded = totalPrice - payment;
            return String.format("Insufficient funds. Please insert $%.2f more.", amountNeeded);
        }

        return String.format("Purchase successful. Change due: $%.2f", payment - totalPrice);
    }

    /**
     * Gives the change to the user in the form of dollars, quarters, dimes, nickels, and pennies.
     * @param change The amount of change to give.
     * @return A message indicating the change given.
     */
    public String giveChange(double change) {
        if (change <= 0) {
            return "No change to give.";
        }

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

        return String.format("Change: %d dollars, %d quarters, %d dimes, %d nickels, %d pennies", dollars, quarters, dimes, nickels, pennies);
    }
}
