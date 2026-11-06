package java_assignments.java_algorithm_assignment_01;

public class JavaAlgoSolution_01 {
    public static void main(String[] args) {
        int[] testCase = {5, 6, 8, 9};
        System.out.println(missingNumStretch(testCase, 5));
    }

    public static int missingNum(int[] arr){
        int missingInt = 0;
        for(int i = 1; i < arr.length+1; i++){
            boolean found = false;
            for(int j = 0; j < arr.length; j++){
                if(i == arr[j]){
                    found = true;
                    break;
                } 
            }

            if(!found){
                    return missingInt = i;
                }
        }
        
        return missingInt;
    }

    public static int missingNumStretch(int[] arr, int start){
        int missingInt = 0;
        for(int i = start; i < arr.length+start+1; i++){
            boolean found = false;
            for(int j = 0; j < arr.length; j++){
                if(i == arr[j]){
                    found = true;
                    break;
                } 
            }

            if(!found){
                    return missingInt = i;
                }
        }
        
        return missingInt;
    }
}
