/**
     * @param args the command line arguments
     * Java assignment 05 - Duplicate Words in a Sentence
     * Objective: Practice tokenizing a string into individual words, and using a data structure (such as a Map) to count occurrences of each word.
     * Steps:
     * 1. A method that accepts one param called sentence (String). The sentence would be split into individual words and the method would count how many times each word occurs in the sentence.
     * 2. word match is case - insensitive, so "Hello" and "hello" would be considered the same word. Print result into a list format which shows every unique word and its total count.All words should be printed in lowercase.
     * 3. no punctuation in the sentence, and the sentence always has at least one word.
*/

import java.util.LinkedHashMap;
import java.util.Map;

public class DupeWordChecker {
    public static void countDuplicateWords(String sentence) {

        //sentence is split into words and becomes case insensitive
        String[] words = sentence.toLowerCase().split("\\s+");

        //create a linked hash map to store each unique word and its count
        Map<String, Integer> wordCount = new LinkedHashMap<>();

        //go through each word in the array and count its occurrences
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        //each unique word and its count is printed in the order they first appeared in the sentence
        boolean first = true;
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (!first) {
                System.out.print(", ");
            }
            System.out.print(entry.getKey() + " - " + entry.getValue());
            first = false;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        countDuplicateWords("the boy went to the store and the boy bought some milk");
        countDuplicateWords("This is a unique sentence with no duplicate words");
        countDuplicateWords("");
    }
}
