import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class parsing {

    public static String parseString(String input) {
        if (input == null || input.isEmpty()) {
            return "Input string is empty or null.";
        }

        Map<String, Integer> wordCount = new HashMap<>();

        String[] words = input.split("\\s+");
        StringBuilder output = new StringBuilder();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            output.append(entry.getKey()).append(": ").append(entry.getValue()).append(", ");
        }

        if (output.length() > 0) {
            output.setLength(output.length() - 2); 
        }

        return output.toString();
    }

    public static String removeDuplicates(String input) {
        if (input == null || input.isEmpty()) {
            return "Input string is empty or null.";
        }

        StringBuilder output = new StringBuilder();
        String[] words = input.split("\\s+");
        Map<String, Boolean> seenWords = new HashMap<>();

        for (String word : words) {
            if (!seenWords.containsKey(word)) {
                output.append(word).append(" ");
                seenWords.put(word, true);
            }
        }

        return output.toString().trim();
    }

    public static String sentenceStats(String input) {
        if (input == null || input.isEmpty()) {
            return "Input string is empty or null.";
        }

        String[] words = input.split("\\s+");
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

         int maxCount = 0;
        int minCount = Integer.MAX_VALUE;

        for (int count : wordCountMap.values()) {
            if (count > maxCount) {
                maxCount = count;
            }

            if (count < minCount) {
                minCount = count;
            }
        }

        List<String> mostFrequent = new ArrayList<>();
        List<String> leastFrequent = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            if (entry.getValue() == maxCount) {
                mostFrequent.add(entry.getKey());
            }

            if (entry.getValue() == minCount) {
                leastFrequent.add(entry.getKey());
            }
        }

        int longestLength = 0;
    int shortestLength = Integer.MAX_VALUE;

    List<String> longestWords = new ArrayList<>();
    List<String> shortestWords = new ArrayList<>();

    for (String word : wordCountMap.keySet()) {

        if (word.length() > longestLength) {
            longestLength = word.length();
            longestWords.clear();
            longestWords.add(word);
        } else if (word.length() == longestLength) {
            longestWords.add(word);
        }

        if (word.length() < shortestLength) {
            shortestLength = word.length();
            shortestWords.clear();
            shortestWords.add(word);
        } else if (word.length() == shortestLength) {
            shortestWords.add(word);
        }
    }


        StringBuilder output = new StringBuilder();
        
        output.append("Most frequent word(s): ")
            .append(String.join(", ", mostFrequent))
            .append(" (")
            .append(maxCount)
            .append(" times)\n");

        output.append("Least frequent word(s): ")
            .append(String.join(", ", leastFrequent))
            .append(" (")
            .append(minCount)
            .append(" time(s))\n");

        output.append("Longest word(s): ")
            .append(String.join(", ", longestWords))
            .append(" (")
            .append(longestLength)
            .append(" characters)\n");

        output.append("Shortest word(s): ")
            .append(String.join(", ", shortestWords))
            .append(" (")
            .append(shortestLength)
            .append(" characters)");

        return output.toString();
    }


    public static void main(String[] args) {
        String input = "The time I went to the store I bought a watermelon";
        System.out.println(parseString(input));
        System.out.println(removeDuplicates(input));
        System.out.println(sentenceStats(input));

        input = "Every word here is unique";
        System.out.println(parseString(input));
        System.out.println(removeDuplicates(input));
        System.out.println(sentenceStats(input));

    }
}
