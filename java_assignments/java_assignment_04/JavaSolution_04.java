package java_assignments.java_assignment_04;

import java.util.ArrayList;
import java.util.List;

public class JavaSolution_04 {
    public static void main(String[] args) {
        System.out.println(passwordCheckerStretchTwo(""));
    }

    public static String passwordChecker(String pass){
        boolean oneDigit = false;
        boolean oneUpperCase = false;
        boolean specialChar= false;
        String specialChars = "!@#$%^&*";
        String strength = "";

        pass = pass == null ? "" : pass;

        char[] chArr=pass.toCharArray();

        boolean lengthTest = (pass.length() >= 8) ? true : false;
        int rulesPassed = lengthTest ? 1 : 0;

        for(int i = 0; i < chArr.length; i++){
            if(Character.isDigit(chArr[i]) && !oneDigit){
                oneDigit = true;
                rulesPassed++;
            } else if(Character.isUpperCase(chArr[i]) && !oneUpperCase){
                oneUpperCase = true;
                rulesPassed++;
            } else if(specialChars.indexOf(chArr[i]) != -1 && !specialChar){
                specialChar = true;
                rulesPassed++;
            }
        }

        switch(rulesPassed){
            case 0, 1:
                strength = "Weak";
                break;
            case 2, 3:
                strength = "Medium";
                break;
            case 4:
                strength = "Strong";
                break;
        }
 
        return "Length: "+(lengthTest ? "Pass" : "Fail")+" | Digit: "+(oneDigit ? "Pass" : "Fail")+
        " | Uppercase: "+(oneUpperCase ? "Pass" : "Fail")+" | Special Char: "+(specialChar ? "Pass" : "Fail")+
        " -- Strength: "+strength;

    }

    public static String passwordCheckerStretch(String pass){
        boolean oneDigit = false;
        boolean oneUpperCase = false;
        boolean specialChar= false;
        String specialChars = "!@#$%^&*";
        String strength = "";

        pass = pass == null ? "" : pass;

        char[] chArr=pass.toCharArray();

        boolean lengthTest = (pass.length() >= 8) ? true : false;
        int rulesPassed = lengthTest ? 3 : 0;

        for(int i = 0; i < chArr.length; i++){
            if(Character.isDigit(chArr[i]) && !oneDigit){
                oneDigit = true;
                rulesPassed+=2;
            } else if(Character.isUpperCase(chArr[i]) && !oneUpperCase){
                oneUpperCase = true;
                rulesPassed+=2;
            } else if(specialChars.indexOf(chArr[i]) != -1 && !specialChar){
                specialChar = true;
                rulesPassed+=3;
            }
        }

        switch(rulesPassed){
            case 0, 1, 2, 3, 4:
                strength = "Weak";
                break;
            case 5, 6, 7:
                strength = "Medium";
                break;
            case 8, 9, 10:
                strength = "Strong";
                break;
        }
 
        return "Length: "+(lengthTest ? "Pass" : "Fail")+" | Digit: "+(oneDigit ? "Pass" : "Fail")+
        " | Uppercase: "+(oneUpperCase ? "Pass" : "Fail")+" | Special Char: "+(specialChar ? "Pass" : "Fail")+
        " -- Points: "+rulesPassed+" -- Strength: "+strength;

    }

    public static String passwordCheckerStretchTwo(String pass){
        boolean oneDigit = false;
        boolean oneUpperCase = false;
        boolean specialChar= false;
        String specialChars = "!@#$%^&*";
        String strength = "";
        ArrayList<String> commonPass = new ArrayList<>(List.of("password","Password","123456789","workcomputer","qwerty","null"));
        pass = commonPass.contains(pass) ? "" : pass;

        char[] chArr=pass.toCharArray();

        boolean lengthTest = (pass.length() >= 8) ? true : false;
        int rulesPassed = lengthTest ? 1 : 0;

        for(int i = 0; i < chArr.length; i++){
            if(Character.isDigit(chArr[i]) && !oneDigit){
                oneDigit = true;
                rulesPassed++;
            } else if(Character.isUpperCase(chArr[i]) && !oneUpperCase){
                oneUpperCase = true;
                rulesPassed++;
            } else if(specialChars.indexOf(chArr[i]) != -1 && !specialChar){
                specialChar = true;
                rulesPassed++;
            }
        }

        switch(rulesPassed){
            case 0, 1:
                strength = "Weak";
                break;
            case 2, 3:
                strength = "Medium";
                break;
            case 4:
                strength = "Strong";
                break;
        }
 
        return "Length: "+(lengthTest ? "Pass" : "Fail")+" | Digit: "+(oneDigit ? "Pass" : "Fail")+
        " | Uppercase: "+(oneUpperCase ? "Pass" : "Fail")+" | Special Char: "+(specialChar ? "Pass" : "Fail")+
        " -- Strength: "+strength;

    }
}
