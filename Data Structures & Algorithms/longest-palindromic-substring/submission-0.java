class Solution {
    public String longestPalindrome(String s) {
        int resultLen = 0;
        String result = "";

        for (int i = 0; i<s.length(); i++) {
            int l = i, r = i;

            while(l>=0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r-l+1 > resultLen) {
                    resultLen = r-l+1;
                    result = s.substring(l, r+1);
                }
                l--;
                r++;
            }
            l=i;
            r=i+1;

            while(l>=0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r-l+1 > resultLen) {
                    resultLen = r-l+1;
                    result = s.substring(l, r+1);
                }
                l--;
                r++;
            }
        }
        return result;
    }
}
