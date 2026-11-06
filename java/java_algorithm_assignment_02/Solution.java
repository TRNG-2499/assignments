import java.io.*;
import java.util.*;

public class Solution {
    /*
    * PSUEDOCODE
    * input: a (integer array), k (# number of steps)
    * output: rotated array
    * 
    * initialize an with a a-length array of zeros
    * initialize i with remainder of a's length subtracted by k divided by a's length
    * if i is less than 0
    *   set i to a's length added by i
    * initialize indexNumber with 0
    * 
    * while indexNumber is less than a's length
    *   set an's indexNumber-th number to the a's ith element
    *   add 1 to i
    *   if i is greater than or equal to a's length
    *       set i to 0
    *   add 1 to indexNumber
    * 
    * return an
     */
    public static int[] rotateArray(int[] array, int k){
        int[] an = new int[array.length];
        int i = (array.length - k) % array.length;
        if(i < 0){
            i = array.length + i;
        }
        int indexNumber = 0;

        while(indexNumber < array.length){
            an[indexNumber] = array[i];
            i++;
            if(i >= array.length){
                i = 0;
            }
            indexNumber++;
        }
        return an;
    }

    public static void main(String[] args){
        System.out.println(printArray(rotateArray(new int[]{1, 2, 3, 4, 5}, 2)));
        System.out.println(printArray(rotateArray(new int[]{1, 2, 3}, 4)));
        System.out.println(printArray(rotateArray(new int[]{1, 2, 3, 4}, 0)));
    }

    private static String printArray(int[] a){
        StringBuilder b = new StringBuilder();
        b.append("{");
        for(int i = 0; i < a.length; i++){
            b.append(a[i]);
            if(i < a.length - 1){
                b.append(", ");
            }
        }
        b.append("}");
        return b.toString();
    }
}