package com.revature;

public class RomanNumeralConverter {
    // smallest and largest numbers that can be written as a standard roman numeral
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 3999;

    // ordered largest to smallest, with the subtractive pairs (CM, CD, ...) included,
    // so toRoman can always take the biggest value that still fits
    private static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] LETTERS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    // normal solution
    public static String toRoman(int num) {
        if (num < MIN_VALUE || num > MAX_VALUE) {
            throw new IllegalArgumentException(
                    "Number must be between " + MIN_VALUE + " and " + MAX_VALUE + ": " + num);
        }

        // StringBuilder avoids making a new String every time a letter is added
        StringBuilder romanNum = new StringBuilder();
        for (int i = 0; i < VALUES.length; i++) {
            // repeats a letter as many times as it fits, e.g. 3000 -> MMM
            while (num >= VALUES[i]) {
                romanNum.append(LETTERS[i]);
                num -= VALUES[i];
            }
        }
        return romanNum.toString();
    }

    // normal solution
    public static int toInteger(String roman) {
        if (roman == null || roman.isBlank()) {
            throw new IllegalArgumentException("Roman numeral must not be null or blank");
        }

        // input is case-insensitive, so "xiv" and "XIV" are read the same way
        String upper = roman.toUpperCase();
        int total = 0;
        for (int i = 0; i < upper.length(); i++) {
            int current = valueOf(upper.charAt(i));
            // a smaller letter before a larger one is subtracted, like the I in IV (4) or the C in CM (900)
            if (i + 1 < upper.length() && current < valueOf(upper.charAt(i + 1))) {
                total -= current;
            } else {
                total += current;
            }
        }

        // stretch goal 1
        // every number from 1 to 3999 has exactly one standard numeral, so if converting the total
        // back doesn't give the same letters, the input was non-standard (IIII, VV, IC, VX, ...)
        if (total < MIN_VALUE || total > MAX_VALUE || !toRoman(total).equals(upper)) {
            throw new IllegalArgumentException("Not a standard Roman numeral: " + roman);
        }
        return total;
    }

    // stretch goal 2
    public static String add(String a, String b) {
        // toInteger already throws for invalid input, so both numerals are checked here
        int sum = toInteger(a) + toInteger(b);
        if (sum > MAX_VALUE) {
            throw new IllegalArgumentException("Sum must not be greater than " + MAX_VALUE + ": " + sum);
        }
        return toRoman(sum);
    }

    // normal solution
    // value of a single uppercase letter, used by toInteger
    private static int valueOf(char letter) {
        switch (letter) {
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
                // covers digits, spaces, symbols, and letters that aren't roman numerals
                throw new IllegalArgumentException("Invalid Roman numeral character: '" + letter + "'");
        }
    }
}
