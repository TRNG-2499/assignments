public class RomanNumeralConverter {
  public static String toRoman(int value) {
    if (value < 1 || value > 3999) {
      throw new IllegalArgumentException("Number out of range");
    }

    int m = value / 1000;
    value -= m * 1000;
    int d = value / 500;
    value -= d * 500;
    int c = value / 100;
    value -= c * 100;
    int l = value / 50;
    value -= l * 50;
    int x = value / 10;
    value -= x * 10;
    int v = value / 5;
    value -= v * 5;
    int i = value;

    String ones = "V".repeat(v) + "I".repeat(i);
    if (i == 4) {
      if (v == 1) {
        ones = "IX";
      } else {
        ones = "IV";
      }
    }

    String tens = "L".repeat(l) + "X".repeat(x);
    if (x == 4) {
      if (l == 1) {
        tens = "XC";
      } else {
        tens = "XL";
      }
    }

    String hundreds = "D".repeat(d) + "C".repeat(c);
    if (c == 4) {
      if (d == 1) {
        hundreds = "CM";
      } else {
        hundreds = "CD";
      }
    }

    return "M".repeat(m) + hundreds + tens + ones;
  }

  public static int toInteger(String roman) {
    if (roman == null) {
      throw new IllegalArgumentException("Input cannot be null");
    }

    roman = roman.toUpperCase();

    if (!roman.matches("[IVXLCDM]+")) {
      throw new IllegalArgumentException("Invalid characters in input");
    }

    int m = 0;
    while (roman.length() > 0 && roman.charAt(0) == 'M') {
      m++;
      roman = roman.substring(1);
    }

    int d = 0;
    while (roman.length() > 0 && roman.charAt(0) == 'D') {
      d++;
      roman = roman.substring(1);
    }

    int c = 0;
    while (roman.length() > 0 && roman.charAt(0) == 'C') {
      c++;
      roman = roman.substring(1);
    }

    if (roman.length() > 0) {
      if (roman.charAt(0) == 'D') {
        c = 4;
        roman = roman.substring(1);
      } else if (roman.charAt(0) == 'M') {
        c = 4;
        d = 1;
        roman = roman.substring(1);
      }
    }

    int l = 0;
    while (roman.length() > 0 && roman.charAt(0) == 'L') {
      l++;
      roman = roman.substring(1);
    }

    int x = 0;
    while (roman.length() > 0 && roman.charAt(0) == 'X') {
      x++;
      roman = roman.substring(1);
    }

    if (roman.length() > 0) {
      if (roman.charAt(0) == 'L') {
        x = 4;
        roman = roman.substring(1);
      } else if (roman.charAt(0) == 'C') {
        x = 4;
        l = 1;
        roman = roman.substring(1);
      }
    }

    int v = 0;
    while (roman.length() > 0 && roman.charAt(0) == 'V') {
      v++;
      roman = roman.substring(1);
    }

    int i = 0;
    while (roman.length() > 0 && roman.charAt(0) == 'I') {
      i++;
      roman = roman.substring(1);
    }

    if (roman.length() > 0) {
      if (roman.charAt(0) == 'V') {
        i = 4;
        roman = roman.substring(1);
      } else if (roman.charAt(0) == 'X') {
        i = 4;
        v = 1;
        roman = roman.substring(1);
      }
    }

    return m * 1000 + d * 500 + c * 100 + l * 50 + x * 10 + v * 5 + i;
  }
}
