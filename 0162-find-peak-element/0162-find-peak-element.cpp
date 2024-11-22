/*
* binary search
* M = mid
* L = mid - 1, R = mid + 1
* case1 : L < M && R < M -> peak
* case2 : L < M < R -> peak is right
* case3 : L > M > R -> peak is left
* case4 : M < L && M < R -> reverse peak(any directions have peak)
*/
class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int n = nums.size();
        if(n == 1)
        {
            return 0;
        }
        int left = -1;
        int right = n;
        int mid = -1;
        while(left + 1 < right) 
        {
            mid = (left + right) / 2;
            if (mid <= 0) 
            {
                if(nums[mid] > nums[mid+1])
                {
                    return mid;
                } 
                left = mid;
                continue;
            } 
            else if (mid >= n-1)
            {
                if(nums[mid] > nums[mid]) 
                {
                    return mid;
                }
                right = mid;
                continue;
            }

            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) // isPeak
            {
                return mid;
            }

            if(nums[mid - 1] > nums[mid]) // peak is left
            {
                right = mid;
            }
            else // peak is right
            {
                left = mid;
            }
        }
        return mid;
    }
};