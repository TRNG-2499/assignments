package java_algorithm_assignment_02;

public class RotateArraySolution {
    public static int[] rotateArray(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        int[] rotated = new int[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = arr[i];
        }
        return rotated;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;
        int[] rotated = rotateArray(arr, k);
        for (int num : rotated) {
            System.out.print(num + " ");
        }
        }
}
