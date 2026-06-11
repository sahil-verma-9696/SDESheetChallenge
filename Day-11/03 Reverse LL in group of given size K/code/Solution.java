/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode[] lists = breakInTwo(head, k);

        ListNode h1 = lists[0];
        ListNode h2 = lists[1];
        ListNode ans = null;

        ListNode pt = null;

        while (h2 != null) {

            ListNode[] lst = reverse(h1);

            ListNode h = lst[0];
            ListNode t = lst[1];

            if (ans == null)
                ans = h;

            if (pt != null)
                pt.next = h;

            pt = t;

            ListNode[] lsts = breakInTwo(h2, k);

            h1 = lsts[0];
            h2 = lsts[1];
        }

        if (pt != null)
            pt.next = hasKNodes(h1, k) ? reverse(h1)[0] : h1;

        return ans == null ? reverse(head)[0] : ans;

    }

    private ListNode[] reverse(ListNode head) {

        // Case 
        if (head == null)
            return new ListNode[] { null, null };

        if (head.next == null)
            return new ListNode[] { head, head };

        ListNode tail = head;

        ListNode P1 = null;
        ListNode P2 = head.next;

        while (P2 != null) {
            head.next = P1;

            P1 = head;
            head = P2;
            P2 = P2.next;
        }

        head.next = P1;

        return new ListNode[] { head, tail };
    }

    private ListNode[] breakInTwo(ListNode head, int size) {
        ListNode head1 = head;

        while (size-- > 1 && head != null)
            head = head.next;

        ListNode head2 = head == null ? null : head.next;

        if (head != null)
            head.next = null;

        return new ListNode[] { head1, head2 };
    }

    private boolean hasKNodes(ListNode head, int k) {
        while (head != null && k > 0) {
            head = head.next;
            k--;
        }
        return k == 0;
    }
}