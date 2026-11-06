public class PasswordStrengthChecker {
    static final String SPECIAL_CHARACTERS = "!@#$%^&*";


    private boolean containsDigit(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsUppercase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsSpecialCharacter(String password) {
        for (char c : password.toCharArray()) {
            if (SPECIAL_CHARACTERS.indexOf(c) >= 0) {
                return true;
            }
        }
        return false;
    }
        
    public void checkPasswordStrength(String password) {
        if (password == null || password.isEmpty()) {
            System.out.println("Password cannot be empty.");
            return;
        }
        
        boolean atLeast8Characters = password.length() > 8;
        String Length = atLeast8Characters ? "Pass" : "Fail";
        boolean atLeastOneDigit = containsDigit(password);
        String Digit = atLeastOneDigit ? "Pass" : "Fail";
        boolean atLeastOneUppercase = containsUppercase(password);
        String Uppercase = atLeastOneUppercase ? "Pass" : "Fail";
        boolean atLeastOneSpecialCharacter = containsSpecialCharacter(password);
        String SpecialCharacter = atLeastOneSpecialCharacter ? "Pass" : "Fail";

        int totalCriteriaMet = 0;

        if (atLeast8Characters) totalCriteriaMet++;
        if (atLeastOneDigit) totalCriteriaMet++;
        if (atLeastOneUppercase) totalCriteriaMet++;
        if (atLeastOneSpecialCharacter) totalCriteriaMet++;
        String strength = "Weak";

        if (totalCriteriaMet == 4) {
            strength = "Strong";
        } else if (totalCriteriaMet >= 2) {
            strength = "Medium";
        } 

        System.out.println("Length: " + Length + "| Digit: " + Digit + "| Uppercase: " + Uppercase + "| Special Character: " + SpecialCharacter + "-- Strength: " + strength);

    }   
    
    public static void main(String[] args) {
        PasswordStrengthChecker checker = new PasswordStrengthChecker();
        String noLengthPassword = "Ab1!";
        String noDigitPassword = "Abcdefgh!";
        String noUppercasePassword = "abcde1!@";
        String noSpecialCharacterPassword = "Abcdefg1";
        String strongPassword = "Abcdef1!@";
        String weakPassword = "abc";
        String nullPassword = null;
        checker.checkPasswordStrength(noLengthPassword);
        checker.checkPasswordStrength(noDigitPassword);
        checker.checkPasswordStrength(noUppercasePassword);
        checker.checkPasswordStrength(noSpecialCharacterPassword);
        checker.checkPasswordStrength(strongPassword);
        checker.checkPasswordStrength(weakPassword);
        checker.checkPasswordStrength(nullPassword);
    }

}
