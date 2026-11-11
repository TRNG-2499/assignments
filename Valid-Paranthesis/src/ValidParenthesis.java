import java.util.Stack;

public class ValidParenthesis {
        public static void main(String[] args) {
            System.out.println(isValid("()"));       // true
            System.out.println(isValid("()[]{}<>"));// true
            System.out.println(isValid("(]"));       // false
            System.out.println(isValid("([)]"));     // false
            System.out.println(isValid("<{[]}>"));   // true
            System.out.println(isValid("(<>"));      // false
            System.out.println(isValid(""));         // true

        }

        public static boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {

                char current = s.charAt(i);


                //Let's check if it is an opening bracket
                char last = 0;
                if (current == '(' || current == '[' || current == '{' || current == '<') {
                    stack.push(current);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    last = stack.pop();
                }

                //Let's check if the brackets match

                if (current == ')' && last != '(') {
                    return false;
                }
                if (current == ']' && last != '[') {
                    return false;
                }
                if (current == '}' && last != '{') {
                    return false;
                }
                if (current == '>' && last != '<') {
                    return false;
                }
            }

            return stack.isEmpty();

        }



    }

