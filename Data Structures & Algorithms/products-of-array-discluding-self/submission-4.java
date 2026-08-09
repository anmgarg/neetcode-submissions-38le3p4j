class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        for (int i =0; i<nums.length; i++) {
            if(i==0) {
                left[0] = 1;
            }
            else {
                left[i] = nums[i-1]*left[i-1];
            }
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
