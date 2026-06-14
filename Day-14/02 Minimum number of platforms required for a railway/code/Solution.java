class Solution {
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        
        int n = arr.length;
        
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int intersectionPoint = 0;
        
        int maxIntersection = 0;
        
        int i = 0;
        int j = 0;
        
        while(i < n){
            
            if(arr[i] <= dep[j]){
                intersectionPoint++;
                i++;
            }else{
                intersectionPoint--;
                j++;
            }
            
            maxIntersection = Math.max(maxIntersection, intersectionPoint);
            
        }
        
        return maxIntersection;
    }
}
