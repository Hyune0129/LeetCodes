#ifndef LIMITS
    #define LIMITS
#endif
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        int *arr = new int[n];
        for(int i=0; i<n; i++) { // init
            arr[i] = std::numeric_limits<int>::max();
        }
        for(int i=0; i<n; i++) { 
            *std::lower_bound(arr, arr + n, nums[i]) = nums[i];
        }        
        return std::lower_bound(arr, arr+n, std::numeric_limits<int>::max()) - arr;
        
    }
};