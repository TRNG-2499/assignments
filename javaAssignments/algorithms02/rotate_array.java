package javaAssignments.algorithms02;

public class rotate_array {
    

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6}; // Example array
        // System.out.println(java.util.Arrays.toString(rotateArray(arr, 7)));
        // System.out.println(java.util.Arrays.toString(rotateArray(arr, 3)));
        System.out.println(java.util.Arrays.toString(rotateArrayLeft(arr, 7)));
        System.out.println(java.util.Arrays.toString(rotateArrayLeft(arr, 3)));
        // System.out.println(java.util.Arrays.toString(rotateArrayVariable(arr, -7)));
        // System.out.println(java.util.Arrays.toString(rotateArrayVariable(arr, 7)));
        System.out.println(java.util.Arrays.toString(rotateArrayInPlace(arr, 7)));
        System.out.println(java.util.Arrays.toString(rotateArrayInPlace(arr, 3)));
    }

    public static int[] rotateArray(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // Handle rotation greater than array length
        int[] rotated = new int[n];
        for (int i = 0; i < n; i++) { // Rotate each element by k positions
            rotated[(i + k) % n] = arr[i]; //stick it all in a new array
        }
        return rotated; //ship it back
    }

    public static int[] rotateArrayLeft(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // Handle rotation greater than array length
        int[] rotated = new int[n];
        for (int i = 0; i < n; i++) { // Rotate each element by k positions
            rotated[(i - k + n) % n] = arr[i]; //stick it all in a new array, this is the only change from the right rotation method (and the name ig)
        }
        return rotated; //ship it back
    }

    public static int[] rotateArrayVariable(int[] arr, int k) { //quick and easy
        if (k > 0) {
            return rotateArray(arr, k); //evens go right
        } else {
            return rotateArrayLeft(arr, -k); //odds go left
        }
    }

    public static int[] rotateArrayInPlace(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // Handle rotation greater than array length
        int temp = 0;
        for (int i = 0; i < k; i++) { //loop through this process until I have rotated the array by k positions
            temp = arr[0];
            for (int j = 0; j < n - 1; j++) {   //shift all values left 1 space
                arr[j] = arr[j + 1]; 
                //System.out.println(java.util.Arrays.toString(arr)); //TEST STATEMENT
            }
            arr[n - 1] = temp;  //place the first element at the end
        }
        return arr; //ship it back
    }
}
