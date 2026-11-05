public class vendingMachine {

    public static String calculateChange(double price, double amountInserted) {

        if (price < 0) {
            return "Invalid input: item price cannot be negative.";
        }

        if (amountInserted < 0) {
            return "Invalid input: amount inserted cannot be negative.";
        }

        if (amountInserted < price) {
            double amountNeeded = price - amountInserted;
            
            return "Insufficient funds. Please insert $" + String.format("%.2f", amountNeeded) + " more.";

        }

        else {
            double change = amountInserted - price;

            return "Change to be returned: $" + String.format("%.2f", change);
        }
    }

    public static String calculateMultipleItems(double[] prices, double amountInserted) {

        if (amountInserted < 0) {
            return "Invalid input: amount inserted cannot be negative.";
        }

        double totalPrice = 0;

        for (double price : prices) {
            if (price < 0) {
                return "Invalid input: item price cannot be negative.";
            }
            totalPrice += price;
        }


        if (amountInserted < totalPrice) {
            double amountNeeded = totalPrice - amountInserted;
            return "Insufficient funds. Please insert $" + String.format("%.2f", amountNeeded) + " more.";
        } else {
            double change = amountInserted - totalPrice;
            return "Change to be returned: $" + String.format("%.2f", change);
        }
    }

    public static String makeChange(double amount) {
        if (amount < 0) {
            return "Invalid input: amount cannot be negative.";
        }

        int amountInCents = (int) Math.round(amount * 100);
        int[] denominations = {2000, 1000, 500, 100, 50, 25, 10, 5, 1}; 
        String[] denominationNames = {"$20", "$10", "$5", "$1", "50¢", "25¢", "10¢", "5¢", "1¢"};
        StringBuilder changeString = new StringBuilder("Change breakdown: for amount $" + String.format("%.2f", amount) + "\n");

        for (int i = 0; i < denominations.length; i++) {
            int count = amountInCents / denominations[i];
            if (count > 0) {
                changeString.append(count).append(" x ").append(denominationNames[i]).append("\n");
                amountInCents -= count * denominations[i];
            }
        }

        return changeString.toString();
    }

    public static void main(String[] args) {

        System.out.println(calculateChange(1.50, 2.00));

        System.out.println(calculateChange(1.50, 1.00));

        System.out.println(calculateChange(1.50, 1.50));

        System.out.println(calculateChange(1.50, -1.00));

        System.out.println("\nMULTIPLE ITEMS");

        double[] prices = {1.50, 2.00, 3.00};

        System.out.println(calculateMultipleItems(prices, 10.00));

        System.out.println(calculateMultipleItems(prices, 5.00));

        System.out.println("\nMAKING CHANGE");

        System.out.println(makeChange(3.76));

        System.out.println(makeChange(35.86));


    }
}