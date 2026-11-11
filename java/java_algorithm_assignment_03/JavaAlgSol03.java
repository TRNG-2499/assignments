package assignments.java.java_algorithm_assignment_03;

public class JavaAlgSol03 {

    public static void main(String[] args) {
        System.out.println(compress("aaabbbccd"));
        System.out.println(compress("abcd"));
        System.out.println(compress("aAaA"));
        System.out.println(compress("aaaaaaaaaaaa"));
        System.out.println(compress(""));

        System.out.println(compressWhenShorter("aaaaaa"));
        System.out.println(compressWhenShorter("abcd"));
        System.out.println(compressWhenShorter("aabb"));
        System.out.println(compressWhenShorter("aAaA"));
        System.out.println(compressWhenShorter(""));

        System.out.println(decompress("a3b3c2d1"));
        System.out.println(decompress("a1b1c1d1"));
        System.out.println(decompress("A4"));
        System.out.println(decompress("a12"));
        System.out.println(decompress(""));
    }

    private static String compress(String input) {
        if (input == null || input.isEmpty())
            return "";

        char starterChar = input.charAt(0);
        int currentCount = 1;
        StringBuilder result = new StringBuilder();

        for (int i = 1; i < input.length(); i++) {
            char letter = input.charAt(i);
            if (Character.toLowerCase(letter) == Character.toLowerCase(starterChar)) {
                currentCount++;
            } else {
                result.append(starterChar).append(currentCount);
                starterChar = letter;
                currentCount = 1;
            }
        }
        result.append(starterChar).append(currentCount);
        return result.toString();
    }

    // stretch
    private static String compressWhenShorter(String input) {
        if (input == null || input.isEmpty())
            return "";

        String compressed = compress(input);
        return compressed.length() < input.length()
                ? compressed
                : input;
    }

    // stretch
    public static String decompress(String input) {
        if (input == null || input.isEmpty())
            return "";

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            String count = "";
            char letter = input.charAt(i);

            // get number after letter
            while (i + 1 < input.length() && Character.isDigit(input.charAt(i + 1))) {
                i++;
                count += input.charAt(i);
            }

            // append to result
            result.append(String.valueOf(letter).repeat(Integer.parseInt(count)));
        }

        return result.toString();
    }

}