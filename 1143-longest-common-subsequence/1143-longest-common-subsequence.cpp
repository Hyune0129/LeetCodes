class Solution {
public:
    int longestCommonSubsequence(string text1, string text2) {
        int m = text1.length();
        int n = text2.length();
        vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));
        for(int t1 = 1; t1 <= m; t1++)
        {
            for(int t2 = 1; t2 <= n; t2++)
            {
                if(text1[t1 - 1] == text2[t2 - 1])
                {
                    dp[t1][t2] = dp[t1-1][t2-1] + 1;
                }
                else 
                {
                    dp[t1][t2] = max(dp[t1][t2-1], dp[t1-1][t2]);
                }
            }
        }
        // printVectorMatrix(dp);
        return dp[m][n];
    }

    void printVectorMatrix(vector<vector<int>>& matrix)
    {
        for(int r=0; r<matrix.size(); r++)
        {
            for(int c=0; c<matrix[0].size(); c++)
            {
                std::cout << matrix[r][c] << " ";
            }
            std::cout << std::endl;
        }
    }
};