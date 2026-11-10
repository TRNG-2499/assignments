package java_algorithm_assignment_03;

import java.util.*;

public class compress {
    public static void main(String args[]) {
        System.out.println("Compressing program running...");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your string: ");
        String input = scanner.nextLine();
        if (input.isEmpty() || input == null) {
            System.out.println("Compressed string: ");
            scanner.close();
            return;
        }
        System.out.println("Choose compression mode: 1 for normal, 2 for shorter, 3 for decompression");
        int mode = scanner.nextInt();
        if (mode == 1) {
            compressString(input);
        } else if (mode == 2) {
            System.out.println("Compressed string: " + shorter(input));
        } else if (mode == 3) {
            decompressString(input);
        } else {
            System.out.println("Invalid mode selected");
        }
        scanner.close();
    }

    public static void compressString(String str) {

        if (str.isEmpty()) {
            System.out.println("Compressed string: ");
            return;
        }

        int count = 0;

        char[] parse = str.toCharArray();

        String result = "";

        char prev = parse[0];

        for (int i = 0; i < parse.length; i++) {
            if (i > 0 && Character.toLowerCase(parse[i]) != Character.toLowerCase(prev)) {
                result += prev;
                result += count;
                count = 0;
                prev = parse[i];
            }
            count++;
        }
        result += prev;
        result += count;
        System.out.println("Compressed string: " + result);

    }

    public static String shorter(String str) {

        if (str.isEmpty()) {
            System.out.println("Compressed string: ");
            return "";
        }

        int count = 0;

        char[] parse = str.toCharArray();

        String result = "";

        char prev = parse[0];

        for (int i = 0; i < parse.length; i++) {
            if (i > 0 && Character.toLowerCase(parse[i]) != Character.toLowerCase(prev)) {
                result += prev;
                result += count;
                count = 0;
                prev = parse[i];
            }
            count++;
        }
        result += prev;
        result += count;

        if (result.length() >= str.length()) {
            System.out.println("Compression unsuccessful, result string bigger than original");
            return str;
        }
        return result;
    }

    public static void decompressString(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i += 2) {
            char c = str.charAt(i);
            int count = str.charAt(i + 1) - '0';
            if (count == 0) {
                System.out.println("Invalid input, numeric value cannot be 0");
                return;
            }
            for (int j = 0; j < count; j++) {
                result += c;
            }
        }
        System.out.println("Decompressed string: " + result);
    }
}
