import  java.util.*;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

class Solution {

    class Pair {
        TreeNode node;
        int row;
        int col;

        Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // col -> row -> minHeap(values)
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0, 0));

        while (!queue.isEmpty()) {

            Pair curr = queue.poll();

            map.computeIfAbsent(curr.col, k -> new TreeMap<>())
               .computeIfAbsent(curr.row, k -> new PriorityQueue<>())
               .offer(curr.node.val);

            if (curr.node.left != null) {
                queue.offer(new Pair(curr.node.left, curr.row + 1, curr.col - 1));
            }

            if (curr.node.right != null) {
                queue.offer(new Pair(curr.node.right, curr.row + 1, curr.col + 1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {

            List<Integer> column = new ArrayList<>();

            for (PriorityQueue<Integer> pq : rows.values()) {

                while (!pq.isEmpty()) {
                    column.add(pq.poll());
                }
            }

            ans.add(column);
        }

        return ans;
    }
}