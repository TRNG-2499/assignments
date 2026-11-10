import java.io.*;
import java.util.*;

public class Solution {

    public static int closestValue(int[] array, int target){
        /*
        * PSEUDOCODE:
        * input: array (array of integers), target
        * initialize closestValue to -1
        * initialize minimumDifference = 100000000;
        * 
        * for every element e in array
        *   initialize difference with the absolute value of e and target's difference
        *   if difference is less than the minimumDifference
        *       set closestValue to e
        *       set minimumDifference to difference
        * 
        * return closestValue
        */
        int closestValue = -1;
        int minimumDifference = 100000000;

        for(int e : array){
            int difference = (target > e) ? target - e : e - target;
            if(difference < minimumDifference){
                closestValue = e;
                minimumDifference = difference;
            }
        }

        return closestValue;
    }

    public static void main(String[] args){
        System.out.println(closestValue(new int[]{4, 9, 1, 15, 8}, 10));
        System.out.println(closestValue(new int[]{4, 9, 1, 15, 8}, 2));
        System.out.println(closestValue(new int[]{5, 15}, 10));
        System.out.println(closestValue(new int[]{}, 10));
    }
}