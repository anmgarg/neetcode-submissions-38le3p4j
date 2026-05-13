class Solution {
    public String minWindow(String s, String t) {
        if (t.equals("")) {
            return "";
        }
        Map<Character, Integer> countT = new HashMap<>();
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        int resultLength = Integer.MAX_VALUE;
        for (Character c : t.toCharArray())  {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < s.length(); i++) {
            Map<Character, Integer> countS = new HashMap<>();
            for(int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                countS.put(c, countS.getOrDefault(c, 0) + 1);

                boolean flag = true;
                for(Character tc : countT.keySet()) {
                    if(countT.get(tc) > countS.getOrDefault(tc, 0)) {
                        flag = false;
                        break;
                    }
                }

                if (flag && (j-i+1) < resultLength) {
                    result[0] = i;
                    result[1] = j;
                    resultLength = j-i+1;
                    break;
                }
            }
        }

        return resultLength == Integer.MAX_VALUE ? "" : s.substring(result[0], result[1]+1);
    }
}
