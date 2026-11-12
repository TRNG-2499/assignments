public class Solution_04 {

  // global password settings
  private static int passwordLength = 8;

  public static void main(String args[]) {
    passChecker("password");
    passChecker("Password1");
    passChecker("P@ssw0rd");
    passChecker("");

    // streach test
    System.out.println(isBlacklisted("password"));
    System.out.println(isBlacklisted("123456"));
    System.out.println(isBlacklisted("qwerty"));
    System.out.println(isBlacklisted("8675309"));
    System.out.println(isBlacklisted("Password1"));
    System.out.println(isBlacklisted("P@ssw0rd"));
  }

  public static void passChecker(String password) {
    boolean valid = notEmpty(password);
    if (valid) {
      boolean length = checkLength(password);
      boolean digit = hasDigit(password);
      boolean uppercase = hasUppercase(password);
      boolean special = hasSpecialChar(password);
      printResults(length, digit, uppercase, special);
    } else {
      printResults(false, false, false, false);
    }
  }

  private static boolean notEmpty(String password) {
    return password != null && !password.isEmpty();
  }

  private static boolean checkLength(String password) {
    return password.length() >= passwordLength;
  }

  private static boolean hasDigit(String password) {
    for (int i = 0; i < password.length(); i++) {
      char letter = password.charAt(i);
      if (Character.isDigit(letter)) {
        return true;
      }
    }
    return false;
  }

  private static boolean hasUppercase(String password) {
    for (int i = 0; i < password.length(); i++) {
      char letter = password.charAt(i);

      if (Character.isUpperCase(letter)) {
        return true;
      }
    }
    return false;
  }

  private static boolean hasSpecialChar(String password) {
    String specialChars = "!@#$%^&*";
    for (int i = 0; i < password.length(); i++) {
      char letter = password.charAt(i);
      if (specialChars.contains(String.valueOf(letter))) {
        return true;
      }
    }
    return false;
  }

  private static void printResults(
    boolean length,
    boolean digit,
    boolean uppercase,
    boolean special
  ) {
    int score = 0;
    if (length) score++;
    if (digit) score++;
    if (uppercase) score++;
    if (special) score++;

    String strength;
    if (score == 4) {
      strength = "Strong";
    } else if (score >= 2) {
      strength = "Medium";
    } else {
      strength = "Weak";
    }

    System.out.println(
      "Length: " +
        (length ? "Pass" : "Fail") +
        " | Digit: " +
        (digit ? "Pass" : "Fail") +
        " | Uppercase: " +
        (uppercase ? "Pass" : "Fail") +
        " | Special Character: " +
        (special ? "Pass" : "Fail") +
        " -- Strength: " +
        strength
    );
  }

  // custom Weighting is just changing a the value of these lines:
  // if (length) score++;
  // if (digit) score++;
  // if (uppercase) score++;
  // if (special) score++;
  // really no need for another method

  // this could be added to the passChecker and a small alteration in printResults
  private static boolean isBlacklisted(String password) {
    String[] blacklistedPasswords = {
      "password",
      "123456",
      "qwerty",
      "password1",
      "8675309",
    };

    for (String blacklisted : blacklistedPasswords) {
      if (blacklisted.equalsIgnoreCase(password)) {
        return true;
      }
    }
    return false;
  }
}
