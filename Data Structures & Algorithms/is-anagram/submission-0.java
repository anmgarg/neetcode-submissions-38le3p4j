class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        Arrays.sort(sArr);

        char[] tArr = t.toCharArray();
        Arrays.sort(tArr);

        return String.valueOf(sArr).equals(String.valueOf(tArr));
    }
}
