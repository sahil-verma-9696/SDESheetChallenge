# Prerequisites

- variables
- nested loops
- arrays
- sets

- nCr formula and pascal triangle relation.
- smart way to calculate nCr.

# Observation Based Problem + Math Based Problem...

- Challenge your brain to find the pattern in the pascal triangle.

# Solution

1. Brute Force Solution
2. Better Solution
3. Optimal Solution

---

# Brute Force Solution

- try to generate each row of the pascal triangle.
- return the first `numRows` rows.

# Complexity Analysis

## Time

O(n^2) - nested loop for each row.

## Space

O(n^2) - to store the pascal triangle.

---

# Better Solution

- use the nCr formula to generate each row of the pascal triangle.

- for item of row: O(n)
  - use nCr formula to calculate the value of the item. O(n)

# Complexity Analysis

## Time

O(n\*n) - `n` is the number of column or row number.

## Space

O(1) - constant space.

---

# Optimal Solution

- Analyse the formula on each item closely you find a pattern.

- let the row be `5`.

[5][0] = 1

[5][1] = `1` * 5/1 = 5
[5][2] = `(5/1)` * (4/2) = 10 : Note (5/1) is calculated used it.
[5][3] = `(5/1) * (4/2)` * (3/3) = 10
[5][4] = `(5/1) * (4/2) * (3/3)` * (2/4) = 5
[5][5] = `(5/1) * (4/2) * (3/3) * (2/4)` * (1/5) = 0



[5][0] = 1

[5][1] = `[5][0]` * 5/1 = 5
[5][2] = `[5][1]` * (4/2) = 10 : Note (5/1) is calculated used it.
[5][3] = `[5][2]` * (3/3) = 10
[5][4] = `[5][3]` * (2/4) = 5
[5][5] = `[5][4]` * (1/5) = 0

- let the row be `3`.

[3][0] = 1

[3][1] = 1 * (3/1) = 3
[3][2] = 1 * (3/1) * (2/2) = 3
[3][3] = 1 * (3/1) * (2/2) * (1/3) = 0

- use this pattern to generate the pascal's triangle particular row.

# Complexity Analysis

## Time

O(n) = for each item do only `single multiplication` operation.

## Space

O(1) - constant space.
