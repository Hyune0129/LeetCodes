// ref : https://leetcode.com/problems/maximum-sum-circular-subarray/solutions/3066636/weird-kadane-explanation-with-images/

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int minSum = nums[0];
        int maxSum = nums[0];
        int maxSub = nums[0];
        int minSub = nums[0];
        int totalSum = nums[0];
        for(int i=1; i<n; i++) {
            minSum = Math.min(nums[i], nums[i] + minSum);
            maxSum = Math.max(nums[i], nums[i] + maxSum);
            maxSub = Math.max(maxSub, maxSum);
            minSub = Math.min(minSub, minSum);
            totalSum += nums[i];
        }
        if(maxSub <= 0) { // [-3, -2, -3]   
            return maxSub;
        }
        
        return Math.max(totalSum - minSub, maxSub);
    }
}