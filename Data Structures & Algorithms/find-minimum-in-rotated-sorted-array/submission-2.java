class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int res = nums[0];

        while (left <= right) {
            if (nums[left] < nums[right]) {
                res = Math.min(res, nums[left]);
                break;
            }

            int mid = left + (right-left)/2;
            res = Math.min(res, nums[mid]);
            if(nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;        
    }
}

// 3,4,5,6,1,2


// 3rd - 5 (<6 and >4)
// 4th - 6 



// 4,5,6,7


// 4,5,0,1,2,3

// 3rd - 0
// 
