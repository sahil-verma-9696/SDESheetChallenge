/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return solve(root.left, root.right);
    }

    private boolean solve(TreeNode A, TreeNode B){
        if(A == null && B == null)
        return true;

        if(A == null || B == null)
        return false;

        if(A.val != B.val)
        return false;

        boolean left = solve(A.left, B.right);
        boolean right = solve(A.right, B.left);

return left && right;
    }
}