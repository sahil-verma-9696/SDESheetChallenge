import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = null;

        // ans = brute(nums);

        ans = optimal(nums);

        return ans;
    }

    // Brute method.
    /**
    Q. Why not int[ (int)1e9 ] ? 
    
    Ans. int -> 4bytes 
    
    1_000_000_000 * 4 = 4_000_000_000 bytes
    
    1GB = 1024bytes
    
    4e9/1024 = 3906250 
    
    3.9GB
    
    `1e6 is safe to initialize`
    */

    public List<Integer> brute(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i : nums) {
            if (!freq.containsKey(i)) {
                freq.put(i, 1);
            } else {
                freq.put(i, freq.get(i) + 1);
            }
        }

        int k = n / 3;

        for (Integer key : freq.keySet()) {
            if (freq.get(key) > k) {
                ans.add(key);
            }
        }

        return ans;
    }

    /**
    Complexity analysis
    -------------------
    time : O(n);
    space : O(n);
    */

    /****************************************************/

    public List<Integer> optimal(int[] nums) {
        int n = nums.length;

        List<Integer> ans = new ArrayList<>();

        int Modi = 0;
        int Akhlesh = 0;

        int ModiVote = 0;
        int AkhleshVote = 0;

        for (int i : nums) {
            if (Modi == i) {
                ModiVote++;
            } else if (Akhlesh == i) {
                AkhleshVote++;
            } else if (ModiVote == 0) {
                Modi = i;
                ModiVote = 1;
            } else if (AkhleshVote == 0) {
                Akhlesh = i;
                AkhleshVote = 1;
            } else {
                ModiVote--;
                AkhleshVote--;
            }
        }

        // Verification.
        ModiVote = 0;
        AkhleshVote = 0;


        for(int i : nums){
            if(i == Modi) ModiVote++;
            else if(i == Akhlesh) AkhleshVote++;
        }

        if (ModiVote > n / 3)
            ans.add(Modi);
        if (AkhleshVote > n / 3)
            ans.add(Akhlesh);

        return ans;
    }
}