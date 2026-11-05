import java.util.*;


public class duplicateWordsInSentence {
    static void main(String[] args) {
        duplicateWordsInSentence instance = new duplicateWordsInSentence();
        /*
            Main test
         */
//        String sentence = "The time I went to the store I bought a watermelon";
//        System.out.println(instance.duplicateWordFinder(sentence));

        /*
            Stretch test
         */
        String sentence = "The time I went to the store I bought a watermelon";
        System.out.println(instance.duplicateWordFinderStretch(sentence));
    }

    public String duplicateWordFinder(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            throw new IllegalArgumentException("Error: Sentence input: Sentence cannot be empty.");
        }

        Map<String, Integer> wordCountMap = new HashMap<>();
        String[] words = sentence.split("\\s+"); // \\s+ handles multiple spaces, tabs, etc
        for (String word : words) {
            String lowercase = word.toLowerCase();
            if (wordCountMap.containsKey(lowercase)) {
                wordCountMap.put(lowercase, wordCountMap.get(lowercase) + 1);
            } else {
                wordCountMap.put(lowercase, 1);
            }
        }
        return wordCountMap.toString();
    }

    public String duplicateWordFinderStretch(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            throw new IllegalArgumentException("Error: Sentence input: Sentence cannot be empty.");
        }
        Map<String, Integer> wordCountMap = new HashMap<>();
        String[] words = sentence.split("\\s+"); // \\s+ handles multiple spaces, tabs, etc
        int maxWordLen = 0;
        int minWordLen = Integer.MAX_VALUE;
        int maxWordCount = 0;
        int minWordCount = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            maxWordLen = Math.max(word.length(), maxWordLen);
            minWordLen = Math.min(word.length(), minWordLen);

            // Update word count in dictionary
            String lowercase = word.toLowerCase();
            if (wordCountMap.containsKey(lowercase)) {
                int newCount = wordCountMap.get(lowercase) + 1;
                wordCountMap.put(lowercase, newCount);
                maxWordCount = Math.max(newCount, maxWordCount);
                minWordCount = Math.min(newCount, minWordCount);
            } else {
                wordCountMap.put(lowercase, 1);
                maxWordCount = Math.max(1, maxWordCount);
                minWordCount = Math.min(1, minWordCount);

                // Removing duplicate words for the return sentence
                if (!sb.isEmpty()) {
                    sb.append(" ");
                }
                sb.append(word);
            }
        }
        // Get the least and most frequently repeated words and words with least and most characters
        List<String> mostFrequent = new ArrayList<>();
        List<String> leastFrequent = new ArrayList<>();
        List<String> mostCharacters = new ArrayList<>();
        List<String> leastCharacters = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if (value == maxWordCount) {
                mostFrequent.add(key);
            } if (value == minWordCount) {
                leastFrequent.add(key);
            } if (key.length() == maxWordLen) {
                mostCharacters.add(key);
            } if (key.length() == minWordLen) {
                leastCharacters.add(key);
            }
        }

        // Create the final string that contains all info
        String noDuplicateSentence = sb.toString();

        return "Sentence without duplicates: " + noDuplicateSentence +
                "\nLeast Frequent Word(s): " + leastFrequent.toString() +
                "\nMost Frequent Word(s): " + mostFrequent.toString() +
                "\nLongest word(s): " + mostCharacters.toString() +
                "\nShortest word(s): " + leastCharacters.toString();
    }
}
