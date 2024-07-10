class Solution {
    public int longestSubarray(int[] nums) {
        int start = 0;
        int end = 0;
        int deletedCount = 0;
        while(end < nums.length) {
            if(nums[end] == 0) {
                deletedCount++;
            }
            end++;
            if(deletedCount > 1) {
                if(nums[start] == 0)
                    deletedCount--;
                start++;
            }
            
        }
        return end - start - 1;
    }
}