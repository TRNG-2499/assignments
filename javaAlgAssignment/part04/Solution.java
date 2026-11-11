package javaAlgAssignment.part04;

public class Solution {
    public static int closestValue(int [] num, int target){

        if (num.length == 0){
            return -1;
        }

        int closest = num[0];
        for(int i = 1; i < num.length; i++){
            int currDistance = Math.abs(closest - target);
            int nextDistance = Math.abs(num[i] - target);
            if(currDistance > nextDistance){
                closest = num[i];
            } else if (currDistance == nextDistance && num[i] < closest){
                closest = num[i];
            }
        }
        return closest;
    }
    public static void main(String[] args) {
        System.out.println(closestValue(new int [] {4,9,1,15,8}, 2));
        System.out.println(closestValue(new int [] {4,9,1,15,8}, 10));
        System.out.println(closestValue(new int [] {5,15}, 10));
        System.out.println(closestValue(new int [] {}, 10));
    }
}
