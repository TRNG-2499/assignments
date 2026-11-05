import java.util.LinkedHashMap; // Keeps words in the order they first appear.
import java.util.Locale;        // Provides consistent lowercase conversion.
import java.util.Map;           // Stores each word with its occurrence count.
import java.util.StringJoiner;  // Joins the results with commas between entries.

public class DuplicateWords {

    // Prints each unique word and its count in the order it first appears.
    public static void countWords(String sentence) {
        String[] words = sentence.trim().toLowerCase(Locale.ROOT).split("\\s+");
        Map<String, Integer> wordCounts = new LinkedHashMap<>();

        // Add new words with a count of 1, or increase their existing count.
        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        // Separate entries with commas without adding a trailing comma.
        StringJoiner results = new StringJoiner(", ");

        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            results.add(entry.getKey() + " - " + entry.getValue());
        }

        System.out.println(results);
    }

    // Demonstrates repeated words, unique words, and mixed casing.
    public static void main(String[] args) {
        countWords("The time I went to the store I bought a watermelon");
        countWords("Every word here is unique");
        countWords("Java java JAVA");
    }
}