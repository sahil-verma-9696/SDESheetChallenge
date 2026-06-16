class Solution {
    // It is a greedy algo problem.
    // Why ?
    // Because i want to assign the only necessary cookie to childrens.
    // example : 
    // if g[i] = 1 then, 
    // it is good to give cookie whose size is closest to `1`.
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;

        // sort to take as close as possible answer.
        Arrays.sort(g);
        Arrays.sort(s);

        // now using two pointers i assign the cookies
        int childIdx = 0;
        int cookieIdx = 0;

        while(childIdx < n && cookieIdx < m){

            // is assign cookie size satisfies the greed ?
            if(s[cookieIdx] >= g[childIdx]){
                // yes

                // so assign cookie and move forward
                cookieIdx++;

                // child satisfied so move forward
                childIdx++;
            }else{
                // no

                // cookie not able to assign 
                // since array is sorted so upcomming greed is also high from the current.
                // so this cookie not able assign further so move to the next cookie.
                cookieIdx++;
            }
        }


        return childIdx;
    }
}