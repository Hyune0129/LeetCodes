class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        const int MAX_VALUE = 1000000;
        int n = cost.size();
        vector<int> min_costs(MAX_VALUE, n);
        min_costs[0] = cost[0];
        min_costs[1] = cost[1];
        for(int i=2; i<n; i++)
        {
            min_costs[i] = min(min_costs[i-2], min_costs[i-1]) + cost[i];
        }
        return min(min_costs[n-2], min_costs[n-1]);

    }
};