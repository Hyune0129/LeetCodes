public class Solution {
    public int MaxArea(int[] height) {
        int n = height.Length;
        int maxArea = 0;
        int left = 0;
        int right = n - 1;
        while(left < right) {
            maxArea = Math.Max(maxArea, (right - left) * Math.Min(height[right], height[left]));
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}