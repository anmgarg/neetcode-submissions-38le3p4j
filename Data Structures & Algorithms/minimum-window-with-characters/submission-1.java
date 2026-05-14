class Solution {
    public String minWindow(String s, String t) {

        if(t.equals("")) {
            return "";
        }

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (Character c: t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int have = 0;
        int need = countT.size();
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        int length = Integer.MAX_VALUE;

        for (int r = 0; r < s.length(); r++) {
            char current = s.charAt(r);
            window.put(current, window.getOrDefault(current, 0) + 1);

            if(null != countT.get(current) && countT.get(current) == window.get(current)) {
                have++;
            }

            while (have == need) {
                
                if ((r-left+1) < length) {
                    length = r-left+1;
                    res[0] = left;
                    res[1] = r;
                }
                char leftWindowChar = s.charAt(left);
                window.put(leftWindowChar, window.get(leftWindowChar) - 1);
                if (countT.get(leftWindowChar) != null && window.get(leftWindowChar) < countT.get(leftWindowChar)) {
                    have--;
                }
                left++;
                
            }

        }
        
        return length == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
