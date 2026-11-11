package Closet_Value_In_Array;

public class ClosestValueInArray {
    public static void main(String[] args) {
        int [] numbers = {4, 9, 1, 15, 8};
        int target = 10;
        int result = bestSoFar(numbers, target);
        System.out.println("Closest value is : " + result);

    }
    public static int bestSoFar(int [] array, int target){

        if(array == null || array.length == 0){
            return -1;
        }

        //Assume the first element is the closest
        int closest = array[0];

        //let's calculate the initial difference
        int smallestDifference = Math.abs(array[0] - target);

        //Check the remaining elements

        for(int i = 1; i<array.length; i++){
            int currentDifference = Math.abs(array[i] - target);

            //let's update if the current element is closer or equally close but smaller

            if(currentDifference < smallestDifference || (currentDifference == smallestDifference && array[i] < closest)){
                closest = array[i];
                smallestDifference = currentDifference;
            }

        }

        return closest;
    }

}
