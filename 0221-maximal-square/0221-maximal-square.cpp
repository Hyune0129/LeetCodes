class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int m = matrix.size();
        int n = matrix[0].size();
        int dp[300][300];
        int max = 0;
        for(int i=0; i<m; i++) {
            if(matrix[i][0] == '1') {
                dp[i][0] = 1;
                max = 1;
            } else {
                dp[i][0] = 0;
            }
        }
        for(int i=0; i<n; i++) {
            if(matrix[0][i] == '1') {
                dp[0][i] = 1;
                max = 1;
            } else {
                dp[0][i] = 0;
            }
        }
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(matrix[i][j] == '1') {
                    int min = std::min(dp[i-1][j], dp[i][j-1]);
                    min = std::min(min, dp[i-1][j-1]);
                    dp[i][j] = min + 1;
                    max = std::max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        // for(int i=0; i<m; i++) {
        //     for(int j=0; j<n; j++) {
        //         std::cout << dp[i][j] << " ";
        //     }
        //     std::cout << std::endl;
        // }
        return std::pow(max, 2);
    }
};