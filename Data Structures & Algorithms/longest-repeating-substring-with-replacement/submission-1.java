class Solution {
    public int characterReplacement(String s, int k) {
        int result = 1;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxFreq = 0;
        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right); 
            map.put(c, map.getOrDefault(c , 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));
            while ((right - left + 1) - maxFreq > k) {
                char cl = s.charAt(left);
                map.put(cl, map.get(cl) - 1);
                left++;
            }

            result = Math.max((right - left + 1), result);
                
        }
        return result;
    }
}
