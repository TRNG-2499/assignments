package java_assignment_05;

import java.util.*;

public class dupWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Running duplicate word check...");

        System.out.println("Choose mode: ");
        System.out.println("1. Default Mode");
        System.out.println("2. Remove Duplicates");
        System.out.println("3. Sentence Stats");
        System.out.print("Enter your choice: ");
        int mode = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        String[] words = sentence.split("\\s+");

        switch (mode) {
            case 1:
                DefaultMode(words);
                break;
            case 2:
                String result = RemoveDup(words);
                System.out.println(result);
                break;
            case 3:
                SentenceStats(words);
                break;
            default:
                System.out.println("Invalid mode selected.");
                break;
        }

        scanner.close();
    }

    public static void DefaultMode(String[] words) {

        Map<String, Integer> counts = new LinkedHashMap<>();

        for (String word : words) {
            String lowerCase = word.toLowerCase();
            counts.put(lowerCase, counts.getOrDefault(lowerCase, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            System.out.print(entry.getKey() + " - " + entry.getValue() + ", ");
        }

    }

    public static String RemoveDup(String[] words) {

        Map<String, Integer> counts = new LinkedHashMap<>();

        String result = "";

        for (String word : words) {
            String lowerCase = word.toLowerCase();
            counts.put(lowerCase, counts.getOrDefault(lowerCase, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            result += entry.getKey() + " ";
        }
        return result;
    }

    public static void SentenceStats(String[] words) {

        int highestCount = Integer.MIN_VALUE;
        int lowestCount = Integer.MAX_VALUE;
        int longestLength = Integer.MIN_VALUE;
        int shortestLength = Integer.MAX_VALUE;

        Map<String, Integer> counts = new LinkedHashMap<>();

        for (String word : words) {
            String lowerCase = word.toLowerCase();
            counts.put(lowerCase, counts.getOrDefault(lowerCase, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            System.out.print(entry.getKey() + " - " + entry.getValue() + ", ");
        }

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            int count = entry.getValue();
            int length = entry.getKey().length();

            if (count > highestCount) {
                highestCount = count;
            }
            if (count < lowestCount) {
                lowestCount = count;
            }
            if (length > longestLength) {
                longestLength = length;
            }
            if (length < shortestLength) {
                shortestLength = length;
            }
        }

        List<String> mostFrequent = new ArrayList<>();
        List<String> leastFrequent = new ArrayList<>();
        List<String> longest = new ArrayList<>();
        List<String> shortest = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            int count = entry.getValue();
            int length = entry.getKey().length();

            if (count == highestCount) {
                mostFrequent.add(entry.getKey());
            }
            if (count == lowestCount) {
                leastFrequent.add(entry.getKey());
            }
            if (length == longestLength) {
                longest.add(entry.getKey());
            }
            if (length == shortestLength) {
                shortest.add(entry.getKey());
            }
        }

        System.out.println("Most frequent words: " + mostFrequent);
        System.out.println("Least frequent words: " + leastFrequent);
        System.out.println("Longest words: " + longest);
        System.out.println("Shortest words: " + shortest);

    }
}
