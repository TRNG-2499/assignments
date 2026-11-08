package assignments.java.java_algorithm_assignment_02;

public class RotateArray {
    public static int[] rotateRight(int[] arr, int k) {
        if (isNullOrEmpty(arr)) {
            return arr;
        }
        k = k % arr.length;

        int[] result  = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[(i + k) % arr.length] = arr[i];
        }
        return result;
    }
    // Stretch goal #1 Rotate Left — Write a method that rotates the array to the left by k positions. 
    // For example, given [1, 2, 3, 4, 5] and k = 2, the result should be [3, 4, 5, 1, 2].
    public static int[] rotateLeft(int[] arr, int k) {
        if (isNullOrEmpty(arr)) {
            return arr;
        }
        k = k % arr.length;

        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[(i - k + arr.length) % arr.length] = arr[i];
        }
        return result;
    }
    /*Stretch goal #2 
     * Negative Step Counts — Write a method where a negative value of k rotates the array in the opposite direction (so k = -2 rotates left by 2, 
    and k = 2 rotates right by 2). Make sure large negative values, such as -7 on a 5-element array, are handled correctly. 
    */
    public static int[] rotate(int[] arr, int k) {
        if (isNullOrEmpty(arr)) {
            return arr;
        }
        k = k % arr.length;
        if (k >= 0) {
            return rotateRight(arr, k);
        } else {
            return rotateLeft(arr, -k);
        }
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    
    }

    public static void rotateRightInPlace(int[] arr, int k) {
        if (isNullOrEmpty(arr)) {
            return;
        }
        k = k % arr.length;
        if (k == 0) {
            return;
        }
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
    }

    //helper method to handle when arr is null or empty
    private static boolean isNullOrEmpty(int[] arr) {
        return arr == null || arr.length == 0;
    }

    //helper method to print an array
    private static void printArray(int[] arr) {
        if (isNullOrEmpty(arr)) {
            System.out.println("Array is null or empty");
            return;
        }
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;
        int[] rotated = rotateRight(arr, k);
        printArray(rotated);

        int[] arr2 = {1, 2, 3, 4};
        int k2 = 0;
        int[] rotated2 = rotateRight(arr2, k2);
        printArray(rotated2);

        int[] arr3 = {1, 2, 3};
        int k3 = 4;
        int[] rotated3 = rotateRight(arr3, k3);
        printArray(rotated3);

        int[] arr4 = {1, 2, 3, 4, 5};
        int k4 = 2;
        int[] rotatedLeft = rotateLeft(arr4, k4);
        printArray(rotatedLeft);

        int[] arr5 = {1, 2, 3, 4, 5};
        int k5 = -2;
        int[] rotated5 = rotate(arr5, k5);
        printArray(rotated5);

        int[] rotated6 = rotate(arr5, -7);
        printArray(rotated6);

        reverse(arr5, 0, arr5.length - 1);
        printArray(arr5);

        int[] arr6 = {1, 2, 3};
        rotateRightInPlace(arr6, 4);
        printArray(arr6);
    }
}
