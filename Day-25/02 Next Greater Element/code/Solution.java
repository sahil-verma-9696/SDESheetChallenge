import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        Stack<Integer> stk = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>(); 

        for (int i = m - 1; i >= 0; i--){
            int it = nums2[i];

            while(!stk.isEmpty() && stk.peek() <= it){
                stk.pop();
            }

            int nextGreater = stk.isEmpty() ? -1 : stk.peek();

            map.put(it, nextGreater);

            stk.push(it);
        }

        int[] ans = new int[n];

        for(int i=0; i<n; i++){
            ans[i] = map.get(nums1[i]);
        }



        return ans;
    }
}