public class RomanNumeralConverter {

    public static String toRoman(int number){
        StringBuilder romanNum = new StringBuilder();

        if(number <= 0 || number >= 4000){
            throw new IllegalArgumentException("Input out of bounds.");
        }

        while (number > 0) {
            if (number >= 1000) {
                romanNum.append("M");
                number -= 1000;
            } else if (number >= 900) {
                romanNum.append("CM");
                number -= 900;
            } else if (number >= 500) {
                romanNum.append("D");
                number -= 500;
            } else if (number >= 400) {
                romanNum.append("CD");
                number -= 400;
            } else if (number >= 100) {
                romanNum.append("C");
                number -= 100;
            } else if (number >= 90) {
                romanNum.append("XC");
                number -= 90;
            } else if (number >= 50) {
                romanNum.append("L");
                number -= 50;
            } else if (number >= 40) {
                romanNum.append("XL");
                number -= 40;
            } else if (number >= 10) {
                romanNum.append("X");
                number -= 10;
            } else if (number == 9) {
                romanNum.append("IX");
                number -= 9;
            } else if (number >= 5) {
                romanNum.append("V");
                number -= 5;
            } else if (number == 4) {
                romanNum.append("IV");
                number -= 4;
            } else {
                romanNum.append("I");
                number -= 1;
            }
        }


        return romanNum.toString();
    }

    public static int toInteger(String romanNum){
        int regNum = 0;

        try {
            if(romanNum.isEmpty()){
                throw new IllegalArgumentException("Input cannot be empty.");
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Input cannot be null.");
        }

        romanNum = romanNum.toUpperCase();

        for(int i=0; i < romanNum.length(); i++){
            switch(romanNum.charAt(i)){
                case 'I':
                case 'V':
                case 'X':
                case 'L':
                case 'C':
                case 'D':
                case 'M':
                    break;
                default:
                    throw new IllegalArgumentException("Input contains illegal characters.");
            }
        }

        for(int i=0; i < romanNum.length(); i++) {
            switch (romanNum.charAt(i)) {
                case 'I':
                    regNum += 1;
                    break;
                case 'V':
                    if(i!=0 && romanNum.charAt(i-1) == 'I'){
                        regNum += 3; //Idea here is regNum += [i] - [i-1]*2 instead of having an additional subtraction step then adding [i]
                    } else {
                        regNum += 5;
                    }
                    break;
                case 'X':
                    if(i!=0 && romanNum.charAt(i-1) == 'I'){
                        regNum += 8;
                    } else {
                        regNum += 10;
                    }
                    break;
                case 'L':
                    if(i!=0 && romanNum.charAt(i-1) == 'X'){
                        regNum += 30;
                    } else {
                        regNum += 50;
                    }
                    break;
                case 'C':
                    if(i!=0 && romanNum.charAt(i-1) == 'X'){
                        regNum += 80;
                    } else {
                        regNum += 100;
                    }
                    break;
                case 'D':
                    if(i!=0 && romanNum.charAt(i-1) == 'C'){
                        regNum += 300;
                    } else {
                        regNum += 500;
                    }
                    break;
                case 'M':
                    if(i!=0 && romanNum.charAt(i-1) == 'C'){
                        regNum += 800;
                    } else {
                        regNum += 1000;
                    }
                    break;
            }
        }

        return regNum;
    }

}
