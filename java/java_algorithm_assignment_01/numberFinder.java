import java.util.HashSet;
import java.util.Set;

public class numberFinder {
    public static int findNumber(int[] arr) {
        int n = arr.length + 1;

        // only works since it's 1 to n and incrementing++ not stepping 2
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }

        return expectedSum - actualSum;
        
    }

    public static int customStarting(int[] arr, int start) {
        int end = arr.length + 1;

        long expectedSum = (long) (start + end) * (arr.length + 1) / 2;
        long actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }

        return (int) (expectedSum - actualSum);
        
    }

    public static int[] twoMissing(int[] arr) {

        int n = arr.length + 2;

        Set<Integer> expectedSet = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            expectedSet.add(i);
        }

        for (int num : arr) {
            expectedSet.remove(num);
        }

        int[] missing = new int[2];

        int index = 0;

        for (int i = 1; i <= n; i++) {
            if (expectedSet.contains(i)) {
                missing[index] = i;
                index++;
            }
        }

        return missing;
    }

    public static int[] missingAndDupes(int[] arr) {
        int n = arr.length;

        Set<Integer> expectedSet = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            expectedSet.add(i);
        }

        int[] result = new int[2];
        int index = 0;
        // dupes
        for (int num : arr) {
            if (!expectedSet.contains(num)) {
                result[index] = num; 
                index++;
            } else {
                expectedSet.remove(num);
            }
        }
        //missing
        for (int i = 1; i <= n; i++) {
            if (expectedSet.contains(i)) {
                result[index] = i; 
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6};
        System.out.println(findNumber(arr));
        System.out.println(customStarting(arr, 1));

        System.out.println("Two missing numbers:");
        int[] arr2 = {1, 2, 4, 6};
        System.out.println(twoMissing(arr2)[0] + ", " + twoMissing(arr2)[1]);

        System.out.println("Missing and duplicate numbers:");
        int[] arr3 = {1, 2, 2, 4, 5};
        System.out.println("Duplicate: " + missingAndDupes(arr3)[0] + ", Missing: " + missingAndDupes(arr3)[1]);
    }
}
