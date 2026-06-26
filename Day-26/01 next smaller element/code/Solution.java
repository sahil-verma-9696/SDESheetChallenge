import java.util.*;

class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
        Stack<Integer> stk = new Stack<>();
        
        ArrayList<Integer> lst = new ArrayList<>();
        
        int n = arr.length;
        
        for(int i=0; i<n; i++) lst.add(0);
        
        for(int i = n-1; i>=0; i--){
            while(!stk.isEmpty() && stk.peek() >= arr[i])
            stk.pop();
            
            int nxtSmaller = stk.isEmpty() ? -1 : stk.peek();
            
            lst.set(i, nxtSmaller);
            
            stk.push(arr[i]);
        }
        
        return lst;
    }
}