public class PasswordStrengthChecker {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*";
    private static final int MIN_LENGTH = 8;

    // ---------- Base activity ----------
    // Checks each rule separately, then gives a strength label from the number of
    // rules passed.
    // A null password is treated like an empty one: every rule fails and it is
    // Weak.
    public static String checkPasswordStrength(String password) {
        boolean lengthOk = hasMinimumLength(password);
        boolean digitOk = hasDigit(password);
        boolean upperOk = hasUppercase(password);
        boolean specialOk = hasSpecialCharacter(password);

        int passed = 0;
        if (lengthOk)
            passed++;
        if (digitOk)
            passed++;
        if (upperOk)
            passed++;
        if (specialOk)
            passed++;

        String strength;
        if (passed == 4) {
            strength = "Strong";
        } else if (passed >= 2) {
            strength = "Medium";
        } else {
            strength = "Weak";
        }

        return formatRules(lengthOk, digitOk, upperOk, specialOk) + " -- Strength: " + strength;
    }

    // ---------- Rule checks (each one handles null safely) ----------
    private static boolean hasMinimumLength(String password) {
        return password != null && password.length() >= MIN_LENGTH;
    }

    private static boolean hasDigit(String password) {
        if (password == null)
            return false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasUppercase(String password) {
        if (password == null)
            return false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasSpecialCharacter(String password) {
        if (password == null)
            return false;
        for (int i = 0; i < password.length(); i++) {
            if (SPECIAL_CHARACTERS.indexOf(password.charAt(i)) >= 0) {
                return true;
            }
        }
        return false;
    }

    private static String formatRules(boolean lengthOk, boolean digitOk, boolean upperOk, boolean specialOk) {
        return "Length: " + passFail(lengthOk)
                + " | Digit: " + passFail(digitOk)
                + " | Uppercase: " + passFail(upperOk)
                + " | Special Character: " + passFail(specialOk);
    }

    private static String passFail(boolean result) {
        return result ? "Pass" : "Fail";
    }

    // ---------- Stretch 1: Custom Rule Weighting ----------
    // Points: length = 1, digit = 1, uppercase = 1, special character = 2 (5
    // possible).
    // Cutoffs: 5 points = Strong, 3-4 points = Medium, 0-2 points = Weak.
    private static final int LENGTH_POINTS = 1;
    private static final int DIGIT_POINTS = 1;
    private static final int UPPERCASE_POINTS = 1;
    private static final int SPECIAL_POINTS = 2;
    private static final int TOTAL_POINTS = LENGTH_POINTS + DIGIT_POINTS + UPPERCASE_POINTS + SPECIAL_POINTS;

    public static String checkWeightedPasswordStrength(String password) {
        boolean lengthOk = hasMinimumLength(password);
        boolean digitOk = hasDigit(password);
        boolean upperOk = hasUppercase(password);
        boolean specialOk = hasSpecialCharacter(password);

        int points = 0;
        if (lengthOk)
            points += LENGTH_POINTS;
        if (digitOk)
            points += DIGIT_POINTS;
        if (upperOk)
            points += UPPERCASE_POINTS;
        if (specialOk)
            points += SPECIAL_POINTS;

        String strength;
        if (points == TOTAL_POINTS) {
            strength = "Strong";
        } else if (points >= 3) {
            strength = "Medium";
        } else {
            strength = "Weak";
        }

        return formatRules(lengthOk, digitOk, upperOk, specialOk)
                + " -- Points: " + points + "/" + TOTAL_POINTS
                + " -- Strength: " + strength;
    }

    // ---------- Stretch 2: Common Password Blacklist Check ----------
    private static final String[] COMMON_PASSWORDS = {
            "password", "123456", "qwerty", "12345678", "111111",
            "abc123", "letmein", "iloveyou", "admin", "welcome",
            "password1", "p@ssw0rd"
    };

    // A password on the blacklist (ignoring case) is always Weak, no matter which
    // rules it passes.
    public static String checkPasswordWithBlacklist(String password) {
        if (isCommonPassword(password)) {
            return formatRules(hasMinimumLength(password), hasDigit(password),
                    hasUppercase(password), hasSpecialCharacter(password))
                    + " -- Strength: Weak (common password)";
        }
        return checkPasswordStrength(password);
    }

    private static boolean isCommonPassword(String password) {
        if (password == null)
            return false;
        for (String common : COMMON_PASSWORDS) {
            if (common.equalsIgnoreCase(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] samples = { "password", "Password1", "P@ssw0rd", "", null, "Tr0ub4dor&3x", "short!" };

        System.out.println("=== Base activity ===");
        for (String s : samples) {
            System.out.println(label(s) + " -> " + checkPasswordStrength(s));
        }

        System.out.println("\n=== Stretch 1: Custom Rule Weighting ===");
        for (String s : samples) {
            System.out.println(label(s) + " -> " + checkWeightedPasswordStrength(s));
        }

        System.out.println("\n=== Stretch 2: Common Password Blacklist ===");
        for (String s : samples) {
            System.out.println(label(s) + " -> " + checkPasswordWithBlacklist(s));
        }
        System.out.println(label("QWERTY") + " -> " + checkPasswordWithBlacklist("QWERTY"));
    }

    private static String label(String s) {
        return s == null ? "null" : "\"" + s + "\"";
    }
}
