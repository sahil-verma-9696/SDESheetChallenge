class Solution {
    int findCeil(Node root, int x) {
        int ceil = -1;

        while (root != null) {

            // Exact match
            if (root.data == x) {
                return x;
            }

            if (root.data > x) {
                // Current node can be a possible ceil
                ceil = root.data;

                // Try to find a smaller valid ceil
                root = root.left;
            } else {
                // Current value is smaller than x
                root = root.right;
            }
        }

        return ceil;
    }
}