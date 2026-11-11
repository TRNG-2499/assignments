import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    balancedPrint("()");
    balancedPrint("{}");
    balancedPrint("[]");
    balancedPrint("(}");
    balancedPrint("({})");
    balancedPrint("([[]])");
    balancedPrint("([[}])");
  }

  public static void balancedPrint(String s) {
    System.out.printf("%b - %s%n", balanced(s), s);
  }

  public static boolean balanced(String s) {
    Stack<BracketType> opening = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      BracketType type = BracketType.fromCharOpening(c);
      if (type != null) {
        opening.push(type);
        continue;
      }

      type = BracketType.fromCharClosing(c);
      if (type != null) {
        if (opening.empty() || opening.pop() != type) {
          return false;
        }

        continue;
      }

      throw new RuntimeException("Invalid input in string");
    }

    return opening.empty();
  }
}
