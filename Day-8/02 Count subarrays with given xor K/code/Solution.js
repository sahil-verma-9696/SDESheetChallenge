/**
 * @param {number[]} arr
 * @param {number} k
 * @returns {number}
 */

class Solution {
    subarrayXor(arr, k) {
        // code here
        let sol = 0;
        
        // sol = this.bruteSol(arr,k);
        
        sol = this.optimalSol(arr,k);
        
        return sol;
    }
    
    
    /*
    Complexity Analysis
    time : O(n^2)
    space : O(1)
    */
    bruteSol(arr, k){
        let res = 0;
        let n = arr.length;
        
        for(let i=0; i<n; i++){
            let t = 0;
            for(let j=i; j<n; j++){
                t = t ^ arr[j];
                
                if(t == k) res++;
            }
        }
        
        return res;
    }
    
    
    optimalSol(arr,k){
        let res = 0;
        
        let cumXor = 0;
        
        let map = {};
        
        map[cumXor] = 1;
        
        for(let i of arr){
            cumXor ^= i;
            
            let diff = cumXor^k;
            
            if(map[diff] != undefined) res += map[diff];
            
            if(map[cumXor]){
                map[cumXor] = map[cumXor] + 1;
            }else{
                map[cumXor] = 1;
            }
        }
        
        return res;
    }
}