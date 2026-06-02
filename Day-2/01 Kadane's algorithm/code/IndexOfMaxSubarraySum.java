
class IndexOfMaxSubarraySum {

    int[] solve(int[] arr) {
        int n = arr.length;

        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        int start = 0;
        int end = 0;
        int tempStart = 0;

        for (int i = 0; i < n; i++) {
            currentSum += arr[i];

            if (currentSum < 0) {
                currentSum = 0;
                tempStart = i;
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
            maxSum = Math.max(maxSum, currentSum);
        }

        return new int[]{start, end};
    }
}
