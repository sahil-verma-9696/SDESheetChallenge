class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;

        return build(preorder, 0, n-1);
        
    }

    private TreeNode build(int[] preorder, int s, int e){

        if(s > e) return null;

        int rootVal = preorder[s];

        TreeNode root = new TreeNode(rootVal);

        int leftElems = 0;
        int rightElems = 0;

        for(int i=s; i<=e; i++){
            if(preorder[i] < rootVal){
                leftElems++;
            }else if(preorder[i] > rootVal){
                rightElems++;
            }
        }

        root.left = build(preorder , s + 1            , s + leftElems);
        root.right = build(preorder, s + leftElems + 1, s + leftElems + rightElems);

        return root;
    }
}