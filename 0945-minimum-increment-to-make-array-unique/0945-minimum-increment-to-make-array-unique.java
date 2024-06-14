class Solution {
    public int minIncrementForUnique(int[] nums) {
        int N = nums.length;
        if(N == 1)
            return 0;
        int minNum = 0;
        int ans = 0;
        Arrays.sort(nums);
        for(int num : nums) {
            minNum = Math.max(num, minNum);
            if(minNum == num) {
                minNum++;
            } else if(minNum > num) {
                ans+= (minNum - num);
                minNum++;
            }
        }
        return ans;
    }
}