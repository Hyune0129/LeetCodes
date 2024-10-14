class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        const int ROTTEN = 2;
        const int FRESH = 1;
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<bool>> isVisited(m , vector<bool>(n, false));
        vector<vector<int>> times(m, vector<int>(n, 0));
        queue<pair<int, int>> posQueue;
        int freshCount = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == FRESH) {
                    freshCount++;
                } else if(grid[i][j] == ROTTEN ) {
                    isVisited[i][j] = true;
                    posQueue.push(make_pair(i, j));
                }
            }
        }
        int minute = 0;
        const int dx[4] = {-1, 1, 0, 0};
        const int dy[4] = {0, 0, -1, 1};
        while(not posQueue.empty() && freshCount > 0) {
            pair<int, int> pos = posQueue.front();
            posQueue.pop();
            for(int d=0; d<4; d++) {
                int ny = pos.first + dy[d];
                int nx = pos.second + dx[d];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if(isVisited[ny][nx]) {
                    continue;
                }
                isVisited[ny][nx] = true;
                if(grid[ny][nx] == FRESH) {
                    freshCount--;
                    posQueue.push(make_pair(ny, nx));
                    times[ny][nx] = times[pos.first][pos.second] + 1;
                    minute = max(minute, times[ny][nx]);
                }
            }
        }
        if(freshCount > 0) {
            return -1;
        }
        return minute;
    }
};