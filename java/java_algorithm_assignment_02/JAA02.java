package java_algorithm_assignment_02;

import java.util.Arrays;

public class JAA02 {
    
    public static int[] rotateRight(int[] arr, int shifts){
        int[] shifted = new int[arr.length];
        int s = 0;
        for(int i = arr.length - shifts; i < arr.length; i++){
            shifted[s] = arr[i];
            s++;
        }
        for (int i = 0; i < arr.length-shifts; i++){
            shifted[s] = arr[i];
            s++;
        }

        return shifted;
    }   

    public static int calcShifts(int k, int len){
        return k % len;
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
        int k = 6;

        int[] out = rotateRight(arr, calcShifts(k, arr.length));

        System.out.println(Arrays.toString(out));

    }
}
