class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> tFreq = new HashMap<>();
        for (int i =0; i<t.length(); i++) {
            char c = t.charAt(i);
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        int have = 0;
        int need = tFreq.size();
        int left = 0;
        int resultLength = Integer.MAX_VALUE;
        int[] res = { -1, -1};

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (tFreq.containsKey(c) && tFreq.get(c).equals(window.get(c))) {
                have++;
            }

            while (have == need) {
                if (right - left + 1 < resultLength) {
                    resultLength = right - left + 1;
                    res[0] = left;
                    res[1] = right;
                }
                char cleft = s.charAt(left);
                window.put(cleft, window.get(cleft) - 1);
                if (tFreq.containsKey(cleft) 
                        && window.get(cleft) < tFreq.get(cleft)) {
                    have--;
                }
                left++;
            }

        }

        return resultLength == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);

    }
}
