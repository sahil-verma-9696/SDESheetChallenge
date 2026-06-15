
import java.util.*;

class Solution {

    class Item {

        int value, weight;

        double perWeightValue;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.perWeightValue = (double) value / weight;
        }
    }

    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        int n = val.length;

        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            items[i] = new Item(val[i], wt[i]);
        }

        Arrays.sort(items, (a, b) -> Double.compare(b.perWeightValue, a.perWeightValue));

        double maxi = 0.0;

        for (int i = 0; i < n; i++) {

            // If bag full i break.
            if (capacity == 0) {
                break;
            }

            if (items[i].weight <= capacity) {
                // take the item value
                maxi += items[i].value;

                // decrease the capacity
                capacity -= items[i].weight;
            } else {
                // take the fractional value
                maxi += items[i].perWeightValue * capacity;

                capacity = 0;
            }
        }

        return Double.parseDouble(String.format("%.6f", maxi));

        // code here
    }
}
