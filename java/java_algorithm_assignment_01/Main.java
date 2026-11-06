import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3, 7, 1, 2, 8, 4, 5}));
        System.out.println(missingNumber(new int[]{13, 3, 7, 11, 4, 6, 2, 10, 9, 5, 8, 1}));
        System.out.println(customStart(new int[]{5, 6, 8, 9}, 5));
        System.out.println(Arrays.toString(twoMissingNumber(new int[]{1, 2, 4, 6})));
        System.out.println(Arrays.toString(missingDuplicate(new int[]{1, 2, 2, 4})));
    }

    /**
     * Find the missing number in a distinct consecutive array.
     * @param list The array of numbers.
     * @return The missing number.
     */
    public static int missingNumber(int[] list) {
        int n = list.length + 1;
        int expectedSum = n * (n + 1) / 2;
        int sum = 0;
        for (int num: list) {
            sum += num;
        }
        return expectedSum - sum;
    }

    /**
     * Find the missing number in a distinct consecutive array with a custom start.
     * @param list The array of numbers.
     * @param start The starting number.
     * @return The missing number.
     */
    public static int customStart(int[] list, int start) {
        int n = list.length + 1;
        int end = start + n - 1;
        int baseSum = end * (end + 1) / 2;
        int ignoredSum = (start - 1) * ((start - 1) + 1) / 2;
        int expectedSum = baseSum - ignoredSum;
        int sum = 0;
        for (int num: list) {
            sum += num;
        }
        return expectedSum - sum;
    }

    /**
     * Find two missing number in a distinct consecutive array.
     * @param list The array of numbers.
     * @return An array containing the two missing number.
     */
    public static int[] twoMissingNumber(int[] list) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int item: list) {
            seen.put(item, 1);
        }

        int[] result = new int[2];
        int i = 0;
        for (int item = 1; item <= list.length + 2; item++) {
            if (!seen.containsKey(item)) {
                result[i] = item;
                i++;
            }
        }
        return result;
    }

    /**
     * Find the missing number in a distinct consecutive array and a duplicate number.
     * @param list The array of numbers.
     * @return An array containing the missing number followed by the duplicate number.
     */
    public static int[] missingDuplicate(int[] list) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int item: list) {
            seen.put(item, seen.getOrDefault(item, 0) + 1);
        }

        int missingNumber = 0;
        int duplicateNumber = 0;
        for (int item = 1; item <= list.length; item++) {
            if (!seen.containsKey(item)) {
                missingNumber = item;
            }
            if (seen.containsKey(item) && seen.get(item) > 1) {
                duplicateNumber = item;
            }
        }
        return new int[]{missingNumber, duplicateNumber};
    }
}