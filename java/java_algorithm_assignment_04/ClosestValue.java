/*
*Write a method that accepts two parameters: an array of integers and a target integer value. 
The array is not assumed to be sorted, and all numbers in the array will always be positive integers.
The method should return the value from the array that is numerically closest to the target.
If there is a tie (two values are equally close to the target), return the smaller of the two tied values.
Since the array is not sorted, a straightforward linear scan comparing each element's 
distance from the target is the expected approach here. Sorting the array first is not required, 
but you are welcome to sort it as part of your solution if you'd like to explore whether it helps "optimize" your approach.
If the array is empty, return -1. Since the array will otherwise always contain positive integers, 
-1 can be safely used as a signal that no result was found.

*/


public class ClosestValue {
    public static int closestValue(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int closest = arr[0];
        int minDiff = Math.abs(arr[0] - target);
        for (int i = 1; i < arr.length; i++) {
            int diff  = Math.abs(arr[i] - target);
            if (diff < minDiff) {
                minDiff = diff;
                closest = arr[i];
            } else if (diff == minDiff) {
                closest = Math.min(closest, arr[i]);
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        int[] arr = {4, 9, 1, 15, 8};
        int target = 10;
        System.out.println(closestValue(arr, target));

        int[] arr2 = {5, 15};
        int target2 = 10;
        System.out.println(closestValue(arr2, target2));
    }
    
}
