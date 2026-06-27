import java.util.*;

class Solution {

    class Node{
        int item;
        int idx;

        Node(int item, int idx){
            this.item = item;
            this.idx = idx;
        }
    }

    public int largestRectangleArea(int[] heights) {
        int[] nxtSmallers = getSmaller(heights);
        int[] prvSmallers = getSmaller(heights, true);

        int n = heights.length;

        int maxArea = 0;

        for(int i=0; i<n; i++){

            int nxtSmaller = nxtSmallers[i]  == -1 ? n : nxtSmallers[i];
            int prevSmaller = prvSmallers[i];



            int width = nxtSmaller - prevSmaller - 1;

            int height = heights[i];

            int area = width * height;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
        
    }

    private int[] getSmaller(int[] a){
        return getSmaller(a, false);
    }

    private int[] getSmaller(int[] arr, boolean prev){
        int n = arr.length;
        int[] res = new int[n];

        Stack<Node> stk = new Stack<>();

        int i = prev ? 0 : n - 1;

        while(prev ? i<n : i>=0){
            while(!stk.isEmpty() && stk.peek().item >= arr[i])
            stk.pop();

            int nxtSmall = stk.isEmpty() ? -1 : stk.peek().idx;

            res[i] = nxtSmall;

            stk.push(new Node(arr[i], i));

            if(prev) i++;
            else i--;
        }

        return res;
    }
}