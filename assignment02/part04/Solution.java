package assignment02.part04;
import java.util.Scanner;

public class Solution {

    public static String passwordChecker(String password){
        boolean ischarLong = false;
        boolean isDigit = false;
        boolean isUpper = false;
        boolean isSpec = false;

        if (password == null){
            password = "";
        }

        String specialChar = "!@#$%^&*";
        int len = password.length();
        int numRules = 0;

        for(int i = 0; i < len; i++){
            char c = password.charAt(i);
            if (Character.isDigit(c)){
                isDigit = true;
            }
            if (Character.isUpperCase(c)){
                isUpper = true;
            }
            if (specialChar.contains(String.valueOf(c))){
                isSpec = true;
            }
        }
        if (len >= 8){
            numRules++;
            ischarLong = true;
        }
        if (isDigit){
            numRules++;
        }
        if (isUpper){
            numRules++;
        }
        if (isSpec){
            numRules++;
        }

        return String.format("Length: %s | Digit: %s | Uppercase: %s | Special Character: %s -- Strength: %s", 
                            ischarLong ? "Pass":"Fail", isDigit ? "Pass":"Fail", isUpper ? "Pass":"Fail", isSpec ? "Pass":"Fail",
                        (numRules == 4) ? "Strong": (numRules >= 2) ? "Medium" : "Weak");
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        System.out.println(passwordChecker(userInput));
        System.out.println(passwordChecker(null));
        sc.close();
    }
}
