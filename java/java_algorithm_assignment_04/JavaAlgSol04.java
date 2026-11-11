package assignments.java.java_algorithm_assignment_04;

public class JavaAlgSol04 {

    public static void main(String[] args) {
        System.out.println(findClosest(new int[] { 4, 9, 1, 15, 8 }, 10));
        System.out.println(findClosest(new int[] { 4, 9, 1, 15, 8 }, 2));
        System.out.println(findClosest(new int[] { 15, 5 }, 10));
        System.out.println(findClosest(new int[] { 4, 10, 8 }, 10));
        System.out.println(findClosest(new int[] {}, 10));
    }

    public static int findClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int closestIndex = 0;

        // O(n) time and O(1) space
        for (int i = 1; i < nums.length; i++) {
            if (isCloser(nums[closestIndex], nums[i], target)) {
                closestIndex = i;
            }
        }
        return nums[closestIndex];
    }

    public static boolean isCloser(int current, int test, int target) {
        int currentDistance = Math.abs(current - target);
        int testDistance = Math.abs(test - target);

        return testDistance < currentDistance ||
                (testDistance == currentDistance && test < current);
    }
}
