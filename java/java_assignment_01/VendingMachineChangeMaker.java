import java.util.List;

/**
 * Vending Machine Change Maker.
 *
 * Base method: makeChange(price, amountInserted)
 * Stretch goals: makeChangeForItems(prices, amountInserted)
 *                breakIntoDenominations(changeOwed)
 */
public class VendingMachineChangeMaker {

    /**
     * Decides the outcome of a single purchase: invalid input, insufficient funds,
     * or a successful purchase with change.
     */
    public static String makeChange(double price, double amountInserted) {
        if (price < 0) {
            return "Invalid input: item price cannot be negative.";
        }
        if (amountInserted < 0) {
            return "Invalid input: amount inserted cannot be negative.";
        }
        if (amountInserted < price) {
            return String.format("Insufficient funds. Please insert $%.2f more.", price - amountInserted);
        }
        return String.format("Purchase successful. Change due: $%.2f", amountInserted - price);
    }

    /**
     * Stretch goal: several items bought together, paid for with one amount.
     */
    public static String makeChangeForItems(List<Double> prices, double amountInserted) {
        if (prices == null || prices.isEmpty()) {
            return "Invalid input: no items selected.";
        }
        if (amountInserted < 0) {
            return "Invalid input: amount inserted cannot be negative.";
        }
        double total = 0;
        for (double price : prices) {
            if (price < 0) {
                return "Invalid input: item price cannot be negative.";
            }
            total += price;
        }
        if (amountInserted < total) {
            return String.format("Insufficient funds. Total is $%.2f. Please insert $%.2f more.",
                    total, total - amountInserted);
        }
        return String.format("Purchase successful. Total: $%.2f. Change due: $%.2f",
                total, amountInserted - total);
    }

    /**
     * Stretch goal: split change into the fewest $1.00, $0.25, $0.10, $0.05 and $0.01 pieces.
     * Works in whole cents to avoid floating-point rounding errors.
     */
    public static String breakIntoDenominations(double changeOwed) {
        if (changeOwed < 0) {
            return "Invalid input: change owed cannot be negative.";
        }
        long cents = Math.round(changeOwed * 100);
        int[] values = {100, 25, 10, 5, 1};
        String[] names = {"$1.00", "$0.25", "$0.10", "$0.05", "$0.01"};

        StringBuilder result = new StringBuilder(String.format("Change for $%.2f:", cents / 100.0));
        for (int i = 0; i < values.length; i++) {
            long count = cents / values[i];
            cents %= values[i];
            result.append(String.format("%n  %s x %d", names[i], count));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("--- Base method ---");
        System.out.println(makeChange(1.50, 2.00));   // Purchase successful. Change due: $0.50
        System.out.println(makeChange(1.50, 1.00));   // Insufficient funds. Please insert $0.50 more.
        System.out.println(makeChange(1.50, 1.50));   // Purchase successful. Change due: $0.00
        System.out.println(makeChange(1.50, -1.00));  // Invalid input: amount inserted cannot be negative.
        System.out.println(makeChange(-1.50, 2.00));  // Invalid input: item price cannot be negative.

        System.out.println("\n--- Stretch: multiple items ---");
        System.out.println(makeChangeForItems(List.of(1.25, 0.75, 2.00), 5.00));
        System.out.println(makeChangeForItems(List.of(1.25, 0.75, 2.00), 3.00));

        System.out.println("\n--- Stretch: denominations ---");
        System.out.println(breakIntoDenominations(2.91));
    }
}
