class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                Character popped = stack.pop();
                if ((c == ')' && popped != '(') || (c == '}' && popped != '{')
                    || (c == ']' && popped != '[')) {
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }
}
