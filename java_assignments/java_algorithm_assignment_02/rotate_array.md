# Rotate Array

## Objective

Practice manipulating array elements in place (or into a new array), handling positional shifts based on a given step count, and accounting for step counts that wrap around the array's length.

## Instructions

- Write a method that accepts two parameters: an array of integers, and an integer `k` representing the number of steps to rotate.
- The method should return the array with its elements rotated to the **right** by `k` positions. Elements that shift past the end of the array should wrap around to the beginning.
- `k` may be larger than the length of the array — your method should handle this correctly (an array rotated by its own length returns to its original order, so only the remainder matters).
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
- [ ] Code is organized into at least one clearly named method (avoid putting all logic directly in `main`)

## Stretch Goals

Each stretch goal should be implemented as its own separate method — do not modify your original method to accommodate these. Your original solution should remain intact and callable on its own.

- **Rotate Left** — Write a method that rotates the array to the **left** by `k` positions. For example, given `[1, 2, 3, 4, 5]` and `k = 2`, the result should be `[3, 4, 5, 1, 2]`.
- **Negative Step Counts** — Write a method where a negative value of `k` rotates the array in the opposite direction (so `k = -2` rotates left by 2, and `k = 2` rotates right by 2). Make sure large negative values, such as `-7` on a 5-element array, are handled correctly.
- **Minimal Extra Memory** — Write a method that performs the rotation directly within the original array, without creating a second array to hold some or all of the elements. Think about whether there is a sequence of simpler operations on parts of the array that produces the same overall result.
