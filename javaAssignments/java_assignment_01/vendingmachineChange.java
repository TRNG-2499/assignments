package javaAssignments.java_assignment_01;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class vendingmachineChange {
    public static void main(String[] args) {
        /* //TEST STATEMENTS

        //normal purchase
        System.out.println(calculateChange(10.0, 4.75));

        //negative vals
        System.out.println(calculateChange(-10.0, 4.7));

        //insufficient funds
        System.out.println(calculateChange(3.0, 4.0));
        
        //buying multiple items
        System.out.println(buyingMultiple(10.0, new double[]{4.75, 2.25}));

        //insufficient funds for multiple items
        System.out.println(buyingMultiple(5.0, new double[]{4.75, 2.25}));

        //negative values for multiple items
        System.out.println(buyingMultiple(10.0, new double[]{-4.75, 2.25}));

        //all negative values for multiple items
        System.out.println(buyingMultiple(10.0, new double[]{-4.75, -2.25}));
        */

        //return change denominations
        System.out.println(returnChangeDenoms(new BigDecimal("10.0"), new BigDecimal("4.75")));

        //change denoms negatives
        System.out.println(returnChangeDenoms(new BigDecimal("-10.0"), new BigDecimal("4.75")));

        //change denoms insufficient funds
        System.out.println(returnChangeDenoms(new BigDecimal("3.0"), new BigDecimal("4.0")));

        //change denoms exact amount
        System.out.println(returnChangeDenoms(new BigDecimal("4.75"), new BigDecimal("4.75")));

        //change denoms funny rounding numbers
        System.out.println(returnChangeDenoms(new BigDecimal("10.0"), new BigDecimal("3.65")));
    }
        public static String calculateChange(double amountReceived, double itemPrice) {

            //input validation
            if (amountReceived < 0 || itemPrice < 0) {
                return "Invalid input. Please enter non-negative values.";
            }

            //offering return values based on the amount received and item price
            if (amountReceived >= itemPrice) {
                return "Purchase Successful. Change: $" + (amountReceived - itemPrice);
            } else {
                return "Insufficient funds. Please insert $" + (itemPrice - amountReceived) + " more";
            }
    }

        public static String buyingMultiple(BigDecimal amountReceived, BigDecimal[] itemPrice) {

            //input validation
            for (BigDecimal price : itemPrice) {
                if (price.compareTo(BigDecimal.ZERO) < 0) {
                    return "Invalid input. Please enter non-negative values.";
                }
            }

            //determine total cost of items
            BigDecimal totalCost = BigDecimal.ZERO;
            for (BigDecimal price : itemPrice) {
                totalCost = totalCost.add(price);
            }

            //offering return values based on the amount received and total cost
            if (amountReceived.compareTo(totalCost) >= 0) {
                return "Purchase Successful. Change: $" + amountReceived.subtract(totalCost);
            } else {
                return "Insufficient funds. Please insert $" + totalCost.subtract(amountReceived) + " more";
            }
        }

        public static String returnChangeDenoms (BigDecimal amountReceived, BigDecimal itemPrice) {

            //input validation
            if (amountReceived.compareTo(BigDecimal.ZERO) < 0 || itemPrice.compareTo(BigDecimal.ZERO) < 0) {
                return "Invalid input. Please enter non-negative values.";
            }

            //determine change
            BigDecimal change = amountReceived.subtract(itemPrice);
            if (change.compareTo(BigDecimal.ZERO) < 0) {
                return "Insufficient funds. Please insert $" + change.negate() + " more";
            }

            //calculate denominations
            //this looks much worse than I had wanted it to, however rounding errors on float values kept causing issues
            //working with BigDecimal lets me avoid rounding errors and floating point issues.
            //It is the preferred format for money
            BigDecimal ones = new BigDecimal("1.0");
            BigDecimal quarters = new BigDecimal("0.25");
            BigDecimal dimes = new BigDecimal("0.10");
            BigDecimal nickels = new BigDecimal("0.05");
            BigDecimal pennies = new BigDecimal("0.01");
            BigDecimal onesCount = change.divide(ones, 0, RoundingMode.DOWN);
            change = change.remainder(ones);
            BigDecimal quartersCount = change.divide(quarters, 0, RoundingMode.DOWN);
            change = change.remainder(quarters);
            BigDecimal dimesCount = change.divide(dimes, 0, RoundingMode.DOWN);
            change = change.remainder(dimes);
            BigDecimal nickelsCount = change.divide(nickels, 0, RoundingMode.DOWN);
            change = change.remainder(nickels);
            BigDecimal penniesCount = change.divide(pennies, 0, RoundingMode.DOWN);
            

            return "Change: " + onesCount + " ones, " + quartersCount + " quarters, " + dimesCount + " dimes, " + nickelsCount + " nickels, " + penniesCount + " pennies";
        }
}