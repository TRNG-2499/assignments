// These values are ordered largest to smallest so toRoman tries the
// biggest match first. The value 900 handles the special pair CM.

public class RomanNumeralConverter {
    private static final int[] VALUES = {
        1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    };

    // Each symbol matches the value at the same index. For example,
    // VALUES[1] is 900 and SYMBOLS[1] is "CM".

    private static final String[] SYMBOLS = {
        "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    };



    
    // Convert a number to uppercase Roman numerals using the largest value that fits.
    public static String toRoman(int number) {
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("Number must be between 1 and 3999.");
        }

        StringBuilder roman = new StringBuilder();

        // Use the largest symbol or pair that fits, then convert what is left.
        for (int i = 0; i < VALUES.length; i++) {
            while (number >= VALUES[i]) {
                roman.append(SYMBOLS[i]);
                number -= VALUES[i];
            }
        }

        return roman.toString();
    }


    // Read from right to left and subtract a smaller symbol before a larger one.
    // For example, IV is 5 minus 1.

    public static int toInteger(String roman) {
        if (roman == null || roman.isEmpty()) {
            throw new IllegalArgumentException("Enter a Roman numeral.");
        }

        long total = 0;
        int nextValue = 0;

        // Read from right to left. In IV, the I is smaller than the V, so subtract it.
        for (int i = roman.length() - 1; i >= 0; i--) {
            int value = symbolValue(roman.charAt(i));

            if (value < nextValue) {
                total -= value;
            } else {
                total += value;
            }

            nextValue = value;
        }

        if (total < 1 || total > 3999) {
            throw new IllegalArgumentException("Roman numeral value must be between 1 and 3999.");
        }

        return (int) total;
    }



    // Give uppercase and lowercase letters the same value.
    // This helper is private because only the converter uses it.
    
    private static int symbolValue(char symbol) {
        switch (symbol) {
            case 'I': case 'i': return 1;
            case 'V': case 'v': return 5;
            case 'X': case 'x': return 10;
            case 'L': case 'l': return 50;
            case 'C': case 'c': return 100;
            case 'D': case 'd': return 500;
            case 'M': case 'm': return 1000;
            default: throw new IllegalArgumentException("Invalid Roman numeral character: " + symbol);
        }
    }
}