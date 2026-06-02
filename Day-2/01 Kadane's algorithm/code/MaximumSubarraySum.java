
class MaximumSubarraySum {

    /**
     * Kadane's algorithm
     * ---
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public static int solve(int[] arr) {
        int n = arr.length;

        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            if (currentSum < 0) {
                currentSum = 0;
            }

            currentSum += arr[i];

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
