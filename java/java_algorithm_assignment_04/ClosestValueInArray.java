import java.util.Arrays;

public class ClosestValueInArray {

    // ---------- Base activity ----------
    // Linear scan that keeps the best value seen so far. A value replaces the
    // best when it is strictly closer, or equally close but smaller.
    // The array does not need to be sorted. An empty array returns -1.
    public static int findClosest(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int closest = array[0];
        long bestDistance = distance(closest, target);

        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            long d = distance(value, target);
            if (d < bestDistance || (d == bestDistance && value < closest)) {
                closest = value;
                bestDistance = d;
            }
        }
        return closest;
    }

    // Absolute difference as a long, so very large/small ints cannot overflow.
    private static long distance(int value, int target) {
        return Math.abs((long) value - target);
    }

    // ---------- Stretch 1: Closest 'K' Values ----------
    // Returns the k values closest to the target, ordered from closest to
    // farthest. Ties are broken the same way as findClosest (smaller first).
    // If k is larger than the array, every value is returned; k <= 0 or an
    // empty array returns an empty array. The input array is not changed.
    public static int[] findClosestK(int[] array, int target, int k) {
        if (array == null || array.length == 0 || k <= 0) {
            return new int[0];
        }

        int[] sorted = array.clone();
        // Simple insertion sort by (distance, then value), so the closest
        // values end up at the front.
        for (int i = 1; i < sorted.length; i++) {
            int current = sorted[i];
            int j = i - 1;
            while (j >= 0 && isBetterMatch(current, sorted[j], target)) {
                sorted[j + 1] = sorted[j];
                j--;
            }
            sorted[j + 1] = current;
        }

        return Arrays.copyOf(sorted, Math.min(k, sorted.length));
    }

    // True when a should come before b: a is closer, or equally close and smaller.
    private static boolean isBetterMatch(int a, int b, int target) {
        long da = distance(a, target);
        long db = distance(b, target);
        return da < db || (da == db && a < b);
    }

    // ---------- Stretch 2: Find Farthest Match ----------
    // Same scan as findClosest, but keeps the value with the largest distance.
    // Ties return the smaller value. An empty array returns -1.
    public static int findFarthest(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int farthest = array[0];
        long bestDistance = distance(farthest, target);

        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            long d = distance(value, target);
            if (d > bestDistance || (d == bestDistance && value < farthest)) {
                farthest = value;
                bestDistance = d;
            }
        }
        return farthest;
    }

    // ---------- Stretch 3: Higher/Lower Flag ----------
    // Same as findClosest, but preferHigher decides ties:
    // false -> the smaller value (original behavior), true -> the larger value.
    public static int findClosest(int[] array, int target, boolean preferHigher) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int closest = array[0];
        long bestDistance = distance(closest, target);

        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            long d = distance(value, target);
            boolean winsTie = preferHigher ? value > closest : value < closest;
            if (d < bestDistance || (d == bestDistance && winsTie)) {
                closest = value;
                bestDistance = d;
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        int[] numbers = { 4, 9, 1, 15, 8 };

        System.out.println("=== Base activity: closest value ===");
        System.out.println(findClosest(numbers, 10));              // 9
        System.out.println(findClosest(numbers, 2));               // 1
        System.out.println(findClosest(new int[] { 5, 15 }, 10));  // 5 (tie -> smaller)
        System.out.println(findClosest(new int[] { 15, 5 }, 10));  // 5 (order does not matter)
        System.out.println(findClosest(new int[] {}, 10));         // -1

        System.out.println("\n=== Stretch 1: Closest 'K' Values ===");
        System.out.println(Arrays.toString(findClosestK(numbers, 10, 3)));            // [9, 8, 15]
        System.out.println(Arrays.toString(findClosestK(new int[] { 5, 15, 10 }, 10, 2))); // [10, 5]
        System.out.println(Arrays.toString(findClosestK(numbers, 2, 10)));            // [1, 4, 8, 9, 15]
        System.out.println(Arrays.toString(findClosestK(new int[] {}, 10, 2)));       // []

        System.out.println("\n=== Stretch 2: Find Farthest Match ===");
        System.out.println(findFarthest(numbers, 10));             // 1
        System.out.println(findFarthest(numbers, 2));              // 15
        System.out.println(findFarthest(new int[] { 5, 15 }, 10)); // 5 (tie -> smaller)
        System.out.println(findFarthest(new int[] {}, 10));        // -1

        System.out.println("\n=== Stretch 3: Higher/Lower Flag ===");
        System.out.println(findClosest(new int[] { 5, 15 }, 10, false)); // 5
        System.out.println(findClosest(new int[] { 5, 15 }, 10, true));  // 15
        System.out.println(findClosest(numbers, 10, true));              // 9 (no tie)
        System.out.println(findClosest(new int[] {}, 10, true));         // -1
    }
}
