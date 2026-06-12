/*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/
class Solution {
    public Node flatten(Node root) {
        // code here
        
        Node ans = null;
        
        Node lst1 = null;
        Node lst2 = null;
        
        while(root != null){
            
            lst2 = root;
            
            lst1 = mergeTwoLists(lst1, lst2);
            
            if(ans == null) ans = lst1;
            
            
            root = root.next;
        }
        
        
        return ans;
        
    }
    
    public Node mergeTwoLists(Node list1, Node list2) {

        Node ans = null;
        Node anshead = null;

        while (list1 != null && list2 != null) {

            if (list1.data == list2.data) {

                if (ans == null) {
                    ans = list1;
                    anshead = ans;
                    list1 = list1.bottom;

                    ans.bottom = list2;
                    list2 = list2.bottom;

                    ans = ans.bottom;
                } else {
                    ans.bottom = list1;
                    list1 = list1.bottom;

                    ans = ans.bottom;

                    ans.bottom = list2;
                    list2 = list2.bottom;

                    ans = ans.bottom;
                }

            } else if (list1.data < list2.data) {
                if (ans == null) {
                    ans = list1;
                    anshead = ans;

                    list1 = list1.bottom;

                } else {
                    ans.bottom = list1;
                    list1 = list1.bottom;
                    ans = ans.bottom;
                }
            } else {
                if (ans == null) {
                    ans = list2;
                    anshead = ans;
                    list2 = list2.bottom;
                } else {
                    ans.bottom = list2;
                    list2 = list2.bottom;
                    ans = ans.bottom;
                }
            }
        }

        if (list1 != null) {
            if (ans == null) {
                ans = list1;
                anshead = ans;
            } else {
                ans.bottom = list1;
            }
        }

        if (list2 != null) {
            if (ans == null) {
                ans = list2;
                anshead = ans;
            } else {
                ans.bottom = list2;
            }
        }

        return anshead;

    }
}