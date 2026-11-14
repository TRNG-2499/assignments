import java.util.Locale;

public class RomanNumeralConverter {


    private static final int[] VALUES = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

    private static final String[] NUMERALS = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String toRoman(int number) {
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("Number must be between 1 and 3999");
        }

        StringBuilder roman = new StringBuilder();
        int remaining = number;

        // Start's with the largest Roman numeral value and then work's downward, it's a greedy alg. for this case only. Can't think another way right now
        for (int i = 0; i < VALUES.length && remaining > 0; i++) {

            // this keeps using the current numeral while it's value fits
            // Ex: 2000 becomes "MM" by subtracting 1000 two times. 
            while (remaining >= VALUES[i]) {
                roman.append(NUMERALS[i]);
                remaining -= VALUES[i];
                
            }
        }

        return roman.toString();
    }

    public static int toInteger(String roman) {

        if (roman == null) {
            throw new IllegalArgumentException("Roman numeral cannot be null");
        }

        // removes leading/ tailing spaces and rejects empty input
        String value = roman.trim();

        if (value.isEmpty()) {
            throw new IllegalArgumentException("Roman numeral cannot be empty");
        }

        // we accept lowercase and mixed-case strings
        value = value.toUpperCase(java.util.Locale.ROOT);

        int total = 0;
        int previousValue = 0;

        // reads from right to left to handle addtion and subtra.
        for (int i = value.length() - 1; i >= 0; i--) {
            int currentVal = romanValue(value.charAt(i));


            // don't accpet chars that are not vaild roman numeral letters
            if (currentVal == -1) {
                throw new IllegalArgumentException("Invaild Roman numeral character: " + value.charAt(i));
            }

            // smaller value before a larger value is sub.
            // Ex: IV = 5 - 1 = 4, othervise, let's add the value (VI = 5 + 1 = 6)
            if (currentVal < previousValue) {
                total -= currentVal;
            }
            else {
                total += currentVal;
            }

            // this saves the current value for the next comparsion
            previousValue = currentVal;

        }

        // this converts the result back to Roman numerals to check its format
        // Ex: "IIII" calculates to 4, but toRoman(4) returns "IV"
        // since they do not match, "IIII" is invaild
        if (total < 1 || total > 3999 || !toRoman(total).equals(value)) {
            throw new IllegalArgumentException("Invaild Roman numeral: "+ roman);
        }
        return total;
    }

    public static String add(String a, String b) {
        // convert's both inputs to integers. 
        // toInteger also checks whether the inputs are vaild
        int firstNumber = toInteger(a);
        int secondNumber = toInteger(b);

        int sum = firstNumber + secondNumber;

        // the sum needs to stay within the supported Roman num range
        if (sum > 3999) {
            throw new IllegalArgumentException("Sum cannot exceed 3999");
        }

        return toRoman(sum);
    }

    // This is just  a helper method that returns the integer value of one Roman letter
    private static int romanValue(char romanChar) {
        switch (romanChar) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return -1;
        }
    }
       
}