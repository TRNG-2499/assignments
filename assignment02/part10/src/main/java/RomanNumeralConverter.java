import java.util.HashMap;
import java.util.Map;

public class RomanNumeralConverter {

    public static String toRoman(int number){

        if(number <= 0 || number >3999){
            throw new IllegalArgumentException("The valid input numbers is from 1-3999");
        }
        String[] r = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        Integer[] nums = {1000, 900, 500,400, 100,90, 50,40, 10,9,5,4,1};
        String res ="";
        int total;
        for(int i = 0; i <r.length; i++){
            while(number>=nums[i]){
                total = number/nums[i];
                res+=r[i];
                number-=nums[i];
            }
        }
        return res;
    }

    public static int toInteger(String roman){
        Map <Character,Integer> letterValue = new HashMap<>();

        if (roman == null || roman.isBlank()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
        
        letterValue.put('I', 1);
        letterValue.put('V', 5);
        letterValue.put('X', 10);
        letterValue.put('L', 50);
        letterValue.put('C', 100);
        letterValue.put('D', 500);
        letterValue.put('M', 1000);

        String caseHandle = roman.toUpperCase();
        for (int i = 0; i < caseHandle.length(); i++) {
            Integer current = letterValue.get(caseHandle.charAt(i));
            if (current == null) {
                throw new IllegalArgumentException("Invalid Roman numeral: " + roman);
            }
        }
        
        int n = roman.length();
        int total = 0;
        for(int i = 0; i < n; i++){
            if(i+1 < n && letterValue.get(caseHandle.charAt(i)) < letterValue.get(caseHandle.charAt(i+1))){
                total -= letterValue.get(caseHandle.charAt(i));
            } else if (i+ 1 < n && letterValue.get(caseHandle.charAt(i)) >= letterValue.get(caseHandle.charAt(i+1))){
                total += letterValue.get(caseHandle.charAt(i));
            } else {
                total+= letterValue.get(caseHandle.charAt(i));
            }
        }
        return total;
    }

    public static void main(String[] args) {
        String r = "XLIIIII";
        System.out.println(toRoman(3040));
        System.out.println(toInteger(r));
    }
}