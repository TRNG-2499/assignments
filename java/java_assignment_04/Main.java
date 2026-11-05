public class Main {
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Must provide a password.");
      return;
    }

    int score = 0;
    if (checkLengthRule(args[0])) {
      System.out.println("Length rule passed.");

      score += 1;
    } else {
      System.out.println("Length rule failed.");
    }

    if (checkDigitRule(args[0])) {
      System.out.println("Digit rule passed.");

      score += 1;
    } else {
      System.out.println("Digit rule failed.");
    }

    if (checkUppercaseRule(args[0])) {
      System.out.println("Uppercase rule passed.");

      score += 1;
    } else {
      System.out.println("Uppercase rule failed.");
    }

    if (checkSpecialRule(args[0])) {
      System.out.println("Special rule passed.");

      score += 1;
    } else {
      System.out.println("Special rule failed.");
    }

    if (score == 4) {
      System.out.println("Password strength: strong");
    } else if (score >= 2) {
      System.out.println("Password strength: medium");
    } else {
      System.out.println("Password strength: weak");
    }
  }

  private static boolean checkLengthRule(String password) {
    return password.length() >= 8;
  }

  private static boolean checkDigitRule(String password) {
    for (int i = 0; i < password.length(); i++) {
      if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
        return true;
      }
    }

    return false;
  }

  private static boolean checkUppercaseRule(String password) {
    for (int i = 0; i < password.length(); i++) {
      if (Character.isUpperCase(password.charAt(i))) {
        return true;
      }
    }

    return false;
  }

  private static boolean checkSpecialRule(String password) {
    return password.matches(".*[!@#$%^&*].*");
  }
}
