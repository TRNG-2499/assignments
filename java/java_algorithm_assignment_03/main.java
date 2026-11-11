import java.util.Vector;

class main {

    private static void foo(String str) {
        str = str;
    }

    public static void main(String[] args) {
        String str = "aaAaBbbcccdDDeeeEffF";
        String lc_str = str.toLowerCase();
        StringBuilder sb = new StringBuilder("");
        char[] arr;
        int size, count = 1;
        char curr;

        //take the size, str.split with the current letter,
        //compare the change in size, and append to the new string
        // "(current_letter)(difference in size)", and continue the loop;

        arr = lc_str.toCharArray();
        curr = arr[0];
        for(int i = 0; i < str.length() - 1; i++) {
            curr = arr[i];
            if(arr[i+1] == curr) {
                count++;
                System.out.println(sb.toString());
            } else {
                sb.append(Character.toString(arr[i]) + count);
                count = 1;
            }
        }
        System.out.println("New String: " + sb.toString());
    }
}