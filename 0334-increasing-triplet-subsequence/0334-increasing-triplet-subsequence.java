class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length <= 2) {
            return false;
        }
        int min = Integer.MAX_VALUE;
        int middle= Integer.MAX_VALUE;
        for(int index = 0; index < nums.length; index++) {
            if(checkTriplet(min, middle, nums[index])) {
                return true;
            }
            min = Math.min(min, nums[index]);
            if(min < nums[index]) {
                middle = Math.min(middle, nums[index]);
            }
        }
        return false;
    }

    private boolean checkTriplet(int num1, int num2, int num3) {
        if(num1 >= num2)
            return false;
        if(num2 >= num3)
            return false;
        return true;
    }
}