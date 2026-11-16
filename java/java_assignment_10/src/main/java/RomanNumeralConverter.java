package com.example;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// run mvn clean test in folder java_assignment_10
// pom.xml is on jdk 25 if change is needed

public class RomanNumeralConverter {
    public static String toRoman(int number) {
        if (number <= 0 || number > 3999) {
            throw new IllegalArgumentException("Number must be 1-3999.");
        }

        StringBuilder output = new StringBuilder();
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

        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                output.append(symbols[i]);
                number -= values[i];
            }
        }

        return output.toString();
    }

    public static int toInteger(String roman) {
        if (roman == null || roman.isBlank()) {
            throw new IllegalArgumentException("Input cannot be null or empty.");
        }
        roman = roman.toUpperCase().trim();
        Pattern pattern = Pattern.compile("[^IVXLCDM]");
        Matcher matcher = pattern.matcher(roman);
        if(matcher.find()) {
            throw new IllegalArgumentException("Input must be a valid roman numeral");
        }
        
        int output = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = 0; i < roman.length(); i++) {
            int current = map.get(roman.charAt(i));

            if (i + 1 < roman.length() && current < map.get(roman.charAt(i + 1))) {
                output -= current;
            } else {
                output += current;
            }
        }

        return output;
    }
}
