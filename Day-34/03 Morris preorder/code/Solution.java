
import java.util.*;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        TreeNode i = root;
        TreeNode l = i.left;
        TreeNode r = i.right;

        // TreeNode x = getRightMost(i);
        // if(x != null)
        // System.out.println(x.val);
        while (true) {
            ans.add(i.val);

            if (l == null && r == null) {
                break;
            }

            if (l != null) {
                TreeNode rightMost = getRightMost(l);

                if (rightMost != null) // System.out.println(rightMost.val);
                {
                    rightMost.right = r;
                }

                i = l;

                if (r != null && i.right == r) {
                    ans.add(i.val);
                    i.right = null;
                    i = r;
                }

                l = i.left;
                r = i.right;
            } else {
                i = r;
                l = i.left;
                r = i.right;
            }
        }

        return ans;
    }

    private TreeNode getRightMost(TreeNode root) {
        while (root.right != null || root.left != null) {
            if (root.right != null) {
                root = root.right;
                continue;
            }

            if (root.left != null) {
                root = root.left;
            }
        }
        return root;
    }
}
