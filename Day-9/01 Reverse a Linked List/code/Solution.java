
class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {

    public ListNode reverseList(ListNode head) {

        // Case 
        if (head == null) {
            return head;
        }

        if (head.next == null) {
            return head;
        }

        ListNode P1 = null;
        ListNode P2 = head.next;

        while (P2 != null) {
            head.next = P1;

            P1 = head;
            head = P2;
            P2 = P2.next;
        }

        head.next = P1;

        return head;
    }
}
