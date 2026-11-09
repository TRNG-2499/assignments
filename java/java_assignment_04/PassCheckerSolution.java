public class PassCheckerSolution {
    public static String checkPassword(String pass) {
        boolean longEnough = pass != null && pass.length() >= 8;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        boolean hasUpper = false;

        String specialChars = "!@#$%^&*"; 

        if (pass != null) {
            for (char c : pass.toCharArray()) {
                if (c >= '0' && c <= '9') hasDigit = true;
                if (specialChars.indexOf(c) >= 0) hasSpecial = true;
                if (Character.isUpperCase(c)) hasUpper = true;
                
            }
        }

        int passed = (longEnough ? 1 : 0)
                   + (hasDigit ? 1 : 0)
                   + (hasUpper ? 1 : 0)
                   + (hasSpecial ? 1 : 0);

        String strength = passed == 4 ? "Strong"
                        : passed >= 2 ? "Medium"
                        : "Weak"; 

        return "Length: " + (longEnough ? "Pass" : "Fail")
                + " | Digit: " + (hasDigit ? "Pass" : "Fail")
                + " | Uppercase: " + (hasUpper ? "Pass" : "Fail")
                + " | Special Character: " + (hasSpecial ? "Pass" : "Fail")
                + " -- Strength: " + strength; 
    }
}