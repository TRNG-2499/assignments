import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution_05 {

    public static void main(String[] args) {
        // Example 1
        String input1 = "The time I went to the store I bought a watermelon";
        System.out.println("Example 1 (Basic): " + duplicateWordsInASentence(input1));

        // Example 2
        String input2 = "Every word here is unique";
        System.out.println("Example 2 (Basic): " + duplicateWordsInASentence(input2));

        // Stretch Goal 1
        System.out.println("\nStretch 1 (Remove Duplicates): " + removeDuplicateWords(input1));

        // Stretch Goal 2
        System.out.println("\nStretch 2 (Statistics):");
        printSentenceStatistics(input1);
    }

    public static String duplicateWordsInASentence(String sentence) {
        String[] words = sentence.split("\\s+");
        
        // Use LinkedHashMap to preserve the insertion order of first appearances
        Map<String, Integer> wordCount = new LinkedHashMap<>();

        for (String word : words) {
            String lower = word.toLowerCase();
            wordCount.put(lower, wordCount.getOrDefault(lower, 0) + 1);
        }

        StringBuilder result = new StringBuilder();
        boolean first = true;
        
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (!first) {
                result.append(", ");
            }
            result.append(entry.getKey()).append(" - ").append(entry.getValue());
            first = false;
        }

        return result.toString();
    }

    public static String removeDuplicateWords(String sentence) {
        String[] words = sentence.split("\\s+");
        Set<String> seenLower = new HashSet<>();
        List<String> resultList = new ArrayList<>();

        for (String word : words) {
            if (!seenLower.contains(word.toLowerCase())) {
                seenLower.add(word.toLowerCase());
                resultList.add(word);
            }
        }

        return String.join(" ", resultList);
    }

    public static void printSentenceStatistics(String sentence) {
        String[] words = sentence.split("\\s+");
        Map<String, Integer> wordCount = new LinkedHashMap<>();

        for (String word : words) {
            String lower = word.toLowerCase();
            wordCount.put(lower, wordCount.getOrDefault(lower, 0) + 1);
        }

        int maxFreq = 0;
        int minFreq = Integer.MAX_VALUE;
        int maxLength = 0;
        int minLength = Integer.MAX_VALUE;

        // First pass to find extremes
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            maxFreq = Math.max(maxFreq, entry.getValue());
            minFreq = Math.min(minFreq, entry.getValue());
            maxLength = Math.max(maxLength, entry.getKey().length());
            minLength = Math.min(minLength, entry.getKey().length());
        }

        List<String> mostFrequent = new ArrayList<>();
        List<String> leastFrequent = new ArrayList<>();
        List<String> longest = new ArrayList<>();
        List<String> shortest = new ArrayList<>();

        // Second pass to gather ties
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == maxFreq) mostFrequent.add(entry.getKey());
            if (entry.getValue() == minFreq) leastFrequent.add(entry.getKey());
            if (entry.getKey().length() == maxLength) longest.add(entry.getKey());
            if (entry.getKey().length() == minLength) shortest.add(entry.getKey());
        }

        System.out.println("Most frequent: " + mostFrequent);
        System.out.println("Least frequent: " + leastFrequent);
        System.out.println("Longest words: " + longest);
        System.out.println("Shortest words: " + shortest);
    }
    
}

