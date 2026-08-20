class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0;
        HashSet<Character> set = new HashSet<>();
        for(char c: s.toCharArray()) {
            set.add(c);
        }

        for (Character c: set) {
            int count = 0;
            int left = 0;

            for(int right = 0; right < s.length(); right++) {
                if (s.charAt(right) == c) {
                    count++;
                }

                if (right - left + 1 - count <= k) {
                    result = Math.max(right - left + 1, result);
                } else {
                    if(s.charAt(left) == c) {
                        count--;
                    }
                    left++;
                }
                
            }
        }
        return result;
    }
}
