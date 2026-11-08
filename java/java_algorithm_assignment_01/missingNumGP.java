public class missingNumGP {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,6};
        System.out.println(findNum(arr));
    }
    public static int findNum(int[] numbers) {
        int n = numbers.length + 1;

        int[] freq = new int[n+1];

        for(int i = 0; i < n-1; i++) {
            freq[numbers[i]]++;
        }
        for(int i = 1; i <= n; i++) {
            if (freq[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
