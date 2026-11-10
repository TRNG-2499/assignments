// Write a method that accepts a single parameter: a String.
// The method should return a new String where runs of consecutive, identical characters are replaced with the character followed by 
// the count of how many times it repeated in that run (for example, "aaabbbccd" becomes "a3b3c2d1").
// A character that does not repeat (a run of length 1) should still be followed by a 1 in the output, as shown in the example.
// Runs should be identified case-insensitively — for example, "aA" should be treated as a single run of length 2, 
// not two separate runs. The character used in the compressed output for a given run should match the casing of the first character 
// in that run (for example, "aA" compresses to "a2", while "Aa" compresses to "A2").
// Consider how your method should handle an empty string as input.

public class CompressConsCharacters {
    public static String compress(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        
        char runChar = input.charAt(0);
        int count = 1;

        // loop through the rest of the characters
        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.toLowerCase(currentChar) == Character.toLowerCase(runChar)) {
                count++;
            } else {
                result.append(runChar).append(count);
                runChar = currentChar;
                count = 1;
            }
        }
        result.append(runChar).append(count);
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(compress("aaabbbccd"));
        System.out.println(compress("aAaA"));
    }
}
