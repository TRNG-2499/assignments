import java.util.Arrays

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

    public boolean checkBlacklist(String[] blacklist, String target) {
        return (target != null && blacklist.contains(target)
                ? return true
                : return false;
    }

    private String foo(String password, String[] blacklist) {
        String output = "", strength;
        if(blacklist.contains(password)) { return "password is in our list of commonly used password, try again - weak"; }

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
            strength = getPasswordStrength(count, strength);

            output = (lengthReq) ? output + "Passes -> " + strength : output + "Fails -> " + strength;
        }
        return output;
    }

    private static String getPasswordStrength(int count, String strength) {
        strength = switch (count) {
            case 0, 1 -> "Weak";
            case 2, 3 -> "Medium";
            case 4 -> "Strong";
            default -> "Invalid input";
        };
        return strength;
    }

    protected String protect_foo(String password, String[] blacklist) {
        boolean contains = Arrays.stream(blacklist).anyMatch(password::equals);
        if(blacklist.contains(password)) {
            return foo(password);
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