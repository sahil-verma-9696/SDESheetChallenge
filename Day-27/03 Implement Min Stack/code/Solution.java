import java.util.*;

class MinStack {

    class Pair {
        int num;
        int min;

        Pair(int num, int min) {
            this.num = num;
            this.min = min;
        }
    }

    Stack<Pair> stk;

    int min = Integer.MAX_VALUE;

    public MinStack() {
        stk = new Stack<>();
    }

    public void push(int value) {

        this.min = Math.min(value, min);

        stk.push(new Pair(value, min));
    }

    public void pop() {
        stk.pop();

        if (stk.isEmpty()) {
            min = Integer.MAX_VALUE;
        } else {
            min = stk.peek().min;
        }
    }

    public int top() {
        return stk.peek().num;
    }

    public int getMin() {
        return stk.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */