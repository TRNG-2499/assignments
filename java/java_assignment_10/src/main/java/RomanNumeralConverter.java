/**
 * Converts between integers (1-3999) and Roman numerals.
 *
 * Work through RomanNumeralConverterTest one group at a time (Red -> Green ->
 * Refactor).
 */
public class RomanNumeralConverter {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 3999;

    // TODO: Decide how to store the numeral values. A hint: subtractive pairs
    // (CM, CD, XC, XL, IX, IV) can be treated as "symbols" too, listed
    // from largest to smallest alongside M, D, C, L, X, V, I.

    private RomanNumeralConverter() {
        // Utility class - no instances.
    }

    /**
     * Converts an integer to an uppercase Roman numeral.
     *
     * @param number a value from 1 to 3999
     * @return the Roman numeral, e.g. 1994 -> "MCMXCIV"
     * @throws IllegalArgumentException if number is outside 1-3999
     */
    public static String toRoman(int number) {
        // TODO: validate range and throw IllegalArgumentException with a clear message
        // TODO: build the numeral (StringBuilder) from the largest value down
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException("This number is not supported. Choose a number between 1 and 3999. ");
        }

        StringBuilder roman = new StringBuilder();
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                roman.append(symbols[i]);
                number -= values[i];
            }
        }

        return roman.toString();

    }

    /**
     * Converts a Roman numeral to an integer. Input is case-insensitive.
     *
     * @param roman a Roman numeral such as "XIV", "xiv" or "Xiv"
     * @return the integer value, e.g. "MCMXCIV" -> 1994
     * @throws IllegalArgumentException if roman is null, blank, or contains invalid
     *                                  characters
     */
    public static int toInteger(String roman) {
        if (roman == null || roman.isBlank()) {
            throw new IllegalArgumentException(roman + "Is an invalid entry, use a different roman numeral");
        }

        String upper = roman.toUpperCase();
        int total = 0;

        for (int i = 0; i < upper.length() - 1; i++) {
            int current = valueOf(upper.charAt(i));

            int next = valueOf(upper.charAt(i + 1));

            if (current < next) {
                total -= current;
            } else {
                total += current;

            }
        }
        total += valueOf(upper.charAt(upper.length() - 1));
        return total;
    }

    /**
     * Returns the value of a single Roman symbol.
     *
     * @throws IllegalArgumentException if c is not a valid Roman symbol
     */
    private static int valueOf(char c) {

        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new IllegalArgumentException("Invalid Roman numeral character: '" + c + "'");
        }

    }
}
