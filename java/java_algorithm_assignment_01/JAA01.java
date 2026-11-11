package java_algorithm_assignment_01;

import java.util.Arrays;

public class JAA01 {
    // Sum of 1 to n minus all nums in array

    // Just sort and check diff between indices
    
    public static int findMissing(int[] arr){
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            if (arr[i+1] - arr[i] > 1){
                return (int)arr[i]+1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr = {13, 3, 7, 11, 4, 6, 2, 10, 9, 5, 8, 1};
        int out = findMissing(arr);
        System.out.println(out);
    }
}
