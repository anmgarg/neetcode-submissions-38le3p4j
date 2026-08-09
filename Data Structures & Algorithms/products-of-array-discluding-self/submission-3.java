class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        for (int i =0; i<nums.length; i++) {
            if(i==0) {
                left[0] = 1;
            }
            else {
                left[i] = nums[i-1]*left[i-1];
            }
        }
        for (int i = nums.length - 1; i>=0; i--) {
            if (i == nums.length - 1) {
                right[nums.length - 1] = 1;
            }
            else {
                right[i] = nums[i+1]*right[i+1];
            }
        }
        int[] result = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            result[i] = left[i]*right[i];
        }

        return result;    

    }
}  
