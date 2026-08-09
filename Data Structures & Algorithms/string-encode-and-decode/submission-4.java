class Solution {

    public String encode(List<String> strs) {
        String encoded = "";
        for(String str: strs) {
            encoded = encoded + str.length() + "#" + str;
        }
        return encoded;
    }

    public List<String> decode(String str) {

        String input = str;
        List<String> strs = new ArrayList<>();

        while (!input.isEmpty()) {
            int hashIndex = input.indexOf("#");
            String lengthInString = input.substring(0, hashIndex);
            int length = Integer.valueOf(lengthInString);
            int start = lengthInString.length() + 1;
            int end = start + length;
            strs.add(input.substring(start, end));
            input = input.substring(end);
        }

        return strs;

    }
}
