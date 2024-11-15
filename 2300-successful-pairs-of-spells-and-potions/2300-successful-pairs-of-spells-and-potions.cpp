class Solution {
public:
    vector<int> successfulPairs(vector<int>& spells, vector<int>& potions, long long success) {
        vector<int> result;
        sort(potions.begin(), potions.end());
        for(int spell : spells) {
            auto iter = lower_bound(potions.begin(), potions.end(), ((success - 1) / spell) + 1);
            // cout << *iter << " ";
            if(iter == potions.end()) {
                result.push_back(0);
                continue;
            }
            result.push_back(potions.end() - iter);
        }


        return result;
    }
};