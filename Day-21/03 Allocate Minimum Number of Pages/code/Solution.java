


//Back-end complete function Template for Java

class Solution {
    public static boolean isPossible(int[] arr, int m, int k){
        int stu = 1;
        int sum = 0;
        for(int i = 0; i<arr.length; i++){
            if((sum + arr[i])<=m){
                sum += arr[i];
            }else{
                stu++;
                sum = arr[i];
                if(stu > k || arr[i] > m) return false;
            }
        }
        return true;
    }
    
    public static int findPages(int[] arr, int k) {
        // code here
        if(k>arr.length)return -1;
        
        int maxPage = 0; for(int i : arr)maxPage+=i;
        
        int l = 0;
        int r = maxPage;
        int m = 0;
        int ans = -1;
        while(l<=r){
            m = l + (r - l)/2;
            
            if(isPossible(arr,m,k)){
                ans = m;
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return ans;
    }
}