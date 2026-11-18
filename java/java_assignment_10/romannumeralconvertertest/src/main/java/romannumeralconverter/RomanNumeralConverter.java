package romannumeralconverter;
public class RomanNumeralConverter {

    public static String toRoman(int number){
        String roman = "";

        if(number >= 1000 && number < 4000) {
            roman += "M";
            number -= 1000;
            if(number > 0) {
                roman += toRoman(number);
            }
        }else if(number < 1000 && number >= 900) {
            roman += "CM";
            number -= 900;
            if(number > 0) {
                roman += toRoman(number);
            }
        }else if(number < 900 && number >= 500) {
            roman += "D";
            number -= 500;
            if(number > 0) {
                roman += toRoman(number);
            }
        }else if(number < 500 && number >= 400) {
            roman += "CD";
            number -= 400;
            if(number > 0) {
                roman += toRoman(number);
            }
        }else if(number < 400 && number >= 100) {
            roman += "C";
            number -= 100;
            if(number > 0) {
                roman += toRoman(number);
            }
        }else if(number < 100 && number >= 90) {
            roman += "XC";
            number -= 90;
            if(number > 0) {
                roman += toRoman(number);
            }
        }else if(number < 90 && number >= 50) {
            roman += "L";
            number -= 50;
            if(number > 0) {
                roman += toRoman(number);
            }
        }else if(number < 50 && number >= 40) {
            roman += "XL";
            number -= 40;
            if(number > 0) {
                roman += toRoman(number);
            }
        }else if(number < 40 && number >= 10) {
            roman += "X";
            number -= 10;
            if(number > 0) {
                roman += toRoman(number);
            }
        }else if(number < 10 && number >= 9) {
            roman += "IX";
            number -= 9;
            if(number > 0) {
                roman += toRoman(number);
            }
        }else if(number < 9 && number >= 5) {
            roman += "V";
            number -= 5;
            if(number > 0) {
                roman += toRoman(number);
            }
        }else if(number < 5 && number >= 4) {
            roman += "IV";
            number -= 4;
            if(number > 0) {
                roman += toRoman(number);
            }
        }else if(number < 4 && number >= 1) {
            roman += "I";
            number -= 1;
            if(number > 0) {
                roman += toRoman(number);
            }
        }else {
            throw new IllegalArgumentException("Number must be between 1 and 3999.");
        }

        return roman;
    }

    public static int toInteger(String roman){
        int number = 0;
        
        if(roman == null || roman.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty.");
        }
        roman = roman.toUpperCase();
        

        if(roman.length() == 1) {
            if(roman.charAt(0) == 'M') {
                number += 1000;
                roman = roman.substring(1, roman.length());
                if(roman.length() > 0) {
                    number += toInteger(roman);
                }
            }else if(roman.charAt(0) == 'D') {
                number += 500;
                roman = roman.substring(1, roman.length());
                if(roman.length() > 0) {
                    number += toInteger(roman);
                }
            }else if(roman.charAt(0) == 'C') {
                number += 100;
                roman = roman.substring(1, roman.length());
                if(roman.length() > 0) {
                    number += toInteger(roman);
                }
            }else if(roman.charAt(0) == 'L') {
                number += 50;
                roman = roman.substring(1, roman.length());
                if(roman.length() > 0) {
                    number += toInteger(roman);
                }
            }else if(roman.charAt(0) == 'X') {
                number += 10;
                roman = roman.substring(1, roman.length());
                if(roman.length() > 0) {
                    number += toInteger(roman);
                }
            }else if(roman.charAt(0) == 'V') {
                number += 5;
                roman = roman.substring(1, roman.length());
                if(roman.length() > 0) {
                    number += toInteger(roman);
                }
            }else if(roman.charAt(0) == 'I') {
                number += 1;
                roman = roman.substring(1, roman.length());
                if(roman.length() > 0) {
                    number += toInteger(roman);
                }
            }else {
                throw new IllegalArgumentException("Invalid Roman numeral.");
            }
        }else if(roman.length() > 1) {
            if(roman.charAt(0) == 'M') {
                number += 1000;
                roman = roman.substring(1, roman.length());
                if(roman.length() > 0) {
                    number += toInteger(roman);
                }
            }else if(roman.substring(0, 2).equals("CM")) {
                number += 900;
                roman = roman.substring(2, roman.length());
                if(roman.length() > 0) {
                    number += toInteger(roman);
                }
            }else if(roman.charAt(0) == 'D') {
                number += 500;
                roman = roman.substring(1, roman.length());
                if(roman.length() > 0) {
                    number += toInteger(roman);
                }
            }else if(roman.substring(0, 2).equals("CD")) {
                number += 400;
                roman = roman.substring(2, roman.length());
                if(roman.length() > 0) {
                    number += toInteger(roman);
                }
            }else if(roman.charAt(0) == 'C') {
                number += 100;
                roman = roman.substring(1, roman.length());
                if(roman.length() > 0) {
                    number += toInteger(roman);
                }
            }else if(roman.substring(0, 2).equals("XC")) {
                number += 90;
                roman = roman.substring(2, roman.length());
                if(roman.length() > 0) {
                    number += toInteger(roman);
                }
            }else if(roman.charAt(0) == 'L') {
                number += 50;
                roman = roman.substring(1, roman.length());
                if(roman.length() > 0) {
                    number += toInteger(roman);
                }
            }else if(roman.substring(0, 2).equals("XL")) {
                number += 40;
                roman = roman.substring(2, roman.length());
                if(roman.length() > 0) {
                    number += toInteger(roman);
                }
            }else if(roman.charAt(0) == 'X') {
                number += 10;
                roman = roman.substring(1, roman.length());
                if(roman.length() > 0) {
                    number += toInteger(roman);
                }
            }else if(roman.substring(0, 2).equals("IX")) {
                number += 9;
                roman = roman.substring(2, roman.length());
                if(roman.length() > 0) {
                    number += toInteger(roman);
                }
            }else if(roman.charAt(0) == 'V') {
                number += 5;
                roman = roman.substring(1, roman.length());
                if(roman.length() > 0) {
                    number += toInteger(roman);
                }
            }else if(roman.substring(0, 2).equals("IV")) {
                number += 4;
                roman = roman.substring(2, roman.length());
                if(roman.length() > 0) {
                    number += toInteger(roman);
                }
            }else if(roman.charAt(0) == 'I') {
                number += 1;
                roman = roman.substring(1, roman.length());
                if(roman.length() > 0) {
                    number += toInteger(roman);
                }
            }else {
                throw new IllegalArgumentException("Invalid Roman numeral.");
            }
        }

        return number;
    }
}
