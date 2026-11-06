import java.util.Arrays;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

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


    // Stretch goal #1
    // Used a set to ensure we maintain just one copy of each word,
    // a linked hash set specifically so the ordering is preserved
    //
    // Then used String.join() to quickly and easily combine the values in the set
    // by a " " character
    public static void removeDuplicateWords(String sentence) {
        String[] splitArray = sentence.split(" ");

        LinkedHashSet<String> wordSet = new LinkedHashSet<String>();
        for (String word : splitArray) {
            wordSet.add(word);
        }

        String result = String.join(" ", wordSet);
        System.out.println(result);
    }


    // Stretch goal #2
    public static class LongestWordInfo {
        String longestWord;
        int longestWordCount;
    }

    public static class ShortestWordInfo {
        String shortestWord;
        int shortestWordCount;
    }

    public static class MostFrequentInfo {
        String mostFreq;
        int mostFreqCount;
    }

    public static class LeastFrequentInfo {
        String leastFreq;
        int leastFreqCount;
    }

    public static void getSentenceStats(String sentence) {
        String[] strArray = sentence.split(" ");
        LinkedHashMap<String, Integer> wordFreqMap = new LinkedHashMap<String, Integer>();

        LongestWordInfo longest = new LongestWordInfo();
        ShortestWordInfo shortest = new ShortestWordInfo();

        for (int i = 0; i < strArray.length; i++) {
            String word = strArray[i];

            if (i == 0) {
                longest.longestWord = word;
                longest.longestWordCount = word.length();
                shortest.shortestWord = word;
                shortest.shortestWordCount = word.length();
            }

            if (wordFreqMap.get(word) == null) {
                wordFreqMap.put(word, 1);

                if (word.length() > longest.longestWordCount) {
                    longest.longestWord = word;
                    longest.longestWordCount = word.length();
                }

                if (word.length() < shortest.shortestWordCount) {
                    shortest.shortestWord = word;
                    shortest.shortestWordCount = word.length();
                }

                continue;
            }
            wordFreqMap.put(word, wordFreqMap.get(word) + 1);
        }

        // Initial value rides on the assumption that the sentence will have at least one
        // string value, otherwise I'd just add an edge case handler at the top for
        // empty strings
        MostFrequentInfo mf = new MostFrequentInfo();
        LeastFrequentInfo lf = new  LeastFrequentInfo();

        boolean firstIdx = true;
        for (Map.Entry<String, Integer> entry : wordFreqMap.entrySet()) {
            if (firstIdx) {
                firstIdx = false;
                mf.mostFreq = entry.getKey();
                mf.mostFreqCount = entry.getValue();
                lf.leastFreq = entry.getKey();
                lf.leastFreqCount = entry.getValue();
                continue;
            }

            if (entry.getValue() > mf.mostFreqCount) {
                mf.mostFreq = entry.getKey();
                mf.mostFreqCount = entry.getValue();
            }

            if (entry.getValue() < lf.leastFreqCount) {
                lf.leastFreq = entry.getKey();
                lf.leastFreqCount = entry.getValue();
            }
        }

        System.out.printf("Most frequent word(s): %s appears %d times %n", mf.mostFreq, mf.mostFreqCount);
        System.out.printf("Least frequent word(s): %s appears %d times %n", lf.leastFreq, lf.leastFreqCount);
        System.out.printf("Longest word(s): %s has %d characters %n", longest.longestWord, longest.longestWordCount);
        System.out.printf("Shortest word(s): %s has %d characters %n", shortest.shortestWord, shortest.shortestWordCount);
    }


    public static void main(String[] args) {
        // getWordCounts("The time I went to the store I bought a watermelon");

        // removeDuplicateWords("The time I went to the store I bought a watermelon");

        getSentenceStats("The time I went to the store I bought a watermelon");
    }
}
