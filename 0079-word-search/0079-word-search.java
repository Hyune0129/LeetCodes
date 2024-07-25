class Solution {
    // directions
    int[] dr = { -1, 1, 0, 0 };
    int[] dc = { 0, 0, -1, 1 };

    int m, n;
    String word;
    char[][] board;
    boolean[][] isVisited;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        this.board = board;
        this.word = word;
        isVisited = new boolean[m][n];
        char firstLetter = word.charAt(0);
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == firstLetter) {
                    isVisited[row][col] = true;
                    if (isInWord(row, col, 1)) {
                        return true;
                    }
                    isVisited[row][col] = false;
                }
            }
        }
        return false;
    }

    private boolean isInWord(int row, int col, int wordIndex) {
        if (wordIndex >= word.length()) {
            return true;
        }
        char c = word.charAt(wordIndex);
        boolean ans = false;
        // System.out.println(c + " " + wordIndex);
        for (int d = 0; d < 4; d++) {
            int nr = row + dr[d];
            int nc = col + dc[d];
            if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                continue;
            }
            if(isVisited[nr][nc]) {
                continue;
            }
            if (c == board[nr][nc]) {
                isVisited[nr][nc] = true;
                ans = ans | isInWord(nr, nc, wordIndex + 1);
                isVisited[nr][nc] = false;
            }
        }
        return ans;
    }

}