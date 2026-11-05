public class passwordStrengthChecker {
    
    public static String checkPasswordStrength(String password) {
        if (password == null) {
            return "Invalid input: Password cannot be null.";
        }

        boolean hasLength = false;
        boolean hasUppercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        String specialCharacters = "!@#$%^&*";
        StringBuilder output = new StringBuilder();

        if (password.length() >= 8) {
            hasLength = true;
        }

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (specialCharacters.indexOf(c) >= 0) {
                hasSpecialChar = true;
            }
        }

        if (hasLength) {
            output.append("Length: Pass | ");
        } else {
            output.append("Length: Fail | ");
        }

        if (hasDigit) {
            output.append("Digit: Pass | ");
        } else {
            output.append("Digit: Fail | ");
        }

        if (hasUppercase) {
            output.append("Uppercase: Pass | ");
        } else {
            output.append("Uppercase: Fail | ");
        }

        if (hasSpecialChar) {
            output.append("Special Character: Pass ");
        } else {
            output.append("Special Character: Fail ");
        }

        if (hasLength && hasUppercase && hasDigit && hasSpecialChar) {
            output.append("-- Strength: Strong");
        } else if (hasLength && (hasUppercase || hasDigit || hasSpecialChar)) {
            output.append("-- Strength: Medium");
        } else {
            output.append("-- Strength: Weak");
        }

        return output.toString();
    }

    public static String customWeighting(String password) {
        if (password == null) {
            return "Invalid input: Password cannot be null.";
        }

        int score = 0;
        String specialCharacters = "!@#$%^&*";

        if (password.length() >= 8) {
            score += 1;
        }

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                score += 1;
            } else if (Character.isDigit(c)) {
                score += 1;
            } else if (specialCharacters.indexOf(c) >= 0) {
                score += 2;
            }
        }

        StringBuilder output = new StringBuilder();
        output.append("Score: ").append(score).append(" | ");

        if (score >= 4) {
            output.append("Strength: Strong");
        } else if (score >= 2) {
            output.append("Strength: Medium");
        } else {
            output.append("Strength: Weak");
        }

        return output.toString();
    }

    public static String blacklistCheck(String password, String[] blacklist) {
        if (password == null) {
            return "Invalid input: Password cannot be null.";
        }

        if (blacklist == null || blacklist.length == 0) {
            return "Invalid input: Blacklist cannot be null or empty.";
        }

        for (String blacklistedPassword : blacklist) {
            if (password.equals(blacklistedPassword)) {
                return "Password is weak: It is blacklisted.";
            }
        }

        return customWeighting(password);
    }

    public static void main(String[] args) {
        String[] testPasswords = {
            "abc",          
            "",
            "Abcdef1!",   
            "Abcdefghij",  
            "Password1!"
        };
        String[] blacklist = {"password", "123456", "qwerty", "Password1!", "Password"};

        for (String password : testPasswords) {
            System.out.println("\nTesting password: " + password);
            System.out.println(checkPasswordStrength(password));
            System.out.println(customWeighting(password));
            System.out.println(blacklistCheck(password, blacklist));
        }
        
    }
}
