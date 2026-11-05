import java.util.LinkedHashMap;

public class VendingMachine {

    public static String validateInput(double price, double moneyIn) {
        if (price < 0) {
            return "Invalid input. Item price cannot be negative.";
        } else if (moneyIn < 0) {
            return "Invalid input. Money inserted cannot be negative.";
        } else if (moneyIn < price) {
            String differenceNeeded = String.format("%.2f", (price - moneyIn));
            String finalString = "Insufficient funds. Please insert " + "$" + differenceNeeded + " more.";
            return finalString;
        } else {
            String changeDue = String.format("%.2f", (moneyIn - price));
            String finalString = "Purchase successful. " + "Change due: $" + changeDue;
            return finalString;
        }
    }


    // Stretch goal method #1
    // I used method overloading here just for practice
    // Just used a simple for loop to get the sum of every item of the price list / array
    public static String validateInput(double[] priceList, double moneyIn) {
        if (moneyIn < 0) {
            String errString = "Invalid input. Money inserted cannot be negative.";
            return errString;
        }

        double sumPrice = 0;
        for (double v : priceList) {
            if (v < 0) {
                String errString = "Invalid input. Item price in list cannot be negative.";
                return errString;
            }
            sumPrice += v;
        }

        if (moneyIn < sumPrice) {
            String differenceNeeded = String.format("%.2f", (sumPrice - moneyIn));
            String finalString = "Insufficient funds. Please insert " + "$" + differenceNeeded + " more.";
            return finalString;
        } else {
            String changeDue = String.format("%.2f", (moneyIn - sumPrice));
            String finalString = "Purchase successful. " + "Change due: $" + changeDue;
            return finalString;
        }
    }


    // Stretch goal method #2
    // Wasn't sure what the parameters of this function were so I just assumed it
    // takes an item price and money inserted amount.
    //
    // Also assumed that this function should only ever be called when there is non-zero
    // change left-over so I made sure to add edge cases to convey that.
    //
    // Created a LinkedHashMap to act as a frequency map to store the count per
    // denomination, while maintaining insertion order (just for easier readable)
    //
    // Looped through each denomination and ran an inner while loop to exhaust
    // the number of times each value can "go into" the current remaining change
    public static void denominationBreakdown(double price, double moneyIn) {
        if (moneyIn < price) {
            System.out.println("Insufficient funds. Not applicable to this method.");
            return;
        }
        if (price < 0) {
            System.out.println("Invalid input. Item price in list cannot be negative.");
            return;
        }

        LinkedHashMap<String, Integer> frequencyMap = new LinkedHashMap<String, Integer>();

        double changeDue = moneyIn - price;
        double remaining = changeDue;
        double[] denominations = new double[] {1.00, 0.25, 0.10, 0.05, 0.01};
        for (double v : denominations) {
            String d = String.format("%.2f", v);

            if (frequencyMap.get(d) == null) {
                frequencyMap.put(d, 0);
            }

            // This introduces a rounding error tolerance limit to workaround the problem
            while (remaining >= v - 0.00001) {
                remaining -= v;
                
                if (frequencyMap.get(d) == 0) {
                    frequencyMap.put(d, 1);
                } else {
                    frequencyMap.put(d, frequencyMap.get(d) + 1);
                }
            }
        }

        System.out.println(frequencyMap);
    }


    public static void main(String[] args) {
        // Test case for base vending machine input validation
        String result1 = validateInput(20, 20);
        System.out.println(result1);

        // Test case for stretch method #1
        String result2 = validateInput(new double[] {1, 2, 3, 4, 5}, 20.50);
        System.out.println(result2);

        // Test case for stretch method #2
        // Expected: 1.00:2, 0.25:3, 0.10:0, 0.05:0, 0.01:2
        denominationBreakdown(10, 12.77);
    }
}
