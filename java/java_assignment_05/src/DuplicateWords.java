import java.util.Map;
import java.util.TreeMap;

public class DuplicateWords {
    public static void main(String[] args) {
        reportWordCount("The time I went to the store I bought a watermelon");
        reportWordCount("She sells she shells by the she shore");
        reportWordCount("Why should I ask why when I have to know why you ask?");
    }

    private static void reportWordCount(String sentence) {
        Map<String, Integer> wordCountTable = new TreeMap<>();
        String[] words = sentence.split("[^a-zA-z0-9]");

        for (String word : words) {
            Integer count = wordCountTable.putIfAbsent(word.toLowerCase(), 1);
            if (count != null)
                wordCountTable.put(word.toLowerCase(), ++count);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("|");
        for (Map.Entry<String, Integer> word : wordCountTable.entrySet()) {
            sb.append(" %s - %d |".formatted(word.getKey(), word.getValue()));
        }

        System.out.println(sb);
    }
}
