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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);


        int intLevel = 1;

        while(!queue.isEmpty()) {

            int size = queue.size(); 
            List<Integer> level = new ArrayList<>();

            System.out.println(intLevel);

            

            for(int i = 0; i < size; i++){

                TreeNode curr = queue.poll();
                level.add(curr.val);

                if(curr.left != null){
                    queue.offer(curr.left);
                }

                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }


            if(intLevel%2 == 0){
                Collections.reverse(level);
            }

            ans.add(level);

            intLevel++;
        }

        return ans;
    }
}