import java.util.*;

class Solution {

    static class Node {
        int sum;
        int i;
        int j;

        Node(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A,
                                    ArrayList<Integer> B,
                                    int K) {

        int n = A.size();

        Collections.sort(A);
        Collections.sort(B);

        PriorityQueue<Node> maxHeap =
                new PriorityQueue<>(
                        (a, b) -> b.sum - a.sum
                );

        HashSet<String> visited = new HashSet<>();

        maxHeap.offer(
                new Node(
                        A.get(n - 1) + B.get(n - 1),
                        n - 1,
                        n - 1
                )
        );

        visited.add((n - 1) + "#" + (n - 1));

        ArrayList<Integer> ans = new ArrayList<>();

        while (K-- > 0) {

            Node curr = maxHeap.poll();

            ans.add(curr.sum);

            int i = curr.i;
            int j = curr.j;

            if (i - 1 >= 0 &&
                    visited.add((i - 1) + "#" + j)) {

                maxHeap.offer(
                        new Node(
                                A.get(i - 1) + B.get(j),
                                i - 1,
                                j
                        )
                );
            }

            if (j - 1 >= 0 &&
                    visited.add(i + "#" + (j - 1))) {

                maxHeap.offer(
                        new Node(
                                A.get(i) + B.get(j - 1),
                                i,
                                j - 1
                        )
                );
            }
        }

        return ans;
    }
}