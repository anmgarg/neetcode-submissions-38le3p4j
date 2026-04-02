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
        if(s1.length() != s2.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++;
            arr[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if(arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
