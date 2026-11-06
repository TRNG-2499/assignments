import java.util.LinkedHashMap;

public class Solution_05 {

  public static void main(String[] args) {
    dupWords("The time I went to the store I bought a watermelon");
    dupWords("Java is fun and Java is powerful");
    dupWords("apple banana apple orange banana apple");
    dupWords("Every word here is unique");
    dupWords("HELLO hello Hello WORLD world");
  }

  public static void dupWords(String sentence) {
    //seperate words
    String[] words = sentence.split(" ");

    // create hash map
    LinkedHashMap<String, Integer> wordCount = new LinkedHashMap<>();

    // loop through array of words
    for (int i = 0; i < words.length; i++) {
      // normialize to lower case
      words[i] = words[i].toLowerCase();

      // if word in array is in wordcount hash get its value and add 1
      if (wordCount.containsKey(words[i])) {
        wordCount.put(words[i], wordCount.get(words[i]) + 1);
      } else {
        // else put the word in wordcount and set a value to 1
        wordCount.put(words[i], 1);
      }
    }
    printResults(wordCount);
  }

  private static void printResults(LinkedHashMap<String, Integer> hashWords) {
    String stringResult = "";
    for (String word : hashWords.keySet()) {
      if (!stringResult.isEmpty()) {
        stringResult += ", ";
      }
      stringResult += word + " - " + hashWords.get(word);
    }
    System.out.println(stringResult);
  }

  //could be added to printResults or dupwords
  private static void printWoDups(LinkedHashMap<String, Integer> hashWords) {
    String stringResult = "";
    for (String word : hashWords.keySet()) {
      if (!stringResult.isEmpty()) {
        stringResult += " ";
      }
      stringResult += word;
    }
    System.out.println(stringResult);
  }
}
