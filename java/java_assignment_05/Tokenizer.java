import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Tokenizer {

    public static class CustMap extends LinkedHashMap<String, Long> {

        public CustMap(Map<String, Long> counts) {
            super(counts);
        }

        @Override 
        public String toString() {
            String res = new String();
            for (String k : keySet()) {
                res = res.concat(
                    String.format(
                        ", %s - %d",
                        k,
                        get(k)
                    )
                );
            }

            return res.substring(2);
        }
    }

    public static String countWords(String sentence) {
        String[] words = sentence.split(" ");
        words =
            Arrays
                .stream(words)
                .map(w -> w.replaceAll("\\W", "").toLowerCase())
                .toArray(String[]::new);

        LinkedHashMap<String, Long> counts =
            Arrays
                .stream(words)
                .collect(
                    Collectors.groupingBy(
                        w -> w,
                        LinkedHashMap::new,
                        Collectors.counting()
                    )
                );

        return new CustMap(counts).toString();
    }

    public static String deDupString(String sentence) {
        String[] words = sentence.split(" ");
        words =
            Arrays
                .stream(words)
                .map(w -> w)
                .toArray(String[]::new);

        LinkedHashMap<String, Long> counts =
            Arrays
                .stream(words)
                .collect(
                    Collectors.groupingBy(
                        w -> w,
                        LinkedHashMap::new,
                        Collectors.counting()
                    )
                );

        
        return String.join(" ", counts.keySet().toArray(String[]::new));
    }

    public static void main(String[] args) {
        String s1 = "The time I went to the store I bought a watermelon";
        System.out.println(countWords(s1));
        System.out.println(deDupString(s1));

        // I would love to implement the other stretch goal
        // however, it is very late and I have spent too much time
        // over engineering my solutions. I am going to go read
    }
}
