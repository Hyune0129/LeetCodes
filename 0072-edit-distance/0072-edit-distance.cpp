class Solution {
public:
    int minDistance(string word1, string word2) {
        int dp[word1.length() + 1][word2.length() + 1];
        for(int i=0; i<=word1.length(); i++) {
            dp[i][0] = i;
        }
        for(int i=0; i<=word2.length(); i++) {
            dp[0][i] = i;
        }
        for(int i=1; i<=word1.length(); i++) {
            for(int j=1; j<=word2.length(); j++) {
                if(word1[i-1] == word2[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                    continue;
                }
                dp[i][j] = 1 + std::min(std::min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]);
            }
        }

        // for(int i=0; i<=word1.length(); i++) {
        //     for(int j=0; j<=word2.length(); j++) {
        //         std::cout << dp[i][j] << " ";
        //     }
        //     std::cout << std::endl;
        // }
        return dp[word1.length()][word2.length()];
    }
};