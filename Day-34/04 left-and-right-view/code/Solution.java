
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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        rightDFS(root, ans, 1);

        return ans;
        
    }

    private void rightDFS(TreeNode root, List<Integer> lst, int level){

        if(root == null) return;

        // if elements are less than required.
        // at this level
        if(lst.size() < level){
            lst.add(root.val);
        }


        // for right view go for right first

        if(root.right != null){
            level++;
            rightDFS(root.right, lst, level);
            level--;
        }

        if(root.left != null){
            level++;
            rightDFS(root.left, lst, level);
            level--;
        }
    }

    private void leftDFS(TreeNode root, List<Integer> lst, int level){

        if(root == null) return;

        // if elements are less than required.
        // at this level
        if(lst.size() < level){
            lst.add(root.val);
        }


        // for LEFT view go for LEFT first


        if(root.left != null){
            level++;
            leftDFS(root.left, lst, level);
            level--;
        }

        if(root.right != null){
            level++;
            leftDFS(root.right, lst, level);
            level--;
        }

        
    }
}