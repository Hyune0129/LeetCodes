class Solution {
    public int longestOnes(int[] nums, int k) {
        if(nums.length == 1) {
            if(nums[0] == 1 || k == 1) {
                return 1;
            }
            return 0;
        }
        int left = 0;
        int right = 1;
        int max = 0;
        if(nums[left] == 0) {
            k--;
        }
        while(k < 0) {
            if(nums[left] == 0) {
                left++;
                k++;
            }   
        }
        System.out.println(left + " " + right + " " + k);
        while(right < nums.length) {
            while((right < nums.length) && ( k > 0 || nums[right] == 1)) {
                // System.out.println(left + " " + right + " " + k);
                if(nums[right] == 0) {
                    k--;
                }
                right++;
                
            }
            max = Math.max(max, right - left);
            // System.out.println(left + " " + right + " " + k);
            while(k == 0 && left < nums.length) {
                if(nums[left] == 0) {
                    k++;
                    left++;
                    break;
                }
                left++;
            }
            // System.out.println(left + " " + right + " " + k);
            max = Math.max(max, right - left);
        }
        return max;
    }
}