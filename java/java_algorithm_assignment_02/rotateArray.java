
public class rotateArray {
    public static int[] rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // Handle cases where k is greater than the array length

        // Reverse the entire array
        reverse(arr, 0, n - 1);
        // Reverse the first k elements
        reverse(arr, 0, k - 1);
        // Reverse the remaining n-k elements
        reverse(arr, k, n - 1);

        return arr;
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

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;
        int[] rotatedArr = rotate(arr, k);
        System.out.print("Rotated Array: ");
        for (int num : rotatedArr) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] rotatedArr2 = rotate(new int[]{1, 2, 3}, 4); // Example with k greater than array length
        System.out.print("Rotated Array (k > array length): ");
        for (int num : rotatedArr2) {
            System.out.print(num + " ");
        }
        System.out.println();
        int[] rotatedArr3 = rotate(new int[]{1, 2, 3, 4}, 0); // Example with k = 0
        System.out.print("Rotated Array (k = 0): ");
        for (int num : rotatedArr3) {
            System.out.print(num + " ");
        }

    }
}
