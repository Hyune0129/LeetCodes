public class Solution {
    public double FindMaxAverage(int[] nums, int k) {
        int left = 0;
        int right = k - 1;
        int sum = 0;
        for(int i=0; i<k; i++) {
            sum += nums[i];
        }
        int max = sum;
        right++;
        for(; right < nums.Length; left++, right++) {
            sum += nums[right];
            sum -= nums[left];
            // Console.WriteLine(sum);
            max = Math.Max(max, sum);
        }
        return (double) max / k;
    }
}