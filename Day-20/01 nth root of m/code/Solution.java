class Solution {
    public int nthRoot(int n, int m) {
        // code here
        
        if(n == 1) return m;
        
        int s = 1;
        int e = m/2;
        
        
        
        int ans = m;
       
        
        while(s <= e){
            
            int mid = s + (e - s)/2;
            
            int t = (int)Math.pow(mid,n);
            if(t == m){
                ans = mid;
                return ans;
            }else if(t < m){
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        
        return (int)Math.pow(ans,n) == m ? ans : -1;
    }
}