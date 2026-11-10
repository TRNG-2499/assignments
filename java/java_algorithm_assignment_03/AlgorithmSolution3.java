import java.util.HashMap;
import java.util.LinkedHashMap;
public class AlgorithmSolution3{
    public static void main(String[] args) {
        System.out.println(compressConsecString(""));
        System.out.println(decompresString("a3b3c2d1"));
    }
    public static String compressConsecString(String str){
        HashMap <Character, Integer> uniqueCount = new LinkedHashMap<>();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(uniqueCount.keySet().contains(Character.toUpperCase(c)))
                c = Character.toUpperCase(c);
            else if(uniqueCount.keySet().contains(Character.toLowerCase(c)))
                c = Character.toLowerCase(c);
            uniqueCount.put(c, uniqueCount.getOrDefault(c, 0) + 1);
        }
        StringBuilder buildStr = new StringBuilder();
        for(Character key : uniqueCount.keySet()){
            buildStr.append(key);
            buildStr.append(uniqueCount.get(key));
        }
        return buildStr.toString();
    }

    //Stretch Goal Decompression
    public static String decompresString(String str){
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < str.length(); i+=2){
            Character c = str.charAt(i);
            int length = Integer.parseInt(str.charAt(i+1)+"");
            for(int j = 0; j < length; j++)
                output.append(c);
        }
        return output.toString();
    }
}