public class MissingNumberFinder {

    public static int findMissingNumber(int[] numbers) {
        long n = numbers.length + 1L;

        // Find the sum of 1 through n, then subtract every number we have.
        long missingNumber = n * (n + 1) / 2;
        for (int number : numbers) {
            missingNumber -= number;
        }

        return (int) missingNumber;
    }

    public static void main(String[] args) {
        System.out.println(findMissingNumber(new int[]{3, 7, 1, 2, 8, 4, 5}));
        System.out.println(findMissingNumber(new int[]{13, 3, 7, 11, 4, 6, 2, 10, 9, 5, 8, 1}));
        System.out.println(findMissingNumber(new int[]{1, 2, 3}));
    }
}