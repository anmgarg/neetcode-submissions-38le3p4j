class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int temp = map.get(c) + 1;
                if(temp > left) {
                    left = temp;
                }
            }
            map.put(c, i);
            result = Math.max(result, i-left+1);
        }
        return result;
    }
}
