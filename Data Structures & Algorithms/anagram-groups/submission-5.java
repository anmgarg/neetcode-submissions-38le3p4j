class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str: strs) {
            int[] freq = new int[26];
            for (char c: str.toCharArray()) {
                freq[c-'a']++;
            }
            String tuple = Arrays.toString(freq);
            map.putIfAbsent(tuple, new ArrayList<>());
            map.get(tuple).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
