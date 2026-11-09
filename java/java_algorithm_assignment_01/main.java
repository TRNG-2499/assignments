import java.util.Arrays;
import java.util.Vector;
import java.util.List;


class Main {

    public Vector<Integer> missing_val_finder(int[] arr) {
        Vector<Integer> targets = new Vector<>();
        int gap, expected_next;

        // array could iterate by 2, 3, 4, 5, ... each time rather than just by 1
        Arrays.sort(arr);
        gap = Integer.MAX_VALUE;

        for(int i = 1; i < arr.length; i++) {
            int current_gap = arr[i] - arr[i - 1];
            if(current_gap > 0 && current_gap < gap) {
                gap = current_gap;
            }
        }

        //edge case: if all integers are the same
        if(gap == Integer.MAX_VALUE || gap == 0) {
            return targets;
        }

        for(int i = 1; i < arr.length; i++) {
            expected_next = arr[i - 1] + gap;
            while (arr[i] > expected_next) {
                targets.add(expected_next); // missing number
                expected_next += gap;
            }
        }
        System.out.println("Array over");
        return targets;
    }


    public static void main(String[] args) {
        int[] arr = {13, 3, 7, 11, 4, 6, 2, 10, 9, 5, 8, 1};
        int[] arr2 = {3, 7, 1, 2, 8, 4, 5};

        Main main = new Main();
        System.out.println(main.missing_val_finder(arr));
        System.out.println(main.missing_val_finder(arr2));
    }
}