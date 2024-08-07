class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) {
            return new int[]{-1, -1};
        }
        // O(2 * log n)
        int left = -1;
        int right = nums.length;
        int low = 0;
        int high = 0;
        while(left + 1 < right) {
            int mid = (left + right) / 2;
            if(nums[mid] <= target) {
                high = mid;
                left = mid;
            } else { // nums[mid] > target
                right = mid;
            }
        }
        left = -1;
        right = nums.length;
        while(left + 1 < right) {
            int mid = (left + right) / 2;
            if(nums[mid] < target) {
                low = mid + 1;
                left = mid;
            } else {
                right = mid;
            }
        }
        // System.out.println(low + " " + high);
        int[] result = new int[2];
        if(nums[low] != target || nums[high] != target) {
            result[0] = -1;
            result[1] = -1;
        } else {
            result[0] = low;
            result[1] = high;
        }
        return result;
    }
}