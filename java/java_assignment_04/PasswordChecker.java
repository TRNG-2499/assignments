public class PasswordChecker {
    public static String isValidPassword(String password) {
        if (password.length() == 0 || password == null) {
            System.out.println("Password cannot be empty or null.");
            return "Invalid";
        }
        
        boolean lengthValid = password.length() >= 8;
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        
        int strengthScore = 0;
        String strength = "";

        char[] specialChars = {'!', '@', '#', '$', '%', '^', '&', '*'};

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (c == specialChars[0] || c == specialChars[1] || c == specialChars[2] || c == specialChars[3] || c == specialChars[4] || c == specialChars[5] || c == specialChars[6] || c == specialChars[7]) {
                hasSpecialChar = true;
            }

        }

        if (lengthValid) {
            strengthScore++;
        }

        if (hasUppercase && hasLowercase) {
            strengthScore++;
        }

        if (hasDigit) {
            strengthScore++;
        }
        if (hasSpecialChar) {
            strengthScore++;
        }

        System.out.print("Length: " + (lengthValid ? "Pass" : "Fail"));
        System.out.print(", Uppercase: " + (hasUppercase ? "Pass" : "Fail"));
        System.out.print(", Digit: " + (hasDigit ? "Pass" : "Fail"));
        System.out.println(", Special Character: " + (hasSpecialChar ? "Pass" : "Fail"));

        if (strengthScore <= 1) {
            strength = "Weak";
            System.out.println("Password strength: Weak");
        } else if (strengthScore <= 3) {
            strength = "Medium";
            System.out.println("Password strength: Medium");
        } else {
            strength = "Strong";
            
        }
        System.out.println("Password strength: " + strength);
        return strength;
    }
    public static void main(String[] args) {
        String password = "Password123!";
        isValidPassword(password);
    }
}
