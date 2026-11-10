/*## Requirements Checklist

- [ ] Method accepts the array as a parameter (not hardcoded)
- [ ] Correctly identifies the single missing integer in the range `1` to `n`
- [ ] Solution works regardless of the order of the values within the array
- [ ] Code is organized into at least one clearly named method (avoid putting all logic directly in `main`)

Find the missing number in a shuffled 1 to n array*/

import java.util.Arrays;

public class missing_number {

    public static void main(String[] args){
    
    
    int[] a = {3, 7, 1, 2, 8, 4, 5}; //6
    int[] b = {13, 3, 7, 11, 4, 6, 2, 10, 9, 5, 8, 1}; //12

    System.out.println(String.format("Array %s. Missing number: %s", Arrays.toString(a), check(a)));
    System.out.println(String.format("Array %s. Missing number: %s", Arrays.toString(b), check(b)));   
    

    }


    public static String check(int[] arr){

        //Sort(brute force)

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                
                if(arr[i] < arr[j]){
                int swap = arr[i];
                arr[i] = arr[j];
                arr[j] = swap; 
                }
            }
        }

        
        System.out.println(String.format("Sorted: %s", Arrays.toString(arr)));

        //Search through the list
        int missing_no = 0;
        for(int i = 1; i < arr.length; i++){

            if(arr[i] != arr[i-1] + 1){         //Current should be prev + 1
                missing_no = arr[i] - 1;        //If not, then the missing number is current - 1
            }
        }

        return String.format("The missing number is: %d", missing_no);
    }
}
