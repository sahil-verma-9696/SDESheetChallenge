import java.util.function.Consumer;

class Solution {

    public boolean findTarget(TreeNode root, int k) {

        Tree myTree = new Tree(root);

        boolean[] found = {false};

        myTree.inorder(node -> {

            if (found[0]) {
                return;
            }

            int diff = k - node.val;

            if (findX(root, diff, node)) {
                found[0] = true;
            }
        });

        return found[0];
    }

    private boolean findX(TreeNode root, int x, TreeNode currentNode) {

        if (root == null) {
            return false;
        }

        if (root.val == x) {
            // Make sure we don't use the same node twice
            return root != currentNode;
        }

        if (x < root.val) {
            return findX(root.left, x, currentNode);
        }

        return findX(root.right, x, currentNode);
    }
}

class Tree {

    TreeNode root;

    public Tree(TreeNode root) {
        this.root = root;
    }

    // ================= PREORDER =================
    // Root -> Left -> Right

    public void preorder(Consumer<TreeNode> action) {
        preorder(root, action);
    }

    private void preorder(TreeNode node, Consumer<TreeNode> action) {
        if (node == null) {
            return;
        }

        action.accept(node);          // Root
        preorder(node.left, action);  // Left
        preorder(node.right, action); // Right
    }


    // ================= INORDER =================
    // Left -> Root -> Right

    public void inorder(Consumer<TreeNode> action) {
        inorder(root, action);
    }

    private void inorder(TreeNode node, Consumer<TreeNode> action) {
        if (node == null) {
            return;
        }

        inorder(node.left, action);   // Left
        action.accept(node);          // Root
        inorder(node.right, action);  // Right
    }


    // ================= POSTORDER =================
    // Left -> Right -> Root

    public void postorder(Consumer<TreeNode> action) {
        postorder(root, action);
    }

    private void postorder(TreeNode node, Consumer<TreeNode> action) {
        if (node == null) {
            return;
        }

        postorder(node.left, action);  // Left
        postorder(node.right, action); // Right
        action.accept(node);           // Root
    }
}