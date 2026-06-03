
import java.util.*;

class Solution {

    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) {
            return new int[0][0];
        }

        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        // Step 2: Traverse and merge
        for (int i = 1; i < intervals.length; i++) {

            int[] last = merged.get(merged.size() - 1);
            int[] current = intervals[i];

            // If overlapping
            if (current[0] <= last[1]) {
                last[1] = Math.max(last[1], current[1]);
            } else {
                merged.add(current);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
