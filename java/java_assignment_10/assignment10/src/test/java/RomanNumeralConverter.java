import java.io.*;
import java.util.*;

public class RomanNumeralConverter {
    public static String toRoman(int number){
        if(number < 1 || number > 3999){
            throw new IllegalArgumentException("Input is invalid, must be 1-3999!");
        }

        /*PSEUDOCODE
        * input: number
        * output: roman
        * 
        * initialize roman with a blank string builder
        * for every digit d from left to right of number
        *   if thousand (M)
        *       if d is 1
        *           add roman with "M"
        *       else if d is 2
        *           add roman with "MM"
        *       else if d is 3
        *           add roman with "MMM"
        *   else if hundred (C)
        *       if d is 1
        *           add roman with "C"
        *       if d is 2
        *           add roman with "CC"
        *       if d is 3
        *           add roman with "CCC"
        *       if d is 4
        *           add roman with "CD"
        *       if d is 5
        *           add roman with "D"
        *       if d is 6
        *           add roman with "DC"
        *       if d is 7
        *           add roman with "DCC"
        *       if d is 8
        *           add roman with "DCCC"
        *       if d is 9
        *           add roman with "CM"
        *   else if ten (X)
        *       if d is 1
        *           add roman with "X"
        *       else if d is 2
        *           add roman with "XX"
        *       else if d is 3
        *           add roman with "XXX"
        *       else if d is 4
        *           add roman with "XL"
        *       else if d is 5
        *           add roman with "L"
        *       else if d is 6
        *           add roman with "LX"
        *       else if d is 7
        *           add roman with "LXX"
        *       else if d is 8
        *           add roman with "LXXX"
        *       else if d is 9
        *           add roman with "XC"
        *   else if one (I)
        *       if d is 1
        *           add roman with "I"
        *       else if d is 2
        *           add roman with "II"
        *       else if d is 3
        *           add roman with "III"
        *       else if d is 4
        *           add roman with "IV"
        *       else if d is 5
        *           add roman with "V"
        *       else if d is 6
        *           add roman with "VI"
        *       else if d is 7
        *           add roman with "VII"
        *       else if d is 8
        *           add roman with "VIII"
        *       else if d is 9
        *           add roman with "XI"
        * 
        *  return roman
        */

        int decNumber = number;
        StringBuilder roman = new StringBuilder();
        for(int i = 4; i > 0; i--){
            int denom = 1;
            for(int p = 0; p < i - 1; p++){
                denom *= 10;
            }
            
            int digit = decNumber/denom;
            decNumber -= (digit * denom);

            switch(i){
                case 4:
                    switch(digit){
                        case 1:
                            roman.append("M");
                            break;
                        case 2:
                            roman.append("MM");
                            break;
                        case 3:
                            roman.append("MMM");
                            break;
                    }
                    break;
                case 3:
                    switch(digit){
                        case 1:
                            roman.append("C");
                            break;
                        case 2:
                            roman.append("CC");
                            break;
                        case 3:
                            roman.append("CCC");
                            break;
                        case 4:
                            roman.append("CD");
                            break;
                        case 5:
                            roman.append("D");
                            break;
                        case 6:
                            roman.append("DC");
                            break;
                        case 7:
                            roman.append("DCC");
                            break;
                        case 8:
                            roman.append("DCCC");
                            break;
                        case 9:
                            roman.append("CM");
                            break;
                    }
                    break;
                case 2:
                    switch(digit){
                        case 1:
                            roman.append("X");
                            break;
                        case 2:
                            roman.append("XX");
                            break;
                        case 3:
                            roman.append("XXX");
                            break;
                        case 4:
                            roman.append("XL");
                            break;
                        case 5:
                            roman.append("L");
                            break;
                        case 6:
                            roman.append("LX");
                            break;
                        case 7:
                            roman.append("LXX");
                            break;
                        case 8:
                            roman.append("LXXX");
                            break;
                        case 9:
                            roman.append("XC");
                            break;
                    }
                    break;
                case 1:
                    switch(digit){
                        case 1:
                            roman.append("I");
                            break;
                        case 2:
                            roman.append("II");
                            break;
                        case 3:
                            roman.append("III");
                            break;
                        case 4:
                            roman.append("IV");
                            break;
                        case 5:
                            roman.append("V");
                            break;
                        case 6:
                            roman.append("VI");
                            break;
                        case 7:
                            roman.append("VII");
                            break;
                        case 8:
                            roman.append("VIII");
                            break;
                        case 9:
                            roman.append("IX");
                            break;
                    }
                    break;
            }
        }
        return roman.toString();
    }

