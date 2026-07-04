
import java.util.*;

class Node {

    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;

    }
}

class Solution {

    class Pair {

        Node a;
        int b;

        Pair(Node a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public ArrayList<Integer> bottomView(Node root) {
        // code here
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {

            Pair top = queue.poll();

            if(!map.containsKey(top.b)) // <-- add this
            map.put(top.b, top.a.data);

            if (top.a.left != null) {
                queue.offer(new Pair(top.a.left, top.b - 1));
            }

            if (top.a.right != null) {
                queue.offer(new Pair(top.a.right, top.b + 1));
            }
        }

        ArrayList<Integer> ans = new ArrayList<>(map.values());

        return ans;
    }
}
