class Solution {
    int[] dp1;
    int[] dp2;
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int n = nums.length;
        dp1 = new int[n];
        dp2 = new int[n];

        dp1[n-1] = nums[n-1];
        dp1[n-2] = Math.max(dp1[n-1], nums[n-1]);

        dp2[n-1] = 0;
        dp2[n-2] = nums[n-2];

        for (int i = n-3; i>=1; i--) {
            dp1[i] = Math.max(dp1[i+1], nums[i] + dp1[i+2]);
        }
        dp1[0] = dp1[1];

        for (int i = n-3; i>=0; i--) {
            dp2[i] = Math.max(dp2[i+1], nums[i] + dp2[i+2]);
        }

        return Math.max(dp1[0], dp2[0]);

    }
}
