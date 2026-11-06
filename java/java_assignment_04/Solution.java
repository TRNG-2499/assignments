package java_assignment_04;

public class Solution {

    public static void main(String[] args) {
        String password1 = "Password123!";
        String password2 = "pass";
        String password3 = "Passw0rd";
        String password4 = "P@ssw0rd";

        System.out.println("Password: " + password1 + " | " + passwordStrengthCheck(password1));
        System.out.println("Password: " + password2 + " | " + passwordStrengthCheck(password2));
        System.out.println("Password: " + password3 + " | " + passwordStrengthCheck(password3));
        System.out.println("Password: " + password4 + " | " + passwordStrengthCheck(password4));
    }

    public static String passwordStrengthCheck(String password) {
        boolean hasMinimumLength = password != null && password.length() >= 8;
        boolean hasDigit = false;
        boolean hasUppercase = false;
        boolean hasSpecialCharacter = false;

        if (password != null) {
            for (int i = 0; i < password.length(); i++) {
                char character = password.charAt(i);
                if (character >= '0' && character <= '9') {
                    hasDigit = true;
                }
                if (Character.isUpperCase(character)) {
                    hasUppercase = true;
                }
                if ("!@#$%^&*".indexOf(character) >= 0) {
                    hasSpecialCharacter = true;
                }
            }
        }

        int passedRules = 0;
        if (hasMinimumLength) passedRules++;
        if (hasDigit) passedRules++;
        if (hasUppercase) passedRules++;
        if (hasSpecialCharacter) passedRules++;

        String strength;
        if (passedRules == 4) {
            strength = "Strong";
        } else if (passedRules >= 2) {
            strength = "Medium";
        } else {
            strength = "Weak";
        }

        return "Length: " + (hasMinimumLength ? "Pass" : "Fail")
                + " | Digit: " + (hasDigit ? "Pass" : "Fail")
                + " | Uppercase: " + (hasUppercase ? "Pass" : "Fail")
                + " | Special Character: " + (hasSpecialCharacter ? "Pass" : "Fail")
                + " -- Strength: " + strength;
    }
}
