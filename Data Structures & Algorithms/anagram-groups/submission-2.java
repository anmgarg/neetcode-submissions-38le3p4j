class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String str: strs) {
            int[] alphabets = new int[26];
            for (char c: str.toCharArray()) {
                alphabets[c - 'a']++;
            }
            String key = Arrays.toString(alphabets);
            result.putIfAbsent(key, new ArrayList<>());
            result.get(key).add(str);
        }
        return new ArrayList<>(result.values());   
    }
}
