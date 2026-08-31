class Solution {
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}


// 3,4,5,6,1,2
// 1
// left = 0
// right = 5
// mid = 2