import java.util.HashSet;
public class dup {
    public String checkDups(String sent) {
        String[] words = sent.split(" ");
        HashSet<String> seen = new HashSet<>();
        for (String word : words) {
            if (seen.contains(word)) {
                return "Duplicate found: " + word;
            }
            seen.add(word);
        }
        return "No duplicates found.";
    }
    public static void main(String[] args) {
        dup dp = new dup();
        System.out.println(dp.checkDups("This is a test sentence."));
        System.out.println(dp.checkDups("duplicates duplicates we we we are are"));
    }
}