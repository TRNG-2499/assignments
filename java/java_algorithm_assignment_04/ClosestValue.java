public class ClosestValue {

    public static int findClosest(int[] array, int target) {
        if (array.length == 0) {
            return -1;
        }

        int best = array[0];

        for (int i = 1; i < array.length; i++) {

            int newDistance  = Math.abs(target - array[i]);
            int bestDistance = Math.abs(target - best);

            if (newDistance < bestDistance) {
                best = array[i];
            }

            else if (newDistance == bestDistance && array[i] < best) {
                best = array[i];
            }
        }

        return best;
    }

    public static void main(String[] args) {
        System.out.println(findClosest(new int[]{4, 9, 1, 15, 8}, 10));
        System.out.println(findClosest(new int[]{4, 9, 1, 15, 8}, 2));
        System.out.println(findClosest(new int[]{5, 15}, 10));
        System.out.println(findClosest(new int[]{15, 5}, 10));
        System.out.println(findClosest(new int[]{}, 10));
    }
}
