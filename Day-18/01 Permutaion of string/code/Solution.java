class Solution {
    public void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    public void backtrack(int[] nums, int s, List<List<Integer>> result) {

        if (s == (nums.length-1)) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }

        for (int i = s; i < nums.length; i++) {
            swap(nums, s, i);
            backtrack(nums, s + 1, result);
            swap(nums, s, i);
        }

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, 0, result);

        return result;
    }
}