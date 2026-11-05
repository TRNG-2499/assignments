import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void countWords(String input) {
        Map<String, Integer> wordCounter = new LinkedHashMap<>(); //using linkedhashmap over regular hash map bc it maintains insertion order
        String[] splitSentence = input.split(" ");

        //Counting words
        for (String s : splitSentence) {
            String currentWord = s.toLowerCase();

            if (!wordCounter.containsKey(currentWord)) {
                //Case where word doesn't exist in map yet
                wordCounter.put(currentWord, 1);
            } else {
                //Case where word has already appeared at least once
                wordCounter.replace(currentWord, wordCounter.get(currentWord) + 1);
            }
        }

        //Printing out word counts
        for (String key : wordCounter.keySet()){
            System.out.print(key + " - " + wordCounter.get(key) + ", ");
        }

    }



    public static void main(String[] args) {

        //Example 1
        System.out.println("\nThe time I went to the store and bought a watermelon");
        countWords("The time I went to the store and bought a watermelon");

        //No Duplicates
        System.out.println("\nEvery word here is unique");
        countWords("Every word here in unique");

    }
}
