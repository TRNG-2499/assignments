import java.util.HashMap;
import java.util.Map;

public class CompressConsecutiveCharacters {

    public static void main(String[] args) {
        System.out.println(compressConsecutiveChars(" " + "abbcccddddeeeee"));
    }
    public static String compressConsecutiveChars(String letters){
        String [] splits = letters.toLowerCase().trim().split("");

            Map<String, Integer> count = new HashMap<>();

        if (letters == null || letters.trim().isEmpty()) {
            return "\"\"";
        }
            for (String myLetters : splits) {
                count.put(myLetters, count.getOrDefault(myLetters, 0) + 1);
            }
            for (String l : count.keySet()) {
                int currentCount = count.get(l);
                System.out.print(l + currentCount);
            }
        return letters;
    }
}
