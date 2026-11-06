/**
     * @param args the command line arguments
     * Java assignment 04 - Password Strength Checker
     * Objective: Practice iterating through a string, tracking multiple independent boolean conditions, and combining several pass/fail checks into an overall evaluation.
     * Steps:
     * 1. A method that accepts one param called password (String) 4 rules to follow when evaluating the password: first is at least 8 char long, second is at least one digit from 0 to 9, third it contains at least one capital letter, and fourth it has at least one special char.
     * 2. the method should return which of the 4 rules pass and which fail. Printing the result of each rule. 
     * 3. A scale that determines strength of password. 4 is strong, 2-3 is medium and 0-1 is weak.
     * 4. The method should handle empty or null input.
*/
public class PassStrengthCheck {
    public static String checkPasswordStrength(String password) {

        //system won't crash if password is null or empty
        boolean checkLength = password != null && password.length() >= 8;
        boolean checkDigit = false;
        boolean checkUppercase = false;
        boolean checkSpecialChar = false;

        //loop through the password to check for digit, uppercase, and special character
        if (password != null) {
            for (int i = 0; i < password.length(); i++) {
                char currentChar = password.charAt(i);
                if (Character.isDigit(currentChar)) {
                    checkDigit = true;
                }
                if (Character.isUpperCase(currentChar)) {
                    checkUppercase = true;
                }
                if ("!@#$%^&*".indexOf(currentChar) != -1) {
                    checkSpecialChar = true;
                }
            }
        }

        //counts up the number of rules passed
        int passedRules = 0;
        if (checkLength) passedRules++;
        if (checkDigit) passedRules++;
        if (checkUppercase) passedRules++;
        if (checkSpecialChar) passedRules++;

        //checks the password strength based on the number of rules passed
        String strength;
        if (passedRules == 4) {
            strength = "Strong";
        } else if (passedRules >= 2) {
            strength = "Medium";
        } else {
            strength = "Weak";
        }

        return "Length: " + (checkLength ? "Pass" : "Fail")
                + " | Digit: " + (checkDigit ? "Pass" : "Fail")
                + " | Uppercase: " + (checkUppercase ? "Pass" : "Fail")
                + " | Special Character: " + (checkSpecialChar ? "Pass" : "Fail")
                + " - Strength: " + strength;
    }
    public static void main(String[] args) {
        System.out.println(checkPasswordStrength("mynameisbob"));
        System.out.println(checkPasswordStrength("Hi4278"));
        System.out.println(checkPasswordStrength("Myp@assword!isAwesome1"));
        System.out.println(checkPasswordStrength(null));
        System.out.println(checkPasswordStrength(""));
    }
}
