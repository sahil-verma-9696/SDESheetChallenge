
class Solution {

    public void sortColors(int[] nums) {
        int n = nums.length;

        int left = 0;
        int mid = 0;
        int right = n - 1;

        while (mid <= right) {
            if (nums[mid] == 0) {
                swap(nums, left, mid);
                mid++;
                left++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                swap(nums, right, mid);
                right--;
            }
        }
    }

    public void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
