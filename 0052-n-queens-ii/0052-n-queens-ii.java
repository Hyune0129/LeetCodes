class Solution {
    boolean[][] isQueen;
    boolean[] isPlaceCol;
    int n;
    int answer = 0;
    public int totalNQueens(int n) {
        isQueen = new boolean[n][n];
        isPlaceCol = new boolean[n];
        this.n = n;
        solve(0);
        return answer;
    }

    private void solve(int row) {
        if(row == n) {
            answer++;
            return;
        }
        for(int i=0; i<n; i++) {
            if(isPlaceCol[i] || !canPlace(row, i)) {
                continue;
            }
            isPlaceCol[i] = true;
            isQueen[row][i] = true;
            solve(row + 1);
            isPlaceCol[i] = false;
            isQueen[row][i] = false;
        }
        

    }

    private boolean canPlace(int row, int col) {
        int r = row;
        int c = col;
        while(r >=0 && c >=0) {
            if(isQueen[r][c]) {
                return false;
            }
            r--;
            c--;
        }
        r = row;
        c = col;
        while(r >=0 && c < isQueen[0].length) {
            if(isQueen[r][c]) {
                return false;
            }
            r--;
            c++;
        }
        return true;
    }
}