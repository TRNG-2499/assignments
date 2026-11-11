import java.util.*;

public class ValidParenthesis {
    public static void main() {
        ValidParenthesis instance = new ValidParenthesis();

        /*
        Core test
         */
        System.out.println("Core test\n--------------");
        System.out.println(instance.validateParenthesis("()"));
        System.out.println(instance.validateParenthesis("()[]{}<>"));
        System.out.println(instance.validateParenthesis("(]"));
        System.out.println(instance.validateParenthesis("([)]"));
        System.out.println(instance.validateParenthesis("<{[]}>"));
        System.out.println(instance.validateParenthesis("(<>"));
        System.out.println(instance.validateParenthesis(""));

        /*
        Stretch test
         */
        System.out.println("Stretch test\n--------------");
        System.out.println(instance.validateAllParenthesis("()"));
        System.out.println(instance.validateAllParenthesis("()[]{}<>"));
        System.out.println(instance.validateAllParenthesis("(]"));
        System.out.println(instance.validateAllParenthesis("([)]"));
        System.out.println(instance.validateAllParenthesis("<{[]}>"));
        System.out.println(instance.validateAllParenthesis("(<>"));
        System.out.println(instance.validateAllParenthesis(""));

        System.out.println(instance.validateParenthesisSelection("()[]{}<>", List.of('(','>')));
        System.out.println(instance.validateParenthesisSelection("()[]{}<>", List.of('(','>','[','}')));
    }

    public boolean validateParenthesis(String input) {
        String validCharacters = "(){}[]<>";
        Map<Character, Character> parenthesisMatch = Map.of(
                 ')', '(',
                 '}', '{',
                 ']', '[',
                 '>', '<'
        );

        Stack<Character> openParenthesis = new Stack<>();

        for (char c : input.toCharArray()) {
            if (validCharacters.indexOf(c) == -1) {
                // Invalid character in input string
                return false;
            }

            if (parenthesisMatch.containsKey(c)) {
                // Handle closing parenthesis
                if (openParenthesis.isEmpty() || openParenthesis.pop() != parenthesisMatch.get(c)) {
                    return false ;
                }

            } else {
                // Handle opening parenthesis
                openParenthesis.push(c);
            }
        }

        if (openParenthesis.isEmpty()) {
            return true;
        }

        return false;
    }

    public List<Integer> validateAllParenthesis(String input) {
        String validCharacters = "(){}[]<>";
        Map<Character, Character> parenthesisMatch = Map.of(
                ')', '(',
                '}', '{',
                ']', '[',
                '>', '<'
        );

        Stack<Integer> openParenthesis = new Stack<>();
        List<Integer> invalidIndices = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (validCharacters.indexOf(c) == -1) {
                // Invalid character in input string
                return List.of(-1);
            }

            if (parenthesisMatch.containsKey(c)) {
                // Handle closing parenthesis
                if (openParenthesis.isEmpty()) {
                   invalidIndices.add(i); // change to index
                } else {
                    int prevOpen = openParenthesis.pop();
                    if (input.charAt(prevOpen) != parenthesisMatch.get(c)) {
                        invalidIndices.add(i);
                        invalidIndices.add(prevOpen);
                    }
                }
            } else {
                // Handle opening parenthesis
                openParenthesis.push(i);
            }
        }

        while (!openParenthesis.isEmpty()) {
            int c = openParenthesis.pop();
            invalidIndices.add(c);
        }
        if (invalidIndices.isEmpty()) {
            return List.of();
        } else {
            return invalidIndices;
        }
    }

    public boolean validateParenthesisSelection(String input, List<Character> selection) {
        String validCharacters = "";
        Map<Character, Character> parenthesisMatch = new HashMap<>(Map.of(
        ));
        for (int i = 0; i < selection.size(); i++) {
            char c = selection.get(i);
            switch(c) {
                case '(', ')' -> {
                    parenthesisMatch.put(')', '(');
                    validCharacters += "()";
                }
                case '{', '}' -> {
                    parenthesisMatch.put('}', '{');
                    validCharacters += "{}";
                }
                case '[', ']' -> {
                    parenthesisMatch.put(']', '[');
                    validCharacters += "[]";
                }
                case '<', '>' -> {
                    parenthesisMatch.put('>', '<');
                    validCharacters += "<>";
                }
            }
        }

        Stack<Character> openParenthesis = new Stack<>();

        for (char c : input.toCharArray()) {
            if (validCharacters.indexOf(c) == -1) {
                // Invalid character in input string
                return false;
            }

            if (parenthesisMatch.containsKey(c)) {
                // Handle closing parenthesis
                if (openParenthesis.isEmpty() || openParenthesis.pop() != parenthesisMatch.get(c)) {
                    return false ;
                }

            } else {
                // Handle opening parenthesis
                openParenthesis.push(c);
            }
        }

        if (openParenthesis.isEmpty()) {
            return true;
        }

        return false;
    }
}