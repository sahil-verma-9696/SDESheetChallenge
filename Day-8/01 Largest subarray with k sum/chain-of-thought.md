# Largest Subarray with K sum

Return the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Subarray is continguous part of an array.

### Example 1:

Input: nums = [1,1,1], k = 2
Output: 2


## What i know about subarray.

- 1. to calculate the subarrays, we need traverse array nestedly 
- Time Complexity : O(n^2) Space Complexity: O(1)

- 2. to calculate the sum of subarray, efficient way is to use prefix sum. 
- Time Complexity : O(n) Space Complexity: O(n)

- 3. if array is sorted, then we use two pointer approach to find the subarray.
- Time Complexity : O(n) Space Complexity: O(1)




## Thinking via Prefix Sum approach.

nums : [n1, n2, n3, n4].
       [0 , 1 , 2 , 3]

prefixSum : [ 
            0 : n1, 
            1 : n1 + n2, 
            2 : n1 + n2 + n3, 
            3 : n1 + n2 + n3 + n4
            ].


if i want sum of subarray

- nums[0:0] = prefixSum[0]
- nums[0:1] = prefixSum[1]
- nums[0:2] = prefixSum[2]
- nums[0:3] = prefixSum[3]

- nums[1:1] (n2)     = prefixSum[1] - prefixSum[0] : ( n1 + n2 - n1 ) : n2
- 
- nums[1:2]          = prefixSum[2] - prefixSum[0] 
- (n2 + n3)           (n1 + n2 + n3) - (n1) = n2 + n3
- 
- nums[1:3]          = prefixSum[3] - prefixSum[0]
  (n2 + n3 + n4)      (n1 + n2 + n3 + n4) - (n1) = n2 + n3 + n4

- nums[2:2] = prefixSum[2] - prefixSum[1]
- nums[2:3] = prefixSum[3] - prefixSum[1]

- nums[3:3] = prefixSum[3] - prefixSum[2]   

In general : 


`sumOfSubarray[i:j] = i > 0 ? prefixSum[j] - prefixSum[i-1] : prefixSum[j]`


now if we closely observe to find a subarray with target sum k.

its mean 

`prefixSum[j] - prefixSum[i-1] == k`

prefixSum[j] (let P1) : Unknown
prefixSum[i-1] (let P2) : Unknown
k : Known

**Now This Problem is a variation of two sum problem**

one of the `Unknown` we find using loop. 

let `prefixSum[i-1]` be the Unknown we find using loop.

then `prefixSum[j] = k + prefixSum[i-1]` 

```
P1 = k + P2
or
P2 = P1 - k
```


which we can find using hashing.


### Algo

1. Calculate the prefix sum array.
2. Initialize ans = 0
3. Initialize a Map<Integer, Integer> map.
4. for P1 : prefixSum : 
   1. `P2 = k + P1` <- this may lead to overflow user `(P2 = P1 - k)`
   2. if map.containsKey(P2)
      1. ans = Math.max(ans, j - map.get(P2))
   3. else
      1. map.put(P1, j)
5. return ans



**unordered_map or HashMap**

Insertion/Acessing 

due to using `hash table`

Average case: O(1), 
Worst case: O(n) due to hash collisions.

**Ordered map or TreeMap**

due to using `balanced tree`

Average case: O(log n), 
Worst case: O(log n)