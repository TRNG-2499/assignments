import java.util.HashSet;
import java.util.LinkedHashMap;

public class DuplicateCheck {
    public static void main(String[] args) {
        // dupeCounter("The time I went to the store I bought a watermelon");
        // dupeCounter("Every word here is unique");
    }

    public static void dupeCounter(String sentence) {
        String[] sentenceArray = sentence.toLowerCase().split("[ ]");
        LinkedHashMap<String, Integer> wordCounts = new LinkedHashMap<>();
        StringBuilder out = new StringBuilder();

        for (String word : sentenceArray) {
            wordCounts.merge(word, 1, Integer::sum);
        }

        for (String key : wordCounts.keySet()) {
            String s = key + " - " + wordCounts.get(key) + ", ";
            out.append(s);
        }

        out.delete(out.length()-2,out.length()-1);
        //cba
        System.out.println(out);

    }

    public static void dupeDeleter(String sentence) {
        String[] sentenceArray = sentence.split("[ ]");
        HashSet<String> wordSet = new HashSet<>();
        StringBuilder out = new StringBuilder();

        for (String word : sentenceArray) {
            if (!wordSet.contains(word.toLowerCase())) {
                String s = word + " ";
                out.append(s);

            }
            wordSet.add(word.toLowerCase());
        }

        out.deleteCharAt(out.length()-1);
        //cba
        System.out.println(out);

    }

    // public static void sentenceStats(String sentence) {
    //     String[] sentenceArray = sentence.split("[ ]");
    //     HashMap<String, Integer> wordCounts = new HashMap<>();
    //     StringBuilder out = new StringBuilder();

    //     for (String word : sentenceArray) {
    //         wordCounts.merge(word, 1, Integer::sum);
    //     }

    // }

    
}