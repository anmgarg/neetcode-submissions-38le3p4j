class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            char[] row = board[i];
            for (int j = 0; j < row.length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    boolean result = dfs(i - 1, j, 1, word, board, visited)
                        || dfs(i + 1, j, 1, word, board, visited)
                        || dfs(i, j - 1, 1, word, board, visited)
                        || dfs(i, j + 1, 1, word, board, visited);
                    if (result) {
                        return true;
                    }
                }
                visited[i][j] = false;
            }
        }
        return false;
    }

    public boolean dfs(
        int i, int j, int pointer, String word, char[][] board, boolean[][] visited) {
        if (pointer >= word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
            || board[i][j] != word.charAt(pointer) || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean result =
            dfs(i - 1, j, pointer + 1, word, board, visited) ||
            dfs(i + 1, j, pointer + 1, word, board, visited) ||
            dfs(i, j + 1, pointer + 1, word, board, visited) ||
            dfs(i, j - 1, pointer + 1, word, board, visited);
        
        if (result) {
            return true;
        } else {
            visited[i][j] = false;
            return false;
        }
    }
}
