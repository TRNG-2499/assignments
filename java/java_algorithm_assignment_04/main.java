import java.util.Arrays;

class Main {
    public static int findClosestElementInArray(int[] arr, int target) {
        if(arr == null) return -1;

        int closest_element = Integer.MAX_VALUE, distance = Integer.MAX_VALUE;
        for(int curr : arr) {
            if(curr == target) return curr;
            int currDistance = Math.abs(target - curr);

            if(currDistance < distance) {
                closest_element = curr;
                distance = currDistance;
            }
            if(currDistance == distance) {
                closest_element = (closest_element < curr) ? closest_element : curr;
            }
        }

        return (closest_element == Integer.MAX_VALUE) ? -1 : closest_element;
    }

    public static void run_cases(int[] arr, int target) {
        System.out.println(
                "Array: " + Arrays.toString(arr) + "\n" +
                "Target: " + target + "\n" +
                "Closest element: " + findClosestElementInArray(arr, target) + "\n");
    }

    public static void main(String[] args) {
        int[] arr = {4, 9, 1, 15, 8};
        int[] arr2 = {5, 15};
        int[] null_arr = {};
        run_cases(arr, 10);
        run_cases(arr,1);
        run_cases(arr2, 10);
        run_cases(null_arr, 10);

    }
}