class Solution {
    public int lengthOfLongestSubstring(String s) {
        /**
        zxyzxyz                    

        1. start counting till you find repeat character, keep updating the maxlength so far
        2. When you find repeat character, find the index and strip from before
        */    
        int startIndex = 0;
        int maxLength = 0;
        String subs = "";
        for(int i=0; i<s.length(); i++) {
            String temp = String.valueOf(s.charAt(i));
            if(subs.contains(temp)) {
                subs = subs.substring(subs.indexOf(s.charAt(i)) + 1) + temp;
            } else {
                subs = subs + String.valueOf(s.charAt(i));
                maxLength = Math.max(maxLength, subs.length());
            }
        }

        return maxLength;


    }
}
