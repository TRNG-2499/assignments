package java_algorithm_assignment_01;

import java.util.*;

public class missing_number {
    public static void main(String[] args) {
        System.out.println("Running program Missing Number");

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
        int[] arr = { 1, 2, 2, 3, 4, 6 };
        // This is the end of automatic array generation

        arr = MergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array: " + Arrays.toString(arr));

        System.out.println("1 for Default Mode ");
        System.out.println("2 for Custom Mode ");
        System.out.println("3 for 2 Numbers Mode ");
        System.out.println("4 for Missing and Duplicate Mode ");
        System.out.print("Enter program mode: ");

        int mode = scanner.nextInt();
        switch (mode) {
            case 1:
                DefaultMode(arr);
                break;
            case 2:
                System.out.print("Enter the starting number for Custom Mode: ");
                int n = scanner.nextInt();
                CustomMode(arr, n);
                break;
            case 3:
                TwoNumbersMode(arr);
                break;
            case 4:
                MissingAndDuplicateMode(arr);
                break;
            default:
                System.out.println("Invalid mode selected.");
                break;
        }

        scanner.close();

    }

    public static void DefaultMode(int[] arr) {
        for (int i = 1; i <= arr.length; i++) {
            if (i != arr[i - 1]) {
                System.out.println("Missing number: " + i);
                return;
            }
        }
        System.out.println("No missing number found.");
    }

    public static void CustomMode(int[] arr, int n) {

        for (int i = 0; i < arr.length; i++) {
            if (n != arr[i]) {
                System.out.println("Missing number: " + n);
                return;
            }
            n++;
        }

        System.out.println("No missing number found.");
    }

    public static void TwoNumbersMode(int[] arr) {

        int count = 0;
        int seq = 1;

        List<Integer> missingNumber = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (seq != arr[i]) {
                System.out.println("Missing number: " + seq);
                count++;
                missingNumber.add(seq);
                seq++;

            }
            seq++;
        }

        if (count == 0) {
            System.out.println("No missing number found.");
        } else if (count == 2) {
            System.out.println("Two missing numbers: " + missingNumber);
        } else {
            System.out.println("Invalid input, more than 2 missing numbers");
        }

    }

    public static void MissingAndDuplicateMode(int[] arr) {

        int seq = 2;
        int missingNumber = -1;
        int duplicateNumber = -1;

        // Loop to find the duplicate number first
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                duplicateNumber = arr[i];
                continue;
            }
        }

        // Loop to find the missing number after handling duplicates
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                continue;
            }
            if (seq != arr[i]) {
                missingNumber = seq;
                break;
            }
            seq++;
        }

        System.out.println("Missing number: " + missingNumber);
        System.out.println("Duplicate number: " + duplicateNumber);
    }

    public static int[] MergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            MergeSort(arr, left, mid);
            MergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
        return arr;
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;

        // Merge the temp arrays
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

    }
}
