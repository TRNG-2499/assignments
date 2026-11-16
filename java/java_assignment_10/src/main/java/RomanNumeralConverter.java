
public class RomanNumeralConverter {
    //roman numeral values and their corresponding symbols
    private static final int[] VALUES = {
            1000, 900, 500, 400, 100, 90,
            50, 40, 10, 9, 5, 4, 1
    };
    private static final String[] SYMBOLS = {
            "M", "CM", "D", "CD", "C", "XC",
            "L", "XL", "X", "IX", "V", "IV", "I"
    };

    //convert a integer into a Roman numeral
    public static String toRoman(int number) {
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException(
                    "Number must be between 1 and 3999."
            );
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < VALUES.length; i++) {
            while (number >= VALUES[i]) {
                result.append(SYMBOLS[i]);
                number -= VALUES[i];
            }
        }
        return result.toString();
    }

    //convert a Roman numeral into an integer
    public static int toInteger(String roman) {
        if (roman == null || roman.isBlank()) {
            throw new IllegalArgumentException(
                    "Roman numeral cannot be null or empty."
            );
        }

        roman = roman.toUpperCase();
        int total = 0;

        for (int i = 0; i < roman.length(); i++) {
            int current = getValue(roman.charAt(i));
            if (i + 1 < roman.length()) {
                int next = getValue(roman.charAt(i + 1));
                if (current < next) {
                    total -= current;
                } else {
                    total += current;
                }
            } else {
                total += current;
            }
        }

        if (total < 1 || total > 3999 ||
                !toRoman(total).equals(roman)) {
            throw new IllegalArgumentException(
                    "Invalid Roman numeral: " + roman
            );
        }
        return total;
    }

    //get the integer value of an individual Roman symbol
    private static int getValue(char symbol) {
        switch (symbol) {
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
                throw new IllegalArgumentException(
                        "Invalid Roman numeral character: " + symbol
                );
        }
    }
}
