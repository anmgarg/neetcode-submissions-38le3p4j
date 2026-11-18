class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        int result = 0;
        for (int num : nums) {
            if(!set.contains(num-1)) {
                int temp = 1;
                while (set.contains(num + temp)) {
                    temp++;
                }
                result = Math.max(temp, result);
            }
        }
        return result;
    }
}
