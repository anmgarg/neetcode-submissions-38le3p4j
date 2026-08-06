class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        for(char c: t.toCharArray()) {
            Integer freq = map.get(c);
            if (freq == null) {
                return false;
            }
            if (freq > 1) {
                map.put(c, freq - 1);
            } else {
                map.remove(c);
            } 
        }
        return map.size() == 0;
    }
}
