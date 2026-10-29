class TrieNode {
    Map<Character, TrieNode> map = new HashMap<>();
    boolean endOfWord = false;
}

class Solution {
    Set<String> result = new HashSet<>();
    TrieNode node;
    int row, column;

    private void addWord(String word) {
        TrieNode current = node;
        for(char c : word.toCharArray()) {
            TrieNode temp = current.map.get(c);
            if (temp == null) {
                temp = new TrieNode();
                current.map.put(c, temp);
            }
            current = temp;
        }
        current.endOfWord = true;
    }

    public List<String> findWords(char[][] board, String[] words) {
        this.row = board.length;
        this.column = board[0].length;
        node = new TrieNode();

        for(String word: words) {
            addWord(word);
        }

        for (int i = 0; i<row; i++) {
            for (int j =0; j<column; j++) {
                
                boolean[][] visibility = new boolean[row][column];
                String tempWord = new String("");
                dfs(i,j, board, visibility, node, tempWord);
                
            }
        }
        List<String> list = new ArrayList<>(result);
        return list;
    }   

    private void dfs(int i, int j, char[][] board, boolean[][] visibility, TrieNode current, String tempWord) {
        
        if ( i < 0 || j < 0 || i >= row || j >= column || visibility[i][j]) {
            return;
        }
        TrieNode temp = current.map.get(board[i][j]);
        if (temp != null) {
            tempWord = tempWord + board[i][j];
            if (temp.endOfWord) {
                result.add(tempWord);
            }
            visibility[i][j] = true;
            dfs(i+1, j, board, visibility, temp, tempWord);
            dfs(i-1, j, board, visibility, temp, tempWord);
            dfs(i, j+1, board, visibility, temp, tempWord);
            dfs(i, j-1, board, visibility, temp, tempWord);
            visibility[i][j] = false;
        }
    }   
}
