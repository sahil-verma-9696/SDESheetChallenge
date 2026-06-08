// User function Template for Java
import  java.util.*;

class Solution {
	public int longestSubarray(int[] arr, int k) {
		// code here
		int ans = 0;
		
		// ans = this.betterSolution(arr,k);
		
		// Optimal for ( +ve );
		ans = this.optimalSolution(arr, k);
		
		return ans;
	}
	
	// time = O(n) and space = O(n);
	// optimal for +ve , -ve and 0s 
	public int betterSolution(int[] arr, int k) {
		int maxLen = 0;
		
		int n = arr.length;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int p1 = 0;
		
		for (int i = 0; i<n; i++) {
			p1 += arr[i];// Calculate Prefix sum in run time
			
			if (p1 == k) {
				maxLen = i + 1;
			}
			
			int p2 = p1 - k;
			
			if (map.containsKey(p2)) {
				int p2Idx = map.get(p2);
				
				int len = i - p2Idx;
				
				maxLen = Math.max(len, maxLen);
			}
			
			if (!map.containsKey(p1)) {
				map.put(p1, i);
			}
		}
		
		return maxLen;
	}
	
	// left-skewed two pointer approach ( Optimal for positive)
	// time = O(n) and space = O(1);
	public int optimalSolution(int[] arr, int k) {
		int n = arr.length;
		
		int p1 = 0;

		int sum = 0;
		
		int maxLen = 0;
		
		for(int p2 = 0; p2<n; p2++){
		    sum += arr[p2];
		    
		    while (p1 <= p2 && sum > k) {
                sum -= arr[p1];
                p1++;
            }
            
            if(sum == k){
                maxLen = Math.max(p2 - p1 + 1, maxLen);
            }
		}
		
		return maxLen;
		
	}
}

// a - b = k
// a - k = b
