package com.assignment10;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralConverter {
    public static int[] numberArray = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public static String[] numeralArray = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public static HashMap<String, Integer> rnMap = new HashMap<>(
        Map.ofEntries(
            Map.entry("M", 1000),
            Map.entry("D", 500),
            Map.entry("C", 100),
            Map.entry("L", 50),
            Map.entry("X", 10),
            Map.entry("V", 5),
            Map.entry("I", 1)
        )
    );

    public static String toRoman(int number) {
        if (number <= 0 || number > 3999) {
            throw new IllegalArgumentException("Invalid number, must be between 1 - 3999");
        }

        StringBuilder strBuild = new StringBuilder();

        for (int idx = 0; idx < numberArray.length; idx++) {
            while (number >= numberArray[idx]) {
                strBuild.append(numeralArray[idx]);
                number -= numberArray[idx];
            }
        }

        return strBuild.toString();
    }


    public static int toInteger(String roman) {

        // Input validation checks
        if (roman == null || roman.length() == 0 ){
            throw new IllegalArgumentException("Input string cannot be null or empty");
        }

        roman = roman.toUpperCase();
        char[] charArray = roman.toCharArray();

        for (char c : charArray) {
            if (!rnMap.containsKey(Character.toString(c))) {
                throw new IllegalArgumentException("An invalid roman numeral character was used");
            }
        }

        int result = 0;

        for (int i = 0; i < charArray.length; i++) {
            int currVal = rnMap.get(Character.toString(charArray[i]));

            if (i == charArray.length - 1) {
                result += currVal;
                continue;
            }

            int nextVal = rnMap.get(Character.toString(charArray[i+1]));

            if (nextVal > currVal) {
                result -= currVal;
            } else {
                result += currVal;
            }
        }

        // If the roman numeral isn't reproducible from
        // the converted result, then it must be invalid
        if (!roman.equals(toRoman(result))) {
            throw new IllegalArgumentException("Input is not a standard roman numeral!");
        }

        return result;
    }


    public static String add(String a, String b) {
        a = a.toUpperCase();
        b = b.toUpperCase();

        if (toInteger(a) + toInteger(b) > 3999) {
            throw new IllegalArgumentException("Sum of inputs cannot exceed 3999!");
        }

        return toRoman(toInteger(a) + toInteger(b));
    }
}

