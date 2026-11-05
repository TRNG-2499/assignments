public class PasswordStrengthChecker {

    // Evaluates each password rule and returns the results with a strength label.
    public static String checkPasswordStrength(String password) {
        // Treat null as an empty password so all rules fail safely.
        if (password == null) {
            password = "";
        }

        boolean hasLength = password.length() >= 8;
        boolean hasDigit = false;
        boolean hasUppercase = false;
        boolean hasSpecial = false;
        String specialCharacters = "!@#$%^&*";

        // Check each character for the remaining three rules.
        for (int i = 0; i < password.length(); i++) {
            char character = password.charAt(i);

            if (character >= '0' && character <= '9') {
                hasDigit = true;
            }

            if (Character.isUpperCase(character)) {
                hasUppercase = true;
            }

            if (specialCharacters.indexOf(character) >= 0) {
                hasSpecial = true;
            }
        }

        // Count each rule once, regardless of how many matching characters appear.
        int rulesPassed = 0;

        if (hasLength) {
            rulesPassed++;
        }

        if (hasDigit) {
            rulesPassed++;
        }

        if (hasUppercase) {
            rulesPassed++;
        }

        if (hasSpecial) {
            rulesPassed++;
        }

        String strength;

        if (rulesPassed == 4) {
            strength = "Strong";
        } else if (rulesPassed >= 2) {
            strength = "Medium";
        } else {
            strength = "Weak";
        }

        return "Length: " + (hasLength ? "Pass" : "Fail")
                + " | Digit: " + (hasDigit ? "Pass" : "Fail")
                + " | Uppercase: " + (hasUppercase ? "Pass" : "Fail")
                + " | Special Character: " + (hasSpecial ? "Pass" : "Fail")
                + " -- Strength: " + strength;
    }

    // Covers all strength levels, empty input, and null input.
    public static void main(String[] args) {
        System.out.println(checkPasswordStrength("password"));
        System.out.println(checkPasswordStrength("Password1"));
        System.out.println(checkPasswordStrength("P@ssw0rd"));
        System.out.println(checkPasswordStrength(""));
        System.out.println(checkPasswordStrength(null));
        System.out.println(checkPasswordStrength("Ab1"));
    }
}