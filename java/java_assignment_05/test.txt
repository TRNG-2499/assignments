import java.util.LinkedHashMap;
import java.util.Map;
/*
linked hashmap bc of the order req
 */
public class test {

    public static void countWords(String text) {
        // Handle empty
        if (text == null || text.trim().isEmpty()) {
            System.out.println("No words found.");
            return;
        }

        // Lowercase, trim, and split by one or more whitespace characters
        String[] words = text.toLowerCase().trim().split("\\s+");

        // Count each word, keeping first-appearance order
        Map<String, Integer> counts = new LinkedHashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        // Build the output: "word - count, word - count"
        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (output.length() > 0) {
                output.append(", ");
            }
            output.append(entry.getKey()).append(" - ").append(entry.getValue());
        }
        System.out.println(output);
    }

    public static void main(String[] args) {
        countWords("The time ");
        countWords("Every word here is unique");
        countWords("  Java  is  not fun to  learn  ");
    }
}