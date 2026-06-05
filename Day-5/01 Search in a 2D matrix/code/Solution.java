class Solution {
    public boolean searchMatrix(int[][] mat, int x) {
        
        int row = mat.length;
        int col = mat[0].length;
        
        int l = 0;
        int r = row*col-1;
        
        while(l<=r){
            int mid = l + (r - l)/2;
            
            int rw = mid/col;
            int cl = mid%col;
            
            if(mat[rw][cl] == x){
                return true;
            }else if(mat[rw][cl] > x){
                r = mid -1;
            }else{
                l = mid+1;
            }
        }
        
        return false;
    }
}