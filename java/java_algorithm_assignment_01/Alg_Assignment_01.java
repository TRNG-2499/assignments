import java.util.Arrays;
import java.util.stream.IntStream;

public class Alg_Assignment_01 {
    
    public static void main(String[] args) {
            
        int[] arr1 = {3, 7, 1, 2, 8, 4, 5};
        int[] arr2 = {13, 3, 7, 11, 4, 6, 2, 10, 9, 5, 8, 1};

        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Output: " + missingNumberFinder(arr1));

        System.out.println("Input: " + Arrays.toString(arr2));
        System.out.println("Output: " + missingNumberFinder(arr2));

        int[] arr3 = {5, 6, 8, 9};
        System.out.println("Input: " + Arrays.toString(arr3));
        System.out.println("Output: " + customStartValue(arr3, 5));

        int[] arr4 = {1, 2, 4, 6};
        System.out.println("Input: " + Arrays.toString(arr4));
        System.out.println("Output: " + Arrays.toString(twoMissingNumbers(arr4)));

        int[] result1 = findMissingAndDuplicate(new int[] {1, 2, 2, 4});
        System.out.println("Duplicate: " + result1[0] + ", Missing: " + result1[1]); 

        int[] result2 = findMissingAndDuplicate(new int[] {3, 1, 3, 4});
        System.out.println("Duplicate: " + result2[0] + ", Missing: " + result2[1]); 

 
            
    }

        // first try wasn't really understanding the req. of n being more lenght +1 & also was not understanding how to compare the arr to the range in the nested loops, leaving here to learn from mistake. Not to do it again. 
        // public static int missingNumberFinder(int arr[]) {

        //     int missingVal = 0;
        //     int numbersRange[] = IntStream.rangeClosed(1, arr.length).toArray();

        //     // for (int i = 0; i < arr.length; i++) {
        //     //     // now for every index in the arr let's check its' index value is within the numberRange array and if it is not then that is the missing value. 
        //     //     if (arr[i] ==  numbersRange[i]) {
                    
        //     //     }
        //     //     else {
        //     //         missingVal = numbersRange[i];
        //     //     }
        //     // }
        //     for (int i = 0; i < arr.length; i++) {
        //         boolean found = false;
        //         for (int j = 0; j < numbersRange.length; j++) {
        //             if (arr[i] == numbersRange[j]) {
        //                 found = true;
        //             }
        //         }
        //         if (!found) {
        //             missingVal = arr[i];
        //             break;
        //         }
        //     }

        //     return missingVal;

        // }

        
        public  static int missingNumberFinder(int arr[]) {
            // correcting the range this time around to include n (length + 1)  I am dumb
            int n = arr.length + 1;
            int[] numberRange = IntStream.rangeClosed(1, n).toArray();

            // was doing the oppsite last time
            for (int i = 0; i < numberRange.length; i++) {
                boolean found = false;
                // checks first if the # from Range exists in the input array, had it was backwards first time srry
                for (int k = 0; k < arr.length; k++) {
                    if (arr[k] == numberRange[i]) {
                        found = true;
                        break;
                    }
                }

            if (!found) {
                return numberRange[i];
            }

        }
        return 0;
     }

     /*
      Mostly same as the last one expect the n start is determine my user not defaults to 1 and ending value is the length of arr?
      This just to understand the range of number could be in the array for numberRange array that I am going to have. 
      Note: Understood end math, after a bit of thinking and help searching online. 

      */

     public static int customStartValue(int arr[], int start) {
        int end = start + arr.length; // instesed of just length, this one uses start and the length togther. 
        int[] numberRange = IntStream.rangeClosed(start, end).toArray();
        
            // was doing the oppsite last time
            for (int i = 0; i < numberRange.length; i++) {
                boolean found = false;
                // checks first if the # from Range exists in the input array, had it was backwards first time srry
                for (int k = 0; k < arr.length; k++) {
                    if (arr[k] == numberRange[i]) {
                        found = true;
                        break;
                    }
                }

            if (!found) {
                return numberRange[i];
            }

        }
        return 0;

     }

     /*

      */
     public static int[] twoMissingNumbers(int arr[]) {
        int n = arr.length + 2;
        int[] numberRange = IntStream.rangeClosed(1, n).toArray();
        int[] missingNumbers = new int[2];
        int missingCount = 0;

        for (int i = 0; i < numberRange.length; i++) {
            boolean found = false;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == numberRange[i]) {
                    found = true;
                    break;
                }
            }              

            if (!found) {
                missingNumbers[missingCount++] = numberRange[i];
                if (missingCount == 2) {
                    return missingNumbers;
                }
            }
        }   
        return missingNumbers;
     }

     public static int[] findMissingAndDuplicate(int[] arr) {
        int n = arr.length;

        int[] numberRange = IntStream.rangeClosed(1, n).toArray();

        int duplicate = -1;
        int missing = -1;

        for (int i = 0; i < numberRange.length; i++) {
            int currentNum = numberRange[i];
            int count = 0;

            // this checks how many times the "currentNum " from our range
            // appers in the actual array. 
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == currentNum) {
                    count++;
                }
            }

            // login for disco.
            if (count == 0) {
                // if it appered zero times, it's the missing one
                missing = currentNum;
            }
            else if (count == 2) {
                // if it apperared twice, it's the dupli.
                duplicate = currentNum;
            }
        }
        return new int[] {duplicate, missing}; 

     }
}



