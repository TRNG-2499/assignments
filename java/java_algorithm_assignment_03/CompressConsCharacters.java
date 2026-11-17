<<<<<<< HEAD
=======
// Write a method that accepts a single parameter: a String.
// The method should return a new String where runs of consecutive, identical characters are replaced with the character followed by 
// the count of how many times it repeated in that run (for example, "aaabbbccd" becomes "a3b3c2d1").
// A character that does not repeat (a run of length 1) should still be followed by a 1 in the output, as shown in the example.
// Runs should be identified case-insensitively — for example, "aA" should be treated as a single run of length 2, 
// not two separate runs. The character used in the compressed output for a given run should match the casing of the first character 
// in that run (for example, "aA" compresses to "a2", while "Aa" compresses to "A2").
// Consider how your method should handle an empty string as input.

>>>>>>> 5857ffd (Complete compressed characters assignment)
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

<<<<<<< HEAD
    // method to return compressed string only if shorter than original
    public static String compressIfShorter(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        String compressed = compress(input);
        return compressed.length() < input.length() ? compressed : input;
    }

    //decompression method
    public static String decompress(String compressed) {
        if (compressed == null || compressed.isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < compressed.length()) {
            char letter = compressed.charAt(i);
            i++;
            //read all consecutive digits that follow, building up the count
            int countStart = i;
            
            while (i < compressed.length() && Character.isDigit(compressed.charAt(i))) {
                i++;
            }
            int count = Integer.parseInt(compressed.substring(countStart, i));

            for (int j = 0; j < count; j++) {
                result.append(letter);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(compress("aaabbbccd"));
        System.out.println(compress("aAaA"));
        System.out.println(compressIfShorter("aaabbbccd"));
        System.out.println(compressIfShorter("aAaA"));
        System.out.println(compressIfShorter("aabb"));
        System.out.println(compressIfShorter(""));
        System.out.println(decompress("a3b3c2d1"));
        System.out.println(decompress("a12"));
        System.out.println(decompress("a3b2"));
=======
    public static void main(String[] args) {
        System.out.println(compress("aaabbbccd"));
        System.out.println(compress("aAaA"));
>>>>>>> 5857ffd (Complete compressed characters assignment)
    }
}
