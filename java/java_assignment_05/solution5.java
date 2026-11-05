import java.util.Map;
import java.util.HashMap;
import java.util.StringJoiner;
public class solution5{
    public static void main(String[] args) {
        duplicateCheck("Every word here is unique");
        removeDuplicate("The time I went to the store I bought a watermelon");
    }

    public static void duplicateCheck(String sentence){
        String [] words = sentence.split(" ");
        Map <String, Integer> wordCount = new HashMap();
        for(int i = 0; i < words.length; i++){
            wordCount.put(words[i].toLowerCase(), wordCount.getOrDefault(words[i].toLowerCase(), 0) + 1);
        }
        StringJoiner joiner = new StringJoiner(", ");
        for(String w : words){
            joiner.add(w.toLowerCase() + " - " + wordCount.get(w.toLowerCase()));
        }
        System.out.println(joiner);
    }

    //Stretch Goal Remove Duplicate Words
    public static void removeDuplicate(String sentence){
        String [] words = sentence.split(" ");
        Map <String, Integer> uniqueWord = new HashMap();
        for(String w : words){
            if(!uniqueWord.containsKey(w))
                uniqueWord.put(w, 1);
        }   
        StringJoiner joiner = new StringJoiner(" ");
        for(String w : words){
            if(uniqueWord.get(w) > 0){
                joiner.add(w);
                uniqueWord.replace(w, 0);
            }
        }
        System.out.println(joiner);
    }
}