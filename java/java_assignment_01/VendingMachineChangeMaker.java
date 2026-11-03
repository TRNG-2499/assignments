public class VendingMachineChangeMaker {

    // This method takes the item's price and the money the customer put in.
    // It returns a message explaining what happened.
    public static String calculateChange(double price, double amountInserted) {
        // A price below zero is invalid. Returning here ends the method.
        if (price < 0) {
            return "Invalid input: item price cannot be negative.";
        }

        // The amount inserted also has to be zero or more.
        if (amountInserted < 0) {
            return "Invalid input: amount inserted cannot be negative.";
        }

        // If the customer paid too little, subtract what they paid from the price
        // to find how much more they need. %.2f displays two decimal places.
        if (amountInserted < price) {
            double amountNeeded = price - amountInserted;
            return String.format("Insufficient funds. Please insert $%.2f more.", amountNeeded);
        }

        // The customer paid enough, so subtract the price from what they paid.
        // If they paid the exact price, the change is $0.00.
        double change = amountInserted - price;
        return String.format("Purchase successful. Change due: $%.2f", change);
    }

    public static void main(String[] args) {
        // Call the method with different inputs and print each result.

        // The customer pays $2.00 for a $1.50 item and gets $0.50 back.
        System.out.println(calculateChange(1.50, 2.00));

        // The customer pays $1.00 and still owes $0.50.
        System.out.println(calculateChange(1.50, 1.00));

        // The customer pays the exact price and gets $0.00 back.
        System.out.println(calculateChange(1.50, 1.50));

        // Test what happens when the amount inserted is negative.
        System.out.println(calculateChange(1.50, -1.00));

        // Test what happens when the item price is negative.
        System.out.println(calculateChange(-1.50, 2.00));
    }
}