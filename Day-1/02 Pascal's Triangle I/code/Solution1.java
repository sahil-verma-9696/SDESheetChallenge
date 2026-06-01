
import java.util.*;

class Solution1 {

    /**
     * Expected Solution
     * Time Complexity: O(n*n) - nested loop for each row.
     * Space Complexity: O(1)
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            ans.add(new ArrayList<>(Collections.nCopies(i+1, 1)));
        }

        if(numRows == 1 || numRows == 2) return ans;

        for(int i=2; i<numRows; i++){
            for(int j=1; j<i; j++){
                List<Integer> prev = ans.get(i-1);
                List<Integer> curr = ans.get(i);

                curr.set(j, prev.get(j-1) + prev.get(j));

            }
        }

        return ans;
    }
}