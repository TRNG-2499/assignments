import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] ints = {3,1,2,5,4,7};
        rotateArray(ints, 3);
    }
    //try to incorporate while k is greater than zero push the last number in the array to the front in a loop
    public static void rotateArray(int [] arr, int k){
        for (int j = 0; j < k; j++) {
            int end = arr[arr.length - 1];

            for (int i = arr.length - 1; i > 0 ; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = end;
        }
        System.out.println(Arrays.toString(arr));
        //Array.toString changed my output from the address to a readable array.

    }
}
