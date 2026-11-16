package com.bryan;
import java.util.Map;
public class RomanNumeralConverter {
    private static final Map<Character, Integer> map = Map.of(
        'I', 1,
        'V', 5,
        'X', 10,
        'L', 50,
        'C', 100,
        'D', 500,
        'M', 1000
    );
    private static final int[] val = {
        1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    };
    private static final String[] symbols = {
        "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    };


    public static String toRoman(int num) {
        String roman = "";
        for(int i = 0; i <val.length;i++) {
            while (num >= val[i]) {
                roman+= symbols[i];
                num-=val[i];
            }
        }
        return roman;

    }
    public static int toInteger(String numeral) {
        int total = 0;
        for(int i = 0; i<numeral.length();i++) {
            int value = numeral.charAt(i);
            if(i+1 < numeral.length() && value < numeral.charAt(i+1)) {
                total -= value;
            }
            else {
                total+=value;
            }

        }
        return total;
    }

    public static void main(String[] args ) {
        System.out.println(toInteger("III"));
        System.out.println(toRoman(356));
        System.out.println(toRoman(2));
        System.out.println(toRoman(20));

    }

    
}