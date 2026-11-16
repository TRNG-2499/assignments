
package com.idurus;

public class RomanNumeralConverter {

    // Converts an integer into a Roman numeral
    public static String toRoman(int number) {

        // Validate the number
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException(
                "Number must be between 1 and 3999"
            );
        }

        // Integer values and their corresponding Roman symbols
        int[] values = {
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4, 1
        };

        String[] symbols = {
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV", "I"
        };

        String result = new String();

        // Find the Roman symbols that make up the number
        for (int i = 0; i < values.length; i++) {

            while (number >= values[i]) {
                result += symbols[i];
                number -= values[i];
            }
        }

        return result.toString();
    }


    // Converts a Roman numeral into an integer
    public static int toInteger(String roman) {

        // Validate input
        if (roman == null || roman.isEmpty()) {
            throw new IllegalArgumentException(
                "Roman numeral cannot be null or empty"
            );
        }

        // Convert input to uppercase
        roman = roman.toUpperCase();

        int total = 0;

        // Read each Roman numeral character
        for (int i = 0; i < roman.length(); i++) {

            int current = getValue(roman.charAt(i));

            // Check the next character to handle subtraction
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

        // Validate the resulting number
        if (total < 1 || total > 3999) {
            throw new IllegalArgumentException(
                "Roman numeral must represent a number between 1 and 3999"
            );
        }

        // Ensure the input is a correctly formatted Roman numeral
        if (!toRoman(total).equals(roman)) {
            throw new IllegalArgumentException(
                "Invalid Roman numeral: " + roman
            );
        }

        return total;
    }


    // Returns the integer value of an individual Roman symbol
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
