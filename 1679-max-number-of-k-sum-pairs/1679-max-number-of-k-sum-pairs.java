class Solution {
    public int maxOperations(int[] nums, int k) {
        // sorting -> two ptr
        int answer = 0;
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            int sum = nums[start] + nums[end];
            if(sum == k) {
                answer++;
                start++;
                end--;
            } else if(sum < k) {
                start++;
            } else { // sum >k
                end--;
            }
        }
        return answer;
    }
}