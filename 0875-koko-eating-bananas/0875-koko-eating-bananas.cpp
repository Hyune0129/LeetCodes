class Solution {
private:
    const static int MAX_VALUE = 1000000001;
    bool simulate(vector<int>& piles, int h, int k) {
        int now = 0;
        for(int banana : piles) {
            now += (banana + k - 1) / k;
            if(now > h) {
                return false;
            }
        }
        return true;
    }
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        int sum = 0;
        int left = 0;
        int right = MAX_VALUE;
        int result = MAX_VALUE;

        // binary search 
        while(left + 1 < right) {
            int middle = (left + right) / 2;
            if(simulate(piles, h, middle)) {
                result = min(middle, result);
                right = middle;
            } else {
                left = middle;
            }
        }
        return result;
    }
};