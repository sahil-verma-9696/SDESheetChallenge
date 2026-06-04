class Solution {

    public int inversionCount(int[] arr) {

        // return bruteSol(arr);

        return optimalSol(arr);
    }

    // Brute Force
    // Time: O(n²)
    // Space: O(1)
    public int bruteSol(int[] arr) {

        int n = arr.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    res++;
                }
            }
        }

        return res;
    }

    // Merge Sort Solution
    // Time: O(n log n)
    // Space: O(n)
    public int optimalSol(int[] arr) {

        return divide(arr, 0, arr.length - 1);
    }

    private int divide(int[] arr, int s, int e) {

        if (s >= e) {
            return 0;
        }

        int m = s + (e - s) / 2;

        int invCount = 0;

        // Left half
        invCount += divide(arr, s, m);

        // Right half
        invCount += divide(arr, m + 1, e);

        // Merge and count cross inversions
        invCount += conquer(arr, s, m, e);

        return invCount;
    }

    private int conquer(int[] arr, int s, int m, int e) {

        int leftSize = m - s + 1;
        int rightSize = e - m;

        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        int k = s;

        for (int i = 0; i < leftSize; i++) {
            left[i] = arr[k++];
        }

        for (int i = 0; i < rightSize; i++) {
            right[i] = arr[k++];
        }

        return mergeTwoSorted(arr, s, left, right);
    }

    private int mergeTwoSorted(int[] target, int k,
                               int[] left, int[] right) {

        int i = 0;
        int j = 0;

        int n = left.length;
        int m = right.length;

        int invCount = 0;

        while (i < n && j < m) {

            if (left[i] <= right[j]) {
                target[k++] = left[i++];
            } else {
                target[k++] = right[j++];

                // Count inversions
                invCount += (n - i);
            }
        }

        while (i < n) {
            target[k++] = left[i++];
        }

        while (j < m) {
            target[k++] = right[j++];
        }

        return invCount;
    }
}