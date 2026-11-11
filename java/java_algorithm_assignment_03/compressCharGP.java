import java.util.Locale;
import java.util.HashMap;
public class compressCharGP {
    public static void main(String args[]) {
        System.out.println(compress("aaaaabb"));


    }
    public static String compress(String input) {
        input = input.toLowerCase();
        int charCount = 1;
        char prevChar = input.charAt(0);
        HashMap<String, Integer> charCounts = new HashMap<>();
        for(int i = 1; i < input.length(); i++) {
            char currChar = input.charAt(i);
            if(prevChar == currChar) {
                charCount++;
            } else {
                charCount = 1;
            }
            prevChar = currChar;
            charCounts.put(String.valueOf(currChar),charCount);
        }
        String returnString = "";
        for (String i : charCounts.keySet()) {
            returnString = returnString+(i+charCounts.get(i));
        }
        return returnString;
    }
}
