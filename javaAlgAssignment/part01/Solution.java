package javaAlgAssignment.part01;
import java.util.Arrays;
public class Solution {

    public static int [] numSort(int [] num){
        int len = num.length;
        for (int i = 0; i < len; i++){
            for (int j = i+1; j < len; j++){
                if (num[i] > num[j]){
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }
        return num;
    }

    public static int missingNumber(int [] num){
        int len = num.length;
        for (int i = 0; i < len; i++){ 
            if (num[i] != i+1){
                return i+1;
            }
        }
        return len+1;
    }

    public static void main(String[] args) {
        System.out.println((Arrays.toString(numSort(new int[] {13, 3, 7, 11, 4, 6, 2, 10, 9, 5, 8, 1}))));
        System.out.println(missingNumber(numSort(new int[] {3, 1, 7, 2, 8, 4, 5})));
        System.out.println(missingNumber(numSort(new int[] {1,2,3})));
        System.out.println(missingNumber(numSort(new int[] {13, 3, 7, 11, 4, 6, 2, 10, 9, 5, 8, 1})));

    }
}
