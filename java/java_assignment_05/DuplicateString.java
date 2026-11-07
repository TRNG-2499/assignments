import java.util.HashMap;
import java.util.LinkedHashMap;

public class DuplicateString {
    
    public static void countDuplicateWords(String str) {
        String[] words = str.split(" ");
    
        LinkedHashMap<String, Integer> wordCount = new LinkedHashMap<>();
        for (String word : words) {
            wordCount.put(word.toLowerCase(), wordCount.getOrDefault(word.toLowerCase(), 0) + 1);
        }
        System.out.println(wordCount);
    }

    public static void main(String[] args) {
        countDuplicateWords("The time I went to the store I bought a watermelon");

    }
}
