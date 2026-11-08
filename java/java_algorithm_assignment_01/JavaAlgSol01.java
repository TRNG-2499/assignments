import java.util.Arrays;

public class JavaAlgSol01 {

  public int findMissingNum(int[] nums) {
    // My first attempt sorted the array (O(nlogn) - no good). This version adds up
    // the expected and actual values in O(n) time and O(1) space.

    int end = nums.length + 1;
    int expected = 0;
    int actual = 0;

    for (int i = 1; i <= end; i++) expected += i;

    for (int num : nums) actual += num;

    return expected - actual;
  }

  // stretch - custom starting value
  public int findMissingNum(int[] nums, int start) {
    int end = start + nums.length;
    int expected = 0;
    int actual = 0;

    for (int i = start; i <= end; i++) expected += i;

    for (int num : nums) actual += num;

    return expected - actual;
  }

  // stretch - two missing numbers
  public int[] findTwoMissingNum(int[] nums) {
    boolean[] seen = new boolean[nums.length + 3];
    Arrays.fill(seen, false);

    int[] result = new int[2];
    int resultIndex = 0;

    for (int num : nums) {
      seen[num] = true;
    }

    for (int i = 1; i < nums.length + 3; i++) {
      if (!seen[i]) {
        result[resultIndex] = i;
        resultIndex++;
      }
    }
    return result;
  }

  // stretch - missing and duplicate
  public int[] findDupAndMissNum(int[] nums) {
    boolean[] seen = new boolean[nums.length + 1];
    int[] result = new int[2];

    for (int num : nums) {
      if (seen[num]) result[0] = num;

      seen[num] = true;
    }

    for (int i = 1; i < seen.length; i++) {
      if (!seen[i]) {
        result[1] = i;
        break;
      }
    }
    return result;
  }
}
