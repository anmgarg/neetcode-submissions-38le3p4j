class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        Arrays.sort(nums);
        int prev = nums[0];
        int currentCount = 1;
        int maxCount = 1;
        for (int num : nums) {
            if (num == prev) {
                continue;
            } else if (num == prev + 1) {
                prev = num;
                currentCount++;
                if (maxCount < currentCount) {
                    maxCount = currentCount;
                }
            } else {
                prev = num;
                currentCount = 1;
            }
        }
        return maxCount;
    }
}
