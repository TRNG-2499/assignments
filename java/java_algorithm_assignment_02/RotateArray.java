import java.util.Arrays;

public class RotateArray {
    public static void main(String... args) {
        rightRotate(2,1,2,3,4,5);
        leftRotate(2,1,2,3,4,5);
    }

    public static void rightRotate(int k, int... arr) {
        k = Math.floorMod(k, arr.length); //handles rotations longer than array length
        System.out.println(Arrays.toString(arr));
        //breaking down the rotation into swaps gets you a minimal auxillary space
        //very slow though

        for (int i = 0; i < k; i++){
            for (int j = 1; j < arr.length; j++) {
                swap(0,j,arr);
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void leftRotate(int k, int... arr) {
        k = Math.floorMod(k, arr.length);
        System.out.println(Arrays.toString(arr));
        
        for (int i = 0; i < k; i++){
            for (int j = arr.length - 1; j >= 0; j--) {
                swap(0,j,arr);
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void signedRotate(int k, int... arr) {
        if (k < 0) leftRotate(-k, arr);
        else rightRotate(k, arr);

    }

    public static void swap(int a, int b, int... arr) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}