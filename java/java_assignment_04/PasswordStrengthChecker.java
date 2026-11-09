public class PasswordStrengthChecker {

    public static String checkPasswordStrength(String password) {
        if (password == null || password.isEmpty()) {
            return "Length: Fail | Digit: Fail | Uppercase: Fail | Special Character: Fail -- Strength: Weak";
        }

        boolean isLongEnough = password.length() >= 8;

        boolean hasDigit = false;
        boolean hasUpper = false;
        boolean hasSpecial = false;
        String specials = "!@#$%^&*";

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

           if (c >= '0' && c <= '9') {
             hasDigit = true;
                }
            if (c >= 'A' && c <= 'Z') {
            hasUpper = true;
            }
            if (specials.indexOf(c) != -1) {
                hasSpecial = true;
            }
        }

        int score = 0;
        if (isLongEnough) { score++; }
        if (hasDigit)     { score++; }
        if (hasUpper)     { score++; }
        if (hasSpecial)   { score++; }

        String strength;
        if (score == 4) {
            strength = "Strong";
        } else if (score >= 2) {
            strength = "Medium";
        } else {
            strength = "Weak";
        }

        return "Length: " + (isLongEnough ? "Pass" : "Fail")
                + " | Digit: " + (hasDigit ? "Pass" : "Fail")
                + " | Uppercase: " + (hasUpper ? "Pass" : "Fail")
                + " | Special Character: " + (hasSpecial ? "Pass" : "Fail")
                + " -- Strength: " + strength;
    }

    public static void main(String[] args) {
        System.out.println(checkPasswordStrength("password"));
        System.out.println(checkPasswordStrength("Password1"));
        System.out.println(checkPasswordStrength("P@ssw0rd"));
        System.out.println(checkPasswordStrength(""));
        System.out.println(checkPasswordStrength(null));
    }
}
