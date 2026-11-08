/*# Rotate Array

## Objective

Practice manipulating array elements in place (or into a new array), handling positional shifts based on a given step count, 
and accounting for step counts that wrap around the array's length.

## Instructions

- Write a method that accepts two parameters: an array of integers, and an integer `k` representing the number of steps to rotate.
- The method should return the array with its elements rotated to the **right** by `k` positions. 
Elements that shift past the end of the array should wrap around to the beginning.
- `k` may be larger than the length of the array — your method should handle this correctly 
(an array rotated by its own length returns to its original order, so only the remainder matters).
- Consider what should happen when `k` is `0` — the array should be returned unchanged.

## Example Interactions

**Example 1**
```
Input: array = [1, 2, 3, 4, 5], k = 2
Output: [4, 5, 1, 2, 3]
```

**Example 2 — k larger than array length**
```
Input: array = [1, 2, 3], k = 4
Output: [3, 1, 2]
```

**Example 3 — k is zero**
```
Input: array = [1, 2, 3, 4], k = 0
Output: [1, 2, 3, 4]
```

## Requirements Checklist

- [ ] Method accepts the array and `k` as parameters (not hardcoded)
- [ ] Correctly rotates the array to the right by `k` positions
- [ ] Correctly handles a `k` value larger than the array's length
- [ ] Correctly handles a `k` value of `0`, returning the array unchanged
- [ ] Code is organized into at least one clearly named method (avoid putting all logic directly in `main`) */

import java.util.Arrays;

public class rotate_array {

    public static void main(String args[]){

        int[] a = {1,2,3,4,5};
        int[] a1 = {1,2,3};

        System.out.println(Arrays.toString(a));

        int[] b = rotate(a, 2);
        int[] c = rotate(a, 0);
        int[] d = rotate(a1, 4);

        System.out.println("Rotate");
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.toString(d));

    }

    public static int[] rotate(int[] arr, int k){

        int[] arr2 = new int[arr.length];
        k = k  % arr.length;

        for(int i = 0; i < arr.length; i++){
            arr2[i] = arr[(i-k + arr.length) % arr.length];
        }
        
        return arr2;
    }
    
}
