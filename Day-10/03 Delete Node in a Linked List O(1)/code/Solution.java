/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // Delete in O(1)


        // first overide the value of node with next node value
        node.val = node.next.val;

        // now delete the next node
        node.next = node.next.next;
        
    }
}