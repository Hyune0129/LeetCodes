class Solution {
public:
    int rangeBitwiseAnd(int left, int right) {
        int ans = 0;
        for(int i = 30; i >= 0; i--) {
            // std::cout << (left >> i) << " " << (right >> i) << endl;
            if(left >> i == right >> i) {
                ans |= left & (1 << i);
            }
        }
        return ans;
    }
};