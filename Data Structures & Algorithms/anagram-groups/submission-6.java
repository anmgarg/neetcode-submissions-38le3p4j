class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str: strs) {
            int[] record = new int[26];
            for (char c: str.toCharArray()) {
                record[c - 'a']++;
            }
            String recordStr = Arrays.toString(record);
            map.putIfAbsent(recordStr, new ArrayList<>());
            map.get(recordStr).add(str);
        }

        return new ArrayList<>(map.values());
    
    }
}
