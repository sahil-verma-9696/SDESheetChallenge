class Solution {
    public int inOrderSuccessor(Node root, Node k) {
        // code here
        
        int successor = -1;
        
         while (root != null) {
            // when p is greater or equal, move right
            if (k.data >= root.data) {
                root = root.right;
            }
            // otherwise update successor and move left
            else {
                successor = root.data;
                root = root.left;
            }
        }
        
        return successor;
        
    }
    
    
}