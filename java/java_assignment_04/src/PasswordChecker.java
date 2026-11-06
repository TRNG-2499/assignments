public class PasswordChecker {
    public static void main(String[] args) {
        System.out.println(checkPassword("I!heartPonies@"));
        System.out.println(checkPassword("Peanut&Butter02"));
        System.out.println(checkPassword("password"));
    }

    private static String checkPassword(String password) {
        if (password.isEmpty())
            return "Length: Fail | Digit: Fail | Uppercase: Fail | Special Character: Fail -- Strength: Weak";

        StringBuilder sb = new StringBuilder();
        char[] passwordChars = password.toCharArray();
        int score = 0;

        sb.append("Length: ");
        if (password.length() < 8)
            sb.append("Fail | ");
        else {
            sb.append("Success | ");
            score++;
        }

        sb.append("Digit: ");
        boolean hasDigit = false;
        for (int c = 0; !hasDigit && c < passwordChars.length; c++) {
            if (Character.isDigit(passwordChars[c]))
                hasDigit = true;
        }
        if (!hasDigit)
            sb.append("Fail | ");
        else {
            sb.append("Success | ");
            score++;
        }

        sb.append("Uppercase: ");
        boolean hasUpper = false;
        for (int c = 0; !hasUpper && c < passwordChars.length; c++) {
            if (Character.isUpperCase(passwordChars[c]))
                hasUpper = true;
        }
        if (!hasUpper)
            sb.append("Fail | ");
        else {
            sb.append("Success | ");
            score++;
        }

        sb.append("Speical Character: ");
        char[] specialChars = "!@#$%^&*".toCharArray();
        boolean hasSpecial = false;
        for (int c = 0; !hasSpecial && c < passwordChars.length; c++) {
            for (int s = 0; !hasSpecial && s < specialChars.length; s++) {
                if (passwordChars[c] == specialChars[s])
                    hasSpecial = true;
            }
        }
        if (!hasSpecial)
            sb.append("Fail |");
        else {
            sb.append("Success |");
            score++;
        }

        sb.append(" -- ");
        if (score <= 1)
            sb.append("Strength: Weak");
        else if (score <= 3)
            sb.append("Strength: Medium");
        else
            sb.append("Strength: Strong");

        return sb.toString();
    }
}