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

        System.out.println();

        // stretch goal 1 test cases using the weighted point system
        // special character is worth 2 points, so a password with only a special character
        // and length now ranks higher than one with only a digit and length

        System.out.println(passwordWeightedCheck("password"));
        System.out.println(passwordWeightedCheck("password1"));
        System.out.println(passwordWeightedCheck("password!"));
        System.out.println(passwordWeightedCheck("Password1"));
        System.out.println(passwordWeightedCheck("P@ssw0rd!"));
        System.out.println(passwordWeightedCheck(""));
        System.out.println(passwordWeightedCheck(null));

        System.out.println();

        // stretch goal 2 test cases using the blacklist check
        // QWERTY is blacklisted even though it is uppercase, Password1 would normally be medium
        // but is on the list so it gets forced to weak, and P@ssw0rd! is not on the list so it gets the normal result

        System.out.println(passwordBlacklistCheck("password"));
        System.out.println(passwordBlacklistCheck("QWERTY"));
        System.out.println(passwordBlacklistCheck("Password1"));
        System.out.println(passwordBlacklistCheck("P@ssw0rd!"));
        System.out.println(passwordBlacklistCheck(""));
        System.out.println(passwordBlacklistCheck(null));
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

    // stretch goal 1: custom rule weighting
    // instead of every rule counting as 1, each rule is worth a set number of points
    // length = 1, digit = 1, uppercase = 1, special character = 2, for a total of 5 possible points
    // new cutoffs based on points earned out of 5:
    // 5 points (100%) -> Strong
    // 3-4 points (60% - 80%) -> Medium
    // 0-2 points (0% - 40%) -> Weak

    public static String passwordWeightedCheck(String password) {

        // declaring point values for each rule so they are easy to change later in one spot

        int lengthPoints = 1;
        int digitPoints = 1;
        int uppercasePoints = 1;
        int specialPoints = 2;
        int totalPossiblePoints = lengthPoints + digitPoints + uppercasePoints + specialPoints;

        // declaring variables to use in final return message as false to begin with

        String Length = "Fail";
        String Digit = "Fail";
        String Uppercase = "Fail";
        String Special = "Fail";
        String Strength = "Weak";

        int characterCount = 0; // keep track of how many characters the password contained
        boolean uppercaseLetter = false; // keep track of whether an uppercase letter was used or not
        boolean specialCharacter = false; // keep track of whether a special character was used or not
        boolean numberUsed = false; // keep track of whether a number was used or not
        int pointsEarned = 0; // keep track of the final tally of points earned

        // same null check as passwordCheck(), null earns 0 points and is treated as weak

        if (password == null) {
            return ("Length: " + Length + " | Digit: " + Digit + " | Uppercase: " + Uppercase + " | Special Character: " + Special + " -- Points: " + pointsEarned + "/" + totalPossiblePoints + " -- Strength: " + Strength);
        }

        // same loop as passwordCheck() to check off each rule character by character

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            characterCount++;
            if (ruleCheck(c)) {
                specialCharacter = true;
            } else if (Character.isDigit(c)) {
                numberUsed = true;
            } else if (Character.isUpperCase(c)) {
                uppercaseLetter = true;
            }
        }

        // instead of adding 1 per rule passed, each rule adds its own point value
        // and the matching message is flipped to pass at the same time

        if (characterCount >= 8) {
            pointsEarned += lengthPoints;
            Length = "Pass";
        } if (numberUsed) {
            pointsEarned += digitPoints;
            Digit = "Pass";
        } if (uppercaseLetter) {
            pointsEarned += uppercasePoints;
            Uppercase = "Pass";
        } if (specialCharacter) {
            pointsEarned += specialPoints;
            Special = "Pass";
        }

        // working out the percentage of points earned so the cutoffs still make sense
        // if the point values above are ever changed

        double percentEarned = (double) pointsEarned / totalPossiblePoints;

        // ranking the strength of the password by the percentage of points earned
        if (percentEarned == 1.0) {
            Strength = "Strong";
        } else if (percentEarned >= 0.6) {
            Strength = "Medium";
        } else {
            Strength = "Weak";
        }

        // final return message, same format as passwordCheck() with the points added in
        return ("Length: " + Length + " | Digit: " + Digit + " | Uppercase: " + Uppercase + " | Special Character: " + Special + " -- Points: " + pointsEarned + "/" + totalPossiblePoints + " -- Strength: " + Strength);
    }

    // stretch goal 2: common password blacklist check
    // before looking at any rules, the password is compared against a list of common weak passwords
    // if it matches one (ignoring case), it is automatically weak no matter how many rules it passes
    // the per rule pass/fail results are still shown so the user can see what it would have scored

    public static String passwordBlacklistCheck(String password) {

        // hardcoded list of common weak passwords, all stored lowercase

        String[] blacklist = {"password", "123456", "qwerty", "12345678", "abc123", "password1", "letmein", "iloveyou"};

        boolean blacklisted = false; // keep track of whether the password was found on the blacklist

        // loop through the blacklist and compare each entry to the password
        // the blacklist entry goes first in the comparison so a null password doesnt crash,
        // equalsIgnoreCase(null) just returns false

        for (String weakPassword : blacklist) {
            if (weakPassword.equalsIgnoreCase(password)) {
                blacklisted = true;
                break; // no need to keep checking once a match is found
            }
        }

        // reusing the original passwordCheck() for the per rule results instead of rewriting it

        String result = passwordCheck(password);

        // if the password wasnt on the blacklist, the normal result is returned as is

        if (!blacklisted) {
            return result;
        }

        // if it was blacklisted, everything before the strength label is kept
        // and the strength is overwritten to weak with a note explaining why

        int strengthIndex = result.indexOf(" -- Strength: ");
        return (result.substring(0, strengthIndex) + " -- Strength: Weak (common password)");
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