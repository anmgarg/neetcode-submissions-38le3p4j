class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int result = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                while (set.contains(c)) {
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            set.add(c);
            result = Math.max(result, i - left + 1);
        }
        return result;
    }
}
