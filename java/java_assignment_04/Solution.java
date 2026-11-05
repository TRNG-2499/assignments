import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String... args){
		System.out.println(checkPasswordStrength("password"));
		System.out.println(checkPasswordStrength("Password1"));
		System.out.println(checkPasswordStrength("P@ssw0rd"));
		System.out.println(checkPasswordStrength(""));
    }

    public static String checkPasswordStrength(String password){
		if(password == null){
			password = "";
		}
		
        int digits = 0;
        int uppercaseLetters = 0;
        int specialCharacters = 0;

        for(char c : password.toCharArray()){
            if(Character.isDigit(c)){
	    		digits++;
            } else if(Character.isUpperCase(c)){
				uppercaseLetters++;
			} else {
				switch(c){
					case '!':
					case '@':
					case '#':
					case '$':
					case '%':
					case '^':
					case '&':
					case '*':
						specialCharacters++;
						break;
					default:
						break;
				}
			}
		}
		boolean atLeast8Characters = password.length() >= 8;
		boolean atLeast1Digit = digits >= 1;
		boolean atLeast1Uppercase = uppercaseLetters >= 1;
		boolean atLeast1SpecialCharacter = specialCharacters >= 1;
		
		String lengthTest = (atLeast8Characters) ? "Length: Pass" : "Length: Fail";
		String digitTest = (atLeast1Digit) ? "Digit: Pass" : "Digit: Fail";
		String uppercaseTest = (atLeast1Uppercase) ? "Uppercase: Pass" : "Uppercase: Fail";
		String specialTest = (atLeast1SpecialCharacter) ? "Special Character: Pass" : "Special Character: Fail";

		String strength = calculatePasswordStrengthWithTests(atLeast8Characters, atLeast1Digit, atLeast1Uppercase, atLeast1SpecialCharacter);
		return lengthTest + " | " + digitTest + " | " + uppercaseTest + " | " + specialTest + " -- " + strength;
	}

	private static String calculatePasswordStrengthWithTests(boolean length, boolean digit, boolean uppercase, boolean special){
		int testsPassed = 0;
		if(length) testsPassed++;
		if(digit) testsPassed++;
		if(uppercase) testsPassed++;
		if(special) testsPassed++;
		
		if(testsPassed >= 4){
			return "Strength: Strong";
		} else if(testsPassed == 2 || testsPassed == 3){
			return "Strength: Medium";
		} else {
			return "Strength: Weak";
		}
	}
}