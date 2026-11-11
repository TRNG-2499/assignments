package java_algorithm_assignment_01;

public class MissingNumFinder {
    public static int findMissingNum(int[] num) {
        int lastnum = num.length + 1;

        for (int candidate = 1; candidate <= lastnum; candidate++) {
            int left = 0;
            int right = num.length - 1;
            boolean found = false;

            while (left <= right) {
                if (num[left] == candidate || num[right] == candidate) {
                    found = true;
                    break;
                }

                left++;
                right--;
            }

            if (!found) {
                return candidate;
            }
        }

        throw new IllegalArgumentException("Expected exactly one missing number.");
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 6};
        System.out.println(findMissingNum(num));
    }
}