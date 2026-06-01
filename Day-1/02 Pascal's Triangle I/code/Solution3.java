
import java.util.*;

class Solution3 {

    /**
     * Expected Solution Time Complexity: O(n) Space Complexity: O(1)
     */
    public List<Integer> getRow(int rowIndex) {

        List<Integer> ans = new ArrayList<>();

        ans.add(1);

        if (rowIndex == 0) {
            return ans;
        }

        long prev = 1;

        for (int r = 1; r <= rowIndex; r++) {
            prev = prev * (rowIndex - r + 1) / r;
            ans.add((int) prev);
        }

        return ans;
    }
}
