package com.lmgb;

public class RomanNumeralConverter {

    private static final int[] baseValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    
    private static int symToVal(char c) {
        return switch(c) {
            case 'M' -> 1000;
            case 'D' -> 500;
            case 'C' -> 100;
            case 'L' -> 50;
            case 'X' -> 10;
            case 'V' -> 5;
            case 'I' -> 1;
            default -> 0;
        };
    }

    public static String toRoman(int number) throws IllegalArgumentException {
        if (number <= 0 || number > 3999) {
            throw new IllegalArgumentException("Number must be between 1 and 3999");
        }

        StringBuilder res = new StringBuilder();

        for (int i = 0; number > 0 && i < baseValues.length; i++) {
            while (number >= baseValues[i]) {
                res.append(symbols[i]);
                number -= baseValues[i];
            }
        }

        return res.toString();
    }

    public static int toInteger(String roman) throws IllegalArgumentException {
        int res = 0;

        if (roman == null || roman.length() == 0) {
                throw new IllegalArgumentException("All characters must be valid roman numerals");
        }

        roman = roman.toUpperCase();

        int lv = Integer.MAX_VALUE;
        int n = roman.length();
        for (int i = 0; i < n; i++) {
            int val = symToVal(roman.charAt(i));
            if (val > lv) {
                val -= lv * 2;
            }
            lv = val;
            
            res += val;
            if (val == 0) {
                throw new IllegalArgumentException("All characters must be valid roman numerals");
            }
            if (res < 1 || res > 3999) {
                throw new IllegalArgumentException("Value of roman numeral must be between 1 and 3999");
            }
        }

        if (toRoman(res).compareTo(roman) != 0) {
            throw new IllegalArgumentException("Roman numeral must be valid");
        }

        return res;
    }

    public static String add(String a, String b) throws IllegalArgumentException {
        return toRoman(toInteger(a) + toInteger(b));
    }
}
