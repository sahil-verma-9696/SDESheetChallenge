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
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null)
            return head;

        int n = 0;

        ListNode t = head;
        while (t != null) {
            t = t.next;
            n++;
        }

        k = n == 0 ? k : k % n;

        if (k == 0 || k == n)
            return head;

        ListNode revList = reverse(head);

        // Break list in two parts
        ListNode lst1 = revList;

        while (k-- > 1) {
            revList = revList.next;
        }

        ListNode lst2 = revList.next;
        revList.next = null;

        ListNode revLst1 = reverse(lst1);
        ListNode revLst2 = reverse(lst2);

        lst1.next = revLst2;

        return revLst1;
    }

    private ListNode reverse(ListNode head) {
        if (head == null)
            return null;

        if (head.next == null)
            return head;

        ListNode h = reverse(head.next);

        ListNode lastNode = head.next;

        lastNode.next = head;

        head.next = null;

        return h;
    }
}

// 1, 2, 3, 4, 5

// 5, 4, 3, 2, 1 <-- Complete Reverse
// 4, 5, 3, 2, 1 <-- [0, k-1] Reverse
// 4, 5, 1, 2, 3 <-- [k, n-1] Reverse