import java.util.HashMap;
public class wordCounterGP {
    public static void main(String[] args) {
        counter("Hi how are you you");
    }
    public static void counter(String sentence) {
        String[] words = sentence.split(" ");

        HashMap<String, Integer> wordMap = new HashMap<>();

        for(int i = 0; i < words.length; i++) {
            if (wordMap.containsKey(words[i])) {
                wordMap.put(words[i], wordMap.get(words[i]) + 1);
            } else {
                wordMap.put(words[i], 1);
            }
        }
        for (String i : wordMap.keySet()) {
            System.out.print("| " + i + " -" + wordMap.get(i));
            System.out.println(" ");
        }
    }
}
