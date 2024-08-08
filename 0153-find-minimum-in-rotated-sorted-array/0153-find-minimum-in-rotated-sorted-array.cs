public class Solution {
    public int FindMin(int[] nums) {
        if(nums.Length == 2) {
            return Math.Min(nums[0], nums[1]);
        }
        int left = 0;
        int right = nums.Length - 1;
        while(left + 1 < right) {
            int mid = (left + right) / 2;
            if(nums[left] < nums[right]) { // sorted array in left ~ right
                return nums[left];
            } else if( nums[left] > nums[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return nums[right];
    }
}