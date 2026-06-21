

// User function Template for Java
class Solution {
    static boolean isPossible(int stalls[],int m, int k){
        int cows = 1;
        int lastPosition = stalls[0];
        for(int i = 1; i<stalls.length;i++){
            if((stalls[i]-lastPosition)>=m){
                cows++;
                if(cows==k) return true;
                lastPosition = stalls[i];
            }
        }
        return false;
    }
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int n = stalls.length;
        int s = 0;
        int e = stalls[n-1] - stalls[0];
        int ans = 0;
        int m = 0;
        while(s<=e){
            m = s + (e - s)/2;
            if(isPossible(stalls,m,k)){
                ans = m;
                s = m + 1;
            } else{
                e = m - 1;
            }
        }
        return ans;
    }
}