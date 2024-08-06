class Solution {
    public int search(int[] nums, int target) {        
        if(nums[0] == target) {
            return 0;
        } else if(nums[nums.length - 1] == target) {
            return nums.length - 1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left + 1 < right) {
            int middle = (left + right) / 2;
            // System.out.println(middle);
            if( target == nums[middle] ) {
                return middle;
            }
            if(nums[right] < nums[middle]) {
                if(target < nums[right]) {
                    left = middle;
                } else if(nums[middle] < target) {
                    left = middle;
                } else { // nums[right] < target < nums[middle]
                    right = middle;
                }
            } else if(nums[middle] < nums[left]) {
                if(nums[left] < target) {
                    right = middle;
                } else if(target < nums[middle]) {
                    right = middle;
                } else { // nums[mid] < target < nums[right]
                    left = middle;
                }
            } else { // sorted in left -> right
                if(nums[middle] < target) {
                    left = middle;
                } else { // nums[middle] > target
                    right = middle;
                }
            }
        }
        return -1;
    }
}