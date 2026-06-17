// User function Template for Java

class Solution {
    static int INF = (int)1e9;
    static int NEG_INF = -(int)1e9;
    
    static int palPartition(String s) {
        // code here
        
        // return recur(0, s) - 1;
        
        int n = s.length();
        
        int[] dp = new int[n];
        
        Arrays.fill(dp, -1);
        
        return memo(0, s, dp) - 1;
    }
    
    static int recur(int i, String s){
        int n = s.length();
            
        
        if(i == n) return 0;
        
        int minSubstr = INF;
        
        // I create every substring from i to n
        for(int j=i; j<n; j++){
            
            if(isPalindrome(i,j,s)){
                int cuts = 1 + recur(j+1, s);
                
                minSubstr = Math.min(cuts, minSubstr);
            }
        }
        
        
        return minSubstr;
    }
    
    static int memo(int i, String s, int[] dp){
        int n = s.length();
            
        
        if(i == n) return 0;
        
        if(dp[i] != -1) return dp[i];
        
        int minSubstr = INF;
        
        // I create every substring from i to n
        for(int j=i; j<n; j++){
            
            if(isPalindrome(i,j,s)){
                int cuts = 1 + memo(j+1, s, dp);
                
                minSubstr = Math.min(cuts, minSubstr);
            }
        }
        
        dp[i] = minSubstr;
        
        
        return minSubstr;
    }
    
    static boolean isPalindrome(int s, int e, String str){
        
        // same index means single character
        if(s == e) return true;
        
        while(s <= e){
            if(str.charAt(s) != str.charAt(e)){
                return false;
            }
            
            s++;
            e--;
        }
        
        return true;
        
        
    }
}