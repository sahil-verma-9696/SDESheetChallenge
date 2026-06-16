// User function Template for Java//User function Template for Java
class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        recursion(0, 0, arr, ans);
        
        return ans;
    }
    
    private void recursion(int i, int sum, int[] arr, ArrayList<Integer> ans){
        int n = arr.length;
        
        if(i == n){
            ans.add(sum);
            return;
        }
        
        // take 
        recursion(i+1, sum + arr[i], arr, ans);
        

        // not take
        recursion(i+1, sum         , arr, ans);
        
    }
}