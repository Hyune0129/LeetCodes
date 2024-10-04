class Solution {
public:
    int minReorder(int n, vector<vector<int>>& connections) {
        int count = 0;
        std::vector<bool> isVisited(n, false);
        std::vector<std::vector<int>> graph(n); // sparse graph
        for (std::vector<int> connect : connections) {
            graph[connect[0]].push_back(-connect[1]);
            graph[connect[1]].push_back(connect[0]);
        }
        isVisited[0] = true;
        std::queue<int> q;
        q.push(0);
        while (!q.empty()) {
            int city = q.front();
            q.pop();
            for (int adjCity : graph[city]) {
                if (isVisited[std::abs(adjCity)]) {
                    continue;
                }
                isVisited[std::abs(adjCity)] = true;
                if (adjCity < 0) { // reorder
                    count++;
                    q.push(std::abs(adjCity));
                } else {
                    q.push(adjCity);
                }
            }
        }
        return count;
    }
};