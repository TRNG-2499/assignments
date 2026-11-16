import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeralConverter {

    private static Map<Integer, String> valueRoman = new LinkedHashMap<>() {
        {
            put(1000, "M");
            put(900, "CM");
            put(500, "D");
            put(400, "CD");
            put(100, "C");
            put(90, "XC");
            put(50, "L");
            put(40, "XL");
            put(10, "X");
            put(9, "IX");
            put(5, "V");
            put(4, "IV");
            put(1, "I");
        }
    };
    private static String allowed = "IVXLCDM";

    public static String toRoman(int number) {

        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("Number must be within 1 and 3999");
        }
        StringBuilder result = new StringBuilder();

        for (int entry : valueRoman.keySet()) {

            while (number >= entry) {
                result.append(valueRoman.get(entry));
                number -= entry;
            }
        }
        return result.toString();
    }

    public static int toInteger(String roman) {
        if (roman == null || roman.isEmpty()) {
            throw new IllegalArgumentException("Roman numeral input cannot be empty.");
        }

        roman = roman.toUpperCase();
        int result = 0;

        for (int i = 0; i < roman.length(); i++) {

            if (!allowed.contains(String.valueOf(roman.charAt(i)))) {
                throw new IllegalArgumentException(
                        "Roman numeral may only contain these character's in its composition: IVXLCDM");
            }

            for (Map.Entry<Integer, String> pair : valueRoman.entrySet()) {
                int length = pair.getValue().length();

                if (i + length > roman.length()) {
                    continue;
                }

                String currentSubString = roman.substring(i, i + length);

                if (currentSubString.equals(pair.getValue())) {
                    result += pair.getKey();
                    if (length == 2)
                        i++;
                    break;
                }
            }
        }
        validateRomanFormat(roman, result);
        return result;
    }

    // Stretch 1
    private static void validateRomanFormat(String roman, int num) {
        if (!toRoman(num).equals(roman)) {
            throw new IllegalArgumentException("\"IIII\", \"VV\", \"IC\", and \"VX\" are not valid numerals");
        }
    }

    // stretch 2
    public static String addTwoRoman(String a, String b) {
        // IllegalArgumentException if invalid or sum greater than 3999
        // invalid input otherwise checked in toInteger or toRoman
        int sum = toInteger(a) + toInteger(b);

        if (sum > 3999) {
            throw new IllegalArgumentException("Number cannot be above 3999.");
        }

        // return as uppercase, already done in toRoman
        return toRoman(sum);
    }
}
