package java_algorithm_assignment_04;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 5, 19, 35, 75, 99};
        int target = 50;
        System.out.println(closestValue(arr, target));
        System.out.println(farthestValue(arr, target));

        int[] tieArr = {65, 35};
        System.out.println(closestValueWithTieBreak(tieArr, target, false));
        System.out.println(closestValueWithTieBreak(tieArr, target, true));
    }

    private static int closestValue(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int closest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - target) < Math.abs(closest - target)) {
                closest = arr[i];
            }
        }
        return closest;
    }

    private static int farthestValue(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int farthest = arr[0];
        long farthestDistance = Math.abs((long) farthest - target);
        for (int i = 1; i < arr.length; i++) {
            long distance = Math.abs((long) arr[i] - target);
            if (distance > farthestDistance || (distance == farthestDistance && arr[i] < farthest)) {
                farthest = arr[i];
                farthestDistance = distance;
            }
        }
        return farthest;
    }

    private static int closestValueWithTieBreak(int[] arr, int target, boolean preferHigher) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int closest = arr[0];
        long closestDistance = Math.abs((long) closest - target);
        for (int i = 1; i < arr.length; i++) {
            long distance = Math.abs((long) arr[i] - target);
            if (distance < closestDistance
                    || (distance == closestDistance
                    && (preferHigher ? arr[i] > closest : arr[i] < closest))) {
                closest = arr[i];
                closestDistance = distance;
            }
        }
        return closest;
    }
}
