# Missing Number Finder

## Objective

Practice iterating through an array and comparing its values against an expected range to detect a single missing value.

## Instructions

- Write a method that accepts a single parameter: an array of integers.
- The array will always contain all of the distinct integers from `1` to `n`, in some order, with exactly **one** value missing from that range (where `n` is one more than the length of the array).
- The method should return the single missing integer.
- You can assume the array will always have exactly one missing number — you do not need to handle the case of zero or multiple missing numbers.

## Example Interactions

**Example 1**
```
Input: [3, 7, 1, 2, 8, 4, 5]
Output: 6
```

**Example 2**
```
Input: [13, 3, 7, 11, 4, 6, 2, 10, 9, 5, 8, 1]
Output: 12
```

## Requirements Checklist

- [ ] Method accepts the array as a parameter (not hardcoded)
- [ ] Correctly identifies the single missing integer in the range `1` to `n`
- [ ] Solution works regardless of the order of the values within the array
- [ ] Code is organized into at least one clearly named method (avoid putting all logic directly in `main`)

## Stretch Goals

Each stretch goal should be implemented as its own separate method — do not modify your original method to accommodate these. Your original solution should remain intact and callable on its own.

- **Custom Starting Value** — Write a method that accepts the array plus a `start` value, where the array contains every integer from `start` up to some ending value with exactly one missing. For example, given `[5, 6, 8, 9]` and a start of `5`, the method should return `7`.
- **Two Missing Numbers** — Write a method for an array that is missing exactly **two** values from the range `1` to `n` (where `n` is two more than the length of the array). Return both missing values in an array, in ascending order. For example, given `[1, 2, 4, 6]`, the method should return `[3, 5]`.
- **Missing and Duplicate** — Write a method for an array of length `n` that should contain every integer from `1` to `n`, but instead has one value that appears twice and one value that is missing. Return both the duplicated value and the missing value. For example, given `[1, 2, 2, 4]`, the duplicate is `2` and the missing value is `3`.
