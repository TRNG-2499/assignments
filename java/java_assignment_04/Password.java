package java.java_assignment_04;

public class Password {
    public static String check(String password){
        if (password == null){
            password = "";
        }
        boolean longEnough = password.length() >= 8;
        boolean hasDigit = false;
        boolean hasUpper = false;
        boolean hasSpecial = false;
        String special = "!@#$%^&*";

        for (int i = 0; i < password.length(); i++) {
            char c  = password.charAt(i);
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            }
            if (special.indexOf(c) != -1) {
                hasSpecial = true;
            }
        }
        int passed =0;
        if (longEnough) passed++;
        if (hasDigit) passed++;
        if (hasUpper) passed++;
        if (hasSpecial) passed++;
        
        String strength; 
        if (passed == 4){
            strength = "Strong";
        } else if (passed >= 2){
            strength = "Medium";
        } else{
            strength = "Weak";
        }
        return "At least 8 characters: " + (longEnough ? "Pass" : "Fail") + "\n"
                + "Contains a digit: " + (hasDigit ? "Pass" : "Fail") + "\n"
                + "Contains an uppercase letter: " + (hasUpper ? "Pass" : "Fail") + "\n"
                + "Contains a special character: " + (hasSpecial ? "Pass" : "Fail") + "\n"
                + "Strength: " + strength;
    }

    public static void main(String[] args) {
        String [] test = {
            "Password123!",
            "password",
            "PASSWORD123",
            "Password123"
        };
        for (String p : test) {
            System.out.println("Testing: " + p);
            System.out.println(check(p));
            System.out.println();
        }
    }
}
