import java.util.Arrays;

class Main {
    public static int foo(int[] arr, int target) {
        int closest_element = Integer.MAX_VALUE, distance = Integer.MAX_VALUE;
        int i = 0;
        for(int curr : arr) {
            if(curr < target) {
                if(target - curr <= distance) {
                    if(target - curr == distance) {
                        closest_element = (curr < closest_element) ? curr : closest_element;
                    } else {
                        closest_element = curr;
                        distance = target - curr;
                    }
                }
            } else if(curr > target) {
                if(curr - target <= distance) {
                    if(curr - target == distance) {
                        closest_element = (curr < closest_element) ? curr : closest_element;
                    } else {
                        closest_element = curr;
                        distance = curr - target;
                    }
                }
                // curr is closer to target than the previous array member
            } else {
                return arr[i];
            }
            i++;
        }

        return (closest_element == Integer.MAX_VALUE) ? -1 : closest_element;
    }

    public static void run_cases(int[] arr, int target) {
        System.out.println(
                "Array: " + Arrays.toString(arr) + "\n" +
                "Target: " + target + "\n" +
                "Closest element: " + foo(arr, target) + "\n");
    }

    public static void main(String[] args) {
        int[] arr = {4, 9, 1, 15, 8};
        run_cases(arr, 3);
        run_cases(arr, 6);
    }
}