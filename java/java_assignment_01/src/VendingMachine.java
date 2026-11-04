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

        System.out.println("\n/// Stretch goals ///");
        System.out.println(processChange(new double[]{2.18, 1.14, 0.22}, 3.50)); // insufficient funds
        System.out.println(processChange(new double[]{2.18, 1.14, 0.22}, 4.50)); // 0.96 change
        System.out.println(processChange(new double[]{9.99, 1.49, 0.99}, 12.50)); // 0.03 change
        System.out.println(processChange(new double[]{9.99, 1.49, 0.99}, 12.47)); // 0.00 change

        System.out.println();
        System.out.println("2.17 - " + calcDenominations(2.17)); // 2 dollars 1 dime 1 nickel 2 pennies
        System.out.println("4.01 - " + calcDenominations(4.01)); // 4 dollars 1 penny
        System.out.println("1.50 - " + calcDenominations(1.50)); // 1 dollar 2 quarters
        System.out.println("0.01 - " + calcDenominations(0.01)); // 1 penny
        System.out.println("0.34 - " + calcDenominations(0.34)); // 1 quarter 1 nickel 4 pennies
    }

    // single item
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

    // overloaded for array of items
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

    private static String calcDenominations(double changeAmount) {
        int dollars = 0, quarters = 0, dimes = 0, nickels = 0, pennies = 0;

        while (changeAmount - 1.0 >= 0) {
            changeAmount -= 1.0;
            dollars++;
        }
        while (changeAmount - 0.25 >= 0) {
            changeAmount -= 0.25;
            quarters++;
        }
        while (changeAmount - 0.10 >= 0) {
            changeAmount -= 0.10;
            dimes++;
        }
        while (changeAmount - 0.05 >= 0) {
            changeAmount -= 0.05;
            nickels++;
        }
        while (changeAmount - 0.01 >= 0
                || Math.abs(changeAmount - 0.01) < 0.001) { // dealing with floating point errors
            changeAmount -= 0.01;
            pennies++;
        }

        String message = "Change owed:";
        if (dollars > 0)
            message += " %d %s".formatted(dollars, dollars == 1 ? "dollar" : "dollars");
        if (quarters > 0)
            message += " %d %s".formatted(quarters, quarters == 1 ? "quarter" : "quarters");
        if (dimes > 0)
            message += " %d %s".formatted(dimes, dimes == 1 ? "dime" : "dimes");
        if (nickels > 0)
            message += " %d %s".formatted(nickels, nickels == 1 ? "nickel" : "nickels");
        if (pennies > 0)
            message += " %d %s".formatted(pennies, pennies == 1 ? "penny" : "pennies");

        return message;
    }
}