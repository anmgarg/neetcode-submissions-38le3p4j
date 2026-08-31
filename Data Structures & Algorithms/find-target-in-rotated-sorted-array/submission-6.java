class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left)/2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] <= nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;    
    }
}


/* 4,5,6,7,0,1,2
target = 0


1st
Before
left = 0
nums[left] = 4
right = 6
nums[right] = 2

After
mid = 3
nums[mid] = 7
left = 4


2nd
Before
left = 4
nums[left] = 0
right = 6
nums[right] = 2
mid = 5
nums[mid] = 1

After
right = 5


3rd
Before
left = 4
nums[left] = 0
right = 5
nums[right] = 1
mid = 4

After





*/
