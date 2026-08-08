class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str: strs) {
            char[] strChars = str.toCharArray();
            Arrays.sort(strChars);
            String sortedStr = new String(strChars);
            map.putIfAbsent(sortedStr, new ArrayList<>());
            map.get(sortedStr).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
