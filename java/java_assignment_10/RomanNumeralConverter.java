
// Author: Tyler Pyrzenski

public class RomanNumeralConverter {
    public static void main(String[] args) {


        System.out.println(toRoman(3888));
        System.out.println(toInteger("IX"));
        System.out.println(add("XIV", "VI"));



    }

    public static String toRoman(int number) {
        StringBuilder finalString = new StringBuilder();
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("Invalid input entry. Constraints between 1 and 3999.");
        }
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < values.length; i++ ) {
            while (number >= values[i]) {
                finalString.append(symbols[i]);
                number -= values[i];
            }
        }
        return finalString.toString();
    }

    public static int toInteger(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty.");
        }
        input = input.toUpperCase();
        int finalInteger = 0;
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            int currentWorth = valueOf(current);
            int nextWorth = 0;
            if (i + 1 < input.length()) {
                char next = input.charAt(i+1);
                nextWorth = valueOf(next);
            }

            if (currentWorth < nextWorth) {
                finalInteger -= currentWorth;
            } else {
                finalInteger += currentWorth;
            }
        }

        // strict check. if converting back doesnt give the same numeral its not written the standard way
        if (finalInteger < 1 || finalInteger > 3999 || !toRoman(finalInteger).equals(input)) {
            throw new IllegalArgumentException("Not a standard roman numeral: " + input);
        }
        return finalInteger;
    }

    public static String add(String a, String b) {
        int sum = toInteger(a) + toInteger(b);
        if (sum > 3999) {
            throw new IllegalArgumentException("Sum cannot be greater than 3999.");
        }
        return toRoman(sum);
    }

    public static int valueOf(Character numToChange) {
        switch (numToChange) {
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
                throw new IllegalArgumentException("Not a valid roman numeral: " + numToChange);
        }
    }
}