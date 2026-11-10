package java_algorithm_assignment_03;

public class Solution {
    public static void main(String[] args) {
        System.out.println(stringCompress("aAAabccc"));
        System.out.println(shorterCompress("abc"));
        System.out.println(decompress("A4b1c3"));
    }

    private static String stringCompress(String input) {
        StringBuilder compressed = new StringBuilder();
        if (input.isEmpty()) {
            return compressed.toString();
        }

        char runCharacter = input.charAt(0);
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            char current = input.charAt(i);
            if (Character.toLowerCase(runCharacter) == Character.toLowerCase(current)) {
                count++;
            } else {
                compressed.append(runCharacter).append(count);
                runCharacter = current;
                count = 1;
            }
        }

        compressed.append(runCharacter).append(count);
        return compressed.toString();
    }

    private static String shorterCompress(String input) {
        String compressed = stringCompress(input);
        return compressed.length() < input.length() ? compressed : input;
    }

    private static String decompress(String input) {
        StringBuilder decompressed = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (Character.isDigit(current)) {
                int count = Character.getNumericValue(current);
                char previous = input.charAt(i - 1);
                for (int j = 0; j < count; j++) {
                    decompressed.append(previous);
                }
            }
        }
        return decompressed.toString();
    }
}
