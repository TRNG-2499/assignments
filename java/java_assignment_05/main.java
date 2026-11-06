import java.util.HashSet;
import java.util.Set;

class Main {

    int countOccurrences(String[] words, String target, int pos) {
        int count = 0;
        for (int j = pos; j < words.length; j++) {
            if (words[j].equalsIgnoreCase(target)) count++;
        }
        return count;
    }

    String foo(String arg) {
        String[] words = arg.split(" ");
        Set<String> seen = new HashSet<>();
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String curr = words[i];
            if (seen.add(curr.toLowerCase())) {
                if (out.length() > 0) out.append(", ");
                out.append(curr).append(" - ").append(countOccurrences(words, curr, i));
            }
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println(obj.foo("Every word here is unique"));
        System.out.println(obj.foo("The time I went to the store I bought a watermelon"));
    }
}