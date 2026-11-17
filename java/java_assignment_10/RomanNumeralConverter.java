public class RomanNumeralConverter {

    private static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] SYMBOLS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String toRoman(int number) {
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("Number must be between 1 and 3999");
        }
        String result = "";
        for (int i = 0; i < VALUES.length; i++) {
            while (number >= VALUES[i]) {
                result += SYMBOLS[i];
                number -= VALUES[i];
            }
        }
        return result;
    }

    public static int toInteger(String roman) {
        if (roman == null || roman.isEmpty()) {
            throw new IllegalArgumentException("Roman numeral cannot be null or empty");
        }
        roman = roman.toUpperCase();
        int total = 0;
        int previous = 0;
        for (int i = 0; i < roman.length(); i++) {
            char letter = roman.charAt(i);
            int value;
            if (letter == 'I') {
                value = 1;
            } else if (letter == 'V') {
                value = 5;
            } else if (letter == 'X') {
                value = 10;
            } else if (letter == 'L') {
                value = 50;
            } else if (letter == 'C') {
                value = 100;
            } else if (letter == 'D') {
                value = 500;
            } else if (letter == 'M') {
                value = 1000;
            } else {
                throw new IllegalArgumentException("Invalid Roman numeral: " + roman);
            }
            if (value > previous) {
                total += value - 2 * previous;
            } else {
                total += value;
            }
            previous = value;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(toRoman(4));
        System.out.println(toRoman(1994));
        System.out.println(toRoman(3999));
        System.out.println(toInteger("XLII"));
        System.out.println(toInteger("mcmxciv"));
    }
}
