import java.math.BigDecimal;
import java.math.RoundingMode;

/*
 * Note on money and IEEE 754:
 * Java's double is an IEEE 754 64-bit binary floating-point number. Values like 0.1
 * have no exact binary form, so they are stored as the nearest approximation, and
 * small errors can add up (0.1 + 0.2 == 0.30000000000000004).
 *
 * Comparing the raw doubles can then give the wrong outcome. For example, price
 * 0.1 + 0.2 paid with 0.30 would report "Insufficient funds. Please insert $0.00 more."
 *
 * To avoid that, both inputs are converted to BigDecimal and rounded to whole cents
 * (2 decimal places) BEFORE they are compared or subtracted.
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
