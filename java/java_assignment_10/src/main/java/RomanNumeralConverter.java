import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeralConverter {
    private static final Map<Integer, String> ROMAN_NUMERALS = new LinkedHashMap<>();

    static {
        ROMAN_NUMERALS.put(1000, "M");
        ROMAN_NUMERALS.put(900, "CM");
        ROMAN_NUMERALS.put(500, "D");
        ROMAN_NUMERALS.put(400, "CD");
        ROMAN_NUMERALS.put(100, "C");
        ROMAN_NUMERALS.put(90, "XC");
        ROMAN_NUMERALS.put(50, "L");
        ROMAN_NUMERALS.put(40, "XL");
        ROMAN_NUMERALS.put(10, "X");
        ROMAN_NUMERALS.put(9, "IX");
        ROMAN_NUMERALS.put(5, "V");
        ROMAN_NUMERALS.put(4, "IV");
        ROMAN_NUMERALS.put(1, "I");
    }

    private static final Map<Character, Integer> ROMAN_VALUES = new HashMap<>();

    static {
        for (Map.Entry<Integer, String> entry : ROMAN_NUMERALS.entrySet()) {
            if (entry.getValue().length() == 1) {
                ROMAN_VALUES.put(entry.getValue().charAt(0), entry.getKey());
            }
        }
    }
    

    public static String toRoman(int number) {
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("Number must be between 1 and 3999");
        }
        StringBuilder result = new StringBuilder();
        int remaining = number;

        for (Map.Entry<Integer, String> entry : ROMAN_NUMERALS.entrySet()) {
            int coinValue = entry.getKey();
            String coinSymbol = entry.getValue();

            while (remaining >= coinValue) {
                result.append(coinSymbol);
                remaining -= coinValue;
            }
        }
    
        return result.toString();
    }

    
    public static int toInteger(String roman) {
        if (roman == null || roman.isEmpty()) {
            throw new IllegalArgumentException("Roman numeral cannot be null or empty");
        }
        roman = roman.toUpperCase();
        for (int i = 0; i < roman.length(); i++) {
            if (!ROMAN_VALUES.containsKey(roman.charAt(i))) {
                throw new IllegalArgumentException("Invalid Roman nummeral character: " + roman.charAt(i) + " at position " + i);
            }
        }
        int result = 0;
        for (int i = 0; i < roman.length(); i++) {
            int value = ROMAN_VALUES.get(roman.charAt(i));
            if (i + 1 < roman.length() && value < ROMAN_VALUES.get(roman.charAt(i + 1))) {
                result -= value;
            } else {
                result += value;
            }
        }
        return result;
    }    
}
