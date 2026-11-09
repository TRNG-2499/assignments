import java.util.Arrays;

public class MissingNumberFinder {

    // ---------- Base activity ----------
    // The array holds 1..n with one number missing, where n = length + 1.
    // Sum of 1..n is n(n+1)/2, so the missing number is that sum minus the array's
    // sum.
    // This takes one pass through the array and uses no extra memory. Order doesn't
    // matter.
    public static int findMissingNumber(int[] numbers) {
        long n = numbers.length + 1L;
        long expectedSum = n * (n + 1) / 2; // long avoids overflow for big arrays

        long actualSum = 0;
        for (int value : numbers) {
            actualSum += value;
        }
        return (int) (expectedSum - actualSum);
    }

    // ---------- Stretch 1: Custom Starting Value ----------
    // The array holds start..end with one number missing, where end = start +
    // length.
    public static int findMissingNumber(int[] numbers, int start) {
        long end = (long) start + numbers.length;
        long count = numbers.length + 1L;
        long expectedSum = (start + end) * count / 2; // arithmetic series formula

        long actualSum = 0;
        for (int value : numbers) {
            actualSum += value;
        }
        return (int) (expectedSum - actualSum);
    }

    // ---------- Stretch 2: Two Missing Numbers ----------
    // The array holds 1..n with two numbers missing, where n = length + 2.
    // Mark each number we see, then collect the two that were never marked
    // (smallest first).
    public static int[] findTwoMissingNumbers(int[] numbers) {
        int n = numbers.length + 2;
        boolean[] seen = new boolean[n + 1]; // index 0 is unused

        for (int value : numbers) {
            seen[value] = true;
        }

        int[] missing = new int[2];
        int found = 0;
        for (int i = 1; i <= n && found < 2; i++) {
            if (!seen[i]) {
                missing[found++] = i;
            }
        }
        return missing;
    }

    // ---------- Stretch 3: Missing and Duplicate ----------
    // The array has length n and should hold 1..n, but one number appears twice
    // and another is missing. Returns { duplicate, missing }.
    public static int[] findMissingAndDuplicate(int[] numbers) {
        int n = numbers.length;
        boolean[] seen = new boolean[n + 1];
        int duplicate = -1;

        for (int value : numbers) {
            if (seen[value]) {
                duplicate = value;
            }
            seen[value] = true;
        }

        int missing = -1;
        for (int i = 1; i <= n; i++) {
            if (!seen[i]) {
                missing = i;
                break;
            }
        }
        return new int[] { duplicate, missing };
    }

    public static void main(String[] args) {
        System.out.println("=== Base activity ===");
        System.out.println(findMissingNumber(new int[] { 3, 7, 1, 2, 8, 4, 5 }));
        System.out.println(findMissingNumber(new int[] { 13, 3, 7, 11, 4, 6, 2, 10, 9, 5, 8, 1 }));
        System.out.println(findMissingNumber(new int[] { 2, 3 }));
        System.out.println(findMissingNumber(new int[] {}));

        System.out.println("\n=== Stretch 1: Custom Starting Value ===");
        System.out.println(findMissingNumber(new int[] { 5, 6, 8, 9 }, 5));
        System.out.println(findMissingNumber(new int[] { -2, 0, 1, -1, 3 }, -2));

        System.out.println("\n=== Stretch 2: Two Missing Numbers ===");
        System.out.println(Arrays.toString(findTwoMissingNumbers(new int[] { 1, 2, 4, 6 })));
        System.out.println(Arrays.toString(findTwoMissingNumbers(new int[] { 3, 1, 2 })));

        System.out.println("\n=== Stretch 3: Missing and Duplicate ===");
        int[] result = findMissingAndDuplicate(new int[] { 1, 2, 2, 4 });
        System.out.println("Duplicate: " + result[0] + ", Missing: " + result[1]);
        result = findMissingAndDuplicate(new int[] { 3, 1, 3, 5, 4 });
        System.out.println("Duplicate: " + result[0] + ", Missing: " + result[1]);
    }
}
