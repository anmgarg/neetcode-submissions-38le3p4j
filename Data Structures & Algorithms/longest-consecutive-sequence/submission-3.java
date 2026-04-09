class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 1;
        for (int num : nums) {
            int count = 1;
            if (numSet.contains(num-1)) {
                continue;
            }
            while (numSet.contains(num + 1)) {
                count++;
                if (count > longest) {
                    longest = count;
                }
                num = num + 1;
            }
        }

        return longest;
    }
}
