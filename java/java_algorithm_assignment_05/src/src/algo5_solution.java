import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class algo5_solution {
    public boolean solution(String characters){
        if(characters.isEmpty()) return true;
        String[] split = characters.split("");
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < split.length; i++){
            switch (split[i]) {
                case ")" -> {
                    if(stack.isEmpty()){
                        return false;
                    }
                    if (stack.peek().equals("(")) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
                case "]" -> {
                    if(stack.isEmpty()){
                        return false;
                    }
                    if (stack.peek().equals("[")) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
                case ">" -> {
                    if(stack.isEmpty()){
                        return false;
                    }
                    if (stack.peek().equals("<")) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
                case "}" -> {
                    if(stack.isEmpty()){
                        return false;
                    }
                    if (stack.peek().equals("{")) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
                default -> {
                    stack.push(split[i]);
                }
            }
        }
        return stack.isEmpty();
    }

    public List<Integer> allInvalid(String characters){
        List<Integer> invalid = new ArrayList<>();
        if(characters.isEmpty()) return invalid; // will be empty

        String[] split = characters.split("");
        Stack<String> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();
        for(int i = 0; i < split.length; i++){
            switch (split[i]) {
                case ")" -> {
                    if(stack.isEmpty()){
                        invalid.add(i);
                    }
                    else if (stack.peek().equals("(")) {
                        stack.pop();
                        index.pop();
                    } else {
                        invalid.add(i);
                    }
                }
                case "]" -> {
                    if(stack.isEmpty()){
                        invalid.add(i);
                    }
                    else if (stack.peek().equals("[")) {
                        stack.pop();
                        index.pop();
                    } else {
                        invalid.add(i);
                    }
                }
                case ">" -> {
                    if(stack.isEmpty()){
                        invalid.add(i);
                    }
                    else if (stack.peek().equals("<")) {
                        stack.pop();
                        index.pop();
                    } else {
                        invalid.add(i);
                    }
                }
                case "}" -> {
                    if(stack.isEmpty()){
                        invalid.add(i);
                    }
                    else if (stack.peek().equals("{")) {
                        stack.pop();
                        index.pop();
                    } else {
                        invalid.add(i);
                    }
                }
                default -> {
                    index.push(i);
                    stack.push(split[i]);
                }
            }
        }
        if(!stack.isEmpty()){
            invalid.addAll(index);
        }
        Collections.sort(invalid); // just for cleanliness
        return invalid;
    }
    public boolean matchGiven(String characters, List<String> symbols){
        if(characters.isEmpty()) return true;
        String[] split = characters.split("");
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < split.length; i++){
            switch (split[i]) {
                case ")" -> {
                    if(symbols.contains("(") || symbols.contains(")")){
                        if(stack.isEmpty()){
                            return false;
                        }
                        if (stack.peek().equals("(")) {
                            stack.pop();
                        } else {
                            return false;
                        }
                    }
                    // ignore otherwise
                }
                case "]" -> {
                    if(symbols.contains("[") || symbols.contains("]")) {
                        if (stack.isEmpty()) {
                            return false;
                        }
                        if (stack.peek().equals("[")) {
                            stack.pop();
                        } else {
                            return false;
                        }
                    }
                    // ignore otherwise
                }
                case ">" -> {
                    if(symbols.contains("<") || symbols.contains(">")) {
                        if (stack.isEmpty()) {
                            return false;
                        }
                        if (stack.peek().equals("<")) {
                            stack.pop();
                        } else {
                            return false;
                        }
                    }
                    // ignore otherwise
                }
                case "}" -> {
                    if(symbols.contains("{") || symbols.contains("}")) {
                        if (stack.isEmpty()) {
                            return false;
                        }
                        if (stack.peek().equals("{")) {
                            stack.pop();
                        } else {
                            return false;
                        }
                    }
                    // ignore otherwise
                }
                case "(" -> { // new cases for detecting if it should be pushed to stack
                    if(symbols.contains("(") || symbols.contains(")")) {stack.push(split[i]);}
                }
                case "{" -> {
                    if(symbols.contains("{") || symbols.contains("}")) {stack.push(split[i]);}
                }
                case "[" -> {
                    if(symbols.contains("[") || symbols.contains("]")) {stack.push(split[i]);}
                }
                case "<" -> {
                    if(symbols.contains("<") || symbols.contains(">")) {stack.push(split[i]);}
                }
                default -> {
                    stack.push(split[i]); // should never be called here
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        algo5_solution algo5 = new algo5_solution();
        System.out.println(algo5.solution("")); // Expect true
        System.out.println(algo5.solution("<>{}()[]")); // Expect true
        System.out.println(algo5.solution("([{}])")); // Expect true
        System.out.println(algo5.solution("([)]")); // Expect false
        System.out.println(algo5.solution("(<>{}")); // Expect false, missing last ')'
        System.out.println(algo5.solution(">>>>>")); // Expect false, missing initial '<'
        System.out.println("---------- Stretch Goals ----------");
        System.out.println(algo5.allInvalid(">>>>>")); // Expect 0,1,2,3,4
        System.out.println(algo5.allInvalid("(<>{}")); // Expect 0
        System.out.println(algo5.allInvalid("<>[{}>)")); // Expect 2,5,6
        System.out.println(algo5.allInvalid("<>{}()[]")); // Expect ""
        List<String> tester = new ArrayList<>();
        tester.add("<");
        System.out.println(algo5.matchGiven("((}}<>{}",tester)); // expect true
        tester.add("}");
        System.out.println(algo5.matchGiven("((}}<>{}",tester)); // expect false now due to '}}'
        System.out.println(algo5.matchGiven("<()>{[}]",tester)); // expect true
    }
}
