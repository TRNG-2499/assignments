import java.util.Arrays;

public class RotateArray {

    public static int[] rotateArray(int[] numbers, int k) {
        k = k % numbers.length;
        int[] freshSheet = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            freshSheet[(i + k) % numbers.length] = numbers[i];
        }

        return freshSheet;
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 4, 5};
        int[] test2 = {1, 2, 3};
        int[] test3 = {1, 2, 3, 4};

        System.out.println(Arrays.toString(rotateArray(test1, 2)));
        System.out.println(Arrays.toString(rotateArray(test2, 4)));
        System.out.println(Arrays.toString(rotateArray(test3, 0)));
    }
}
