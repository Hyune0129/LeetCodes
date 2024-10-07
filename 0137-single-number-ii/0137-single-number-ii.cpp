class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int bitCount[32] = {0, };
        int n = nums.size();
        for(int num : nums) {
            for(int i=0; i<32; i++) {
                if(num & 1 == 1) {
                    bitCount[i]++;
                }
                num = num >> 1;
            }
        }
        int ans = 0;
        for(int i=0; i<32; i++) {
            if(bitCount[i] % 3 == 1) {
                ans += (1 << i);
            }
            // std::cout << bitCount[i] << " ";
        }
        return ans;
    }
};