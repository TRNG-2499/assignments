
// Author: Tyler Pyrzenski

public class solution {
    public static void main(String[] args) {

        System.out.println(stringCheck("aaabbbccd"));

        System.out.println(stringCheck("abcd"));

        System.out.println(stringCheck("aaaaaa"));

        System.out.println(stringCheck("aAaA"));

        System.out.println(stringCheck(""));

        System.out.println();

        // compress only when shorter tests
        System.out.println(compressIfShorter("aaabbbccd"));   // a3b3c2d1 (8 < 9)
        System.out.println(compressIfShorter("abcd"));        // abcd (a1b1c1d1 is longer)
        System.out.println(compressIfShorter("aabb"));        // aabb (a2b2 is the same length)
        System.out.println(compressIfShorter("aaaaaa"));      // a6
        System.out.println(compressIfShorter(""));            // empty

        System.out.println();

        // decompression tests
        System.out.println(decompress("a3b3c2d1"));           // aaabbbccd
        System.out.println(decompress("a1b1c1d1"));           // abcd
        System.out.println(decompress("a4"));                 // aaaa
        System.out.println(decompress("A2b3"));               // AAbbb
        System.out.println(decompress("x12"));                // xxxxxxxxxxxx (multi-digit count)
        System.out.println(decompress(""));                   // empty
    }

    public static String stringCheck(String input) {

        int counter = 0;
        StringBuilder sb = new StringBuilder();

        if (input.isEmpty()) {
            return "";
        }

        for (int i = 0; i < input.length(); i++) {
            counter++;
            if (i == input.length() - 1 || Character.toLowerCase(input.charAt(i)) != Character.toLowerCase(input.charAt(i + 1)) ) {
                sb.append(input.charAt(i - counter + 1));
                sb.append(counter);
                counter = 0;
            }
        }
        return sb.toString();

    }

    // returns the compressed version only if it actually saves space
    public static String compressIfShorter(String input) {

        String compressed = stringCheck(input);

        if (compressed.length() < input.length()) {
            return compressed;
        }
        return input;
    }

    // expands a compressed string like "a3b2" back into "aaabb"
    public static String decompress(String compressed) {

        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < compressed.length()) {
            char letter = compressed.charAt(i);
            i++;

            // read every digit after the letter so counts like 12 work
            int count = 0;
            while (i < compressed.length() && Character.isDigit(compressed.charAt(i))) {
                count = count * 10 + (compressed.charAt(i) - '0');
                i++;
            }

            for (int j = 0; j < count; j++) {
                sb.append(letter);
            }
        }
        return sb.toString();
    }

}