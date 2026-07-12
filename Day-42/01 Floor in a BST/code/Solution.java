class Solution {
    public static int floor(Node root, int x) {
        int ans = -1;

        while (root != null) {

            // Exact match is the floor
            if (root.data == x) {
                return x;
            }

            // Current value is smaller than x,
            // so it can be a possible floor.
            // Try to find a larger value on the right.
            if (root.data < x) {
                ans = root.data;
                root = root.right;
            }

            // Current value is greater than x,
            // so floor must be on the left.
            else {
                root = root.left;
            }
        }

        return ans;
    }
}