package assignments.java.java_assignment_04;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        checkPassword("password");
        checkPassword("Password1");
        checkPassword("P@ssw0rd");
        checkPassword("");
        checkPassword(null);
    }

    public static void checkPassword(String password){
        boolean digit = false;
        boolean upperCase = false;
        boolean special = false;

        String charbool = "Fail";
        String digbool = "Fail";
        String upbool = "Fail";
        String spbool = "Fail";
        
        int passed = 0;

        if (password != null && password.length() > 0) {
            for (int i = 0; i < password.length(); i++) {
                char ch = password.charAt(i);
                if (Character.isDigit(ch)){
                    digit = true;
                    //digbool = "Pass";
                }else if (Character.isUpperCase(ch)){
                    upperCase = true;
                    //upbool = "Pass";
                }else if (!Character.isLetter(ch) && !Character.isDigit(ch)){
                    special = true;
                    //spbool = "Pass";
                }
            }

            if (password.length() >= 8){
                charbool = "Pass";
                passed++;
            }
            if (digit){
                    digbool = "Pass";
                    passed++;
            }
            if (upperCase){
                    upbool = "Pass";
                    passed++;
            }
            if (special){
                    spbool = "Pass";
                    passed++;
            }
        }

        System.out.print("Length: "+ charbool +" | Digit: "+ digbool +" | Uppercase: "+ upbool +" | Special Character: "+ spbool +" -- Strength: ");

        if(passed < 2){
            System.out.println("Weak");
        }else if(passed < 4){
            System.out.println("Medium");
        }else if(passed == 4){
            System.out.println("Strong");
        }
    }
}
