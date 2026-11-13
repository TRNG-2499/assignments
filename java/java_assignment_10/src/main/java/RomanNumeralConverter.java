public class RomanNumeralConverter {
    public static String toRoman(int num){
        if(num <= 0)
            throw new IllegalArgumentException("Argument can't be less or equal to 0");
        else if(num > 3999)
            throw new IllegalArgumentException("Argument can't be greater than 3999");
        StringBuilder builder = new StringBuilder();
        int m = 0, d = 0, c = 0, l = 0, x = 0, v = 0, i = 0;
        int cm = 0, cd = 0, xc = 0, xl = 0, ix = 0, iv = 0;
        m = num/1000;
        num = num % 1000;
        cm = num /900;
        num = num % 900;
        d = num / 500;
        num = num % 500;
        cd = num / 400;
        num = num % 400;
        c = num / 100;
        num = num % 100;
        xc = num / 90;
        num = num % 90;
        l = num / 50;
        num = num % 50;
        xl = num / 40;
        num = num % 40;
        x = num / 10;
        num = num % 10;
        ix = num / 9;
        num = num % 9;
        v = num / 5;
        num = num % 5;
        iv = num / 4;
        num = num % 4;
        i = num;
        builder.append("M".repeat(m));
        builder.append("CM".repeat(cm));
        builder.append("D".repeat(d));
        builder.append("CD".repeat(cd));
        builder.append("C".repeat(c));
        builder.append("XC".repeat(xc));
        builder.append("L".repeat(l));
        builder.append("XL".repeat(xl));
        builder.append("X".repeat(x));
        builder.append("IX".repeat(ix));
        builder.append("V".repeat(v));
        builder.append("IV".repeat(iv));
        builder.append("I".repeat(i));

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
