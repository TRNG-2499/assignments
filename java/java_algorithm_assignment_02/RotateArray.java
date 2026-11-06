import java.util.Arrays;

public class RotateArray {

    public static int[] rotateRight(int[] numbers, int k) {
        if (numbers.length == 0 || k == 0) {
            return numbers;
        }

        // A full rotation puts every element back where it started.
        int steps = k % numbers.length;
        int[] rotated = new int[numbers.length];

        // Wrap around to the front when an element moves past the end.
        for (int i = 0; i < numbers.length; i++) {
            int newIndex = (int) ((i + (long) steps) % numbers.length);
            rotated[newIndex] = numbers[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotateRight(new int[]{1, 2, 3, 4, 5}, 2)));
        System.out.println(Arrays.toString(rotateRight(new int[]{1, 2, 3}, 4)));
        System.out.println(Arrays.toString(rotateRight(new int[]{1, 2, 3, 4}, 0)));
    }
}