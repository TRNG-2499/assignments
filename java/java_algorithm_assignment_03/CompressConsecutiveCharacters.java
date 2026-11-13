public class CompressConsecutiveCharacters {

    // ---------- Base activity ----------
    // Replaces each run of the same character (ignoring case) with the run's
    // first character followed by the run length: "aaabbbccd" -> "a3b3c2d1".
    // The output keeps the casing of the first character in each run, so
    // "aAaA" -> "a4" and "Aa" -> "A2". An empty string returns "".
    public static String compress(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        char runChar = input.charAt(0); // first character of the current run
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            char current = input.charAt(i);
            if (sameIgnoreCase(current, runChar)) {
                count++;
            } else {
                result.append(runChar).append(count);
                runChar = current;
                count = 1;
            }
        }
        result.append(runChar).append(count); // the last run is never followed by a different character

        return result.toString();
    }

    // Compares two characters without caring about upper/lower case.
    private static boolean sameIgnoreCase(char a, char b) {
        return Character.toLowerCase(a) == Character.toLowerCase(b);
    }

    // ---------- Stretch 1: Only Compress When Shorter ----------
    // Returns the compressed string only when it is strictly shorter than the
    // original; otherwise the original is returned unchanged.
    public static String compressIfShorter(String input) {
        if (input == null) {
            return "";
        }
        String compressed = compress(input);
        return (compressed.length() < input.length()) ? compressed : input;
    }

    // ---------- Stretch 2: Decompression ----------
    // Expands a "letter + count" string back out: "a3b3c2d1" -> "aaabbbccd".
    // Counts can have more than one digit ("a12"). Every character in a run
    // uses the casing stored in the compressed string, so "a4" -> "aaaa" even if
    // the original was "aAaA" (compression does not keep mixed casing).
    // Note: the format cannot tell a digit character apart from a count, so
    // this expects the compressed characters themselves to be non-digits.
    public static String decompress(String compressed) {
        if (compressed == null || compressed.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < compressed.length()) {
            char letter = compressed.charAt(i);
            if (Character.isDigit(letter)) {
                throw new IllegalArgumentException(
                        "Expected a character at position " + i + " but found the digit '" + letter + "'");
            }
            i++;

            // Read every digit that follows to build the full count.
            int start = i;
            while (i < compressed.length() && Character.isDigit(compressed.charAt(i))) {
                i++;
            }
            if (start == i) {
                throw new IllegalArgumentException("Missing count after '" + letter + "' at position " + (start - 1));
            }

            int count = Integer.parseInt(compressed.substring(start, i));
            for (int j = 0; j < count; j++) {
                result.append(letter);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Base activity: compress ===");
        printCompress("aaabbbccd"); // a3b3c2d1
        printCompress("abcd"); // a1b1c1d1
        printCompress("aaaaaa"); // a6
        printCompress("aAaA"); // a4
        printCompress("Aa"); // A2
        printCompress(""); // ""

        System.out.println("\n=== Stretch 1: Only Compress When Shorter ===");
        printCompressIfShorter("aaabbbccd"); // a3b3c2d1 (8 < 9)
        printCompressIfShorter("abcd"); // abcd (a1b1c1d1 is longer)
        printCompressIfShorter("aabb"); // aabb (a2b2 is the same length)
        printCompressIfShorter("aaaaaa"); // a6

        System.out.println("\n=== Stretch 2: Decompression ===");
        printDecompress("a3b3c2d1"); // aaabbbccd
        printDecompress("a4"); // aaaa
        printDecompress("A2b1"); // AAb
        printDecompress("x12"); // xxxxxxxxxxxx
        printDecompress(""); // ""
        printDecompress("ab2"); // error: missing count after 'a'

        System.out.println("\n=== Round trip: decompress(compress(x)) ===");
        String original = "aAaAbBBc";
        String compressed = compress(original);
        System.out.println("\"" + original + "\" -> \"" + compressed + "\" -> \"" + decompress(compressed) + "\"");
    }

    private static void printCompress(String input) {
        System.out.println("\"" + input + "\" -> \"" + compress(input) + "\"");
    }

    private static void printCompressIfShorter(String input) {
        System.out.println("\"" + input + "\" -> \"" + compressIfShorter(input) + "\"");
    }

    private static void printDecompress(String input) {
        try {
            System.out.println("\"" + input + "\" -> \"" + decompress(input) + "\"");
        } catch (IllegalArgumentException e) {
            System.out.println("\"" + input + "\" -> error: " + e.getMessage());
        }
    }
}
