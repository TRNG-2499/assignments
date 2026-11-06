import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

public class passwordStrengthChecker {
    static void main(String[] args) {
        passwordStrengthChecker pswdStrCheckerInstance = new passwordStrengthChecker();

        /*
            strengthCheck() Tests
         */

//        String invalidPassword = "";
//        System.out.println(pswdStrCheckerInstance.strengthCheck(invalidPassword));
//        String weakPassword = "Abc";
//        System.out.println(pswdStrCheckerInstance.strengthCheck(weakPassword));
//        String mediumPassword = "Abcdefgh*";
//        System.out.println(pswdStrCheckerInstance.strengthCheck(mediumPassword));
//        String strongPassword = "Abcdefgh*9";
//        System.out.println(pswdStrCheckerInstance.strengthCheck(strongPassword));

        /*
            strengthCheckStretch() Tests
         */
//        String invalidPassword = "";
//        System.out.println(pswdStrCheckerInstance.strengthCheckStretch(invalidPassword));
//        String filteredPassword = "PasSword";
//        System.out.println(pswdStrCheckerInstance.strengthCheckStretch(filteredPassword));
        String weakPassword = "Abc";
        System.out.println(pswdStrCheckerInstance.strengthCheckStretch(weakPassword));
        String mediumPassword = "Abcdefgh*";
        System.out.println(pswdStrCheckerInstance.strengthCheckStretch(mediumPassword));
        String strongPassword = "Abcdefgh*9";
        System.out.println(pswdStrCheckerInstance.strengthCheckStretch(strongPassword));
    }

    public String strengthCheck(String password) {
        if (password == null || password.isEmpty()) {
            throw new NullPointerException("Error: Invalid password: The provided password is empty or null.");
        }
        int minimumPasswordLength = 8;
        String specialCharacters = "!@#$%^&*";
        String digits = "1234567890";

        int sufficientLength = (password.length() >= minimumPasswordLength) ? 1 : 0;
        int containsDigits = digits.chars().anyMatch(ch -> password.indexOf(ch) >= 0) ? 1 : 0;
        int containsUppercase = (!password.equals(password.toLowerCase())) ? 1 : 0;
        int containsSpecial = specialCharacters.chars().anyMatch(ch -> password.indexOf(ch) >= 0) ? 1 : 0;

        int numRulesPassed = sufficientLength + containsDigits + containsUppercase + containsSpecial;
        String strength = switch (numRulesPassed) {
            case 0, 1 -> "Weak";
            case 2, 3 -> "Medium";
            case 4 -> "Strong";
            default -> throw new IllegalStateException("Unexpected value: " + numRulesPassed);
        };
        return "\nPassword Strength: " + strength +
                "\n-----------------------" +
                "\nPassed and Failed Rules:\n" +
                    "Length >= 8: " + (sufficientLength != 0) +
                    " | Contains Digit 0-9: " + (containsDigits != 0) +
                    " | Contains Uppercase character: " + (containsUppercase != 0) +
                    " | Contains Special character: " + (containsSpecial != 0);
    }

    public String strengthCheckStretch(String password) {
        List<String> weakPasswords = new ArrayList<String>(List.of("password", "123456789", "qwerty", "1234", "abcdefghijklmnop", "johndoe", "admin"));
        if (password == null || password.isEmpty()) {
            throw new NullPointerException("Error: Invalid password: The provided password is empty or null.");
        }
        if (weakPasswords.contains(password.toLowerCase())) {
            throw new IllegalArgumentException("Error: Invalid password: The provided password was caught in our\n" +
                    "common weak passwords list. Please enter a stronger password.");
        }
        int minimumPasswordLength = 8;
        String specialCharacters = "!@#$%^&*";
        String digits = "1234567890";

        // Evaluate rules passed
        int sufficientLength = (password.length() >= minimumPasswordLength) ? 1 : 0;
        int containsDigits = digits.chars().anyMatch(ch -> password.indexOf(ch) >= 0) ? 1 : 0;
        int containsUppercase = (!password.equals(password.toLowerCase())) ? 1 : 0;
        int containsSpecial = specialCharacters.chars().anyMatch(ch -> password.indexOf(ch) >= 0) ? 1 : 0;

        // Get total weight score
        int sufficientLengthW = 4;
        int containsDigitsW = 2;
        int containsUppercaseW = 1;
        int containsSpecialW = 3;

        double maxScore = sufficientLengthW + containsDigitsW + containsUppercaseW + containsSpecialW;
        double totalScore = (
                        (sufficientLength * sufficientLengthW) +
                        (containsDigits * containsDigitsW) +
                        (containsUppercase * containsUppercaseW) +
                        (containsSpecial * containsSpecialW)
        );
        int totalScoreGrade = (int)Math.round((totalScore / maxScore) * 100);

        String strength = null;

        // More than 80% score is strong,more than 50% is medium, and anything less than 50% is weak.
        if (totalScoreGrade >= 80) {
            strength = "Strong";
        } else if (totalScoreGrade >= 50) {
            strength = "Medium";
        } else {
            strength = "Weak";
        }

        return "\nPassword Strength: " + strength +
                "\n-----------------------" +
                "\nPassed and Failed Rules:\n" +
                "Length >= 8: " + (sufficientLength != 0) +
                " | Contains Digit 0-9: " + (containsDigits != 0) +
                " | Contains Uppercase character: " + (containsUppercase != 0) +
                " | Contains Special character: " + (containsSpecial != 0); }
}
