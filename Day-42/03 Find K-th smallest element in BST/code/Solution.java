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
    public int kthSmallest(TreeNode root, int k) {
        better(root, k);

        return this.ans;
    }

    int c = 0;
    int ans = -1;

    // O(k) O(1)
    private int better(TreeNode root, int k){

        if(root == null) return -1;


        if(this.ans == -1)
        better(root.left, k);

        this.c++;

        System.out.println(root.val + " " + this.c);
        if(this.c == k && this.ans == -1){
            this.ans = root.val;
            return this.ans;
        }

        

        if(this.ans == -1)
        better(root.right, k);

        return this.ans;
    }
}

// Brute
/**
- Store the inorder in an array
- then return k-1 th index element.

time = O(n) 
space = O(n)
 */


 // Best
 /**
 
 - do inorder with a counter k and k--
 - when k is 0 that particular is my ans;

 time = O(k)
 space = O(1)
  */



  // Optimal

/**

 */