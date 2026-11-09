package assignments.java.java_algorithm_assignment_01;

public class MissingNumberFinder {
    public static void main(String[] args) {
        int [] numArray1 = {3, 7, 1, 2, 8, 4, 5};
        int [] numArray2 = {13, 3, 7, 11, 4, 6, 2, 10, 9, 5, 8, 1};
        missingNumberFinder(numArray1);
        missingNumberFinder(numArray2);
    }

    public static void missingNumberFinder(int[] numArr){
        int missing = 0;
        boolean found = false;

        for (int x = 1; x <= numArr.length; x++){
            for (int num : numArr) {
                if (num == x) {
                    found = true;
                    break;
                }
                found = false;
            }

            if (!found){
                missing = x;
                break;
            }
        }

        System.out.println(missing);
    }
}
