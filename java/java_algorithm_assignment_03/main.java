import java.util.Vector;

class Main {
    private static String count_letters(String str) {
        StringBuilder sb = new StringBuilder("");
        char[] arr = str.toLowerCase().toCharArray();
        int count = 1, i;
        char curr = arr[0];

        for(i = 0; i <= str.length() - 1; i++) {
            curr = arr[i];
            if(i < str.length() - 1) {
                if (arr[i + 1] == curr) {
                    count++;
                } else {
                    sb.append(Character.toString(arr[i]) + count);
                    count = 1;
                }
            } else {
                sb.append(Character.toString(arr[i]) + count);
            }
        }

        return sb.toString();
    }

    public static String check_length(String str) {
        String tmp = count_letters(str);
        if(tmp.length() < str.length()) {
            return tmp;
        }
        return str;
    }

    public static void main(String[] args) {
        String str = "aaAaBbbcccdDDeeeEffFuuiIioOossShhqqqqqqqqqqqqqq";
        String answer_str = check_length(str);
        System.out.println("New String: " + answer_str);
    }
}