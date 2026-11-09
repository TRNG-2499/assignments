package java_algorithm_assignment_02;

import java.util.*;

public class rotate {
    public static void main(String[] args) {
        System.out.println("Running program Rotate...");
        Scanner scanner = new Scanner(System.in);

        // // Below is for manual adding array
        // System.out.print("Enter the size of the array: ");
        // int n = scanner.nextInt();
        // if (n <= 0) {
        // System.out.println("Array size must be greater than 0.");
        // return;
        // }
        // int[] arr = new int[n];
        // System.out.println("Enter the elements of the array: ");
        // for (int i = 0; i < n; i++) {
        // arr[i] = scanner.nextInt();
        // }
        // //This is the end of manual adding array

        // Below is for automatic array generation
        int[] arr = { 1, 2, 3, 4 };
        // This is the end of automatic array generation
        System.out.print("Enter the number of steps to rotate: ");
        int step = scanner.nextInt();

        System.out.println("1 for Default Mode ");
        System.out.println("2 for Rotate Left Mode ");
        System.out.println("3 for Negatie Mode ");
        System.out.println("4 for Minimum Memory Mode ");
        System.out.print("Enter program mode: ");

        int mode = scanner.nextInt();
        switch (mode) {
            case 1:
                DefaultMode(arr, step);
                break;
            case 2:
                RotateLeftMode(arr, step);
                break;
            case 3:
                NegativeMode(arr, step);
                break;
            case 4:
                MinimumMemoryMode(arr, step);
                break;
            default:
                System.out.println("Invalid mode selected.");
                break;
        }

        scanner.close();
    }

    public static void DefaultMode(int[] arr, int step) {

        int length = arr.length;
        step = step % length;

        int[] resultArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            int newIndex = (i + step) % length;
            resultArr[newIndex] = arr[i];

        }

        System.out.println("Rotated array: " + Arrays.toString(resultArr));

    }

    public static void RotateLeftMode(int[] arr, int step) {

        int length = arr.length;
        step = step % length;

        int[] resultArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            int newIndex = (i - step + length) % length;
            resultArr[newIndex] = arr[i];

        }

        System.out.println("Rotated array: " + Arrays.toString(resultArr));
    }

    public static void NegativeMode(int[] arr, int step) {

        int length = arr.length;

        int[] resultArr = new int[arr.length];
        int newIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (step > 0) {
                newIndex = (i + step) % length;
            } else {
                newIndex = (i + step + length) % length;
            }
            resultArr[newIndex] = arr[i];

        }

        System.out.println("Rotated array: " + Arrays.toString(resultArr));
    }

    public static void MinimumMemoryMode(int[] arr, int step) {

        int length = arr.length;
        step = step % length;

        step = length - step;

        for (int i = 0; i < step; i++) {

            int temp = arr[0];

            for (int j = 0; j < length - 1; j++) {
                arr[j] = arr[j + 1];
            }

            arr[length - 1] = temp;

        }

        System.out.println("Rotated array: " + Arrays.toString(arr));
    }
}
