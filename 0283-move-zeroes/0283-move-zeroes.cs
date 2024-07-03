public class Solution {
    public void MoveZeroes(int[] nums) {
        if(nums.Length == 1) {
            return;
        }
        int idx1 = 0; // zero index
        int idx2 = 0; // another index
        int n = nums.Length;
        while(idx1 < n && idx2 < n){
            while(idx1 < n && nums[idx1] != 0) {
                idx1++;
            }
            idx2 = idx1;
            while(idx2 < n && nums[idx2] == 0){
                idx2++;
            }
            if(idx1< n && idx2 <n){
                swap(ref nums[idx1], ref nums[idx2]);
            }
            
            idx1++;
            idx2++;
        }
    }

    private void swap(ref int x, ref int y){
        int temp = x;
        x = y;
        y = temp;
    }
}