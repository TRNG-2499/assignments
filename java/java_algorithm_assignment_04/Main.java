public class Main {

    public static int closestValue(int[] array, int target){

        if(array.length==0){
            return -1;
        }

        int closestValue = Integer.MAX_VALUE;
        int distance = Integer.MAX_VALUE;
        int currentDistance = 0;

        for(int i = 0;  i < array.length; i++){

            currentDistance = Math.abs(array[i] - target);

            if(currentDistance < distance || (distance == currentDistance && array[i] < closestValue)){
                closestValue = array[i];
                distance = Math.abs(array[i] - target);
            }
        }

        return closestValue;

    }



    public static void main(String[] args){
        //Test 1: Empty array
        System.out.println("array = [], target = 10");
        int[] arr1 = {};
        System.out.println(closestValue(arr1, 0)); //Expecting -1

        //Test 2: No tie
        System.out.println("array = [4, 9, 1, 15, 8], target = 10");
        int[] arr2 = {4, 9, 1, 15, 8};
        System.out.println(closestValue(arr2, 10)); //Expecting 9

        //Test 3: No tie, same array, different target
        System.out.println("array = [4, 9, 1, 15, 8], target = 2");
        int[] arr3 = {4, 9, 1, 15, 8};
        System.out.println(closestValue(arr3, 2)); //Expecting 1

        //Test 4: Tie, smaller value returned
        System.out.println("array = [5, 15], target = 10");
        int[] arr4 = {5, 15};
        System.out.println(closestValue(arr4, 10)); //Expecting 5


    }


}
