import java.util.Vector;

class Main {
    private static String count_letters(String str) {
        String lc_str = str.toLowerCase();
        StringBuilder sb = new StringBuilder("");
        char[] arr = lc_str.toCharArray();
        int count = 1;
        char curr = arr[0];

        for(int i = 0; i <= str.length() - 1; i++) {
            if(i == str.length() - 1 && arr[i] != curr) {
                sb.append(Character.toString(arr[i]) + count);
            }
            curr = arr[i];
            if(i < str.length() - 1)
                if (arr[i + 1] == curr) {
                    count++;
                    System.out.println(sb.toString());
                } else {
                    sb.append(Character.toString(arr[i]) + count);
                    count = 1;
                }

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "aaAaBbbcccdDDeeeEffFuuiIioOossShhg";
        String answer_str = count_letters(str);
        System.out.println("New String: " + answer_str);
    }

}