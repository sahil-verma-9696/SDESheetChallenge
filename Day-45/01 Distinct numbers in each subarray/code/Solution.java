class Solution {
    /**
     * Finds the number of distinct integers in all contiguous subarrays of size k.
     * Uses a sliding window approach with a frequency map to track distinct elements.
     *
     * @param nums the input array of integers
     * @param k the size of the sliding window
     * @return an array where ans[i] represents the number of distinct integers
     *         in the subarray nums[i..i+k-1]
     */
    public int[] distinctNumbers(int[] nums, int k) {
        // HashMap to store the frequency of each number in the current window
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Initialize the first window of size k
        for (int i = 0; i < k; i++) {
            // Add each element to the frequency map, incrementing its count
            frequencyMap.merge(nums[i], 1, Integer::sum);
        }

        int arrayLength = nums.length;
        // Result array to store the count of distinct numbers for each window
        int[] result = new int[arrayLength - k + 1];

        // Store the distinct count for the first window
        result[0] = frequencyMap.size();

        // Slide the window through the rest of the array
        for (int i = k; i < arrayLength; i++) {
            // Add the new element entering the window
            frequencyMap.merge(nums[i], 1, Integer::sum);

            // Remove the element leaving the window
            // If the count becomes 0, remove the element from the map entirely
            if (frequencyMap.merge(nums[i - k], -1, Integer::sum) == 0) {
                frequencyMap.remove(nums[i - k]);
            }

            // Store the count of distinct elements in the current window
            result[i - k + 1] = frequencyMap.size();
        }

        return result;
    }
}
