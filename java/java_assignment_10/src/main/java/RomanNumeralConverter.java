public class RomanNumeralConverter {
    public static String toRoman(int num){
        if(num <= 0)
            throw new IllegalArgumentException("Argument can't be less or equal to 0");
        else if(num > 3999)
            throw new IllegalArgumentException("Argument can't be greater than 3999");
        StringBuilder builder = new StringBuilder();
        String [] symb = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int [] symbDividend = {1000, 900, 500, 400 ,100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        for(int i = 0; i < symbDividend.length; i++){
            builder.append(symb[i].repeat(num/symbDividend[i]));
            num = num % symbDividend[i];
        }

        return builder.toString();
    }
    public static int toInteger(String str){
        if(str == null || str.length() == 0)
            throw new IllegalArgumentException("String can't be null or empty");
        str = str.toUpperCase();
        int res = 0;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            switch(c){
                case 'M':
                    res += 1000;
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'C':
                    if(i+1 < str.length() && (str.charAt(i+1) == 'D' || str.charAt(i+1) == 'M')){
                        if(str.charAt(i+1) == 'D')
                            res += 400;
                        else if(str.charAt(i+1) == 'M')
                            res += 900;
                        i++;
                        break;
                    }
                    res += 100;
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'X':
                    if(i+1 < str.length() && (str.charAt(i+1) == 'L' || str.charAt(i+1) == 'C')){
                        if(str.charAt(i+1) == 'L')
                            res += 40;
                        else if(str.charAt(i+1) == 'C')
                            res += 90;
                        i++;
                        break;
                    }
                    res += 10;
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'I':
                    if(i+1 < str.length() && (str.charAt(i+1) == 'V' || str.charAt(i+1) == 'X')){
                        if(str.charAt(i+1) == 'V')
                            res += 4;
                        else if(str.charAt(i+1) == 'X')
                            res += 9;
                        i++;
                        break;
                    }
                    res += 1;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid String Detected");
            }
        }

        return res;
    }
}
