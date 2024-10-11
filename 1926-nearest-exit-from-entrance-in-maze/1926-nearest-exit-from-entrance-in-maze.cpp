class Solution {
public:
    int nearestExit(vector<vector<char>>& maze, vector<int>& entrance) {
        const int dr[4] = {-1, 1, 0, 0};
        const int dc[4] = {0, 0,-1, 1};
        int m = maze.size();
        int n = maze[0].size();
        queue<pair<int, int>> q;
        vector<vector<int>> isVisited(m, vector<int>(n, -1));
        isVisited[entrance[0]][entrance[1]] = 0;
        for(int d=0; d<4; d++) {
            int nr = dr[d] + entrance[0];
            int nc = dc[d] + entrance[1];
            if(nr < 0 || nr >= m || nc < 0 || nc >= n) { // boundary
                continue;
            }
            if(maze[nr][nc] == '+') {
                continue;
            }
            isVisited[nr][nc] = 1;
            q.push(make_pair(nr, nc));
        }
        if(q.empty()) { // cant go anywhere from entrance
            return -1;
        }
        while(!q.empty()) { // bfs
            pair<int, int> pos = q.front();
            q.pop();
            for(int d=0; d<4; d++) {
                int nr = dr[d] + pos.first;
                int nc = dc[d] + pos.second;
                if(nr < 0 || nr >= m || nc < 0 || nc >= n) { // boundary
                    return isVisited[pos.first][pos.second];
                }
                if(maze[nr][nc] == '+') { // wall
                    continue;
                }
                if(isVisited[nr][nc] >= 0) { // visited
                    continue;
                }
                isVisited[nr][nc] = isVisited[pos.first][pos.second] + 1;
                q.push(make_pair(nr, nc));
            }
        }
        return -1;
    }
};