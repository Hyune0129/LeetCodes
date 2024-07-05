class Solution {
    final int MAXNODE = (20 * 2) + 1;
    double[][] graph;
    Map<String, Integer> nodeIndexes;
    int nodeSize;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        graph = new double[MAXNODE][MAXNODE];
        double[] answer = new double[queries.size()];
        nodeIndexes = new HashMap<>();
        makeGraph(equations, values);
        for(int i=0; i<queries.size(); i++) {
            List<String> query = queries.get(i);
            answer[i] = getAnswer(query.get(0), query.get(1));
        }
        return answer;
    }

    private void makeGraph(List<List<String>> equations, double[] values) {
        int idx1,idx2;
        for(int i=0; i< equations.size(); i++) {
            List<String> equation = equations.get(i);
            if(!nodeIndexes.containsKey(equation.get(0))) {
                nodeIndexes.put(equation.get(0), nodeIndexes.size());
            }
            if(!nodeIndexes.containsKey(equation.get(1))) {
                nodeIndexes.put(equation.get(1), nodeIndexes.size());
            }
            idx1 = nodeIndexes.get(equation.get(0));
            idx2 = nodeIndexes.get(equation.get(1));
            graph[idx1][idx2] = values[i];
            graph[idx2][idx1] = 1 / values[i];
        }
        nodeSize = nodeIndexes.size();
    }

    private double getAnswer(String a, String b) {
        if(!nodeIndexes.containsKey(a) || !nodeIndexes.containsKey(b)) {
            // dont have node in equations
            return -1.0;
        }
        if(a.equals(b)) {
            return 1.0;
        }
        int idx1 = nodeIndexes.get(a);
        int idx2 = nodeIndexes.get(b);
        if(graph[idx1][idx2] != 0) {
            return graph[idx1][idx2];
        }
        double[] costs = new double[nodeSize];
        Arrays.fill(costs, 1.0);
        for(int i=0; i<nodeSize; i++) {
            for(int j=i+1; j<nodeSize; j++) {
                if(graph[i][j] != 0) {
                    if(j == idx2) {
                        return costs[i] * graph[i][j];
                    }
                    costs[j] = costs[i] * graph[i][j];
                }
            }
        }
        return costs[idx2];
    }

}