import java.util.Arrays;
import java.util.Scanner;

public class DuplicateWords {

    public static void main(String[] args) {
        System.out.println("Duplicate Words in a Sentence");

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a sentence: ");
            String sentence = scanner.nextLine();

            System.out.println();
            countWords(sentence);

            System.out.println();
            System.out.println("Without duplicates: " + removeDuplicates(sentence));

            System.out.println();
            printStatistics(sentence);
        }
    }

    // Base requirement
    public static void countWords(String sentence) {
        String[] words = splitWords(sentence);
        String[] unique = uniqueWords(sentence);

        String output = "";
        for (int i = 0; i < unique.length; i++) {
            if (i > 0) output += ", ";
            output += unique[i] + " - " + countOf(words, unique[i]);
        }
        System.out.println(output);
    }

    // Stretch goal 1
    public static String removeDuplicates(String sentence) {
        String[] words = splitWords(sentence);
        String result = "";

        for (int i = 0; i < words.length; i++) {
            boolean seenBefore = false;
            for (int j = 0; j < i; j++) {
                if (words[j].equalsIgnoreCase(words[i])) {
                    seenBefore = true;
                    break;
                }
            }
            if (!seenBefore) {
                result += (result.isEmpty() ? "" : " ") + words[i];
            }
        }
        return result;
    }

    // Stretch goal 2
    public static void printStatistics(String sentence) {
        String[] words = splitWords(sentence);
        String[] unique = uniqueWords(sentence);

        int maxCount = 0, minCount = Integer.MAX_VALUE;
        int maxLength = 0, minLength = Integer.MAX_VALUE;

        for (String word : unique) {
            int count = countOf(words, word);
            maxCount = Math.max(maxCount, count);
            minCount = Math.min(minCount, count);
            maxLength = Math.max(maxLength, word.length());
            minLength = Math.min(minLength, word.length());
        }

        String mostFrequent = "", leastFrequent = "", longest = "", shortest = "";

        for (String word : unique) {
            int count = countOf(words, word);
            if (count == maxCount) mostFrequent = addToList(mostFrequent, word);
            if (count == minCount) leastFrequent = addToList(leastFrequent, word);
            if (word.length() == maxLength) longest = addToList(longest, word);
            if (word.length() == minLength) shortest = addToList(shortest, word);
        }

        System.out.println("Most frequent:  " + mostFrequent + " (" + maxCount + ")");
        System.out.println("Least frequent: " + leastFrequent + " (" + minCount + ")");
        System.out.println("Longest:        " + longest + " (" + maxLength + " characters)");
        System.out.println("Shortest:       " + shortest + " (" + minLength + " characters)");
    }

    private static String[] splitWords(String sentence) {
        return sentence.trim().split("\\s+");
    }

    private static int countOf(String[] words, String target) {
        int count = 0;
        for (String word : words) {
            if (word.equalsIgnoreCase(target)) count++;
        }
        return count;
    }

    private static String[] uniqueWords(String sentence) {
        String[] words = splitWords(sentence);
        String[] temp = new String[words.length];
        int size = 0;

        for (String word : words) {
            String lower = word.toLowerCase();
            boolean found = false;
            for (int j = 0; j < size; j++) {
                if (temp[j].equals(lower)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                temp[size] = lower;
                size++;
            }
        }
        return Arrays.copyOf(temp, size);
    }
    private static String addToList(String list, String word) {
        return list.isEmpty() ? word : list + ", " + word;
    }
}