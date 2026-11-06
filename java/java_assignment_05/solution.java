import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;

public class solution {
    public static void main(String[] args) {

        // test cases
        splitter("The time I went to the store I bought a watermelon");
        System.out.print("\n");
        splitter("Every word here is unique");
        System.out.print("\n");
        splitter("Revature is an awesome program I sure hope I get placed with Cognizant");
        System.out.print("\n");
        splitter("Java is a coding language Java has a cool ring to it Coding is fun");
        System.out.print("\n\n");

        // stretch goal 1 test cases using removeDuplicates
        // returns a string so main prints the result

        System.out.println(removeDuplicates("The time I went to the store I bought a watermelon"));
        System.out.println(removeDuplicates("Every word here is unique"));
        System.out.println(removeDuplicates("Java is a coding language Java has a cool ring to it Coding is fun"));
        System.out.print("\n");

        // stretch goal 2 test cases using sentenceStatistics
        // prints to the console the same way splitter does

        sentenceStatistics("The time I went to the store I bought a watermelon");
        System.out.print("\n");
        sentenceStatistics("Every word here is unique");
        System.out.print("\n");
        sentenceStatistics("Java is a coding language Java has a cool ring to it Coding is fun");

    }

    // splitter() method is created to manipulate the string


    public static void splitter(String inputSentence) {

        // because it is case-insensitive, i take the entire sentence and instantly drown it all to lowercase
        // so examination is the same across all words
        String sentenceLowerCase = inputSentence.toLowerCase();

        // splitting sentence up into an array for loop to iterate through
        String[] dividedSentence = sentenceLowerCase.split(" ");

        // creating new empty map, using linked so it remembers order
        Map<String, Integer> tally = new LinkedHashMap<>();

        // for loop to check through each word in the sentence
        for (String str : dividedSentence) {
            // if word is located within the map already, .get is used to get current value and save it to current
            // current gets + 1 added to it, and then it is stored back into the map with updated value
            if (tally.containsKey(str)) {
                int current = tally.get(str);
                int updated = current + 1;
                tally.put(str, updated);

                // if word is not seen in map, the word is put as new pair with value 1
            } else {
                tally.put(str, 1);
            }
        }

        // declaring counter to be able to display punctuation correctly
        int counter = 0;


        for (Map.Entry<String, Integer> entry : tally.entrySet()) {
            System.out.print(entry.getKey() + " - " + entry.getValue());
            counter++;
            // if the counter is less than the current map size, it will print a comma
            // if it is equal to or greater than the map size, it will break and not print the final comma
            if (counter < tally.size()) {
                System.out.print(", ");
            }
        }
    }

    // stretch goal 1: remove duplicate words
    // returns the sentence with every repeat of a word removed, keeping only the first time it shows up
    // the kept words stay in their original order and original casing

    public static String removeDuplicates(String inputSentence) {

        // splitting the original sentence, not a lowercase copy, so the original casing is kept for the output
        String[] dividedSentence = inputSentence.split(" ");

        // set to remember which words have already been seen
        // a set only holds unique values and is fast to check, and only the word matters here, not a count,
        // so a set fits better than a map
        Set<String> seenWords = new HashSet<>();

        // list to hold the words that make it into the final sentence, in order
        List<String> keptWords = new ArrayList<>();

        for (String str : dividedSentence) {
            // the lowercase version is what gets checked and stored so "The" and "the" count as the same word
            String lowerWord = str.toLowerCase();

            // if the word hasnt been seen yet, it is the first occurrence, so it is kept with its original casing
            // and marked as seen so any later repeats get skipped
            if (!seenWords.contains(lowerWord)) {
                seenWords.add(lowerWord);
                keptWords.add(str);
            }
        }

        // joining the kept words back together with a space between each one
        return String.join(" ", keptWords);
    }

    // stretch goal 2: sentence statistics
    // reports the most and least frequent words, and the longest and shortest words
    // every tie is reported, and all words are shown in lowercase like splitter()

    public static void sentenceStatistics(String inputSentence) {

        // same tally process as splitter() to get each unique word and its count, in order

        String sentenceLowerCase = inputSentence.toLowerCase();
        String[] dividedSentence = sentenceLowerCase.split(" ");
        Map<String, Integer> tally = new LinkedHashMap<>();

        for (String str : dividedSentence) {
            if (tally.containsKey(str)) {
                int current = tally.get(str);
                int updated = current + 1;
                tally.put(str, updated);
            } else {
                tally.put(str, 1);
            }
        }

        // first pass: going through every unique word once to find the highest and lowest count,
        // and the longest and shortest length
        // they start at the most extreme values possible so the first word always replaces them

        int highestCount = 0;
        int lowestCount = Integer.MAX_VALUE;
        int longestLength = 0;
        int shortestLength = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> entry : tally.entrySet()) {
            int count = entry.getValue();
            int length = entry.getKey().length();

            if (count > highestCount) {
                highestCount = count;
            } if (count < lowestCount) {
                lowestCount = count;
            } if (length > longestLength) {
                longestLength = length;
            } if (length < shortestLength) {
                shortestLength = length;
            }
        }

        // second pass: now that the highest and lowest values are known, every word that matches
        // one of them is added to its list, which is how ties get included

        List<String> mostFrequent = new ArrayList<>();
        List<String> leastFrequent = new ArrayList<>();
        List<String> longestWords = new ArrayList<>();
        List<String> shortestWords = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : tally.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();

            if (count == highestCount) {
                mostFrequent.add(word);
            } if (count == lowestCount) {
                leastFrequent.add(word);
            } if (word.length() == longestLength) {
                longestWords.add(word);
            } if (word.length() == shortestLength) {
                shortestWords.add(word);
            }
        }

        // printing each result, String.join puts a comma between tied words with no trailing comma
        System.out.println("Sentence: " + inputSentence);
        System.out.println("Most frequent (" + highestCount + "): " + String.join(", ", mostFrequent));
        System.out.println("Least frequent (" + lowestCount + "): " + String.join(", ", leastFrequent));
        System.out.println("Longest (" + longestLength + " characters): " + String.join(", ", longestWords));
        System.out.println("Shortest (" + shortestLength + " characters): " + String.join(", ", shortestWords));
    }

}