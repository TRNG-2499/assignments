import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        DuplicateWord test = new DuplicateWord();
        System.out.println(test.getWordCount("The time I went to the store I bought a watermelon"));
        System.out.println(test.getWordCount("Every word here is unique"));

        System.out.println(test.removeDuplicates("The time I went to the store I bought a watermelon"));
        System.out.println(test.getWordStats("The time I went to the store I bought a watermelon"));
    }
}

class DuplicateWord {

    /**
     * This method takes a sentence as input and counts the occurrences of each word in the sentence.
     * It returns a string representation of the word counts, where each line contains a word and its count.
     * @param sentence The input sentence to analyze.
     * @return A string representation of the word counts.
     */
    public String getWordCount(String sentence) {
        Map<String, Integer> wordCount = new HashMap<>();
        int left = 0;

        while (left < sentence.length()) {
            int right = left;
            while (right < sentence.length() && Character.isLetter(sentence.charAt(right))) {
                right++;
            }

            String currentWord = sentence.substring(left, right).toLowerCase();
            wordCount.put(currentWord, wordCount.getOrDefault(currentWord, 0) + 1);
            left = right + 1;
        }

        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> item : wordCount.entrySet()) {
            result.append(item.getKey()).append(": ").append(item.getValue()).append("\n");
        }
        return result.toString();
    }

    /**
     * This method takes a sentence as input and removes duplicate words from it.
     * It returns a new sentence with only the first occurrence of each word, preserving the original order.
     * @param sentence The input sentence to process.
     * @return A new sentence with duplicate words removed.
     */
    public String removeDuplicates(String sentence) {
        Map<String, Integer> wordCount = new HashMap<>();
        int left = 0;

        StringBuilder result = new StringBuilder();
        while (left < sentence.length()) {
            int right = left;
            while (right < sentence.length() && Character.isLetter(sentence.charAt(right))) {
                right++;
            }

            String currentWord = sentence.substring(left, right).toLowerCase();
            wordCount.put(currentWord, wordCount.getOrDefault(currentWord, 0) + 1);
            if (wordCount.get(currentWord) == 1) {
                result.append(currentWord).append(" ");
            }
            left = right + 1;
        }

        return result.toString();
    }

    /**
     * This method takes a sentence as input and analyzes the words in the sentence to find the most frequent word, least frequent word, longest word, and shortest word.
     * It returns a string representation of these statistics.
     * @param sentence The input sentence to analyze.
     * @return A string representation of the word statistics.
     */
    public String getWordStats(String sentence) {
        Map<String, Integer> wordCount = new HashMap<>();
        int left = 0;

        while (left < sentence.length()) {
            int right = left;
            while (right < sentence.length() && Character.isLetter(sentence.charAt(right))) {
                right++;
            }

            String currentWord = sentence.substring(left, right).toLowerCase();
            wordCount.put(currentWord, wordCount.getOrDefault(currentWord, 0) + 1);
            left = right + 1;
        }

        String mostFrequentWord = null;
        String leastFrequentWord = null;
        int mostFrequentCount = Integer.MIN_VALUE;
        int leastFrequentCount = Integer.MAX_VALUE;
        String longestWord = null;
        String shortestWord = null;

        for (Map.Entry<String, Integer> item : wordCount.entrySet()) {
            if (item.getValue() > mostFrequentCount) {
                mostFrequentCount = item.getValue();
                mostFrequentWord = item.getKey();
            }
            if (item.getValue() < leastFrequentCount) {
                leastFrequentCount = item.getValue();
                leastFrequentWord = item.getKey();
            }

            if (longestWord == null || item.getKey().length() > longestWord.length()) {
                longestWord = item.getKey();
            }
            if (shortestWord == null || item.getKey().length() < shortestWord.length()) {
                shortestWord = item.getKey();
            }
        }
        return String.format("Most Frequent Word: %s\nLeast Frequent Word: %s\nLongest Word: %s\nShortest Word: %s",
                mostFrequentWord, leastFrequentWord, longestWord, shortestWord);
    }
}