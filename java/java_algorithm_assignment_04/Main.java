import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static int closest(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int mn = nums[0];
        int md = Math.abs(target - nums[0]);
        for (int i : nums) {
            int d = Math.abs(target - i);
            if (d <= md) {
                mn = d == md ? Math.min(i, mn) : i;
                md = d;
            }
        }

        return mn;
    }

    public static int closest(int[] nums, int target, boolean flag) {
        if (nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int mn = nums[0];
        int md = Math.abs(target - nums[0]);
        for (int i : nums) {
            int d = Math.abs(target - i);
            if (d <= md) {
                mn = d == md ? (!flag ? Math.min(i, mn) : Math.max(i, mn)) : i;
                md = d;
            }
        }

        return mn;
    }

    public static int closestIdx(Integer[] nums, int target) {
        int mi = 0;
        int md = Math.abs(target - nums[mi]);
        for (int j = 0; j < nums.length; j++) {
            int d = Math.abs(target - nums[j]);
            if (d <= md) {
                mi = d == md ? Math.min(nums[mi], nums[j]) : j;
                md = d;
            }
        }

        return mi;
    }

    public static int[] closestK(int[] nums, int target, int k) {
        int[] out = new int[nums.length < k ? nums.length : k];

        List<Integer> numAL = new ArrayList<>(Arrays.stream(nums).boxed().toList());

        for (int i = 0; i < numAL.size() && i < k; i++) {
            int idx = closestIdx(numAL.toArray(Integer[]::new), target);
            out[i] = numAL.remove(idx);
        }

        return out;
    }

    public static int farthest(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int mn = nums[0];
        int md = Math.abs(target - nums[0]);
        for (int i : nums) {
            int d = Math.abs(target - i);
            if (d >= md) {
                mn = d == md ? Math.min(i, mn) : i;
                md = d;
            }
        }

        return mn;
    }
    
    public static void main(String[] args) {
        int[] a0 = new int[]{4,9,1,15,8};
        int[] a1 = new int[]{5,15};
        int a0c = closest(a0, 10);
        int[] a0k = closestK(a0, 10, 3);
        int a1c = closest(a1, 10);
        System.out.println(a0c);
        System.out.println(a1c);
        System.out.println(closest(new int[]{}, 10));
        System.out.println(Arrays.toString(a0k));
    }
}
