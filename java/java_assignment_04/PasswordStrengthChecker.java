package assignments.java.java_assignment_04;


public class PasswordStrengthChecker {
    private static final int LENGTH_WEIGHT = 1;
    private static final int UPPER_WEIGHT = 1;
    private static final int DIGIT_WEIGHT = 1;
    private static final int SPECIAL_WEIGHT = 2;
    private static final String[] BLACKLIST = {"123456", "password", "12345678", "qwerty", "abc123"};
    private static final int TOTAL_WEIGHT = LENGTH_WEIGHT + UPPER_WEIGHT + DIGIT_WEIGHT + SPECIAL_WEIGHT;
    // checks the strength of a given password
    public static String checkStrength(String password) {
        boolean hasLength = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        String specials = "!@#$%^&*";
        
        // check for null password
        if (password == null) {
            password = "";
        }

        // check each character for rules (uppercase, digit, special character)
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (specials.indexOf(c) >= 0) {
                hasSpecial = true;
            }
        }
        int passed = 0;
        if (password.length() >= 8) {
            hasLength = true;
            passed++;
        }
        if (hasUpper) passed++;
        if (hasDigit) passed++;
        if (hasSpecial) passed++;

        // determine overall strength based on number of rules passed
        String strength;
        if (passed == 4) {
            strength = "Strong";
        } else if (passed == 3) {
            strength = "Medium";
        } else {
            strength = "Weak";
        }
        return "Length: " + passFail(hasLength) +
               " | Uppercase: " + passFail(hasUpper) +
               " | Digit: " + passFail(hasDigit) +
               " | Special Character: " + passFail(hasSpecial) + 
               " -- Strength: " + strength;
    }
        
        // helper method to convert boolean to "Pass" or "Fail"
        private static String passFail(boolean b) {
            return b ? "Pass" : "Fail";
        }

    //custom rule weight: assign different weights to each rule for overall strength calculation
    public static String checkStrengthWeighted(String password) {
        if (password == null) {
            password = "";
        }
        boolean hasLength = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        String specials = "!@#$%^&*()-+";

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (specials.indexOf(c) >= 0) {
                hasSpecial = true;
            }
        }
        if (password.length() >= 8) {
            hasLength = true;
        }

        int points = 0;
        if (hasLength) points += LENGTH_WEIGHT;
        if (hasUpper) points += UPPER_WEIGHT;
        if (hasDigit) points += DIGIT_WEIGHT;
        if (hasSpecial) points += SPECIAL_WEIGHT;
        //pick label based on points
        String strength;
        double ratio = (double) points / TOTAL_WEIGHT;
        if (ratio >= 1.0) {
            strength = "Strong";
        } else if (ratio >= 0.5) {
            strength = "Medium";
        } else {
            strength = "Weak";
        }
        // return the report
        return "(Weighted) Length: " + passFail(hasLength) +
               " | Uppercase: " + passFail(hasUpper) +
               " | Digit: " + passFail(hasDigit) +
               " | Special Character: " + passFail(hasSpecial) +
               " -- Score: " + points + "/" + TOTAL_WEIGHT + 
               " -- Strength: " + strength;
    }

    //Common Blacklist password check
    public static boolean isBlacklisted(String password) {
        if (password == null) {
            password = "";
        }
        for (String b : BLACKLIST) {
            if (password.equalsIgnoreCase(b)) {
                return true;
            }
        }
        return false;
    }

    public static String checkStrengthWithBlacklist(String password) {
        if (isBlacklisted(password)) {
            return "Weak: Password is a common blacklisted password";
        }
        return checkStrengthWeighted(password);
    }
    

    public static void main(String[] args) {
        System.out.println("===Basic Strength===");
        System.out.println(checkStrength("Password123"));
        System.out.println(checkStrength("P@ssw0rd"));
        System.out.println(checkStrength("12345678"));
        System.out.println(checkStrength(""));

        System.out.println("===Weighted Strength===");
        System.out.println(checkStrengthWeighted("Password345"));
        System.out.println(checkStrengthWeighted("P@ssw0rd"));
        System.out.println(checkStrengthWeighted("P@sSW0ord!"));
        System.out.println(checkStrengthWeighted("12345678"));

        System.out.println("===Blacklist===");
        System.out.println(checkStrengthWithBlacklist("123456"));
        System.out.println(checkStrengthWithBlacklist("password"));
        System.out.println(checkStrengthWithBlacklist("P@ssw0rd"));
    }
}
