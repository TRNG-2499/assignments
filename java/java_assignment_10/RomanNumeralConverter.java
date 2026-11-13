public class RomanNumeralConverter {

    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String toRoman(int number) {
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("Number must be between 1 and 3999.");
        }

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                roman.append(symbols[i]);
                number -= values[i];
            }
        }

        return roman.toString();
    }

    public static int toInteger(String roman) {
        if (roman == null || roman.isEmpty()) {
            throw new IllegalArgumentException("Roman numeral must not be null or empty.");
        }

        roman = roman.toUpperCase();
        int number = 0;
        int index = 0;

        while (index < roman.length()) {
            boolean matched = false;
            for (int i = 0; i < symbols.length; i++) {
                if (roman.startsWith(symbols[i], index)) {
                    number += values[i];
                    index += symbols[i].length();
                    matched = true;
                    break;
                }
            }

            if (!matched) {
                throw new IllegalArgumentException("Invalid Roman numeral: " + roman);
            }

            if (number > 3999) {
                throw new IllegalArgumentException("Roman numeral must represent a value between 1 and 3999.");
            }
        }

        if (!toRoman(number).equals(roman)) {
            throw new IllegalArgumentException("Invalid Roman numeral: " + roman);
        }

        return number;
    }
}
