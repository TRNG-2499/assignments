public class RomanNumeralConverter {

    public static void main(String[] args) {
        //test statements
        // System.out.println(toRoman(10));
        // System.out.println(toInteger("X"));
        // System.out.println(toRoman(2026));
        // System.out.println(toInteger("MMXXVI"));
    }

 public static String toRoman(int num) {
    try { 
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1}; //creating a list of acceptable numeric values
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"}; //corresponding Roman numeral symbols
        StringBuilder sb = new StringBuilder();

        if (num <= 0 || num >= 4000) { //checking that it is within parameters
            throw new IllegalArgumentException("Number must be positive and less than 4000: " + num);
        }

        for (int i = 0; i < values.length; i++) { //iterating through the list of values
            while (num >= values[i]) { //subtracting the largest possible value and appending the corresponding symbol
                num -= values[i]; //debating using a modulo operator but I think it's cleaner to just go one at a time as opposed to dividing it
                sb.append(symbols[i]);
            }
        }

        return sb.toString();

    } catch (Exception e) {
        throw new IllegalArgumentException("Illegal Argument: " + num);
    }
}

public static int toInteger(String roman) throws IllegalArgumentException {
    try {
        String cleaned = roman.toUpperCase(); //move all characters to upper-case to make entry case-insensitive
        int total = 0;
        int previous = 0;

        if (cleaned.isEmpty()) { //checking for null entries
            throw new IllegalArgumentException("Roman numeral cannot be empty");
        }
        
        for (int i = cleaned.length() - 1; i >= 0; i--) { //iterating from the end of the string
            int current = romanVal(cleaned.substring(i, i + 1)); //getting the value of the current symbol
            if (current != 1 && current != 5 && current != 10 && current != 50 && current != 100 && current != 500 && current != 1000) { //checking for invalid symbols
                throw new IllegalArgumentException("Invalid Roman numeral symbol: " + cleaned.substring(i, i + 1));
            }
            if (current < previous) {
                total -= current; //if current value is less than the previous value, subtract it from the total
            } else {
                total += current; //if current value is greater than or equal to the previous value, add it to the total
            }

            previous = current;
        }

        return total;

    } catch (Exception e) {
        throw new IllegalArgumentException("Invalid Roman numeral: " + roman);
    }
}

    //helper method for toInteger
    public static int romanVal(String symbol) { //helper method to get the value of a single Roman numeral symbol, keeps it out of the method for visual clarity
        switch (symbol) {
            case "I": return 1;
            case "V": return 5;
            case "X": return 10;
            case "L": return 50;
            case "C": return 100;
            case "D": return 500;
            case "M": return 1000;
            default: throw new IllegalArgumentException("Invalid Roman numeral symbol: " + symbol);
        }
    }
}