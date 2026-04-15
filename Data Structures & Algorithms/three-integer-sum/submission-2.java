class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i< nums.length; i++) {
            if (nums[i] > 0) {
                break;
            } 
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int target = 0 - nums[i];
            int j = i+1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    result.add(triplet);
                    j++;
                    k--;
                    while(j<k && nums[j] == nums[j-1])
                    {
                        j++;
                    }
                }
                else if(nums[j] + nums[k] < target) {
                    j++;
                }
                else {
                    k--;
                }
            }
        }


        return result;
    }
}
