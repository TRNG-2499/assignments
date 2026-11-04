/**
 * @author Andrew Litcofsky
 */
public class VendingMachine {
    // tests
    public static void main(String[] args) {
        System.out.println("Fail cases:");
        System.out.println(processChange(-2.50, 2.23)); // invalid price
        System.out.println(processChange(2.50, -2.23)); // invalid money inserted
        System.out.println(processChange(2.50, 2.23)); // insufficient funds - 0.27 short

        System.out.println("\nSuccess cases:");
        System.out.println(processChange(2.50, 2.50)); // success - 0.00 in change
        System.out.println(processChange(1.50, 3.50)); // success - 2.00 in change
        System.out.println(processChange(2.17, 3.50)); // success - 1.33 in change


    }

    private static String processChange(double itemPrice, double moneyInserted) {
        if (itemPrice < 0)
            return "Invalid item price of $%.2f: price cannot be negative.".formatted(itemPrice);
        if (moneyInserted < 0)
            return "Invalid amount %.2f inserted, negative values are not accepted.".formatted(moneyInserted);

        double changeOwed = moneyInserted - itemPrice;

        if (changeOwed < 0)
            return "Insufficient funds provided: $%.2f less than item price.".formatted(-changeOwed);
        // else
        return "Successful purchase: $%.2f change returned.".formatted(changeOwed);
    }

    private static String processChange(double[] itemPrices, double moneyInserted) {
        if (moneyInserted < 0)
            return "Invalid amount %.2f inserted, negative values are not accepted.".formatted(moneyInserted);

        double sumPrice = 0;
        for (double itemPrice : itemPrices) {
            if (itemPrice < 0)
                return "Invalid item price of $%.2f: price cannot be negative.".formatted(itemPrice);
            else
                sumPrice += itemPrice;
        }

        double changeOwed = moneyInserted - sumPrice;
        if (changeOwed < 0)
            return "Insufficient funds provided: $%.2f less than total price.".formatted(-changeOwed);
        // else
        return "Successful purchase: $%.2f change returned.".formatted(changeOwed);
    }
}