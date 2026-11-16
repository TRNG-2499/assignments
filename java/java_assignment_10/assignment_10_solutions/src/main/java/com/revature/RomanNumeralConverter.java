package com.revature;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RomanNumeralConverter {
    public static void main(String[] args) {

    }

    public static String toRoman(int number) {
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("Please enter a valid argument between the range of 1 an 3999");
        }
        int[] potentialNumbers = {
                1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };
        String[] romanSymbols = {
                "M", "CM",
                "D", "CD",
                "C", "XC",
                "L", "XL",
                "X", "IX",
                "V", "IV",
                "I"
        };

        StringBuilder romanString = new StringBuilder();

        for (int i = 0; i < potentialNumbers.length; i++) {
            while (number >= potentialNumbers[i]) {
                romanString.append(romanSymbols[i]);
                number -=  potentialNumbers[i];
            }

        }
        return romanString.toString();
    }

    public static int toInteger(String roman) {
        if (roman == null || roman.isEmpty()) {
            throw new IllegalArgumentException("Please enter a valid roman string.");
        }
        roman = roman.toUpperCase();

        int total = 0;

        Map<Character, Integer> arabicValue = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
        );
        List<Character> arabicValueStrings = new ArrayList<>(
                Arrays.asList('I', 'V', 'X', 'L', 'C', 'D', 'M')
        );

        // Iterate right to left through roman string
        int prevValue = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            char c = roman.charAt(i);
            if (!arabicValueStrings.contains(c)) {
               throw new IllegalArgumentException("Please enter a valid roman string.");
            }
            int cValue = arabicValue.get(c);

            if (cValue < prevValue) {
                total -= cValue;
            } else {
                total += cValue;
            }
            prevValue = cValue;
        }

        return total;
    }
}