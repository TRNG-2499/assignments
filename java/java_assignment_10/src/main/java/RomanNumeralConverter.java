import java.util.Map;
import java.util.HashMap;

public class RomanNumeralConverter {
    private static final Map<Character, Integer> mapping = new HashMap<>();
    static {
        mapping.put('I', 1);
        mapping.put('V', 5);
        mapping.put('X', 10);
        mapping.put('L', 50);
        mapping.put('C', 100);
        mapping.put('D', 500);
        mapping.put('M', 1000);
    }
    
    /**
     * Converts a number to a roman numeral.
     * @param number The number
     * @throws IllegalArgumentException When the input is invalid
     * @return The roman numeral value of the number. 
     */
    public static String toRoman(int number) {
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("Invalid input: number must be greater than 0");
        }

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (number >=  values[i]) {
                number  -= values[i];
                res.append(symbols[i]);
            }
        }
        return res.toString();
    }

    /**
     * Converts a roman numeral to int.
     * @param roman The roman numeral
     * @throws IllegalArgumentException When the input is invalid
     * @return The integer value of the roman numeral. 
     */
    public static int toInteger(String roman) {
        if (roman == null || roman.isEmpty()) {
            throw new IllegalArgumentException("Invalid input");
        }

        int total = 0;
        for (int i = 0; i < roman.length(); i++) {
            char current = Character.toUpperCase(roman.charAt(i));
            if (!mapping.containsKey(current)) {
                throw new IllegalArgumentException("Invalid input: " + current + " is not a valid roman numeral.");
            } 

            int currentVal = mapping.get(current);
            if (i < roman.length() - 1) {
                char next = Character.toUpperCase(roman.charAt(i + 1));
                if (!mapping.containsKey(next)) {
                    throw new IllegalArgumentException("Invalid input: " + next + " is not a valid roman numeral.");
                } 

                int nextVal = mapping.get(next);
                if (currentVal < nextVal) {
                    total -= currentVal;
                } else {
                    total += currentVal;
                }
            } else {
                total += currentVal;
            }
        }
        return total;
    }
}