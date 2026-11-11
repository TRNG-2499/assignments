import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class algo3_solution {
    public String solution(String sentence){
        if(sentence == null) return ""; // assignment doesn't ask for null change, but putting one
        if(sentence.isEmpty()) return sentence;
        List<String> result = new ArrayList<>();
        int ticker = 0;
        int groupStart = 0;
        String[] words = sentence.split("");
        for(int i = 0; i < words.length; i++){
            ticker++;
            String character1 = words[groupStart].toLowerCase();
            if(i != words.length-1){
                String character2 = words[i+1].toLowerCase();
                if(character1.equals(character2)){
                    continue;
                }else{
                    result.add(words[groupStart] + ticker);
                    ticker = 0;
                    groupStart =  i + 1;
                }
            }else{
                result.add(words[groupStart] + ticker);
                ticker = 0;
            }
        }
        return String.join("", result);
    }

    public String onlyShorter(String sentence){
        if(sentence == null) return ""; // assignment doesn't ask for null change, but putting one
        if(sentence.isEmpty()) return sentence;
        List<String> result = new ArrayList<>();
        int ticker = 0;
        int groupStart = 0;
        String[] words = sentence.split("");
        for(int i = 0; i < words.length; i++){
            ticker++;
            String character1 = words[groupStart].toLowerCase();
            if(i != words.length-1){
                String character2 = words[i+1].toLowerCase();
                if(character1.equals(character2)){
                    continue;
                }else{
                    result.add(words[groupStart] + ticker);
                    ticker = 0;
                    groupStart =  i + 1;
                }
            }else{
                result.add(words[groupStart] + ticker);
                ticker = 0;
            }
        }

        String finalized = String.join("",result);
        if(finalized.length() < sentence.length()) {
            return finalized;
        }else{
            return sentence;
        }
    }

    public String decompress(String sentence){ // assume sentence always has at least letter + number?
        String[] words = sentence.split("");
        List<String> result = new ArrayList<>();
        for(int i = 0; i < sentence.length(); i+=2){
            String character =  words[i].toLowerCase();
            int number = Integer.parseInt(words[i+1]);
            for(int j = 0; j < number; j++){
                result.add(words[i]);
            }
        }
        return String.join("", result);
    }

    public static void main(String[] args){
        algo3_solution algo3 = new algo3_solution();
        System.out.println(algo3.solution("aaaaaaa")); // expect a7
        System.out.println(algo3.solution("aabbccdd")); // expect a2b2c2d2
        System.out.println(algo3.solution("abcd")); // expect a1b1c1d1
        System.out.println(algo3.solution("aAaBbCCC")); // expect a3B2C3
        System.out.println(algo3.solution("")); // expect ""
        System.out.println("---------- Stretch Goals ----------");
        System.out.println(algo3.onlyShorter("aaa")); // expect a3
        System.out.println(algo3.onlyShorter("aa")); // expect aa
        System.out.println(algo3.onlyShorter("aabcde")); // expect aabcde
        System.out.println(algo3.decompress("a7")); // expect aaaaaaa
        System.out.println(algo3.decompress("a2")); // expect aa
        System.out.println(algo3.decompress("A1P5l2x1")); // expect APPPPPllx
    }
}
