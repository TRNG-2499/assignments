import java.util.Arrays;

public class RotateArray {

    // ---------- Base activity ----------
    // Returns a new array rotated right by k. Rotating by the array's length gives
    // back the same array, so only k % length matters. The original is not changed.
    public static int[] rotateRight(int[] array, int k) {
        if (array == null || array.length == 0) {
            return array; // nothing to rotate (also avoids dividing by zero below)
        }

        int n = array.length;
        int steps = k % n;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[(i + steps) % n] = array[i];
        }
        return result;
    }

    // ---------- Stretch 1: Rotate Left ----------
    public static int[] rotateLeft(int[] array, int k) {
        if (array == null || array.length == 0) {
            return array;
        }

        int n = array.length;
        int steps = k % n;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = array[(i + steps) % n];
        }
        return result;
    }

    // ---------- Stretch 2: Negative Step Counts ----------
    // Positive k rotates right and negative k rotates left.
    // Math.floorMod always gives a result in 0..n-1, even for negative k,
    // so -2 on 5 elements becomes 3 steps right (the same as 2 left), and -7
    // becomes 3.
    public static int[] rotate(int[] array, int k) {
        if (array == null || array.length == 0) {
            return array;
        }

        int n = array.length;
        int steps = Math.floorMod(k, n);
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[(i + steps) % n] = array[i];
        }
        return result;
    }

    // ---------- Stretch 3: Minimal Extra Memory ----------
    // Rotates right by k inside the original array using three reversals:
    // [1,2,3,4,5], k=2
    // reverse all -> [5,4,3,2,1]
    // reverse first k -> [4,5,3,2,1]
    // reverse the rest -> [4,5,1,2,3]
    // O(n) time, O(1) extra space. Negative k is also supported (rotates left).
    public static void rotateInPlace(int[] array, int k) {
        if (array == null || array.length == 0) {
            return;
        }

        int n = array.length;
        int steps = Math.floorMod(k, n);
        if (steps == 0) {
            return;
        }

        reverse(array, 0, n - 1);
        reverse(array, 0, steps - 1);
        reverse(array, steps, n - 1);
    }

    // Reverses the elements between indexes left and right (inclusive).
    private static void reverse(int[] array, int left, int right) {
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Base activity: rotate right ===");
        System.out.println(Arrays.toString(rotateRight(new int[] { 1, 2, 3, 4, 5 }, 2))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(rotateRight(new int[] { 1, 2, 3 }, 4))); // [3, 1, 2]
        System.out.println(Arrays.toString(rotateRight(new int[] { 1, 2, 3, 4 }, 0))); // [1, 2, 3, 4]
        System.out.println(Arrays.toString(rotateRight(new int[] {}, 3))); // []

        System.out.println("\n=== Stretch 1: Rotate Left ===");
        System.out.println(Arrays.toString(rotateLeft(new int[] { 1, 2, 3, 4, 5 }, 2))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(rotateLeft(new int[] { 1, 2, 3 }, 4))); // [2, 3, 1]

        System.out.println("\n=== Stretch 2: Negative Step Counts ===");
        System.out.println(Arrays.toString(rotate(new int[] { 1, 2, 3, 4, 5 }, 2))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(rotate(new int[] { 1, 2, 3, 4, 5 }, -2))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(rotate(new int[] { 1, 2, 3, 4, 5 }, -7))); // [3, 4, 5, 1, 2]

        System.out.println("\n=== Stretch 3: Minimal Extra Memory (in place) ===");
        int[] data = { 1, 2, 3, 4, 5 };
        rotateInPlace(data, 2);
        System.out.println(Arrays.toString(data)); // [4, 5, 1, 2, 3]
        int[] data2 = { 1, 2, 3, 4, 5, 6, 7 };
        rotateInPlace(data2, 10);
        System.out.println(Arrays.toString(data2)); // [5, 6, 7, 1, 2, 3, 4]
        int[] data3 = { 1, 2, 3, 4, 5 };
        rotateInPlace(data3, -7);
        System.out.println(Arrays.toString(data3)); // [3, 4, 5, 1, 2]
    }
}
