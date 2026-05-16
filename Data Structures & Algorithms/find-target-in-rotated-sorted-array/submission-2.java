class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1 ;

        int pivot = -1;

        // find pivot
        while (left < right) {
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        pivot = left;
        int index = -1;
        if (target >= nums[pivot] && target <=nums[nums.length - 1]) {
            index = binarySearch(nums, pivot, nums.length - 1, target);
        } else {
            index = binarySearch(nums, 0, pivot - 1, target);
        }

        return index;
    }

    public int binarySearch(int[] nums, int left,  int right, int target) {
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target) {
                return mid;
            }
            else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
