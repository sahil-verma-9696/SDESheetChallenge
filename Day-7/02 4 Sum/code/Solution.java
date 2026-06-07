import java.util.*;

class Solution {

    // a + b + c + d = target.

    /**
    NOTE :
    ------
    
    If numbers are repeating. 
    so skip them.
    
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;

        List<List<Integer>> ans = new ArrayList<>();

        // Sort the array
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i - 1] == nums[i])
                continue;

            int a = nums[i];

            for (int j = i + 1; j < n; j++) {
                if (j > i+1 && nums[j - 1] == nums[j])
                    continue;
                int b = nums[j];

                // int causing Overflow
                long remain = (long)target - ((long)a + (long)b);

                // two pointer to find c and d.
                int s = j + 1;
                int e = n - 1;
                while (s < e) {

                    int c = nums[s];
                    int d = nums[e];

                    if ((c + d) == remain) {
                        List<Integer> tem = new ArrayList<>();
                        tem.add(a);
                        tem.add(b);
                        tem.add(c);
                        tem.add(d);

                        ans.add(tem);

                        s++;
                        e--;

                        // Skip the duplicates

                        while (s < e && nums[s] == nums[s - 1]) s++;
                        while (s < e && nums[e] == nums[e + 1]) e--;

                    } else if ((c + d) < remain) {
                        s++;
                    } else {
                        e--;
                    }

                }
            }
        }

        return ans;
    }
}