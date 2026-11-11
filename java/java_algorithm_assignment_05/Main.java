import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Main {

    public static final Set<String> openP = Set.of("(", "{", "[", "<");
    public static final Map<String, String> close2Open = Map.of(")", "(", "}", "{", "]", "[", ">", "<");

    public static boolean balanced(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if (openP.contains(c)) {
                stack.push(c);
            } else if (close2Open.containsKey(c)) {
                String sc = stack.pop();
                String vc = close2Open.get(c);
                if (vc.compareTo(sc) != 0) {
                    return false;
                }
            }
        }

        if (!stack.empty()) {
            return false;
        }

        return true;
    }

    public static boolean balancedCust(String s, String[] sym) {
        Set<String> checked = new HashSet<>();
        for (String sy : sym) {
            if (openP.contains(sy)) {
                checked.add(sy);
            } else if (close2Open.containsKey(sy)) {
                checked.add(close2Open.get(sy));
            }
        }

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if (checked.contains(c)) {
                stack.push(c);
            } else if (close2Open.containsKey(c)) {
                String sc = stack.pop();
                String vc = close2Open.get(c);
                if (vc.compareTo(sc) != 0) {
                    return false;
                }
            }
        }

        if (!stack.empty()) {
            return false;
        }

        return true;
    }

    public static List<Integer> getInv(String s) {
        List<Integer> inv = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if (openP.contains(c)) {
                stack.push(c);
            } else if (close2Open.containsKey(c)) {
                String sc = stack.pop();
                String vc = close2Open.get(c);
                if (vc.compareTo(sc) != 0) {
                    inv.add(i);
                }
            }
        }

        while (!stack.empty()) {
            for (int i = 0; i < stack.size(); i++) {
                inv.add(i);
            }
        }

        return inv;
    }

    public static void main(String[] args) {
        boolean r0 = balanced("()");
        boolean r1 = balanced("()[]{}<>");
        boolean r2 = balanced("(]");
        boolean r3 = balanced("(])]");

        System.out.println(r0);
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
    }
}
