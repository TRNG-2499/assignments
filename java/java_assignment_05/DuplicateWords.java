import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class DuplicateWords {
    public static void countString(String sentence) {
        Map<String, Integer> counts = new LinkedHashMap<>();

        for (String word : sentence.split("\\s+")) {
            String name = word.toLowerCase(Locale.ROOT);
            counts.put(name, counts.getOrDefault(name, 0) + 1);
        }

        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (result.length() > 0) {
                result.append(", ");
            }
            result.append(entry.getKey()).append(" - ").append(entry.getValue());
        }

        System.out.println(result);
    }

   // public static void main(String[] args) {
   //     countString("Cat dog CAT bird dog");
   // }
}