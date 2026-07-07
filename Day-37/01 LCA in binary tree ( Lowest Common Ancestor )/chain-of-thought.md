# Thought = 1 

**Ask every node, Are you able to become LCA ?.**

## Approach

- Ask every node, Are you able to become LCA ?
- If yes, then it is LCA, else move to left or right.

## Complexity

- For each not we find over (n - 1) nodes.
- Total complexity : O(n) * O(n - 1) = O(n*n)
- Space : O(n) recursion stack


## Code

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode LCA = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        dfs(root, p, q);

        return this.LCA;
    }

    public void dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return;

        if (find(root.left, p) && find(root.right, q)) {
            this.LCA = root;
        } else if (find(root.right, p) && find(root.left, q)) {
            this.LCA = root;
        } else if (root.val == p.val && find(root.left, q)) {
            this.LCA = root;
        } else if (root.val == p.val && find(root.right, q)) {
            this.LCA = root;
        } else if (root.val == q.val && find(root.left, p)) {
            this.LCA = root;
        } else if (root.val == q.val && find(root.right, p)) {
            this.LCA = root;
        }

        // Increment || Decrement;
        if (root.left != null) {
            dfs(root.left, p, q);
        }

        if (root.right != null) {
            dfs(root.right, p, q);
        }
    }

    public boolean find(TreeNode root, TreeNode target) {

        if (root == null)
            return false;

        if (root.val == target.val)
            return true;

        boolean isFoundInLeft = false;
        boolean isFoundInRight = false;

        if (root.left != null) {
            isFoundInLeft = find(root.left, target);
        }

        if (root.right != null) {
            isFoundInRight = find(root.right, target);
        }

        return isFoundInLeft || isFoundInRight;
    }
}
```

# Thought = 2

## Approach

- if current node is `p` or `q`, then it is LCA
- if both left and right are LCA, then its `root` is LCA


## Code

```java
class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

         if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;

        return left != null ? left : right;
    }

}
```

