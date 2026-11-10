public class MissingNumber {

    public static int findMissing(int[] numbers) {
        int n = numbers.length + 1;
        boolean[] box = new boolean[n + 1];

        for (int i = 0; i < numbers.length; i++) {
            box[numbers[i]] = true;
        }

        for (int i = 1; i < box.length; i++) {
            if (box[i] == false) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] test1 = {3, 7, 1, 2, 8, 4, 5};
        int[] test2 = {13, 3, 7, 11, 4, 6, 2, 10, 9, 5, 8, 1};

        System.out.println(findMissing(test1));
        System.out.println(findMissing(test2));
    }
}
