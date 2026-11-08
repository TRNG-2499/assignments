package javaAlgAssignment.part02;
import java.util.Arrays;
public class Solution {

    public static int [] reverseRight(int [] num, int k){
        int n = num.length;
        k = k%n;
        int [] rev = new int[num.length];
        for(int i = 0; i < num.length;i++){
            rev[(i+k)%n] = num[i];
        }
        return rev;
    }
    
    public static int [] reverseLeft(int [] num, int k){
        int n = num.length;
        k = k%n;
        int [] rev = new int[num.length];
        for(int i = num.length-1; i >= 0;i--){
            rev[(i-k+n)%n] = num[i];
        }
        return rev;
    }

    public static int [] negativeStep(int [] num, int k){
        int n = num.length;
        k = k%n;
        int [] rev = new int[num.length];
        if (k < 0){
            k = Math.abs(k);
            for(int i = num.length-1; i >= 0;i--){
                rev[(i-k+n)%n] = num[i]; //left
            }
        }
        else{
            for(int i = 0; i < num.length;i++){
                rev[(i+k)%n] = num[i];//right
            }
        }
        return rev;
    }

    public static int [] minimalMemory(int [] num, int start, int end){
        while(start < end){
            int temp = num[start];
            num[start] = num[end];
            num[end] = temp;
            start++;
            end--;
        }
        return num;
    }

    public static void main(String[] args) {
        int [] num = {1,2,3,4,5,6,7};
        int n = num.length-1;
        int k = 2;
        k = k%n;

        System.out.println(Arrays.toString(reverseRight(num, 2)));
        System.out.println(Arrays.toString(reverseLeft(num, 2)));

        System.out.println(Arrays.toString(negativeStep(num, 2)));
        System.out.println(Arrays.toString(negativeStep(num, -7)));

        System.out.println(Arrays.toString(minimalMemory(num, 0,num.length-1)));
        System.out.println(Arrays.toString(minimalMemory(num, 0, k-1)));
        System.out.println(Arrays.toString(minimalMemory(num, k, num.length-1)));

    }
}
