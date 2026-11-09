



public class MissingNumberFinder {

    public static int findMissingNumber(int[] arr) {
        // I'm thinking, If we are missing a number, then that means in theory, we can just get the sum
        // of what it should be minus what it is now, then the difference is the missing number. 
        int arrLength = arr.length;
        int expectedSum = (arrLength + 1) * (arrLength + 2) / 2;
        int actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }


    public static void main(String[] args) {
        int[] arr1 = {3, 7, 1, 2, 8, 4, 5};
        int[] arr2 = {13, 3, 7, 11, 4, 6, 2, 10, 9, 5, 8, 1};
        System.out.println("Missing number in arr1: " + findMissingNumber(arr1));
        System.out.println("Missing number in arr2: " + findMissingNumber(arr2));
    }
}