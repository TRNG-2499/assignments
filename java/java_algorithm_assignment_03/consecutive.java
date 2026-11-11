import java.util.HashMap;
import java.util.Map;
public class consecutive {

public static String count(String word) {
    if (word.length() < 1) {
        return "";
    }
    int left = 0;
    int count = 0;
    Map <Character,Integer> con = new HashMap<>();
    for(int right =0; right<word.length();right++) {
        
        if (Character.toLowerCase(word.charAt(left)) == Character.toLowerCase(word.charAt(right))) {
            count+=1;
        }
        
        else {
            //System.out.print(word.charAt(left)+ " " + count);
            con.put(word.charAt(left),count);
            count= 1;
            left = right;
        }

    }
    con.put(word.charAt(left),count);
    StringBuilder result = new StringBuilder();
    for(Map.Entry<Character,Integer> entry: con.entrySet()) {
        result.append(entry.getKey());
        result.append(entry.getValue());
    }
    System.out.println(result);
    return "";
}
public static void main(String[] args) {
    count("aaabbbccd");

    count("abcd");
   
    count("aaaaaa");
   
    
    count("aAaA");
    count("");
}
}