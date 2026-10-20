class PrefixTree {

    TrieNode trieNode = null;

    public PrefixTree() {
        trieNode = new TrieNode();     
    }

    public void insert(String word) {
        TrieNode temp = trieNode;
        for (char c: word.toCharArray()) {
            TrieNode node = temp.map.get(c);
            if (node == null) {
                TrieNode cLink = new TrieNode();
                temp.map.put(c, cLink);
                temp = cLink;
            } else {
                temp = node;
            }
        }
        temp.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode temp = trieNode;
        for (char c: word.toCharArray()) {
            TrieNode cNode = temp.map.get(c);
            if(cNode == null) {
                return false;
            } else {
                temp = cNode;
            }
        }
        return temp.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode temp = trieNode;
        for (char c: prefix.toCharArray()) {
            TrieNode cNode = temp.map.get(c);
            if (cNode == null) {
                return false;
            } else {
                temp = cNode;
            }
        }
        return true;
    }
}


class TrieNode {
    HashMap<Character, TrieNode> map = new HashMap<>();
    boolean endOfWord = false;
}