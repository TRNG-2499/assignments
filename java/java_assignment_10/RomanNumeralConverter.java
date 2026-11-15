public class RomanNumeralConverter {
    public static String toRoman(int num) throws IllegalArgumentException{
        if(num > 3999 || num <= 0){
            throw new IllegalArgumentException("Integer is greater than 3999, or less than 1");
        }

        int[] values = {
                1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };

        String[] numerals = {
                "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };

        StringBuilder roman = new StringBuilder();

        for(int i = 0; i < values.length; i++){
            while(num >= values[i]){
                roman.append(numerals[i]);
                num -= values[i];
            }
        }

        return roman.toString();
    }
    public static int toInteger(String roman) throws IllegalArgumentException {
        if(roman == null || roman.isBlank()){
            throw new IllegalArgumentException("The string is blank.");
        }
        String[] characters = roman.toUpperCase().split("");
        int current = 0;
        for(int i = characters.length-1; i >= 0; i--){
            switch(characters[i]){
                case "I":
                    if(current >=5 ){
                        current -= 1;
                    }else{
                        current += 1;
                    }
                    break;
                case  "V": // does not need extra
                    current += 5;
                    break;
                case "X":
                    if(current >=50){
                        current -= 10;
                    }else{
                        current += 10;
                    }
                    break;
                case "L": // does not need extra
                    current += 50;
                    break;
                case "C":
                    if(current >= 500){
                        current -= 100;
                    }else{
                        current += 100;
                    }
                    break;
                case "D": // does not need extra
                    current += 500;
                    break;
                case "M": // does not need extra
                    current += 1000;
                    break;
                default:
                    throw new IllegalArgumentException("The string contains illegal characters.");
            }
        }
        return current;
    }
}
