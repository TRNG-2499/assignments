package java.java_algorithm_assignment_01;

public class MissingNumber {
   public static int findMissing(int[] nums){
    long n = nums.length + 1L;
    long expectedSum = n * (n + 1) / 2;
    long actualSum = 0;
    for (int num : nums) {
        actualSum += num;
    }
    return (int) (expectedSum - actualSum);
   }
}