    public static int toInteger(String roman){
        if(roman != null) System.out.println(roman);
        if(roman == null || roman.isEmpty()){
            throw new IllegalArgumentException("Roman Numeral is null");
        }
        if(roman.length() == 1){
            return romanCharacterValue(roman.charAt(0));
        }
        
        int number = 0;

        char prevC = roman.charAt(0);
        int romanDigitValue = 0;
        int romanCharacterNumber = 0;
        int romanCharacterL = romanCharacterLevel(roman.charAt(0));

        for(int i = 0; i < roman.length(); i++){
            if(romanCharacterNumber > 3){
                System.out.println("exception thrown");
                throw new IllegalArgumentException("Roman numeral is invalid");
            }

            char c = roman.charAt(i);
            int cValue = romanCharacterValue(c);
            int cLevel = romanCharacterLevel(c);
            int prevComparison = compareRomanCharacterRanks(c, prevC);
            
            boolean nextDigit = prevComparison < 0 && (romanCharacterL - cLevel) > 0;
            
            boolean sameButNextAdditive = (i >= (roman.length() - 1)) ? false : compareRomanCharacterRanks(roman.charAt(i + 1), c) == -2;
            boolean sameButDifferentDigit = false; //prevComparison > 0 && sameButNextAdditive;
            if(nextDigit || sameButDifferentDigit){
                number += romanDigitValue;

                romanCharacterL--;
                romanCharacterNumber = 0;
                romanDigitValue = 0;
                System.out.println("break: " + number);
            }

            switch(romanCharacterNumber){
                case 1:
                    if(prevComparison > 0 && prevComparison <= 2 && isInRomanCharacterLevel(c, romanCharacterL)){
                        romanDigitValue = (cValue - romanDigitValue);
                        System.out.println(-cValue + " -> " + romanDigitValue);

                        number += romanDigitValue;

                        romanCharacterL--;
                        romanCharacterNumber = 0;
                        romanDigitValue = 0;
                        System.out.println("break: " + number);
                    } else {
                        romanDigitValue += cValue;
                        System.out.println(cValue + " -> " + romanDigitValue);

                        romanCharacterNumber++;
                    }
                    break;
                default:
                    romanDigitValue += cValue;
                    System.out.println(cValue + " -> " + romanDigitValue);

                    romanCharacterNumber++;
                    break;
            }
            prevC = c;
        }
        number += romanDigitValue;

        System.out.println("result: " + number);
        return number;
    }

    private static int compareRomanCharacterRanks(char c1, char c2){
        int rank1 = romanCharacterRank(c1);
        int rank2 = romanCharacterRank(c2);
        return rank1 - rank2;
    }

    private static int romanCharacterRank(char c){
        switch(c){
            case 'I':
            case 'i':
                return 1;
            case 'V':
            case 'v':
                return 2;
            case 'X':
            case 'x':
                return 3;
            case 'L':
            case 'l':
                return 4;
            case 'C':
            case 'c':
                return 5;
            case 'D':
            case 'd':
                return 6;
            case 'M':
            case 'm':
                return 7;
            default:
                throw new IllegalArgumentException("Roman numeral is invalid!");
        }
    }

    private static int romanCharacterLevel(char c){
        switch(c){
            case 'I':
            case 'i':
            case 'V':
            case 'v':
                return 0;
            case 'X':
            case 'x':
            case 'L':
            case 'l':
                return 1;
            case 'C':
            case 'c':
            case 'D':
            case 'd':
                return 2;
            case 'M':
            case 'm':
                return 3;
            default:
                throw new IllegalArgumentException("Roman numeral is invalid!");
        }
    }
    private static boolean isInRomanCharacterLevel(char c, int level){
        switch(c){
            case 'I':
            case 'i':
                return level == 0;
            case 'V':
            case 'v':
                return level == 0;
            case 'X':
            case 'x':
                return level == 0 || level == 1;
            case 'L':
            case 'l':
                return level == 1;
            case 'C':
            case 'c':
                return level == 1 || level == 2;
            case 'D':
            case 'd':
                return level == 2;
            case 'M':
            case 'm':
                return level == 2 || level == 3;
            default:
                return false;
        }
    }

    private static int romanCharacterValue(char c){
        switch(romanCharacterRank(c)){
            case 1:
                return 1;
            case 2:
                return 5;
            case 3:
                return 10;
            case 4:
                return 50;
            case 5:
                return 100;
            case 6:
                return 500;
            case 7:
                return 1000;
            default:
                return -1;
        }
    }
}