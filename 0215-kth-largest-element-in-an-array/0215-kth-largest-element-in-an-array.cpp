#include <iostream>
#include <queue>
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        std::priority_queue<int> min_nums;
        for(const int num : nums) {
            min_nums.push(num);
        }
        int answer = 0;
        for(int i=0; i<k; i++) {
            answer = min_nums.top();
            min_nums.pop();
        }
        return answer;
    }
};