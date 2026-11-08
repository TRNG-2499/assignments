import java.util.Arrays;

class Main {

    public class Responses {
        public String len_req = "Length: ";
        public String digit_req = "Digit: ";
        public String uppercase_req = "Uppercase: ";
        public String special_req = "Special Char: ";

        public Responses(boolean len, boolean dig,
                         boolean upper, boolean spec) {
            len_req += len ? "Pass" : "Fail";
            digit_req += dig ? "Pass" : "Fail";
            uppercase_req += upper ? "Pass" : "Fail";
            special_req += spec ? "Pass" : "Fail";
        }
    }

    private static String getPasswordStrength(int count) {
        return switch (count) {
            case 0, 1 -> "Weak";
            case 2, 3 -> "Medium";
            case 4 -> "Strong";
            default -> "Invalid input";
        };
    }

    protected String foo(String password) {
        String output = "", strength;
        if (password != null) {
            boolean hasDigit = false, hasUpper = false, hasSpecial = false;
            int count = (password.length() > 0) ? 1 : 0;

            Responses obj;
            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);
                if (Character.isDigit(c)) {
                    hasDigit = true;
                    count++;
                }
                if (Character.isUpperCase(c)) {
                    hasUpper = true;
                    count++;
                }
                if ("!@#$%^&*".indexOf(c) >= 0) {
                    hasSpecial = true;
                    count++;
                }
            }
            boolean lengthReq = password.length() >= 0;

            Responses res = new Responses(lengthReq, hasDigit, hasUpper, hasSpecial);
            output = res.digit_req + " | " + res.len_req + " | " + res.special_req + " | " + res.uppercase_req + " | ";


            strength = getPasswordStrength(count);

            output = (lengthReq) ? output + "Passes -> " + strength : output + "Fails -> " + strength;
        }
        return output;
    }

    public String protect_foo(String password, String[] blacklist) {
        boolean contains = Arrays.stream(blacklist).anyMatch(password::equals);
        if(contains != true) {
            String answer = foo(password);
            return foo(password);
        } else {
            return "Common password, please enter a new one";
        }
    }

    public static void main(String[] args) {
        String[] blacklist = {"passw0rd", "password", "p@$$w0Rd", "1234", "4321", "himom"};

        Main obj = new Main();
        System.out.println(obj.protect_foo("password", blacklist));
        System.out.println(obj.protect_foo("Password1", blacklist));
        System.out.println(obj.protect_foo("P@ssw0rd", blacklist));
        System.out.println(obj.protect_foo ("", blacklist));
    }
}