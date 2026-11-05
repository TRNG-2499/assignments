import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String... args){
        System.out.println(readSentence("The time I went to the store I bought a watermelon"));
        System.out.println(readSentence("Every word here is unique"));
    }

    public static String readSentence(String sentence){
        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");
        HashMap<String, Integer> wordCount = new HashMap<>();
        for(String word : words){
		    String caseInsensitiveWord = word.toLowerCase();
		    if(wordCount.containsKey(caseInsensitiveWord)){
			    int count = wordCount.get(caseInsensitiveWord);
			    wordCount.put(caseInsensitiveWord, count + 1);
		    } else {
			    wordCount.put(caseInsensitiveWord, 1);
		    }
	    }

        for(String word: wordCount.keySet()){
            result.append(word + " - " + wordCount.get(word) + ", ");
        }
        result.delete(result.length() - 2, result.length() - 1);
        return result.toString();
    }
}
