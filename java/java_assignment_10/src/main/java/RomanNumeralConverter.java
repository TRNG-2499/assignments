import java.util.Map;

class RomanNumeralConverter {
    // These should be the correct upper and lower bounds
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 3999;

    // Values and their numerals, largest first, including the subtractive pairs (CM, CD, XC, ...).
    private static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] SYMBOLS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    private static final Map<Character, Integer> SYMBOL_VALUES = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    public static String toRoman(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException(
                    "Number must be between " + MIN_VALUE + " and " + MAX_VALUE + ", but was " + number);
        }

        StringBuilder result = new StringBuilder();
        int remaining = number;
        // Greedy: repeatedly take the largest value that still fits.
        for (int i = 0; i < VALUES.length; i++) {
            while (remaining >= VALUES[i]) {
                result.append(SYMBOLS[i]);
                remaining -= VALUES[i];
            }
        }
        return result.toString();
    }

    public static Integer toInteger(String roman) {
        if (roman == null || roman.isBlank()) {
            throw new IllegalArgumentException("Roman numeral must not be null or blank");
        }

        String upper = roman.toUpperCase();
        int total = 0;
        for (int i = 0; i < upper.length(); i++) {
            Integer current = SYMBOL_VALUES.get(upper.charAt(i));
            if (current == null) {
                throw new IllegalArgumentException(
                        "Invalid character '" + roman.charAt(i) + "' in Roman numeral \"" + roman + "\"");
            }

            Integer next = i + 1 < upper.length() ? SYMBOL_VALUES.get(upper.charAt(i + 1)) : null;
            // A smaller symbol before a larger one is subtracted (IV = 4); otherwise it's added.
            if (next != null && current < next) {
                total -= current;
            } else {
                total += current;
            }
        }

        // Reject malformed numerals like "IIII" or "VX": a valid one must match its canonical form.
        if (total < MIN_VALUE || total > MAX_VALUE || !toRoman(total).equals(upper)) {
            throw new IllegalArgumentException("Malformed Roman numeral \"" + roman + "\"");
        }
        return total;
    }
}
