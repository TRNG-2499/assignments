

import java.util.HashMap;

public class RomanNumeralConverter {

    public static String toRoman(int number){

        if(number < 1 || number > 3999) {
            throw new IllegalArgumentException("Number can't be less than 1 or greater than 3999");
        }

        String roman = "";

        int[] numbers = new int[]      {1000,   900,  500,  400, 100,   90,  50,   40,  10,    9,   5,    4,  1};
        String[] romans = new String[] { "M",  "CM",  "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for(int i = 0; i < numbers.length; i++) {
            if(number / numbers[i] == 1)
            {
                roman += romans[i];
                number -= numbers[i];
                // System.out.println("Adding " + numbers[i]);
                // System.out.println("Number left: " + number);
            } else if (number / numbers[i] > 1)
            {
                roman += romans[i].repeat(number / numbers[i]);
                number -= numbers[i] * (number / numbers[i]);
                // System.out.println("Adding " + numbers[i] + " " + (number / numbers[i]) + " times");
                // System.out.println("Number left: " + number);
            }
        }

        return roman;
    }

    public static int toInteger(String roman) {

        if(roman == "" || roman == null)
        {
            throw new IllegalArgumentException("Roman letters cant be NULL or empty");
        }

        int number = 0;

        roman = roman.toUpperCase();

        HashMap<Character, Integer> romanToInt = new HashMap<>();
        romanToInt.put('M', 1000);
        romanToInt.put('D', 500);
        romanToInt.put('C', 100);
        romanToInt.put('L', 50);
        romanToInt.put('X', 10);
        romanToInt.put('V', 5);
        romanToInt.put('I', 1);



        for(int i = 0; i < roman.length(); i++)
        {

            if (!romanToInt.containsKey(roman.charAt(i)))
            {
                throw new IllegalArgumentException("This " + roman.charAt(i) + " is not a roman letter");
            } 
            int current = romanToInt.get(roman.charAt(i));

            if(i == roman.length() - 1)
            {
                number += current;
                break;
            }

            if(!romanToInt.containsKey(roman.charAt(i + 1)))
            {
                throw new IllegalArgumentException("This " + roman.charAt(i) + " is not a roman letter");
               
            }
            
            int next = romanToInt.get(roman.charAt(i + 1));

            if(current >= next)
            {
                number += current;
            } else if (current < next)
            {
                number += (next - current);
                i++;
            }
        }

        return number;
    }
    public static void main(String[] args) {
        System.out.println(toRoman(1987));
        System.out.println(toInteger("X I"));
    }
}