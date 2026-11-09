import java.util.LinkedHashMap;
import java.util.Map;

public class DuplicateWords {

    public static void countWords(String sentence) {
        String[] words = sentence.toLowerCase().split(" ");

        Map<String, Integer> counts = new LinkedHashMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (counts.containsKey(word)) {
                counts.put(word, counts.get(word) + 1);   
            } else {
                counts.put(word, 1);                       
            }
        }

        boolean first = true;
        for (String key : counts.keySet()) {
            if (!first) {
                System.out.print(", ");
            }
            System.out.print(key + " - " + counts.get(key));
            first = false;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        countWords("The time I went to the store I bought a watermelon");
        countWords("Every word here is unique");
    }
}
