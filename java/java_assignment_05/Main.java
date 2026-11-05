import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Must provide a string");
      return;
    }

    StringBuilder b = new StringBuilder();
    for (String arg : args) {
      b.append(arg);
      b.append(" ");
    }

    duplicateWords(b.toString());
  }

  private static void duplicateWords(String s) {
    String[] words = s.toLowerCase().split(" ");

    Map<String, Integer> map = new HashMap<>();

    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    for (String word : words) {
      if (map.get(word) >= 0) {
        System.out.printf("%s - %d%n", word, map.get(word));
        map.put(word, -1);
      }
    }
  }
}
