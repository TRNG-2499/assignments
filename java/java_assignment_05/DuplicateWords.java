
import java.util.HashMap;
import java.util.Map;

public class DuplicateWords {

    public static void main(String[] args) {

        duplicateWords("I like to cook and I like to run");
    }
    public static void duplicateWords(String sentence) {
        //cleans up and turns input into a string
        String[] words = sentence.toLowerCase().trim().split("\\s+");
        //created a hash map
        Map<String, Integer> count = new HashMap<>();

        //was a for loop but intellij recommended a for each
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        //using a for each loop to loop through my map to find the keys/words
        for (String forWord : count.keySet()){
            int currentCount = count.get(forWord);
            System.out.println(forWord + " - " + currentCount);
        }
    }
}

