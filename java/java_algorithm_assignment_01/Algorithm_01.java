public class Algorithm_01 {
    public static int missingNumber(int[] nums) {
        int n = nums.length + 1;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
    public static void main(String[] args) {
        int[] nums = {3, 7, 1, 2, 8, 4, 5};
        int missing = missingNumber(nums);
        System.out.println("Missing number: " + missing);
    }
}
