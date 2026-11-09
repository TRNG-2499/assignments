import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DuplicateWords {

    // ---------- Base activity ----------
    // Prints each unique word (in lowercase) with how many times it appears,
    // in the order the words first show up in the sentence.
    public static void printWordCounts(String sentence) {
        Map<String, Integer> counts = countWords(sentence);

        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (output.length() > 0) {
                output.append(", ");
            }
            output.append(entry.getKey()).append(" - ").append(entry.getValue());
        }
        System.out.println(output);
    }

    // LinkedHashMap keeps keys in the order they were first added.
    private static Map<String, Integer> countWords(String sentence) {
        Map<String, Integer> counts = new LinkedHashMap<>();
        for (String word : splitWords(sentence)) {
            String key = word.toLowerCase();
            counts.put(key, counts.getOrDefault(key, 0) + 1);
        }
        return counts;
    }

    // Splits on any run of whitespace, ignoring spaces at the start and end.
    private static String[] splitWords(String sentence) {
        return sentence.trim().split("\\s+");
    }

    // ---------- Stretch 1: Remove Duplicate Words ----------
    // Keeps only the first time each word appears (ignoring case), with its original casing.
    public static String removeDuplicateWords(String sentence) {
        Set<String> seen = new HashSet<>();
        List<String> kept = new ArrayList<>();

        for (String word : splitWords(sentence)) {
            if (seen.add(word.toLowerCase())) { // add() returns false if already present
                kept.add(word);
            }
        }
        return String.join(" ", kept);
    }

    // ---------- Stretch 2: Sentence Statistics ----------
    // Reports most/least frequent and longest/shortest words, listing every word in a tie.
    public static void printSentenceStatistics(String sentence) {
        Map<String, Integer> counts = countWords(sentence);

        int maxCount = Integer.MIN_VALUE;
        int minCount = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;
        int minLength = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            maxCount = Math.max(maxCount, entry.getValue());
            minCount = Math.min(minCount, entry.getValue());
            maxLength = Math.max(maxLength, entry.getKey().length());
            minLength = Math.min(minLength, entry.getKey().length());
        }

        List<String> mostFrequent = new ArrayList<>();
        List<String> leastFrequent = new ArrayList<>();
        List<String> longest = new ArrayList<>();
        List<String> shortest = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            String word = entry.getKey();
            if (entry.getValue() == maxCount) mostFrequent.add(word);
            if (entry.getValue() == minCount) leastFrequent.add(word);
            if (word.length() == maxLength) longest.add(word);
            if (word.length() == minLength) shortest.add(word);
        }

        System.out.println("Most frequent (" + maxCount + "): " + String.join(", ", mostFrequent));
        System.out.println("Least frequent (" + minCount + "): " + String.join(", ", leastFrequent));
        System.out.println("Longest (" + maxLength + " chars): " + String.join(", ", longest));
        System.out.println("Shortest (" + minLength + " chars): " + String.join(", ", shortest));
    }

    public static void main(String[] args) {
        String sentence1 = "The time I went to the store I bought a watermelon";
        String sentence2 = "Every word here is unique";

        System.out.println("=== Base activity ===");
        printWordCounts(sentence1);
        printWordCounts(sentence2);

        System.out.println("\n=== Stretch 1: Remove Duplicate Words ===");
        System.out.println(removeDuplicateWords(sentence1)); // The time I went to store bought a watermelon
        System.out.println(removeDuplicateWords(sentence2));

        System.out.println("\n=== Stretch 2: Sentence Statistics ===");
        System.out.println("Sentence: \"" + sentence1 + "\"");
        printSentenceStatistics(sentence1);
        System.out.println("\nSentence: \"" + sentence2 + "\"");
        printSentenceStatistics(sentence2);
    }
}
