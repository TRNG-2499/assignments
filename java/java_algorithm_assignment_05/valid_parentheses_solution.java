import java.util.Scanner;
import java.util.Stack;
//Break up string with StringBuilder. It should return true on an empty string
//Do it so that the loop is for(int i=1; i<string.length; i++)
//For bracket reading, check if the location of a bracket is either i+1 or string.length
/*
    For example:
    input: (<{}>)
    The for loop would be set up like
    for(int i = 0; i < string.length; i++)
        if(string.charAt(i) == string.charAt(i + 1) || string.charAt(string.length() - i))
            do something (Like returning it as true and continuing)
 */

public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    System.out.println("Enter your string of brackets");
    String parentheses = scan.nextLine();

    Validation(parentheses);

    scan.close();
}

public static void Validation(String paren){
    Stack<Character> stack = new Stack<Character>();

    if(paren.isEmpty()){
        System.out.println("true");
        return;
    }

    for(int i = 0; i < paren.length(); i++){
        char current = paren.charAt(i);

        if(current == '(' || current == '[' || current == '{' || current == '<'){
            stack.push(current);
        }
        else if(current == ')' || current == ']' || current == '}' || current == '>'){
            if(stack.isEmpty()){
                System.out.println("false");
                return;
            }
            char previous = stack.pop();

            if(current == ')' && previous != '(' || current == ']' && previous != '[' || current == '}' && previous != '{' || current == '>' && previous != '<'){
                System.out.println("false");
                return;
            }
        }

    }
    if(stack.isEmpty())
        System.out.println("true");
    else
        System.out.println("false");
}