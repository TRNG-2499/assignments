package org.example;

public class RomanNumeralConverter {
    public static String toRoman(int number) throws IllegalArgumentException {
        if (number > 3999 || number < 1) {
            throw new IllegalArgumentException("Please input a number from 1- 3999");
        }
        String romanNumeral = "";
        while(number >= 1000) {
            romanNumeral += "M";
            number -= 1000;
        }
        while(number >= 900) {
            romanNumeral += "CM";
            number -= 900;
        }
        while(number >= 500) {
            romanNumeral += "D";
            number -= 500;
        }
        while(number >= 400) {
            romanNumeral += "CD";
            number -= 400;
        }
        while(number >= 100) {
            romanNumeral += "C";
            number -= 100;
        }
        while(number >= 90) {
            romanNumeral += "XC";
            number -= 90;
        }
        while(number >= 50) {
            romanNumeral += "L";
            number -= 50;
        }
        while(number >= 40) {
            romanNumeral += "XL";
            number -= 40;
        }
        while(number >= 10) {
            romanNumeral += "X";
            number -= 10;
        }
        while(number >= 9) {
            romanNumeral += "IX";
            number -= 9;
        }
        while(number >= 5) {
            romanNumeral += "V";
            number -= 5;
        }
        while(number >= 4) {
            romanNumeral += "IV";
            number -= 4;
        }
        while(number >= 1) {
            romanNumeral += "I";
            number -= 1;
        }
        return romanNumeral;
    }

    public static int romanCharVal(char r) {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }


    public static int toInteger(String roman) throws IllegalArgumentException {
        if (roman == null || roman.equals("") || roman.equals(" ")) {
            throw new IllegalArgumentException("Please input a valid string");
        }

        roman = roman.toUpperCase();


        if(!(roman.matches("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$"))) {
            throw new IllegalArgumentException("Please input a valid roman numeral");
        }

        int result = 0;
        for(int i = 0; i < roman.length(); i++) {
            int v1 = romanCharVal(roman.charAt(i));

            if (i+1 < roman.length()) {
                int v2 = romanCharVal(roman.charAt(i+1));
                if(v1 >= v2) {
                    result += v1;
                } else {
                    result += (v2 - v1);
                    i++;
                }
            }  else {
                result += v1;
            }
        }

        return result;
    }
}
