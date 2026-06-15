class Solution {
    /**
    Complexity
    ----------

    time : O(2n)
    space : O(2n)
     */
    public int trap(int[] height) {
        int n = height.length;

        int[] lmaxs = new int[n];
        int[] rmaxs = new int[n];

        int lm = -1;
        int rm = -1;

        for(int i=0; i<n; i++){
            lm = Math.max(lm, height[i]);
            lmaxs[i] = lm;
            
            rm = Math.max(rm, height[n-1-i]);
            rmaxs[n-1-i] = rm;
        }

        

        int trap = 0;

        for(int i=0; i<n; i++){
            trap += Math.min(lmaxs[i],rmaxs[i]) - height[i];
        }

        return trap;
    }
}
/**
[0,1,0,2,1,0,1,3,2,1,2,1]
[0,1,1,2,2,2,2,3,3,3,3,3]
[3,3,3,3,3,3,3,3,2,2,2,1]

[0,0,1,0,1,2,1,0,0,1,0,0]

 */