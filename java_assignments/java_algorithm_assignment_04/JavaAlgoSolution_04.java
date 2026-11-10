package java_assignments.java_algorithm_assignment_04;

public class JavaAlgoSolution_04 {
    public static void main(String[] args) {
        int[] testCase = {4, 9, 1, 15, 8};
        System.out.println(closestInArr(testCase, 10));
    }

    public static int closestInArr(int[] arr, int n){

        int closest = -1;

        if(arr.length < 0){
            return closest;
        }

        for(int i = 0; i < arr.length; i++){
            if(Math.abs((n-arr[i])) < Math.abs((n-closest))){
                closest = arr[i];
            }
        }

        return closest;
    }
}

