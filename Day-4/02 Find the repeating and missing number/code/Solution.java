class Solution {

    int[] findTwoElement(int arr[]) {

        // return xorSol(arr);

        return mathSol(arr);
    }

    // XOR Solution
    // Time: O(n)
    // Space: O(1)
    int[] xorSol(int[] arr) {

        int n = arr.length;

        // Step 1: XOR of 1..n and array elements
        int totalXor = 0;

        for (int i = 1; i <= n; i++) {
            totalXor ^= i;
        }

        for (int num : arr) {
            totalXor ^= num;
        }

        // Step 2: Find rightmost set bit
        int rightMostSetBit = totalXor & (-totalXor);

        int zeroBitClub = 0;
        int oneBitClub = 0;

        // Step 3: Divide array elements into two groups
        for (int num : arr) {
            if ((num & rightMostSetBit) != 0) {
                oneBitClub ^= num;
            } else {
                zeroBitClub ^= num;
            }
        }

        // Divide numbers 1..n into same groups
        for (int i = 1; i <= n; i++) {
            if ((i & rightMostSetBit) != 0) {
                oneBitClub ^= i;
            } else {
                zeroBitClub ^= i;
            }
        }

        // Step 4: Determine which is repeating
        int countZero = 0;

        for (int num : arr) {
            if (num == zeroBitClub) {
                countZero++;
            }
        }

        int repeating, missing;

        if (countZero == 2) {
            repeating = zeroBitClub;
            missing = oneBitClub;
        } else {
            repeating = oneBitClub;
            missing = zeroBitClub;
        }

        return new int[] { repeating, missing };
    }

    // Mathematical Solution
    // Time: O(n)
    // Space: O(1)
    int[] mathSol(int[] arr) {

        long n = arr.length;

        // Sum of first n natural numbers
        long SN = n * (n + 1) / 2;

        // Sum of squares of first n natural numbers
        long S2N = n * (n + 1) * (2 * n + 1) / 6;

        long S = 0;
        long S2 = 0;

        for (int num : arr) {
            S += num;
            S2 += (long) num * num;
        }

        // x - y
        long val1 = S - SN;

        // x² - y²
        long val2 = S2 - S2N;

        // x + y
        val2 = val2 / val1;

        // x = repeating
        long x = (val1 + val2) / 2;

        // y = missing
        long y = x - val1;

        return new int[] { (int) x, (int) y };
    }
}