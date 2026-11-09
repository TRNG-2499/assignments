import java.util.Scanner;
import java.util.Arrays;

class Main {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {1, 2, 3, 4};

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a value for k: ");
        int k = Integer.parseInt(scanner.nextLine());

        total_shift(arr, k);
        total_shift(arr2, k);
        total_shift(arr3, k);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));

    }

    //shifts the entire array right by 'k' spaces
    protected static void total_shift(int[] arr, int k) {
        for(int i = 0; i < k; i++) {
            shift_right(arr);
        }
    }

    //shifts the entire array right by 1 space
    private static void shift_right(int[] arr) {
        int curr, next;
        next = Integer.MAX_VALUE;
        curr = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(i == 0) { curr = arr[i]; }
            //curr = arr[i];
            if(i == arr.length - 1) {
                arr[0] = curr;
            } else {
                next = arr[i+1];
                arr[i+1] = curr;
            }
            curr = next;
        }
    }
}