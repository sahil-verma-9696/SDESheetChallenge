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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        return build(postorder, 0, postorder.length-1,
                     inorder , 0, inorder.length-1,
                     map );
    }

    private TreeNode build(
    int[] postorder, int ps, int pe,
    int[] inorder, int is, int ie,
    Map<Integer, Integer> map
) {
    if (ps > pe || is > ie)
        return null;

    int rootVal = postorder[pe];
    TreeNode root = new TreeNode(rootVal);

    int inordIdx = map.get(rootVal);

    int leftElems = inordIdx - is;
    int rightElems = ie - inordIdx;

    root.left = build(
        postorder,
        ps,
        ps + leftElems - 1,
        inorder,
        is,
        inordIdx - 1,
        map
    );

    root.right = build(
        postorder,
        ps + leftElems,
        pe - 1,
        inorder,
        inordIdx + 1,
        ie,
        map
    );

    return root;
}
}