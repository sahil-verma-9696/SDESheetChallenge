class Solution {
    public int activitySelection(int[] start, int[] finish) {
        // code here
        int n = start.length;
        
        int[][] meetings = new int[n][2];
        
        for(int i=0; i<n; i++){
            meetings[i][0] = start[i];
            meetings[i][1] = finish[i];
        }
        
        Arrays.sort(meetings, (a,b)->a[1] - b[1]);
        
        int[] prev = null;
        
        int c = 0;
        
        for(int[] meeting : meetings){
            
            if(prev == null){
                prev = meeting;
                c++;
                continue;
            }
            
            if(prev != null){
                
                if(prev[1] < meeting[0]){
                    c++;
                    prev = meeting;
                }
                
            }
        }
        
        return c;
    }
}
