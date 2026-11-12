package java.java_algorithm_assignment_03;

public class StringCompression {
    public static String compress(String input){
        if(input == null || input.isEmpty()){
            return "";
        }
        StringBuilder result = new StringBuilder();
        char runChar = input.charAt(0);
        int count = 1;
        for (int i = 1; i<input.length(); i++){
            char current = input.charAt(i);
            if(sameIgnoreCase(current, runChar)){
                count++;
            } else {
                result.append(runChar).append(count);
                runChar = current;
                count = 1;
            }
        }
        result.append(runChar).append(count);
        return result.toString();
    }

    private static boolean sameIgnoreCase(char a, char b){
        return Character.toLowerCase(a) == Character.toLowerCase(b);
    }
}
