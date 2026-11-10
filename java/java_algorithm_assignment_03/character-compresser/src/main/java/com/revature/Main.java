package com.revature;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String string;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string of characters: ");
        string = scanner.nextLine();
        String compressedString = wordCompresser(string);
        System.out.println(compressedString);

        System.out.println();
        System.out.println("-----Stretch Goal 1-----");
        // stretch goal 1
        System.out.println(compressIfShorter(string));

        System.out.println();
        System.out.println("-----Stretch Goal 2-----");
        // stretch goal 2
        System.out.println(wordDecompresser(compressedString));

        scanner.close();
    }

    // normal solution
    public static String wordCompresser(String word) {
        String compressed = "";
        // an empty string has no runs, and word.charAt(0) below would throw
        if (word.isEmpty()) {
            return compressed;
        }

        // the first character of a run is kept so the output uses its casing
        char runChar = word.charAt(0);
        int count = 1;
        for (int i = 1; i < word.length(); i++) {
            char current = word.charAt(i);
            // compare lowercase versions so "aA" counts as one run
            if (Character.toLowerCase(current) == Character.toLowerCase(runChar)) {
                count++;
            } else {
                compressed += runChar + "" + count;
                runChar = current;
                count = 1;
            }
        }
        // the last run never hits a different character, so it's added after the loop
        compressed += runChar + "" + count;
        return compressed;
    }

    // stretch goal 1
    public static String compressIfShorter(String word) {
        String compressed = wordCompresser(word);
        if (compressed.length() < word.length()) {
            return compressed;
        }
        return word;
    }

    // stretch goal 2
    public static String wordDecompresser(String compressed) {
        String decompressed = "";

        int i = 0;
        while (i < compressed.length()) {
            char letter = compressed.charAt(i);
            i++;

            // read every digit after the letter, since a count can be more than one digit (e.g. "a12")
            int count = 0;
            while (i < compressed.length() && Character.isDigit(compressed.charAt(i))) {
                count = count * 10 + (compressed.charAt(i) - '0');
                i++;
            }

            for (int j = 0; j < count; j++) {
                decompressed += letter;
            }
        }
        return decompressed;
    }
}
