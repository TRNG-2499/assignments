/**
     * @param args the command line arguments
     * Java algorithm assignment 03 - Compress Consecutive Characters
     * Objective: Practice iterating through a string while comparing adjacent characters, tracking a running count, and building a new string incrementally based on that tracking.
     * 1. Write a method that accepts a single parameter: a String. The method should return a new String where runs of consecutive, identical characters are replaced with the character followed by the count of how many times it repeated in that run (for example, "aaabbbccd" becomes "a3b3c2d1").
     * 2. A character that does not repeat (a run of length 1) should still be followed by a 1 in the output, as shown in the example. Runs should be identified case-insensitively — for example, "aA" should be treated as a single run of length 2, not two separate runs. The character used in the compressed output for a given run should match the casing of the first character in that run (for example, "aA" compresses to "a2", while "Aa" compresses to "A2").
     * 3. Consider how your method should handle an empty string as input.

*/

public class CompressCharacters {
    public static String compressConsecutiveCharacters(String input) {
        //if input is empty, return an empty string
        if (input.isEmpty()) {
            return "";
        }

        //using StringBuilder to keep strings into one run
        StringBuilder result = new StringBuilder();
        int count = 1;

        //iterate through the input string starting from the second character, set to case insensitive by setting capital letters to lower case, and compare with the previous character
        for (int i = 1; i < input.length(); i++) {
            if (Character.toLowerCase(input.charAt(i)) ==
                Character.toLowerCase(input.charAt(i - 1))) {
                count++;
            } else {
                result.append(input.charAt(i - 1));
                result.append(count);
                count = 1;
            }
        }
        //return results
        result.append(input.charAt(input.length() - 1));
        result.append(count);
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(compressConsecutiveCharacters("dccaAAbbBccdddEee"));
        System.out.println(compressConsecutiveCharacters("abcd"));
        System.out.println(compressConsecutiveCharacters("bbbbb"));
        System.out.println(compressConsecutiveCharacters("aAaA"));
        System.out.println(compressConsecutiveCharacters("AAAA"));
        System.out.println(compressConsecutiveCharacters("a"));
        System.out.println(compressConsecutiveCharacters(""));
    }
}
