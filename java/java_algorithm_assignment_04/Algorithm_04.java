public class Algorithm_04 {
    public static int closestTo(int[] arr, int target) {
        int closest = arr[0];
        int difference = Math.abs(arr[0] - target);
        for (int i = 0; i < arr.length; i++) {
            int current = Math.abs(arr[i] - target);
            if (current < difference) {
                closest = arr[i];
                difference = current;
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        int[] arr = {4, 9, 1, 15, 8};
        int target = 10;
        int closestValue = closestTo(arr, target);
        System.out.println("Closest value to " + target + " is: " + closestValue);
    }
}
