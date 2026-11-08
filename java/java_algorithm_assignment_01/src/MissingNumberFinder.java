import java.util.Set;
import java.util.TreeSet;

public class MissingNumberFinder {
    public static void main(String[] args) {
        System.out.println(findMissingNum(new int[]{3, 7, 1, 2, 8, 4, 5}));
        System.out.println(findMissingNum(new int[]{13, 3, 7, 11, 4, 6, 2, 10, 9, 5, 8, 1}));
        System.out.println();
        System.out.println(findMissingNumFromStart(new int[]{5, 6, 9, 8}, 5));
        System.out.println(findMissingNumFromStart(new int[]{3, 7, 1, 2, 8, 4, 5}, 1));
    }

    private static int findMissingNum(int[] nums) {
        Set<Integer> found = new TreeSet<>();
        for (int i = 1; i <= nums.length; i++)
            found.add(i);
        for (int num : nums)
            found.remove(num);
        return (int) found.toArray()[0];
    }

    private static int findMissingNumFromStart(int[] nums, int start) {
        Set<Integer> found = new TreeSet<>();
        for (int i = start; i <= start + nums.length; i++)
            found.add(i);
        for (int num : nums)
            found.remove(num);
        return (int) found.toArray()[0];
    }
}
