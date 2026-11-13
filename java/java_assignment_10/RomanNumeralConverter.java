import java.util.Locale;

public class RomanNumeralConverter {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 3999;

    private static final int[] VALUES =
            {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] SYMBOLS =
            {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    private RomanNumeralConverter() {}
        public static String toRoman(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException("Number must be between " + MIN_VALUE
                    + " and " + MAX_VALUE + ", but was " + number + ".");
        }

        StringBuilder result = new StringBuilder();
        int remaining = number;

        for (int i = 0; i < VALUES.length; i++) {
            while (remaining >= VALUES[i]) {
                result.append(SYMBOLS[i]);
                remaining -= VALUES[i];
            }
        }
        return result.toString();
    }
    public static int toInteger(String roman) {
        if (roman == null || roman.isBlank()) {
            throw new IllegalArgumentException("Roman numeral must not be null or blank.");
        }

        String upper = roman.toUpperCase(Locale.ROOT);
        int total = 0;

        for (int i = 0; i < upper.length(); i++) {
            int current = symbolValue(upper.charAt(i), roman, i);
            if (i + 1 < upper.length() && current < symbolValue(upper.charAt(i + 1), roman, i + 1)) {
                total -= current;
            } else {
                total += current;
            }
        }

        if (total < MIN_VALUE || total > MAX_VALUE) {
            throw new IllegalArgumentException("\"" + roman + "\" is outside the supported range ("
                    + MIN_VALUE + " to " + MAX_VALUE + ").");
        }

        String expected = toRoman(total);
        if (!expected.equals(upper)) {
            throw new IllegalArgumentException("\"" + roman + "\" is not a correctly formed "
                    + "Roman numeral. Did you mean \"" + expected + "\"?");
        }

        return total;
    }

    private static int symbolValue(char c, String original, int position) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default:
                throw new IllegalArgumentException("\"" + original + "\" is not a valid Roman numeral: "
                        + "invalid character '" + original.charAt(position) + "' at position "
                        + (position + 1) + ". Only I, V, X, L, C, D and M are allowed.");
        }
    }
}
