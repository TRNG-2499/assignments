public class RomanNumeralConverter {

    public static String toRoman(int number) {
        int original = number;

        if (number <= 0 || number >= 4000) {
            throw new IllegalArgumentException("Number must be between 1 and 3999");
        }

        String[] romanString = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int[] romanValue = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

        StringBuilder roman = new StringBuilder();

        while (number > 0) {
            for (int i = 0; i < romanString.length; i++) {
                if (number >= romanValue[i]) {
                    roman.append(romanString[i]);
                    number -= romanValue[i];
                    break;
                }
            }
        }

        if (toInteger(roman.toString()) != original) {
            throw new IllegalStateException("Conversion error: Roman numeral does not match the original number");
        }

        return roman.toString();
    }

    public static int toInteger(String roman) {

        if (roman == null || roman.isEmpty()) {
            throw new IllegalArgumentException("Roman numeral cannot be null or empty");
        }

        roman = roman.toUpperCase();

        String[] romanString = { "M", "D", "C", "L", "X", "V", "I" };
        int[] romanValue = { 1000, 500, 100, 50, 10, 5, 1 };
        int result = 0;

        for (int i = 0; i < roman.length(); i++) {

            char c = roman.charAt(i);
            char next = i < roman.length() - 1 ? roman.charAt(i + 1) : '\0';

            int cIndex = -1;
            int nextIndex = -1;

            for (int j = 0; j < romanString.length; j++) {
                if (romanString[j].charAt(0) == c) {
                    cIndex = j;
                }
                if (next != '\0' && romanString[j].charAt(0) == next) {
                    nextIndex = j;
                }
            }

            if (cIndex == -1) {
                throw new IllegalArgumentException("Invalid Roman numeral character: " + c);
            }

            if (nextIndex != -1 && nextIndex < cIndex) {
                result = result - romanValue[cIndex];
            } else {
                result += romanValue[cIndex];
            }

        }

        return result;
    }
}
