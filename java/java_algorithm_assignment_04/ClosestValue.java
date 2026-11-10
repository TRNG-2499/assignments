package assignments.java.java_algorithm_assignment_04;

public class ClosestValue {

    public static void main(String[] args) {
        int[] numArray1 = {4, 9, 1, 15, 8};
        int[] numArray2 = {5, 15};
        int[] numArray3 = {};
        findClosestValue(numArray1, 10);
        findClosestValue(numArray1, 2);
        findClosestValue(numArray2, 10);
        findClosestValue(numArray3, 10);
    }

    public static void findClosestValue(int[] values, int target) {
        if (values.length > 0){
            int distance = Math.abs(target - values[0]);
            int best = values[0];

            for (int v : values) {
                if (Math.abs(target - v) < distance) {
                    best = v;
                    distance = Math.abs(target - v);
                }else if (Math.abs(target - v) == distance) {
                    if (target > v) {
                        best = v;
                    }
                }
            }

            System.out.println(best);
        }else {
            System.out.println(-1);
        }
    }
}
