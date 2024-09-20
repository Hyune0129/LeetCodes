class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        for(int i=1; i<m; i++) {
            grid[i][0] += grid[i-1][0];
        }
        for(int i=1; i<n; i++) {
            grid[0][i] += grid[0][i-1];
        }
        for(int row=1; row<m; row++) {
            for(int col=1; col<n; col++) {
                grid[row][col] += std::min(grid[row-1][col], grid[row][col-1]);
            }
        }
        return grid[m-1][n-1];
    }
};