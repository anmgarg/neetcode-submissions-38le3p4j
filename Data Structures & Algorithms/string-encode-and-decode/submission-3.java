class Solution {

    public String encode(List<String> strs) {
        if (strs.size() == 0) {
            return null;
        }
        StringBuilder result = new StringBuilder("");
        for(String str: strs) {
            result.append(str.length());
            result.append("#");
            result.append(str);
        }
        return result.toString();

    }

    public List<String> decode(String str) {
        if (null == str) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        if (str.equals("")) {
            result.add("");
            return result;
        }

        String encodedInput = str;
        int i = 0;
        while(i < encodedInput.length()) {
            int index = encodedInput.indexOf("#", i);
            int length = Integer.valueOf(encodedInput.substring(i, index));
            result.add(encodedInput.substring(index + 1, index + 1 + length));
            i = index + 1 + length;
        }
        return result;
    }
}
