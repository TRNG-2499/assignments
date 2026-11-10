/*
# Closest Value in Array

## Objective

Practice linear iteration through an array while tracking the "best so far" result — comparing each element against a running best using a calculated difference, a common pattern that shows up across many search and optimization-style problems.

## Instructions

- Write a method that accepts two parameters: an array of integers and a target integer value. The array is **not** assumed to be sorted, and all numbers in the array will always be **positive integers**.
- The method should return the value from the array that is numerically closest to the target.
- If there is a tie (two values are equally close to the target), return the **smaller** of the two tied values.
- Since the array is not sorted, a straightforward linear scan comparing each element's distance from the target is the expected approach here. Sorting the array first is not required, but you are welcome to sort it as part of your solution if you'd like to explore whether it helps "optimize" your approach.
- If the array is empty, return `-1`. Since the array will otherwise always contain positive integers, `-1` can be safely used as a signal that no result was found.

## Example Interactions

**Example 1**
```
Input: array = [4, 9, 1, 15, 8], target = 10
Output: 9
```

**Example 2**
```
Input: array = [4, 9, 1, 15, 8], target = 2
Output: 1
```

**Example 3 — Tie, smaller value returned**
```
Input: array = [5, 15], target = 10
Output: 5
```

**Example 4 — Empty array**
```
Input: array = [], target = 10
Output: -1
```

## Requirements Checklist

- [ ] Method accepts the array and target as parameters (not hardcoded)
- [ ] Correctly finds the closest value via linear comparison, without assuming the array is sorted
- [ ] Ties are broken consistently, returning the smaller of the two tied values
- [ ] Empty array input returns `-1`
- [ ] Code is organized into at least one clearly named method (avoid putting all logic directly in `main`)


*/



//package assignments.java.java_algorithm_assignment_04;

public class closest {

    public static void main(String[] args){

        /*
Array = [4, 9, 1, 15, 8], target = 10
Output: 9

Input: array = [4, 9, 1, 15, 8], target = 2
Output: 1

Input: array = [5, 15], target = 10
Output: 5

Input: array = [], target = 10
Output: -1
        
        */

        int[] arr1 = {4,9,1,15,8}; //T10 = 9
        int[] arr2 = {4,9,1,15,8}; //T2 = 1
        int[] arr3 = {5,15}; //T10 = 5
        int[] arr4 = {}; //T10 = -1
        
        System.out.println(closest_value(arr1,10)); //9
        System.out.println(closest_value(arr2, 2)); //1
        System.out.println(closest_value(arr3, 10)); //5
        System.out.println(closest_value(arr4, 10)); //-1

    }

    public static int closest_value(int[] arr, int target){

        if(arr.length < 1){
            return -1;
        }

        int smallest_difference = Math.abs(target - arr[0]);
        int closest = arr[0];

        for(int i = 0; i < arr.length; i++){

            //Find the smallest difference
            if(smallest_difference > Math.abs((target - arr[i]))){
                smallest_difference = Math.abs(target - arr[i]);
                closest = arr[i];
            }

            //For tie breakers, just pick the smallest number
            if(smallest_difference == Math.abs((target - arr[i]))){

                if(arr[i] < closest){
                    closest = arr[i];
                }

            }
            
        }
        return closest;
    }

}
