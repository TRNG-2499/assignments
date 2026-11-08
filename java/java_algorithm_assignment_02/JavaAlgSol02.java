public class JavaAlgSol02 {

  public int[] rotateArrayRight(int[] nums, int k) {
    // first attempt i was using negitives for the array but this is not python
    if (k == 0) return nums;
    int[] result = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      int tempIndex = (i + k) % nums.length;
      result[tempIndex] = nums[i];
    }
    return result;
  }

  // stretch left
  public int[] rotateArrayLeft(int[] nums, int k) {
    // turns out math.floorMod works like it is python
    if (k == 0) return nums;
    int[] result = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      int tempIndex = Math.floorMod(i - k, nums.length);
      result[tempIndex] = nums[i];
    }
    return result;
  }

  // strech negative step
  public int[] rotateArray(int[] nums, int k) {
    if (k == 0) return nums;
    int[] result = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      int tempIndex = Math.floorMod(i + k, nums.length);
      result[tempIndex] = nums[i];
    }
    return result;
  }

  // stretch minimal memory
  // made a Recursion solution then realized it was taking up more memory then a second array would take up...
}
