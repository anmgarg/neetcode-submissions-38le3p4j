class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;
    int target;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> current = new ArrayList<>();
        this.nums = nums;
        this.target = target;
        dfs(0, current, 0);
        return result;
    }

    void dfs(int i, List<Integer> current, int total) {
        if (total == target) {
            List<Integer> success = new ArrayList<>(current);
            result.add(success);
            return;
        } else if (total > target || i >= nums.length) {
            return;
        }
        current.add(nums[i]);
        dfs(i, current, total + nums[i]);
        current.remove(current.size() - 1);
        dfs(i+1, current, total);
    }
}
