
import java.util.*;

class Solution {

    class Pair {

        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    List<Integer> lst;
    Stack<Pair> stk;
    int i;

    public Solution() {
        lst = new ArrayList<>();
        stk = new Stack<>();
        this.i = 0;
    }

    public int next(int price) {
        lst.add(price);

        while (!stk.isEmpty() && stk.peek().first <= price) {
            stk.pop();
        }

        Pair prevGreator = stk.isEmpty() ? null : stk.peek();

        stk.push(new Pair(price, i));

        int ans = prevGreator == null ? i + 1 : i - prevGreator.second;

        i = i + 1;

        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
