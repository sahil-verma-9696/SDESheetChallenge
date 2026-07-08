class Solution {
    int maxi = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        int ans = recur(root);
        return Math.max(maxi, ans);
    }

    private int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(0, recur(root.left));
        int rightSum = Math.max(0, recur(root.right));

        this.maxi = Math.max(this.maxi, leftSum + rightSum + root.val);

        // System.out.println(leftSum + " " + rightSum + " " + root.val);

        return root.val + Math.max(leftSum, rightSum);
    }
}