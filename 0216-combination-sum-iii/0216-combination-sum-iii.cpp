class Solution {
private:
    vector<vector<int>> ans;
    int _k;
    int _n;
public:
    vector<vector<int>> combinationSum3(int k, int n) {
        _k = k;
        _n = n;
        vector<int> comb;
        backTracking(comb, 0, 0);
        return ans;
    }

    void backTracking(vector<int>& combination, int depth, int usedNum) {
        if(depth == _k) {
            int sum = accumulate(combination.begin(), combination.end(), 0);
            if(sum == _n)
            {
                ans.push_back(combination);
            }
            return;
        }
        for(int i=usedNum + 1; i<=9; i++) {
            combination.push_back(i);
            backTracking(combination, depth + 1, i);
            combination.pop_back();
        }

    }

};