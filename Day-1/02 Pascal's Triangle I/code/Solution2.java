
class Solution2 {

    /**
     * Expected Solution 
     * Time Complexity: O(c) 
     * Space Complexity: O(1)
     */
    int getElement(int r, int c) {
        int ans = 1;
        for (int i = 0; i < c; i++) {
            ans *= r - i;
            ans /= i + 1;
        }
        return ans;
    }
}
