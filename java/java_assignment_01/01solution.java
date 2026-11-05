import java.math.BigDecimal;
import java.math.RoundingMode;

/*
*
* *
* Some notes about what I learned doing this I was talking to Claude a lot about the IEE thing with Java when you add a float of .1 to a float of .2 it does not equal .3
* so if someone wanted to buy something for $.30, the Machine would always break and say they don’t have enough money. I also talk to it about how large financial institutions use it and it was talking about importing some Java,
* math like big decimal and rounding mode so this is the final version that I came up with basically, we create our static method with a make change argument that contains two doubles which is the price and the amount inserted and then we assign The big decimal value of our price,
* which will turn the double into a big decimal so we can store the number as the exact decimal instead of 1.49999. It will be a real 1.5.
*  We do this on both of these and it doesn’t need another set scale at the end because both values already have two decimal places then we do our standard checks of our number being negative
*  or inserting amount of money that’s negative and not having enough money and then if it passes those checks,
* the purchase is successful and then does it quick mathematical operation to do the change then we have some test cases in void main, and they’re expected outcomes which have been verified
*
*
*
*
*
 */
public static String makeChange(double price, double amountInserted) {
    BigDecimal p = BigDecimal.valueOf(price).setScale(2, RoundingMode.HALF_UP);
    BigDecimal a = BigDecimal.valueOf(amountInserted).setScale(2, RoundingMode.HALF_UP);

    if (p.signum() < 0) {
        return "Invalid input: item price cannot be negative.";
    }
    if (a.signum() < 0) {
        return "Invalid input: amount inserted cannot be negative.";
    }
    if (a.compareTo(p) < 0) {
        return "Insufficient funds. Please insert $" + p.subtract(a) + " more.";
    }
    return "Purchase successful. Change due: $" + a.subtract(p);
}

void main() {
    System.out.println(makeChange(1.50, 2.00));   // Purchase successful. Change due: $0.50
    System.out.println(makeChange(1.50, 1.00));   // Insufficient funds. Please insert $0.50 more.
    System.out.println(makeChange(1.50, 1.50));   // Purchase successful. Change due: $0.00
    System.out.println(makeChange(1.50, -1.00));  // Invalid input: amount inserted cannot be negative.
    System.out.println(makeChange(0.1 + 0.2, 0.30)); // IEEE 754 case: Purchase successful. Change due: $0.00
}
