package java_assignment_05;

public class Solution {
    public static void main(String[] args) {
        String input = "This is a test. This test is only a test.";
        wordCounter(input);

        String input2 = "every word is unique in this sentence";
        wordCounter(input2);

    }


    public static String wordCounter(String input) {
        String[] inputWords = input.split("\\s+");
        String[] uniqueWords = new String[inputWords.length];
        int[] counts = new int[inputWords.length];
        int uniqueWordCount = 0;

        for (String word : inputWords) {
            String lowercaseWord = word.toLowerCase();
            int wordIndex = 0;
            while (wordIndex < uniqueWordCount
                    && !uniqueWords[wordIndex].equals(lowercaseWord)) {
                wordIndex++;
            }

            if (wordIndex < uniqueWordCount) {
                counts[wordIndex]++;
            } else {
                uniqueWords[uniqueWordCount] = lowercaseWord;
                counts[uniqueWordCount] = 1;
                uniqueWordCount++;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < uniqueWordCount; i++) {
            if (result.length() > 0) {
                result.append(", ");
            }
            result.append(uniqueWords[i]).append(" - ").append(counts[i]);
        }

        String output = result.toString();
        System.out.println(output);
        return output;
    }

}
