//two doubles to be received via input
public class solution {
    public static void main(String[] args) {

        // original test cases using fundCheck
        System.out.println(fundCheck(2.00, 1.50));
        System.out.println(fundCheck(1.00, 1.50));
        System.out.println(fundCheck(1.50, 1.50));
        System.out.println(fundCheck(-1.00, 1.50));
        System.out.println(fundCheck(2.00, -5));
        System.out.println(fundCheck(1.10, 1));

        System.out.println();

        // stretch goal 1 test cases using multipleItemCheck
        // an array of item prices is passed in along with one amount inserted
        System.out.println(multipleItemCheck(5.00, new double[]{1.50, 2.25, 0.75}));
        System.out.println(multipleItemCheck(3.00, new double[]{1.50, 2.25, 0.75}));
        System.out.println(multipleItemCheck(4.50, new double[]{1.50, 2.25, 0.75}));
        System.out.println(multipleItemCheck(5.00, new double[]{1.50, -2.25}));
        System.out.println(multipleItemCheck(-5.00, new double[]{1.50, 2.25}));
        System.out.println(multipleItemCheck(5.00, new double[]{}));

        System.out.println();

        // stretch goal 2 test cases using changeInDenominations
        System.out.println(changeInDenominations(0.50));
        System.out.println(changeInDenominations(0.91));
        System.out.println(changeInDenominations(3.68));
        System.out.println(changeInDenominations(0.10000000000000009)); // the result of 1.10 - 1.00 in java
        System.out.println(changeInDenominations(0));
        System.out.println(changeInDenominations(-1.00));
    }
    public static String fundCheck(double input, double price) {
        double payBack;
        double insertMore;

        if (price < 0) {
            return "Input: Price = $" + String.format("%.2f", price) + ", Amount Inserted = $" + String.format("%.2f", input) + "\nOutput: Invalid input: Price cannot be negative.";
        } else {
            if (input < 0) {
                return "Input: Price = $" + String.format("%.2f", price) + ", Amount Inserted = $" + String.format("%.2f", input) + "\nOutput: Invalid input: amount inserted cannot be negative.";
            } else if (input == price) {
                return "Input: Price = $" + String.format("%.2f", price) + ", Amount Inserted = $" + String.format("%.2f", input) + "\nOutput: Purchase successful. Change due: $0.00";
            } else if (input > price){
                payBack = input - price;
                return "Input: Price = $" + String.format("%.2f", price) + ", Amount Inserted = $" + String.format("%.2f", input) + "\nOutput: Purchase successful. Change due: $" + String.format("%.2f", payBack);
            } else {
                insertMore = price - input;
                return "Input: Price = $" + String.format("%.2f", price) + ", Amount Inserted = $" + String.format("%.2f", input) + "\nOutput: Insufficient funds. Please insert $" + String.format("%.2f", insertMore) + " more.";
            }
        }
    }

    // stretch goal 1: multiple items / running total
    // accepts an array of item prices being bought together and one amount inserted
    // all the prices are added up first, then the total is compared to the amount inserted

    public static String multipleItemCheck(double input, double[] prices) {

        double totalPrice = 0; // running total of every item price
        double payBack;
        double insertMore;

        // building the price list for the input line so the user can see every item
        String priceList = "";

        for (int i = 0; i < prices.length; i++) {
            priceList = priceList + "$" + String.format("%.2f", prices[i]);
            if (i < prices.length - 1) {
                priceList = priceList + ", ";
            }
        }

        String inputLine = "Input: Prices = [" + priceList + "], Amount Inserted = $" + String.format("%.2f", input);

        // no items means there is nothing to buy, so it is treated as invalid instead of a $0.00 purchase
        if (prices.length == 0) {
            return inputLine + "\nOutput: Invalid input: no items were selected.";
        }

        // same negative input check as fundCheck
        if (input < 0) {
            return inputLine + "\nOutput: Invalid input: amount inserted cannot be negative.";
        }

        // looping through every price, any negative price makes the whole purchase invalid
        // otherwise the price gets added to the running total
        for (double price : prices) {
            if (price < 0) {
                return inputLine + "\nOutput: Invalid input: item price cannot be negative.";
            }
            totalPrice = totalPrice + price;
        }

        // same outcome checks as fundCheck, just using the total of every item instead of a single price
        if (input >= totalPrice) {
            payBack = input - totalPrice;
            return inputLine + "\nOutput: Total = $" + String.format("%.2f", totalPrice) + ". Purchase successful. Change due: $" + String.format("%.2f", payBack);
        } else {
            insertMore = totalPrice - input;
            return inputLine + "\nOutput: Total = $" + String.format("%.2f", totalPrice) + ". Insufficient funds. Please insert $" + String.format("%.2f", insertMore) + " more.";
        }
    }

    // stretch goal 2: making change in denominations
    // takes a change amount and breaks it down into the fewest bills and coins possible
    // works from the biggest denomination down, using as many of each as will fit before moving to the next one

    public static String changeInDenominations(double change) {

        String inputLine = "Input: Change = $" + String.format("%.2f", change);

        if (change < 0) {
            return inputLine + "\nOutput: Invalid input: change cannot be negative.";
        }

        // converting the dollar amount to whole cents to get around the floating point issue
        // for example 1.10 - 1.00 is actually 0.10000000000000009 as a double, but rounds cleanly to 10 cents
        int remainingCents = (int) Math.round(change * 100);

        if (remainingCents == 0) {
            return inputLine + "\nOutput: No change due.";
        }

        // denominations in cents, biggest to smallest, with matching labels at the same index
        int[] denominationCents = {100, 25, 10, 5, 1};
        String[] denominationLabels = {"$1.00", "$0.25", "$0.10", "$0.05", "$0.01"};

        String breakdown = "";

        for (int i = 0; i < denominationCents.length; i++) {
            // dividing tells how many of this denomination fit into what is left
            int count = remainingCents / denominationCents[i];

            // modulo gives what is left over after using that many of this denomination
            remainingCents = remainingCents % denominationCents[i];

            // only denominations that were actually used get reported
            if (count > 0) {
                if (!breakdown.isEmpty()) {
                    breakdown = breakdown + ", ";
                }
                breakdown = breakdown + denominationLabels[i] + " x " + count;
            }
        }

        return inputLine + "\nOutput: " + breakdown;
    }
}