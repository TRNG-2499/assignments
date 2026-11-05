//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class solution {
    public static void main(String[] args) {

        // five test cases using the passwordCheck method with the string (password) as the passed in argument
        // one case of each strength is displayed
        // both inputs of null and empty string are processed as well

        System.out.println(passwordCheck("password"));
        System.out.println(passwordCheck("Password1"));
        System.out.println(passwordCheck("P@ssw0rd!"));
        System.out.println(passwordCheck(""));
        System.out.println(passwordCheck(null));
    }

    public static String passwordCheck(String password) {

        // declaring variables to use in final return message as false to begin with

        String Length = "Fail";
        String Digit = "Fail";
        String Uppercase = "Fail";
        String Special = "Fail";
        String Strength = "Weak";

        int characterCount = 0; // keep track of how  many digits the password contained
        boolean uppercaseLetter = false; // keep track of whether an uppercase letter was used or not
        boolean specialCharacter = false; // keep track of whether a special letter was used or not
        boolean numberUsed = false; // keep track of whether a number  was used or not
        boolean charCountReached = false; // keep track of whether the password provided met the required minimum digits of 8
        int rulesPassed = 0; // keep track of the final tally of rules passed

        // before password is processed, we want to ensure it has text to begin with and isnt null.
        // null is treated as weak

        if (password == null) {
            return ("Length: " + Length + " | Digit: " + Digit + " | Uppercase: " + Uppercase + " | Special Character: " + Special + " -- Strength: " + Strength);
        }

        // Loop to check each individual character in the string and if each char satisfies
        // one of the rules we have, then it is checked off during the process

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            characterCount++;
            if (ruleCheck(c)) {
                specialCharacter = true;
            } else if (Character.isDigit(c)) {
                numberUsed = true;
            } else if (Character.isUpperCase(c)) {
                uppercaseLetter = true;
            } else {
            }
        }

        // check to go through each originally false rules, and check if they
        // have turned to true, therefor adding a tally to rules passed to see how many
        // in total have been met

        if (characterCount >= 8) {
            charCountReached = true;
            rulesPassed++;
        } if (uppercaseLetter) {
            rulesPassed++;
        } if (specialCharacter) {
            rulesPassed++;
        } if (numberUsed) {
            rulesPassed++;
        }


        // Finalizing the message to return with each rules condition in the end
        if (charCountReached) {
            Length = "Pass";
        } if (uppercaseLetter) {
            Uppercase = "Pass";
        } if (specialCharacter) {
            Special = "Pass";
        } if (numberUsed) {
            Digit = "Pass";
        }

        // ranking the strength of the password by checking how many rules were met in the end
        if (rulesPassed <= 1) {
            Strength = "Weak";
        } else if (rulesPassed >= 2 && rulesPassed <= 3) {
            Strength = "Medium";
        } else if (rulesPassed == 4) {
            Strength = "Strong";
        } else {
            return "";
        }
        // final return message ready to send as all values have been filled in and updated correctly
        return ("Length: " + Length + " | Digit: " + Digit + " | Uppercase: " + Uppercase + " | Special Character: " + Special + " -- Strength: " + Strength);
    }

    // simple switch case to check whether if a char passwordCheck() is going through
    // is one of the included special characters as java does not provide a check within default library

    public static boolean ruleCheck(char passwordRuleCheck) {

        switch (passwordRuleCheck) {
            case '!', '@', '#', '$', '%', '^', '&', '*': {
                return true;
            }
            default: {
                return false;
            }
        }
    }
}