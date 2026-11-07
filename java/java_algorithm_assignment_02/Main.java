import java.util.Arrays;

public class Main {

    public static int[] swap(int i0, int i1, int[] arr) {
        int t = arr[i1];
        arr[i1] = arr[i0];
        arr[i0] = t;

        return arr;
    }

    public static int[] reverse(int start, int end, int[] arr) {
        int l = start;
        int r = end;
        while (l < r) {
            arr = swap(l++, r--, arr);
        }

        return arr;
    }

    public static int[] rotateRight(int[] arr, int n) {
        if (arr.length <= 1 || n < 1) {
            return arr;
        }

        n = n % arr.length;
        arr = reverse(0, arr.length - 1, arr);
        arr = reverse(0, n - 1, arr);
        arr = reverse(n, arr.length - 1, arr);

        return arr;
    }

    public static int[] rotateLeft(int[] arr, int n) {
        int r = arr.length - (n % arr.length);
        return rotateRight(arr, r);
    }

    public static int[] rotate(int[] arr, int n) {
        if (n >= 0) {
            return rotateRight(arr, n);
        }

        return rotateLeft(arr, Math.abs(n));
    }

    public static void main(String[] args) {
        int[] arr = reverse(0, 4, new int[]{1,2,3,4,5});
        System.out.println(Arrays.toString(arr));
        arr = rotateRight(new int[]{1,2,3}, 1);
        System.out.println(Arrays.toString(arr));
        arr = rotateRight(new int[]{1,2,3,4,5}, 1);
        System.out.println(Arrays.toString(arr));
        arr = rotateRight(new int[]{1,2,3,4,5}, 5);
        System.out.println(Arrays.toString(arr));
    }
}
