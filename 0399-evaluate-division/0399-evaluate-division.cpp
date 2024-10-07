class Solution {
private:
    double ans;
    void dfs(int node, int end, double cost, vector<vector<double>>& graph, vector<bool>& isVisited) {
        if(node == end) {
            ans = cost;
            return;
        }
        for(int i=0; i<graph.size(); i++) {
            if(isVisited[i]) {
                continue;
            }
            if(graph[node][i] == -1.0) {
                continue;
            }
            isVisited[i] = true;
            dfs(i, end, cost * graph[node][i], graph, isVisited);
        }
    }
public:
    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
        vector<double> answer;
        int n = equations.size();
        vector<vector<double>> graph(40, vector<double>(40, -1.0));
        unordered_map<string, int> nodeNum;
        int nodeIdx = 0;
        for(int i=0; i<n; i++) {
            string a = equations[i][0];
            string b = equations[i][1];
            if(!nodeNum.contains(a)) {
                nodeNum[a] = nodeIdx++;
            }
            if(!nodeNum.contains(b)) {
                nodeNum[b] = nodeIdx++;
            }
            int aNode = nodeNum[a];
            int bNode = nodeNum[b];

            graph[aNode][aNode] = 1.0;
            graph[bNode][bNode] = 1.0;
            graph[aNode][bNode] = values[i];
            graph[bNode][aNode] = 1.0 / values[i];
        }
        for(vector<string> query : queries) {
            string a = query[0];
            string b = query[1];
            if(!nodeNum.contains(a) || !nodeNum.contains(b)) {
                answer.push_back(-1.0); // cant solve
                continue;
            }
            int start = nodeNum[a];
            int end = nodeNum[b];
            vector<bool> isVisited(n, false);
            isVisited[start] = true;
            ans = -1.0;
            dfs(start, end, 1.0, graph, isVisited);
            answer.push_back(ans);
            
        }
        return answer;
    }
};