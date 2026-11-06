import java.util.HashSet;

// For the majority of the methods I used a simple for loop to manually check
// each character. This method is arguably more lengthy to write than regex expressions
// but it allows me to be able to write a solution for them without needing
// to know regex expressions.

public class PasswordChecker {

    public static void checkPassword(String password) {
        if (password == null) {
            password = "";
        }

        String lengthStr = "";
        String digitStr = "";
        String uppercaseStr = "";
        String specialCharStr = "";
        int passCount = 0;

        // Password length check
        if (password.length() < 8) {
            lengthStr = "Fail";
        } else {
            lengthStr = "Pass";
            passCount += 1;
        }

        // Contains a digit check
        boolean containsDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                containsDigit = true;
                break;
            }
        }
        if (containsDigit == false) {
            digitStr = "Fail";
        } else {
            digitStr = "Pass";
            passCount += 1;
        }

        // Upper case character check
        boolean containsUpper = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                containsUpper = true;
                break;
            }
        }
        if (containsUpper == false) {
            uppercaseStr = "Fail";
        } else {
            uppercaseStr = "Pass";
            passCount += 1;
        }

        // Special character check
        HashSet<Character> specialChars = new HashSet<Character>();
        for (char c : "!@#$%^&*".toCharArray()) {
            specialChars.add(c);
        }
        boolean containsSpecialChar = false;
        for (char c : password.toCharArray()) {
            if (specialChars.contains(c)) {
                containsSpecialChar = true;
                break;
            }
        }
        if (containsSpecialChar == false) {
            specialCharStr = "Fail";
        } else {
            specialCharStr = "Pass";
            passCount += 1;
        }

        String strengthStr = "";
        switch (passCount) {
            case 1:
                strengthStr = "Weak";
                break;
            case 2, 3:
                strengthStr = "Medium";
                break;
            case 4:
                strengthStr = "Strong";
                break;
            default:
                strengthStr = "Weak";
        }

        String formattedString = String.format("Length: %s | Digit: %s | Uppercase: %s | Special Character: %s -- Strength: %s", lengthStr, digitStr, uppercaseStr, specialCharStr, strengthStr);
        System.out.println(formattedString);
    }

    public static void main(String[] args) {
        checkPassword(null);
    }
}
