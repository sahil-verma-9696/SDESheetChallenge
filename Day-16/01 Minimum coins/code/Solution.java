class Solution {
    public int coinChange(int[] coins, int amount) {

        int ans = -1;

        // ans = recursion(0, amount, coins);

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        ans = memo(amount, coins, dp);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int recursion(int i, int amount, int[] coins) {

        if (amount < 0)
            return Integer.MAX_VALUE;
        if (amount == 0)
            return i;

        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int possibleCoin = recursion(i + 1, amount - coin, coins);

            min = Math.min(possibleCoin, min);
        }

        return min;
    }

    private int memo(int amount, int[] coins, int[] dp) {

        if (amount < 0)
            return Integer.MAX_VALUE;

        if (amount == 0)
            return 0;

        if (dp[amount] != -1)
            return dp[amount];

        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int res = memo(amount - coin, coins, dp);

            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, 1 + res);
            }
        }

        return dp[amount] = min;
    }
}