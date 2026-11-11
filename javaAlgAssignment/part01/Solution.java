package javaAlgAssignment.part01;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;

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

    public static int customStart(int [] num, int start){
        int n = num.length;
        for(int i = 0; i < n; i++){
            if(num[i] != start+i){
                return start+i;
            }
        }
        return start+n;
    }
    public static String twoMissingNumbers(int [] num){
        int n = num.length+2;
        ArrayList<Integer> missingNumbers = new ArrayList<>();
        ArrayList<Integer> dupNum = new ArrayList<>();
        HashSet<Integer> present = new HashSet<>();
        for(int nums: num){
            if(!present.add(nums)){
                dupNum.add(nums);
            }
        }

        for (int i = 1; i < n; i++){
            if(!present.contains(i)){
                missingNumbers.add(i);
            }
        }
        return "Duplicates: " + dupNum + ", Missing: " + missingNumbers;
    }
    public static void main(String[] args) {
        int [] num = {5,6,8,9};
        int [] s = {1,2,2,4,6};
        System.out.println((Arrays.toString(numSort(new int[] {13, 3, 7, 11, 4, 6, 2, 10, 9, 5, 8, 1}))));
        System.out.println(missingNumber(numSort(new int[] {3, 1, 7, 2, 8, 4, 5})));
        System.out.println(missingNumber(numSort(new int[] {1,2,3})));
        System.out.println(missingNumber(numSort(new int[] {13, 3, 7, 11, 4, 6, 2, 10, 9, 5, 8, 1})));
        System.out.println(customStart(num, 5));
        System.out.println(twoMissingNumbers(s));
    }
}
