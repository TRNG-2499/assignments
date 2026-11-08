import java.util.Arrays;

public class ArrayRotator {
    public static void main(String[] args) {
        for (int k = 0; k < 18; k++) {
            System.out.println(Arrays.toString(rotateRight(new int[]{4, 2, 1, 6, 3, 5, 8, 7, 9}, k)));
        }
    }

    private static int[] rotateRight(int[] arr, int k) {
        if (k == 0)
            return arr;
        // else
        k %= arr.length;
        int start = 0;
        int inPlace = 0;
        int i;
        int rotating;
        int temp;

        while (inPlace < arr.length) {
            rotating = arr[start];
            i = start;
            do {
                i = (i + k) % arr.length;
                temp = arr[i];
                arr[i] = rotating;
                rotating = temp;
                inPlace++;
            } while (i != start);
            start++;
        }

        return arr;
    }
}
