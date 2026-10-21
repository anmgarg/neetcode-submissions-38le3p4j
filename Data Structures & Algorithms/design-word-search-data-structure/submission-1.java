class WordDictionary {

    TrieNode trie = new TrieNode();

    public WordDictionary() {
        
    }

    public void addWord(String word) {
        TrieNode temp = trie;
        for (char c: word.toCharArray()) {
            temp.map.putIfAbsent(c, new TrieNode());
            temp = temp.map.get(c);
        }
        temp.isEnd = true;
    }

    public boolean search(String word) {
        return search(trie, word);
        
    }

    private boolean search(TrieNode node, String word) {
        TrieNode temp = node;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                boolean found = false;
                for (TrieNode t: temp.map.values()) {
                    found = search(t, word.substring(i+1, word.length()));
                    if(found) {
                        return true;
                    }
                }
                return false;
            } else {
                TrieNode current = temp.map.get(c);
                if (current==null) {
                    return false;
                } else {
                    temp = current;
                }
            }
        }
        return temp.isEnd;
    }
}

class TrieNode {
    Map<Character, TrieNode> map = new HashMap<>();
    boolean isEnd = false;
}