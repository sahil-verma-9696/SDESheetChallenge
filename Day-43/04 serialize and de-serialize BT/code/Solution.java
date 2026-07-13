/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
      // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) {
            return "#";
        }

        StringBuilder payload = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode top = queue.poll();

            if (top == null) {
                payload.append("#,");
                continue;
            }

            payload.append(top.val).append(",");

            queue.offer(top.left);
            queue.offer(top.right);
        }

        return payload.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null || data.equals("#")) {
            return null;
        }

        String[] nodes = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty() && i < nodes.length) {

            TreeNode parent = queue.poll();

            // Build left child
            if (!nodes[i].equals("#")) {
                parent.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(parent.left);
            }

            i++;

            // Build right child
            if (i < nodes.length && !nodes[i].equals("#")) {
                parent.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(parent.right);
            }

            i++;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));


/**
1 2 3 # # 4 5 # # # #
0 1 2 3 4 5 6 7 8 9 10
 */