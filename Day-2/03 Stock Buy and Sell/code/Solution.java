class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] nextMaxs = new int[n];
        int max = 0;

        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(prices[i], max);
            nextMaxs[i] = max;
        }

        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            int dif = nextMaxs[i] - prices[i];

            maxProfit = Math.max(maxProfit, dif);
        }

        return maxProfit;
    }
}