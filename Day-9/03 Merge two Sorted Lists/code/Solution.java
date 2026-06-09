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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode ans = null;
        ListNode anshead = null;

        while (list1 != null && list2 != null) {

            if (list1.val == list2.val) {

                if (ans == null) {
                    ans = list1;
                    anshead = ans;
                    list1 = list1.next;

                    ans.next = list2;
                    list2 = list2.next;

                    ans = ans.next;
                } else {
                    ans.next = list1;
                    list1 = list1.next;

                    ans = ans.next;

                    ans.next = list2;
                    list2 = list2.next;

                    ans = ans.next;
                }

            } else if (list1.val < list2.val) {
                if (ans == null) {
                    ans = list1;
                    anshead = ans;

                    list1 = list1.next;

                } else {
                    ans.next = list1;
                    list1 = list1.next;
                    ans = ans.next;
                }
            } else {
                if (ans == null) {
                    ans = list2;
                    anshead = ans;
                    list2 = list2.next;
                } else {
                    ans.next = list2;
                    list2 = list2.next;
                    ans = ans.next;
                }
            }
        }

        if (list1 != null) {
            if (ans == null) {
                ans = list1;
                anshead = ans;
            } else {
                ans.next = list1;
            }
        }

        if (list2 != null) {
            if (ans == null) {
                ans = list2;
                anshead = ans;
            } else {
                ans.next = list2;
            }
        }

        return anshead;

    }
}