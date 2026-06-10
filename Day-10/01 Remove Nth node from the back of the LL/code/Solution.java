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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Optimal way
        // We using two-pointer fast and slow.
        // fist create a gap of `n` and then 
        // move fast and slow till fast not equal to null.

         // Create a dummy node before head to handle edge cases
        ListNode dummy = new ListNode(0, head);

        // Initialize slow and fast pointers at dummy
        ListNode slow = dummy;
        ListNode fast = dummy;

        // Move fast pointer N+1 steps ahead to create a gap
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Slow is now at node before target → delete target node
        slow.next = slow.next.next;

        // Return updated head
        return dummy.next;
    }
}/**
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Optimal way
        // We using two-pointer fast and slow.
        // fist create a gap of `n` and then 
        // move fast and slow till fast not equal to null.

         // Create a dummy node before head to handle edge cases
        ListNode dummy = new ListNode(0, head);

        // Initialize slow and fast pointers at dummy
        ListNode slow = dummy;
        ListNode fast = dummy;

        // Move fast pointer N+1 steps ahead to create a gap
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Slow is now at node before target → delete target node
        slow.next = slow.next.next;

        // Return updated head
        return dummy.next;
    }
}