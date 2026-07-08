class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length-1,
                     inorder , 0, inorder.length-1,
                     map );
    }

    private TreeNode build(
        int[] preorder, int ps, int pe,
        int[] inorder , int is, int ie,
        Map<Integer,Integer> map
    ){
        if(ps > pe || is > ie) return null;

        int rootVal = preorder[ps];
        TreeNode root = new TreeNode(rootVal);

        int inordIdx = map.getOrDefault(rootVal, 0);

        int leftElems = inordIdx - is;
        int rightElems = ie - inordIdx;


        root.left = build(
            preorder, ps + 1      , ps + leftElems,
            inorder , is, inordIdx - 1,
            map
        );

        root.right = build(
            preorder, ps + leftElems + 1, ps + leftElems + rightElems,
            inorder , inordIdx + 1    ,inordIdx + rightElems,
            map
        );

        return root;
    }
}