class Solution {
    public int lengthOfLongestSubstring(String s) {       
        if(s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        int result = 1;

        int left = 0;
        int right = 1;
        
        while (right < s.length()) {  
            int index = s.indexOf(s.charAt(right), left);
            if (index != right && index > -1) {
                left = index + 1;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}
