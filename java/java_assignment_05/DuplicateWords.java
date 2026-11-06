import java.util.Arrays;
import java.util.Map;
import java.util.LinkedHashMap;

public class DuplicateWords {

    public static void getWordCounts(String sentence) {
        String[] splitArray = sentence.split(" ");

        // Used LinkedHashMap to preserve sentence ordering as much as possible
        // as per specifications
        Map<String, Integer> wordFreqMap = new LinkedHashMap<String, Integer>();

        // Convert everything to lowercase to handle case-insensitivity
        String[] lowercaseSplitArray = Arrays.stream(splitArray).map(s -> s.toLowerCase()).toArray(n -> new String[n]);

        for (String v : lowercaseSplitArray) {
            if (wordFreqMap.get(v) == null) {
                wordFreqMap.put(v, 1);
                continue;
            }
            wordFreqMap.put(v, wordFreqMap.get(v) + 1);
        }

        // StringBuilder to allow for mutable strings which will help
        // since I need every key-value pair info to be formatted and inserted
        // into the final output string
        StringBuilder strBuild = new StringBuilder();
        for (Map.Entry<String, Integer> entry : wordFreqMap.entrySet()) {
            strBuild.append(String.format("%s - %d, ", entry.getKey(), entry.getValue()));
        }
        strBuild.setLength(strBuild.length() - 2);

        System.out.println(strBuild);
    }

    public static void main(String[] args) {
        getWordCounts("The time I went to the store I bought a watermelon");
    }
}
