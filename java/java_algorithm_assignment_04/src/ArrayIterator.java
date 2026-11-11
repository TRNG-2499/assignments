public class ArrayIterator {
    public static void main(String[] args) {
        System.out.println(findClosest(new int[]{4, 9, 1, 15, 8}, 10));
        System.out.println(findClosest(new int[]{4, 9, 1, 15, 8}, 2));
        System.out.println(findClosest(new int[]{5, 15}, 10));
        System.out.println(findClosest(new int[]{}, 13));
        System.out.println(findClosest(new int[]{4, 15, 19, 40, 13, 6}, 14));
    }

    private static int findClosest(int[] arr, int target) {
        if (arr.length == 0) return -1;

        int closest = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        for (int num : arr) {
            int currDiff = Math.abs(target - num);
            if (currDiff < diff) {
                closest = num;
                diff = currDiff;
            } else if (currDiff == diff && num < closest) {
                closest = num;
            }
        }
        return closest;
    }
}
