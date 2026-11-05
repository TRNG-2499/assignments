package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // nextLine so the whole sentence is read, not just the first word
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        printWordCounts(sentence);

        System.out.println();
        System.out.println("-----Stretch Goal 1-----");
        // stretch goal 1
        System.out.println(removeDuplicateWords(sentence));

        System.out.println();
        System.out.println("-----Stretch Goal 2-----");
        // stretch goal 2
        System.out.println(sentenceStatistics(sentence));

        scanner.close();
    }

    // normal solution
    public static void printWordCounts(String sentence) {
        Map<String, Integer> counts = countWords(sentence);

        String output = "";
        for (String word : counts.keySet()) {
            if (!output.isEmpty()) {
                output += ", ";
            }
            output += word + " - " + counts.get(word);
        }
        System.out.println(output);
    }

    public static Map<String, Integer> countWords(String sentence) {
        // LinkedHashMap keeps words in the order they were first added, unlike HashMap
        Map<String, Integer> counts = new LinkedHashMap<>();

        // split on any run of spaces so double spaces don't create empty words
        for (String word : sentence.trim().split("\\s+")) {
            String lower = word.toLowerCase();
            counts.put(lower, counts.getOrDefault(lower, 0) + 1);
        }
        return counts;
    }

    // stretch goal 1
    public static String removeDuplicateWords(String sentence) {
        Set<String> seen = new HashSet<>();

        String output = "";
        for (String word : sentence.trim().split("\\s+")) {
            // add returns false when the word was already seen, so only first occurrences are kept
            if (seen.add(word.toLowerCase())) {
                if (!output.isEmpty()) {
                    output += " ";
                }
                output += word;
            }
        }
        return output;
    }

    // stretch goal 2
    public static String sentenceStatistics(String sentence) {
        Map<String, Integer> counts = countWords(sentence);

        int maxCount = Collections.max(counts.values());
        int minCount = Collections.min(counts.values());

        int maxLength = 0;
        int minLength = Integer.MAX_VALUE;
        for (String word : counts.keySet()) {
            maxLength = Math.max(maxLength, word.length());
            minLength = Math.min(minLength, word.length());
        }

        // looping over the unique words means a tie never lists the same word twice
        List<String> mostFrequent = new ArrayList<>();
        List<String> leastFrequent = new ArrayList<>();
        List<String> longest = new ArrayList<>();
        List<String> shortest = new ArrayList<>();
        for (String word : counts.keySet()) {
            if (counts.get(word) == maxCount) {
                mostFrequent.add(word);
            }
            if (counts.get(word) == minCount) {
                leastFrequent.add(word);
            }
            if (word.length() == maxLength) {
                longest.add(word);
            }
            if (word.length() == minLength) {
                shortest.add(word);
            }
        }

        return "Most frequent: " + String.join(", ", mostFrequent) + " (" + maxCount + " times)"
                + "\nLeast frequent: " + String.join(", ", leastFrequent) + " (" + minCount + " times)"
                + "\nLongest: " + String.join(", ", longest) + " (" + maxLength + " characters)"
                + "\nShortest: " + String.join(", ", shortest) + " (" + minLength + " characters)";
    }
}
