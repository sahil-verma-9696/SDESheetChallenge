import java.util.*;

class Solution {
    public void sortStack(Stack<Integer> st) {
        // code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        while(!st.isEmpty()) minHeap.offer(st.pop());
        
        
        while(!minHeap.isEmpty()) st.push(minHeap.poll());
    }
}