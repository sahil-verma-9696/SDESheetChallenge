
# Prerequisites

* variables 
* nested loops
* arrays
* sets

* nCr formula and pascal triangle relation.
* smart way to calculate nCr.

# Observation Based Problem + Math Based Problem...

* Challenge your brain to find the pattern in the pascal triangle.

# Solution 

element(r,c) = (r-1) C (c-1). 

n = r - 1, 
r = c - 1.

* samart way to calculate nCr.

1. 4C2 = (4 * 3) / (2 * 1) = 6
2. 4C3 = (4 * 3 * 2) / (3 * 2 * 1) = 4
3. 4C4 = (4 * 3 * 2 * 1) / (4 * 3 * 2 * 1) = 1


Now for

5C3 = (5/1) * (4/2) * (3/3) = 10


```

long long ans = 1;

for (int i = 0; i < c; i++) {
    ans *= (r - i);
    ans /= (i + 1);
}

```

# Complexity Analysis

## Time

O(c) - where `c` is the number of columns in the pascal triangle.

## Space

O(1) - constant space.