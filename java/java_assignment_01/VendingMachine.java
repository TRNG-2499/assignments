import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class VendingMachine {

    public static final List<Double> denominations = List.of(
        100d,
        50d,
        20d,
        10d,
        5d,
        1d,
        .25,
        .10,
        .05,
        .01
    );

    public static String validateTransaction(double price, double inserted) {
        String res = new String();
        String invOut = "Invalid input: %s cannot be negative.";
        String insOut = "Insufficient funds. Please insert $%.2f more.";
        String succOut = "Purchase successful. Change due: $%.2f";
        if (price < 0) {
            res = String.format(invOut, "price");
        } else if (inserted < 0) {
            res = String.format(invOut, "amount inserted");
        } else {
            double d =
                BigDecimal
                    .valueOf(price - inserted)
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();
            
            if (d <= 0) {
                res = String.format(succOut, Math.abs(d));
            } else {
                res = String.format(insOut, d);
            }
        }

        System.out.println(res);
        return res;
    }

    public static String validateTransaction(double[] prices, double inserted) {
        double price =
            Arrays
                .stream(prices)
                .reduce(0, Double::sum);
        
        return validateTransaction(price, inserted);
    }

    public static HashMap<Double, Integer> changeToDenom(double change) {
        HashMap<Double, Integer> out = new HashMap<>();

        for (double d : denominations) {
            change =
                BigDecimal
                    .valueOf(change)
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();

            if (change <= 0) {
                break;
            }

            int i = 0;

            while ( d <= change) {
                change -= d;
                i++;
            }
            
            if (i > 0) {
                out.put(d, i);
            }
        }

        return out;
    }

    public static void main(String[] args) {
        validateTransaction(1.5, 2);
        validateTransaction(1.5, 1);
        validateTransaction(1.5, 1.5);
        validateTransaction(1.5, -1);
        
        System.out.println();
        
        double[] prices = {1.0, 0.25, 0.15, 0.05, 0.04, 0.01};
        validateTransaction(prices, 2);
        validateTransaction(prices, 1);
        validateTransaction(prices, 1.5);
        validateTransaction(prices, -1);


        System.out.println();

        System.out.println(changeToDenom(1.5).toString());
        System.out.println(changeToDenom(7.07).toString());
    }
}
