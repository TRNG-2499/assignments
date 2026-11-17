package src.test.java;

public class RomanNumeralConverter {

    public static int[] romanValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public static String[] subtractives = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

/*     public static char numeralSwitch(int number){
        char numeral;
        switch(number){
            case(1):
                numeral = 'I';
                break;
            case(5):
                numeral = 'V';
                break;
            case(10):
                numeral = 'X';
                break;
            case(50):
                numeral = 'L';
                break;
            case(100):
                numeral = 'C';
                break;
            case(500):
                numeral = 'D';
                break;
            case(1000):
                numeral = 'M';
                break;
            default:
                throw new IllegalArgumentException("Invalid input: " + number);
        }
        return numeral;
    } */

    public static String toRoman(int number){
        if(number < 1 || number > 3999){
            throw new IllegalArgumentException("Invalid input: " + number + " Number must be 1-3999.\n");
        }

        StringBuilder roman = new StringBuilder();

        for(int i = 0; i < romanValues.length; i++){
            while(number >= romanValues[i]){
                roman.append(subtractives[i]);
                number -= romanValues[i];
            }
        }
        return roman.toString();
    }

    public static int toInteger(String roman){
        if(roman == null || roman.length() == 0){
            throw new IllegalArgumentException("Invalid input: " + roman + " Roman numeral must be comprised of chars [MDCLXVI].\n");
        }

        String upperRoman = roman.toUpperCase();
        int num = 0;

        /* for (int i = 0; i < roman.length(); i++){
            char numeral = roman.charAt(i);

            switch(numeral){
                case('I'):
                    num += 1;
                    break;
                case('V'):
                    num += 5;
                    break;
                case('X'):
                    num += 10;
                    break;
                case('L'):
                    num += 50;
                    break;
                case('C'):
                    num += 100;
                    break;
                case('D'):
                    num += 500;
                    break;
                case('M'):
                    num += 1000;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid input: " + roman);
            }
        } */

        int index = 0;

        while (index < upperRoman.length()) {
            boolean matched = false;
            for (int i = 0; i < subtractives.length; i++) {
                if (upperRoman.startsWith(subtractives[i], index)) {
                    num += romanValues[i];
                    index += subtractives[i].length();
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                throw new IllegalArgumentException("Invalid input: " + roman + " Roman numeral must be comprised of chars [MDCLXVI].\n");
            }
        }

        return num;
    }
}
