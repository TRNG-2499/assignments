import java.util.Arrays;
import java.util.List;

/**
 * Assignment 01 - Vending Machine Change Maker
 */

public class vending_machine {
    public static void main(String[] args) {
        /*
         * Testing Main Code
         */
        //String invalidItemPriceAndMoney = validatePurchase(-10, -10);
        //System.out.println(invalidItemPriceAndMoney);

        //String invalidItemPrice = validatePurchase(-10, 10);
        //System.out.println(invalidItemPrice);

        //String invalidMoney = validatePurchase(4, 3.50);
        //System.out.println(invalidMoney);

        //String successfulPurchase = validatePurchase(4, 4);
        //System.out.println(successfulPurchase);

        //String successfulPurchaseWithChange = validatePurchase(4, 4.50);
        //System.out.println(successfulPurchaseWithChange);

        /*
         * Testing Stretch Code
         */
        List<Double> itemPrices = Arrays.asList(3.0, 3.0, 4.0, 2.0);
        String stretchSuccessfulPurchaseWithChange = validatePurchaseStretch(itemPrices, 79.11);
        System.out.println(stretchSuccessfulPurchaseWithChange);
    }
    public static String validatePurchase(double itemPrice, double moneyGiven) {
        // Validate arguments
        if (itemPrice < 0 && moneyGiven < 0) {
            return "Invalid input: Item price and money given cannot be negative.";
        }
        else if (itemPrice < 0) {
            return "Invalid input: Item price cannot be negative.";
        }
        else if (moneyGiven < 0) {
            return "Invalid input: Money given cannot be negative.";
        }
        else if (moneyGiven < itemPrice) {
            String missingFunds = String.valueOf(itemPrice - moneyGiven);
            int numDecimals = missingFunds.length() - (missingFunds.indexOf('.') + 1);
            if (numDecimals < 2) {
                missingFunds = missingFunds + 0;
            }
            return "Insufficient funds. Please insert $" + missingFunds + ".";
        }
        else {
            // Successful purchase
            String owed = String.valueOf(moneyGiven - itemPrice);
            int numDecimals = owed.length() - (owed.indexOf('.') + 1);
            if (numDecimals < 2) {
                owed = owed + 0;
            }
            return "Successful Purchase! " + " $" + owed + " is your change.";
        }
    }

    public static String validatePurchaseStretch(List<Double> itemPrices, double moneyGiven) {
        double totalPrice = 0;
        for (double price : itemPrices) {
            totalPrice += price;
        }

        if (moneyGiven >= totalPrice) {
            // Successful purchase, calculate change
            double owed = Math.round((moneyGiven - totalPrice) * 100.0) / 100.0; // rounding to avoid decimal errors

            // Make sure $ has 2 trailing digits
            String owedString = String.valueOf(owed);
            int numDecimals = owedString.length() - (owedString.indexOf('.') + 1);
            if (numDecimals < 2) {
                owedString = owedString + "0";
            }
            StringBuilder sb = new StringBuilder("Successful Purchase! $");
            sb.append(owedString);
            sb.append(" will be returned with the following bills and change:\n");

            // Calculate amount of change and append to the message
            List<String> changeTypes = Arrays.asList("100.00", "50.00", "25.00", "10.00", "5.00", "1.00", "0.25", "0.10", "0.05", "0.01");
            int i = 0;
            for (String change : changeTypes) {
                double changeDouble = Double.parseDouble(change);
                int changeCount = 0;
                while (changeDouble <= owed) {
                    changeCount += 1;
                    owed = Math.round((owed - changeDouble) * 100.0) / 100.0; // Rounding to avoid decimal errors
                }
                if (changeCount > 0) {
                    if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append(changeCount);
                    sb.append("x $");
                    sb.append(change);
                    i++;
                }
            }
            return sb.toString();
        }
        else {
            // Invalid purchase, can return a response implemented in validatePurchase() function.
            return validatePurchase(totalPrice, moneyGiven);
        }
    }
}
