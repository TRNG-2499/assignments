import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotate(new int[]{1, 2, 3, 4, 5}, 2)));
        System.out.println(Arrays.toString(rotate(new int[]{1, 2, 3}, 4)));
        System.out.println(Arrays.toString(rotate(new int[]{1, 2, 3, 4}, 0)));
    }

    /**
     * Rotates an array k number of steps.
     * @param nums The array to rotate.
     * @param k The steps.
     * @return The rotated array.
     */
    public static int[] rotate(int[] nums, int k) {
        int n = nums.length;
        int steps = k % n;
        if (steps == 0) return nums;

        // [1, 2, 3, 4, 5] -> [5, 4, 3, 2, 1] -> [4, 5, 3, 2, 1] -> [4, 5, 1, 2, 3]
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        return nums;
    }

    /**
     * Helper method to help swap two elements in an array.
     */
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Helper method to reverse array.
     */
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}