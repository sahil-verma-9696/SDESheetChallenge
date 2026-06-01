
# Prerequisites

* variables 
* nested loops
* arrays
* sets

# Observation Based Problem...

* Challenge your brain to find the pattern in the pascal triangle.

# Solution 

- Observe the pattern of forming pascal triangle. 

- initialize the array `ans` with size `n`.
- traverse the array `ans` from 0 to `n-1`.
- initialize the array `row` with size `i+1` and fill with `1`.
- traverse the array `row` from `1` to `i - 1`.
- assign the value of `ans[i][j]` as `ans[i-1][j-1] + ans[i-1][j]`


# Complexity Analysis

## Time

O(n^2) - nested loop for each row.

## Space

O(1) - constant space.