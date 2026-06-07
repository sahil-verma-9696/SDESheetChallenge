import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = {};

        // ans = bruteSolution(nums, target);

        // ans = betterSol(nums, target);

        ans = optimalSol(nums, target);

        return ans;
    }

    /**
    Brute Solution (Nested Loop)
    --------------
    
    Complexity Analysis
    -------------------
    
    Time :
    ------
    
    O(n*n) : for each of `a`, Algo find suitable `b` linearly( O(n) ).

    Space :
    -------
    
    O(1) : space is not growing as input grows.    
    */
    public int[] bruteSolution(int[] nums, int target) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int a = nums[i];
            for (int j = i + 1; j < n; j++) {
                int b = nums[j];

                if (a + b == target)
                    return new int[] { i, j };
            }
        }

        return new int[] { -1, -1 };
    }

    /**
    Better Solution (Binary Search)
    ---------------
    
    1. first store the element with index.
    2. Sort the elements.
    3. using binary search to find `b`.
    
    Complexity Analysis
    -------------------
    
    Time :
    ------
    
    O(n* log n) : O(n) + O(n*log n) + O(n * log n)
    
    O(n) : for storing elements in map.
    O(n * log n) : to sort element.
    O(n * log n) : to find `a` and `b`.
    
    Space :
    -------

    O(n) : to store all elements in hashmap  
     */

    public int[] betterSol(int[] nums, int target) {
        int n = nums.length;

        int[][] arr = new int[n][2];

        // [value, index]
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        // Sort by value
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < n; i++) {
            int a = arr[i][0];
            int b = target - a;

            int idx = binarySearch(arr, i + 1, n - 1, b);

            if (idx != -1) {
                return new int[] { arr[i][1], arr[idx][1] };
            }
        }

        return new int[] { -1, -1 };
    }

    private int binarySearch(int[][] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid][0] == target) {
                return mid;
            } else if (arr[mid][0] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    /**
    Optimal Solution ( Hashing )
    ----------------

    Complexity Analysis
    -------------------

    Time : 
    ------

    Average
    -------
    O(n) : O(n) + O(1)

    O(n) : to travese array.
    O(1) : look up in map.

    Worst Case
    ----------

    O(n * log n) : O(n) * O(log n)

    O(n) : to traverse and find a.
    O(log n) : look up in map.
    
    Space : 
    -------

    O(n) : to store element in map. 
     */

    public int[] optimalSol(int[] nums, int target){
        int n = nums.length;

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            int a = nums[i];

            int b = target - a;

            if(map.containsKey(b)){
                return new int[]{ i, map.get(b)};
            }else{
                map.put(a, i);
            }
        }

        return new int[]{-1, -1};
    }

}