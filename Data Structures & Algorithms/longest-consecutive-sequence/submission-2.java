class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int longest = 1;
        int count = 1;
        Set<Integer> set = new TreeSet<>();

        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }

        Integer[] sortedNums = set.toArray(new Integer[0]);

        for(int i = 1; i<sortedNums.length; i++) {
            if (sortedNums[i] == sortedNums[i-1] + 1) {
                count++;
                if  (count > longest) {
                    longest = count;
                }
            } else {
                count = 1;
            }
        }
        return longest;
    }
}
