import java.util.Locale;

public class RomanNumeralConverter {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 3999;

    // Ordered largest to smallest, including the six subtractive pairs,
    // so toRoman can greedily take the largest piece that still fits.
    private static final int[] VALUES =
            {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] SYMBOLS =
            {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    private RomanNumeralConverter() {
        // Utility class; not meant to be instantiated.
    }

    public static String toRoman(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException(
                    "Number must be between " + MIN_VALUE + " and " + MAX_VALUE + ", but was " + number + ".");
        }

        StringBuilder roman = new StringBuilder();
        int remaining = number;
        for (int i = 0; i < VALUES.length; i++) {
            while (remaining >= VALUES[i]) {
                roman.append(SYMBOLS[i]);
                remaining -= VALUES[i];
            }
        }
        return roman.toString();
    }

    public static int toInteger(String roman) {
        if (roman == null || roman.isBlank()) {
            throw new IllegalArgumentException("Roman numeral must not be null or empty.");
        }

        String numeral = roman.toUpperCase(Locale.ROOT);
        int total = 0;
        for (int i = 0; i < numeral.length(); i++) {
            int current = valueOf(numeral.charAt(i), roman);
            boolean smallerThanNext = i + 1 < numeral.length()
                    && current < valueOf(numeral.charAt(i + 1), roman);
            // A smaller letter in front of a larger one is subtracted (the I in IV).
            total += smallerThanNext ? -current : current;
        }

        // Strict validation: every value has exactly one standard spelling, so the
        // input is only valid if it matches what toRoman produces for its value.
        boolean inRange = total >= MIN_VALUE && total <= MAX_VALUE;
        if (!inRange || !toRoman(total).equals(numeral)) {
            throw new IllegalArgumentException(
                    "\"" + roman + "\" is not a standard Roman numeral.");
        }
        return total;
    }

    public static String add(String a, String b) {
        int sum = toInteger(a) + toInteger(b);
        if (sum > MAX_VALUE) {
            throw new IllegalArgumentException(
                    "The sum " + sum + " is too large; Roman numerals only go up to " + MAX_VALUE + ".");
        }
        return toRoman(sum);
    }

    private static int valueOf(char letter, String original) {
        switch (letter) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default:
                throw new IllegalArgumentException(
                        "Invalid character '" + letter + "' in Roman numeral \"" + original + "\".");
        }
    }
}
