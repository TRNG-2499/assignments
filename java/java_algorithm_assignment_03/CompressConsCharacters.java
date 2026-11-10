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
    }
}
