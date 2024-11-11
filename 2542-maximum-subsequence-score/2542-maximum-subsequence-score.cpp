// reference : https://leetcode.com/problems/maximum-subsequence-score/solutions/3082106/java-c-python-priority-queue
#include <queue>
#include <algorithm>

class Solution {
public:
    long long maxScore(vector<int>& nums1, vector<int>& nums2, int k) {
        int n = nums1.size();
        vector<pair<int, int>> nums(n);
        for(int i = 0; i<n; i++) {
            nums[i] = make_pair(nums2[i], nums1[i]);
        }

        // sorting reverse order
        // sorting by nums2
        sort(rbegin(nums), rend(nums)); 

        long long sums = 0;
        long long result = 0;

        priority_queue<int, vector<int>, greater<int>> min_heap;
        for(auto& [num2, num1] : nums) {
            min_heap.push(num1);
            sums += num1;
            if(min_heap.size() > k) {
                sums -= min_heap.top();
                min_heap.pop();
            }
            if(min_heap.size() == k) {
                result = max(result, sums * num2);
            }
        }
        return result;
    }
};