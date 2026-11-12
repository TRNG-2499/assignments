import java.util.ArrayDeque;
import java.util.Deque;

class Main {
    public static boolean foo(String str) {
        boolean answer = false, blocker = false;
        Deque<Character> stack = new ArrayDeque<>();
        char[] charArr = str.toCharArray();
        String validChars = "(){}[]<>";

        if(str == "") return true;


        // you cant open a bracket outside another bracket and close it inside that other bracket
        //push all chars in str to the stack

        for (char curr : charArr) {
            if ("({[<".contains(String.valueOf(curr))) {
                stack.push(curr);
            }
            if(")}]>".contains(String.valueOf(curr))) {
                char top_char = stack.peek();
                answer = switch(top_char) {
                    case '(' -> curr == ')';
                    case '[' -> curr == ']';
                    case '{' -> curr == '}';
                    case '<' -> curr == '>';
                    default -> false;
                };
            }
        }
        return answer;
    }

    public void run_cases(String str) {
        System.out.println(
                "String: " + str + "\n" +
                        "is_balanced: " + foo(str) + "\n");
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run_cases("<{[]}>"); //balanced
        main.run_cases("([)]"); //not balanced
        main.run_cases("{}([])"); //balanced
        main.run_cases(""); //balanced
    }
}