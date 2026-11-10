package assignments.java.java_assignment_05;
import java.util.LinkedHashMap;
import java.util.Map;

public class DuplicateWords {
    public static void main(String[] args) {
        printWordCounts("The time I went to the store I bought a watermelon");
        printWordCounts("Every word here is unique!");
    }

    /*
     * Prints the count of each word in the given sentence.
     * Words are separated by spaces and punctuation is ignored.
     */
    public static void printWordCounts(String sentence) {
        Map<String, Integer> counts = countWords(sentence);

        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (output.length() > 0) {
                output.append(", ");
            }
            output.append(entry.getKey()).append(" - ").append(entry.getValue());
        }
        System.out.println(output.toString());
    }

    /*
     * Build map of lowercase word to their occurrences in the sentence.
     * LinkedHashMap is used to keep keys in the order they were first inserted.
     */
    public static Map<String, Integer> countWords(String sentence) {
        Map<String, Integer> counts = new LinkedHashMap<>();
        String[] words = sentence.toLowerCase().split("\\s+");
        for (String word : words) {
            String key = word.toLowerCase();
            counts.put(key, counts.getOrDefault(key, 0) + 1);
        }
        return counts;
    }
}
