import java.util.*;

class Solution {
    
    static class Node{  // Node structure for Doubly Linked List
        int key, val;
        Node next, prev;
        Node(int key, int val){
            this.key=key;
            this.val=val;
        }
    }
    
    static HashMap<Integer, Node> map = new HashMap<>();   // to store -> (key, node)
    static Node head = new Node(0, 0);  // Dummy head and tail nodes to simplify insert/remove operations
    static Node tail = new Node(0, 0);
    static int capacity;

    Solution(int cap) {  // constructor for LRU
        map.clear();
        this.capacity=cap;
        head.next=tail;   //  Link Head -----> Tail
        tail.prev=head;   //  and  Head <----- Tail
    }

    public static int get(int key) {
        if(map.containsKey(key)){  // If key exists
            Node node = map.get(key);  // Get the node
            remove(node);   // Remove it from current position in DLL
            insert(node);   // Insert it right after head (to mark as most recently used)
            return map.get(key).val;   // Return value
        }
        return -1;
    }

        
    public static void put(int key, int value) {
        if(map.containsKey(key)){   // If key already exists
            remove(map.get(key));  // Remove old node from DLL and map
        }
        if(map.size()==capacity){    // If cache is full
            remove(tail.prev);   // Remove least recently used node (the node before tail)
        }
        insert(new Node(key, value));  // Insert new node as most recently used
    }
    
    private static void insert(Node node){   // Insert node right after head (at most recently used position)
        map.put(node.key, node);
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }
    
    private static void remove(Node node){   // Remove a node from DLL and map
        map.remove(node.key);
        node.next.prev=node.prev;
        node.prev.next=node.next;
    }
}