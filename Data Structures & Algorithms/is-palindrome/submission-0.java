class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int leftIndex = 0;
        int rightIndex = s.length() - 1;

        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && !isAlphaNum(s.charAt(leftIndex)) ) {
                leftIndex++;
            }
            while (rightIndex > leftIndex && !isAlphaNum(s.charAt(rightIndex)) ) {
                rightIndex--;
            }

            if (Character.toLowerCase(s.charAt(leftIndex)) 
                    != Character.toLowerCase(s.charAt(rightIndex))) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }

    boolean isAlphaNum(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') 
            || (c >= '0' && c <= '9');
    }
}
