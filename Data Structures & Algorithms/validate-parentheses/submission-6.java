class Solution {
    public boolean isValid(String s) {
        Deque<Character> dq = new ArrayDeque<>();

        for(int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                dq.push(c);
            } else {
                if (dq.isEmpty()) {
                    return false;
                }
                Character p = dq.peek();
                if ((c == ')' && p == '(') ||
                    (c == ']' && p == '[') ||
                    (c == '}' && p == '{')) {
                    dq.pop();
                } else {
                    return false;
                }
            }
        }

        return dq.size() == 0;
    }
}
