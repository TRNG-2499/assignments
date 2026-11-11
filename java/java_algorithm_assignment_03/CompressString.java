import java.util.Scanner;

public class CompressString {

    public static String compress(String text) {
        if (text.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        char current = text.charAt(0);
        int count = 1;

        for (int i = 1; i < text.length(); i++) {
            char next = text.charAt(i);

            if (Character.toLowerCase(next) == Character.toLowerCase(current)) {
                count++;
            } else {
                result.append(current).append(count);
                current = next;
                count = 1;
            }
        }

        result.append(current).append(count);
        return result.toString();
    }

    // stretch goal 1
    public static String compressIfShorter(String text) {
        String compressed = compress(text);

        if (compressed.length() < text.length()) {
            return compressed;
        }
        return text;
    }

    // stretch goal 2
    public static String decompress(String compressed) {
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < compressed.length()) {
            char letter = compressed.charAt(i);
            i++;

            int count = 0;
            while (i < compressed.length() && Character.isDigit(compressed.charAt(i))) {
                count = count * 10 + (compressed.charAt(i) - '0');
                i++;
            }

            for (int j = 0; j < count; j++) {
                result.append(letter);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a string (or type 'exit' to quit): ");
            String input = scanner.nextLine();

            if (input.equals("exit")) {
                System.out.println("bye bye!");
                break;
            }

            String compressed = compress(input);
            System.out.println("Compressed: \"" + compressed + "\"");
            System.out.println("Stretch Goal 1: \"" + compressIfShorter(input) + "\"");
            System.out.println("Decompressed: \"" + decompress(compressed) + "\"");
            System.out.println();
        }

        scanner.close();
    }
}