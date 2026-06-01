
# Prerequisites

* variables 
* nested loops
* arrays
* sets

# Observation Based Problem...

* Challenge your brain to solve this problem without using any extra arrays or sets.

# Table of Content

* [Approach 1] Using Marker Matrix - O(m*n) Time and O(m*n) Space
* [Approach 2] Using Row and Column Sets - O(m*n) Time and O(m+n) Space
* [Expected Approach] Using First Row and First Column as Markers - O(m*n) Time and O(1) Space

---

# [Approach 1] Using Marker Matrix - O(m*n) Time and O(m*n) Space

> The idea is to maintain an additional matrix `marker[][]` of the same size as the original matrix. First traverse the matrix and whenever a `0` is found, mark its position in `marker[][]`. In the second traversal, for every marked position, make its entire row and column equal to `0`.

### Steps

* Traverse the matrix.
* Store every zero position in `marker[][]`.
* Traverse `marker[][]`.
* For each marked cell:

  * Set its entire row to `0`.
  * Set its entire column to `0`.

### Complexity Analysis

* **Time Complexity:** O(m*n) - for traversing the matrix.
* **Space Complexity:** O(m*n) - for `marker[][]`

---

# [Approach 2] Using Row and Column Sets - O(m*n) Time and O(m+n) Space

> The idea is to maintain two auxiliary data structures:
>
> * `rows` → stores row indices containing at least one `0`
> * `cols` → stores column indices containing at least one `0`
>
> First traverse the matrix and record all rows and columns that contain a `0`. During the second traversal, if the current cell belongs to a marked row or column, update it to `0`.

### Steps

* Create:

  ```java
  Set<Integer> rows = new HashSet<>();
  Set<Integer> cols = new HashSet<>();
  ```

* Traverse the matrix.

  * If `mat[i][j] == 0`

    * Add `i` to `rows`
    * Add `j` to `cols`

* Traverse the matrix again.

  * If `rows.contains(i)` OR `cols.contains(j)`

    * Set `mat[i][j] = 0`

### Complexity Analysis

* **Time Complexity:** O(m*n)
* **Space Complexity:** O(m+n) - for `rows` and `cols` sets.

---

# [Expected Approach] Using First Row and First Column as Markers - O(m*n) Time and O(1) Space

> Instead of using extra arrays or sets, we can use the first row and first column of the matrix itself as marker storage.
>
> The challenge is that `mat[0][0]` is shared by both the first row and first column, making it impossible to determine which one should be zeroed later.
>
> To resolve this ambiguity, maintain two additional variables:
>
> * `fr` → whether the first row contains a `0`
> * `fc` → whether the first column contains a `0`

### Step 1: Identify Zero Rows and Columns

* Check whether the first row contains a `0`.

  ```java
  boolean fr = false;
  ```

* Check whether the first column contains a `0`.

  ```java
  boolean fc = false;
  ```

* Traverse the remaining matrix (`i = 1...m-1`, `j = 1...n-1`).

* Whenever `mat[i][j] == 0`:

  * Mark its row:

    ```java
    mat[i][0] = 0;
    ```
  * Mark its column:

    ```java
    mat[0][j] = 0;
    ```

### Step 2: Zero Out Cells Using Markers

* Traverse the matrix excluding the first row and first column.

* If either:

  ```java
  mat[i][0] == 0
  ```

  or

  ```java
  mat[0][j] == 0
  ```

  then:

  ```java
  mat[i][j] = 0;
  ```

### Step 3: Handle First Row

* If `fr == true`

  * Set the entire first row to `0`.

### Step 4: Handle First Column

* If `fc == true`

  * Set the entire first column to `0`.

### Why Do We Need `fr` and `fc`?

Because:

```text
mat[0][0]
```

belongs to both:

* First Row
* First Column

If we directly use `mat[0][0]` as a marker, we cannot determine whether:

* Only the first row should become zero, or
* Only the first column should become zero, or
* Both should become zero.

Therefore, separate flags `fr` and `fc` are required.

### Complexity Analysis

* **Time Complexity:** O(m*n)
* **Space Complexity:** O(1)
