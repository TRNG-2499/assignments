package javaAlgAssignment.part03;
public class Solution {

    public static String consecutiveCharacters(String s){

        if(s.length() == 0){
            return "";
        }

        String lower = s.toLowerCase();
        String res = "";
        int count = 1;
        int start = 0;
        for (int i = 0; i < s.length()-1; i++){
            if(lower.charAt(i) == lower.charAt(i+1)){
                count++;
            } else{
                res += s.charAt(start) + "" + count;
                start= i+1;
                count = 1;
            }
        }
        if (!lower.isEmpty()){
            res+= s.charAt(start) + "" + count;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(consecutiveCharacters("aaabbbccd"));
        System.out.println(consecutiveCharacters("abcd"));
        System.out.println(consecutiveCharacters("AaaaaaS"));
        System.out.println(consecutiveCharacters("aAaA"));
        System.out.println(consecutiveCharacters(""));
    }
}
