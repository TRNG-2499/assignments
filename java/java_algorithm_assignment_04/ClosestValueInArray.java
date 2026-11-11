

public class ClosestValueInArray {
    public static int findClosestValue(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int closestValue = arr[0];
        int minDifference = Math.abs(arr[0] - target);

        for (int i = 1; i < arr.length; i++) {
            int currentDifference = Math.abs(arr[i] - target);
            if (currentDifference < minDifference) {
                minDifference = currentDifference;
                closestValue = arr[i];
            }
        }

        return closestValue;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 9, 1, 15, 8};
        int target1 = 10;
        int[] arr2 = {4, 9, 1, 15, 8};
        int target2 = 2;
        int[] arr3 = {5, 15};
        int target3 = 10;
        int[] arr4 = {};
        int target4 = 10;

        System.out.println(findClosestValue(arr1, target1));
        System.out.println(findClosestValue(arr2, target2));
        System.out.println(findClosestValue(arr3, target3));
        System.out.println(findClosestValue(arr4, target4));
    }
}