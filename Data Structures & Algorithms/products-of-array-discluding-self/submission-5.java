class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i<nums.length; i++) {
            left[i] = nums[i-1]*left[i-1];
        }
        int postfix = 1;
        for (int i = nums.length - 1; i>=0; i--) {
            if (i == nums.length - 1) {
                postfix = 1;
            } else {
                postfix = postfix*nums[i+1];
            }
            left[i] = left[i]*postfix;
        }
        

        return left;    

    }
}  
