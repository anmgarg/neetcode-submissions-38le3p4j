class Solution {
    int[] dp;
    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        if(nums.length == 2) {
            int max = Math.max(nums[0], nums[1]);
            return max;
        }

        int totalHouses = nums.length;
        dp = new int[totalHouses];
        dp[totalHouses - 1] = nums[totalHouses-1];
        dp[totalHouses - 2] = Math.max(nums[totalHouses-2], dp[totalHouses - 1]);

        for (int i = totalHouses - 3; i>=0; i--) {
            dp[i] = Math.max(nums[i] + dp[i+2], dp[i+1]);
        }
        return dp[0];
    }
}
