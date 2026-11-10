package java_algorithm_assignment_03;

public class CompressConsec {
    public static String compressConsecChar(String words) {
        if (words.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int runLength = 1;
        int runStart = 0;

        for (int i = 1; i < words.length(); i++) {
            char current = words.charAt(i);
            char previous = words.charAt(i - 1);
            
            if (Character.toLowerCase(current) == Character.toLowerCase(previous)) {
                runLength++;
            } else {
                result.append(words.charAt(runStart)).append(runLength);
                runStart = i;
                runLength = 1;
            }
        }

        result.append(words.charAt(runStart)).append(runLength);
        return result.toString();

    }

    public static void main(String[] args) {
        System.out.println(compressConsecChar("!!!??....")); 
    }
}
