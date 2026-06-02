
class Solution {

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int p = -1;

        // Step 1: find pivot
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                p = i;
                break;
            }
        }

        // Step 2: if pivot found, swap
        // swap with slightly greator element
        if (p != -1) {
            for (int j = n - 1; j > p; j--) {
                if (nums[j] > nums[p]) {
                    swap(nums, j, p);
                    break;
                }
            }
        }

        // Step 3: reverse right part
        reverse(nums, p + 1, n - 1);

    }

    void reverse(int[] arr, int l, int r) {
        while (l < r) {
            swap(arr, l, r);
            l++;
            r--;
        }
    }

    void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
