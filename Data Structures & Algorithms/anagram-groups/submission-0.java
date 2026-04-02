class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        for(String str: strs) {
            boolean found = false;
            for (List<String> list: result) {
                if (isAnagram(str, list.get(0))) {
                    list.add(str);
                    found = true;
                    break;
                }
            }
            if(!found) {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                result.add(newList);
            }
        }
        return result;   
    }

    public boolean isAnagram(String s1, String s2) {
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();

        Arrays.sort(s1Chars);
        Arrays.sort(s2Chars);

        return Arrays.equals(s1Chars, s2Chars);
    }
}
