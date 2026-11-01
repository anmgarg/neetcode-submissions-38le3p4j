class Solution {

    int ROWS = 0;
    int COLS = 0;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;

        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        for (int i = 0; i<ROWS; i++) {
            dfs(i, 0, pac, heights);
            dfs(i, COLS - 1, atl, heights);
        }

        for (int i = 0; i<COLS; i++) {
            dfs(0, i, pac, heights);
            dfs(ROWS - 1, i, atl, heights);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i<ROWS; i++) {
            for (int j = 0; j<COLS; j++) {
                if(pac[i][j] && atl[i][j]) {
                    result.add(List.of(i,j));
                }
            }
        }

        return result;

    }

    public void dfs(int r, int c, boolean[][] ocean, int[][] heights) {
        ocean[r][c] = true;

        if (r + 1 < ROWS && !ocean[r+1][c] && heights[r+1][c] >= heights[r][c]) {
            dfs(r+1, c, ocean, heights);
        }

        if (r - 1 >= 0 && !ocean[r-1][c] && heights[r-1][c] >= heights[r][c]) {
            dfs(r-1, c, ocean, heights);
        }

        if (c + 1 < COLS && !ocean[r][c + 1] && heights[r][c+1] >= heights[r][c]) {
            dfs(r, c+1, ocean, heights);
        }

        if (c - 1 >= 0 && !ocean[r][c - 1] && heights[r][c-1] >= heights[r][c]) {
            dfs(r, c-1, ocean, heights);
        }
    }



}
