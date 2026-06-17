class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);

        recursion(0, target, candidates, new ArrayList<>(), ans);

        return ans;
    }

    public void recursion(int idx, int target, int[] arr, List<Integer> temp, List<List<Integer>> ans) {

        if (idx == arr.length) {

            if (target == 0) {
                ans.add(new ArrayList<>(temp));
                return;
            }

            return;
        }

        // Take 
        if (arr[idx] <= target) {
            temp.add(arr[idx]);

            recursion(idx + 1, target - arr[idx], arr, temp, ans);

            temp.remove(temp.size() - 1);
        }

        int next = idx + 1;
        while (next < arr.length && arr[next] == arr[idx]) {
            next++;
        }

        // Not Take
        recursion(next, target, arr, temp, ans);
    }
}