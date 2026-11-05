import java.util.Map;
import java.util.LinkedHashMap;

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

}
