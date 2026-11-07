import java.util.Arrays;

public class Main {

    //Note: This solution also works with stretch goal 1 (custom starting value), except this solution doesn't need the start value to work
    public static int findMissingNumber(int[] input){
        int missingNumber = 0;
        int tempValue = 0;
        boolean sorting = true;

        //Sorting the array first, using bubble sort (for no reason in particular other than its easy to implement)
        while(sorting) {
            sorting = false;
            for (int i = 0; i < input.length - 1; i++) {
                if (input[i] > input[i+1]) {
                    tempValue = input[i];
                    input[i] = input[i+1];
                    input[i+1] = tempValue;
                    sorting = true;
                }
            }
        }

        //Now iterating through array, if 2 elements have a difference of two,
        // take the lower num + 1 to find the missing element
        for (int i = 0; i < input.length - 1; i++){
            if(input[i+1] - input[i] == 2){
                missingNumber = input[i] + 1;
                break;
            }
        }

        return missingNumber;
    }

    public static void main(String[] args) {

        //First Test Case:
        System.out.println("Input: [3, 7, 1, 2, 8, 4, 5]");
        int[] arr1 = {3, 7, 1, 2, 8, 4, 5};
        System.out.println(findMissingNumber(arr1)); //Expecting 6

        //Second Test Case:
        System.out.println("Input: [13, 3, 7, 11, 4, 6, 2, 10, 9, 5, 8, 1]");
        int[] arr2 = {13, 3, 7, 11, 4, 6, 2, 10, 9, 5, 8, 1};
        System.out.println(findMissingNumber(arr2)); //Expecting 12

        //Stretch Case 1:
        System.out.println("Input: [5, 6, 8, 9]");
        int[] arr3 = {5, 6, 8, 9};
        System.out.println(findMissingNumber(arr3)); //Expecting 7


    }
}
