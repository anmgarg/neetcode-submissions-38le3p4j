class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> countt = new HashMap<>();
        HashMap<Character, Integer> countss = new HashMap<>();

        for (char c: t.toCharArray()) {
            countt.put(c, countt.getOrDefault(c, 0) + 1);
        }
        int res[] = {-1, -1};
        int resLength = Integer.MAX_VALUE;
        int need = countt.size();
        int have = 0;
        int left = 0;

        for (int right = 0;  right < s.length(); right++) {
            char r = s.charAt(right);
            countss.put(r, countss.getOrDefault(r, 0) + 1);
            if (countt.get(r) != null && countt.get(r).equals(countss.get(r))) {
                have++;
            }

            while (have == need) {
                if (right - left + 1 < resLength) {
                    resLength = right - left + 1;
                    res[0] = left;
                    res[1] = right;
                }
                char l = s.charAt(left);
                countss.put(l, countss.get(l) - 1);
                if (countt.get(l) != null && countss.get(l) < countt.get(l)) {
                    have--;
                }
                left++;
            }
        }
        return resLength == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
