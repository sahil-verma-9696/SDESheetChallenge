class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();

        itrative(root, lst);

        return lst;
    }


    // Morrise Traversal
    private void itrative(TreeNode root, List<Integer> lst) {

        List<Integer> res = lst;

        TreeNode curr = root;

        while (curr != null) {

            // Case : when left is null
            if (curr.left == null) {

                // Prcessing when left is null
                res.add(curr.val);
                curr = curr.right;
            } else {

                // Case : when left is NOT NULL

                TreeNode leftSubRoot = curr.left;

                // Find Right most node of left-sub-tree
                while (leftSubRoot.right != null && leftSubRoot.right != curr) {
                    leftSubRoot = leftSubRoot.right;
                }

                if (leftSubRoot.right == null) {
                    // Create the THREAD [left-sub-tree -> root]
                    leftSubRoot.right = curr;


                    curr = curr.left;
                } else {

                    // Processing when come back through THREAD
                    res.add(curr.val);
                    
                    // After processing removing so the Original DS remain safe.

                    // Remove the THREAD [left-sub-tree -> root]
                    // Because we revist this 
                    leftSubRoot.right = null;

                    curr = curr.right;
                }
            }
        }
    }
}