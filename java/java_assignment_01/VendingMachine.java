import java.util.List;

public class VendingMachine {

    // ---------- Base activity ----------
    public static String processPurchase(double price, double amountInserted) {
        if (price < 0) {
            return "Invalid input: item price cannot be negative.";
        }
        if (amountInserted < 0) {
            return "Invalid input: amount inserted cannot be negative.";
        }
        if (amountInserted < price) {
            return String.format("Insufficient funds. Please insert $%.2f more.",
                    price - amountInserted);
        }
        return String.format("Purchase successful. Change due: $%.2f",
                amountInserted - price);
    }

    // ---------- Stretch 1: multiple items / running total ----------
    public static String processMultiplePurchase(List<Double> prices, double amountInserted) {
        if (prices == null || prices.isEmpty()) {
            return "Invalid input: no items were provided.";
        }
        double total = 0;
        for (double p : prices) {
            if (p < 0) {
                return "Invalid input: item price cannot be negative.";
            }
            total += p;
        }
        if (amountInserted < 0) {
            return "Invalid input: amount inserted cannot be negative.";
        }
        if (amountInserted < total) {
            return String.format("Insufficient funds. Total is $%.2f. Please insert $%.2f more.",
                    total, total - amountInserted);
        }
        return String.format("Purchase successful. Total: $%.2f. Change due: $%.2f",
                total, amountInserted - total);
    }

    // ---------- Stretch 2: making change in denominations ----------
    public static String makeChange(double changeOwed) {
        if (changeOwed < 0) {
            return "Invalid input: change amount cannot be negative.";
        }
        // Work in whole cents to avoid floating-point errors
        long cents = Math.round(changeOwed * 100);

        int[] values = { 100, 25, 10, 5, 1 };
        String[] names = { "dollar(s)", "quarter(s)", "dime(s)", "nickel(s)", "penny/pennies" };

        StringBuilder sb = new StringBuilder(String.format("Change of $%.2f:", changeOwed));
        if (cents == 0) {
            return sb.append(" no coins needed.").toString();
        }
        for (int i = 0; i < values.length; i++) {
            long count = cents / values[i];
            cents %= values[i];
            if (count > 0) {
                sb.append("\n  ").append(count).append(" ").append(names[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(processPurchase(1.50, 2.00));
        System.out.println(processPurchase(1.50, 1.00));
        System.out.println(processPurchase(1.50, 1.50));
        System.out.println(processPurchase(1.50, -1.00));
        System.out.println(processPurchase(-1.50, 1.00));

        System.out.println(processMultiplePurchase(List.of(1.50, 2.25, 0.75), 5.00));
        System.out.println(processMultiplePurchase(List.of(1.50, 2.25, 0.75), 3.00));

        System.out.println(makeChange(0.67));
        System.out.println(makeChange(1.41));
    }
}