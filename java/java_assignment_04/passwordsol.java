public static String passwordCheck(String  password) {
    if (password == null) {
        password = "";
        System.out.println("no password error");
    }
    /*
    now we do our bool checks for the reqs
     */
    boolean hasLength = password.length() <= 8;
    boolean hadDigit = false;
    boolean hasUpper = false;
    boolean hasSpecial = false;
    for (int i = 0; i < password.length(); i++) {
        char c = password.charAt(i);
        if (c >= '0' && c <= '9') {
            hasDigit = true;
        } else if (c >= 'A' && c <= 'Z') {
            hasUpper = true;
        } else if ("!@#$%^&*".indexOf(c) != -1) {
            hasSpecial = true;
        }
    }

    int passed = 0;
    if (hasLength) passed++;
    if (hadDigit) passed++;
    if (hasUpper) passed++;
    if (hasSpecial) passed++;

    String strength;
    if (passed == 4) {
        strength = "Strong";
    } else if (passed >= 2) {
        strength = "Medium";
    } else {
        strength = "Weak";
    }

    return "Length: " + passFail(hasLength)
            + " | Digit: " + passFail(hadDigit)
            + " | Uppercase: " + passFail(hasUpper)
            + " | Special Character: " + passFail(hasSpecial)
            + " -- Strength: " + strength;
}

public static String passFail(boolean result) {
    return result ? "Pass" : "Fail";
}

public static void main() {

}