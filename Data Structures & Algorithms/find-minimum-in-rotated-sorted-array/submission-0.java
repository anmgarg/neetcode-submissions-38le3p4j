class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;

        int left = 0;
        int mid = nums.length/2;
        int end = nums.length - 1;

        while(end - left > 1) {
            if (nums[left] < nums[mid]) {
                min = Math.min(nums[left], min);
                left = mid + 1;
                mid = (left + end) / 2;
            } else {
                min = Math.min(nums[mid], min);
                end = mid;
                mid = (left + end) / 2;
            }
        }
        min = Math.min(nums[left], min);
        min = Math.min(nums[end], min);
        return min;
    }
}
