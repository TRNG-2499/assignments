import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class RomanNumeralConverter {

    public static String toRoman(int number){
        //I used a linkedHashMap to keep it order highest to lowest
        LinkedHashMap<Integer, String> n = new LinkedHashMap<>();
        n.put(1000,"M");
        n.put(900,"CM");
        n.put(500,"D");
        n.put(400,"CD");
        n.put(100,"C");
        n.put(90,"XC");
        n.put(50,"L");
        n.put(40,"XL");
        n.put(10,"X");
        n.put(9,"IX");
        n.put(5,"V");
        n.put(4,"IV");
        n.put(1,"I");

        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("Number must be between 1 and 3999: " + number);
        }

        //used a stringbuilder to put multiple larger roman numerals together
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, String> entry : n.entrySet()) {
            while (number >= entry.getKey()) {
                result.append(entry.getValue());
                number -= entry.getKey();
            }
        }
        return result.toString();
    }
    public static int toInteger(String roman){
        if (roman == null || roman.trim().isEmpty()) {
            throw new IllegalArgumentException("Roman numeral must not be null or empty");
        }
        String caseInsensitiveRoman = roman.trim().toUpperCase(Locale.ROOT);

        Map<Character, Integer> r = new HashMap<>();
        r.put('I', 1);
        r.put('V', 5);
        r.put('X', 10);
        r.put('L', 50);
        r.put('C', 100);
        r.put('D', 500);
        r.put('M', 1000);

        int total = 0;
        for (int i = 0; i < caseInsensitiveRoman.length(); i++) {
        char c = caseInsensitiveRoman.charAt(i);

            if (!r.containsKey(c)) {
                throw new IllegalArgumentException("Invalid Roman numeral: " + roman);
            }

        int current = r.get(c);

        if (i + 1 < caseInsensitiveRoman.length() && current < r.getOrDefault(caseInsensitiveRoman.charAt(i + 1), 0)) {
            total -= current;
        } else{
            total += current;
            }
        }
        return total;
    }
}
