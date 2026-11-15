import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumeralConverter{
    private static final Map<Character,Integer> charToInt = Map.of(
        'I',1,
        'V',5,
        'X',10,
        'L',50,
        'C',100,
        'D',500,
        'M',1000
    );
    private static final Map<Integer,Character> intToChar = Map.of(
        1,'I',
        5,'V',
        10,'X',
        50,'L',
        100,'C',
        500,'D',
        1000,'M'  
    );

    private static final Pattern ROMAN = Pattern.compile(
        "(M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})",
        Pattern.CASE_INSENSITIVE
    );

    public static String add(String a, String b){
        int sum = toInteger(a) + toInteger(b);
        return toRoman(sum);
    }

    public static String toRoman(int n) {
        if (n < 1 || n > 3999) {
            throw new IllegalArgumentException("Input out of range (1-3999)");
        }

        StringBuilder sb = new StringBuilder();
        for (int base = 1000; base >= 1; base/=10) {
            int d = n / base;
            n %= base;
            char l = intToChar.get(base);

            switch (d) {
                case 9 -> sb.append(l).append(intToChar.get(base * 10));
                case 4 -> sb.append(l).append(intToChar.get(base * 5));
                default -> {
                    if (d >= 5) {
                        sb.append(intToChar.get(base * 5));
                        d -= 5;
                    }
                    sb.append(String.valueOf(l).repeat(d));
                }
            }
        }
        return sb.toString();
    }

    public static int toInteger(String s) {
        String[] tokens = tokenizeString(s);
        int total = 0;
        for (String token : tokens) {
            total += evaluateToken(token);
        }
        return total;
    }

    public static String[] tokenizeString(String s) {
         if (s == null || s.isBlank()) {
            throw new IllegalArgumentException("Invalid Roman Numeral, input is empty or blank");
        }
        Matcher m = ROMAN.matcher(s);
        if (!m.matches()) {
            throw new IllegalArgumentException("Invalid Roman Numeral " + s);
        }
        
        List<String> tokens = new ArrayList<>();
        for (int i = 1; i <= m.groupCount(); i++) {
            String token = m.group(i);
            if (!token.isEmpty()) tokens.add(token);
        }

        return tokens.toArray(String[]::new);
    }

    public static int evaluateToken(String s) {
        int cur = 0, high = 0;
        char[] chars = s.toUpperCase().toCharArray();
        for (int i = chars.length-1; i >= 0; --i) {
            int a = charToInt.get(chars[i]);
            if (a >= high) {
                high = a;
                cur += a;
            } else {
                cur -= a;
            }
        }
        return cur;
    }
}