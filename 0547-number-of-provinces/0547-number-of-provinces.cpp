class Solution {
private:
public:
    int findCircleNum(vector<vector<int>>& isConnected) {
        int n = isConnected.size();
        bool *isVisited = new bool[n]{false, };
        int count = 0;
        std::queue<int> q;
        for(int i=0; i<n; i++) {
            if(isVisited[i]) {
                continue;
            }
            count++;
            q.push(i);
            isVisited[i] = true;
            while(!q.empty()) { // bfs
                int city = q.front();
                q.pop();
                for(int j=0; j<n; j++) {
                    if(isVisited[j]) {
                        continue;
                    }
                    if(isConnected[city][j]) {
                        q.push(j);
                        isVisited[city] = true;
                    }
                }

            }
        }

        
        return count;
    }
};