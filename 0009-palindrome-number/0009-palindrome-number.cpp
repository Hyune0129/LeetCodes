class Solution {
public:
    bool isPalindrome(int x) {
        if(x < 0) {
            return false;
        } else if(x < 10) {
            return true;
        }
        int start = 0;
        int end = std::log10(x);
        while(start < end) {
            int num1 = x / (int)(std::pow(10, end)) % 10;
            int num2 = x / (int)(std::pow(10, start)) % 10;
            // std::cout << num1 << " " << num2 << endl;
            if(num1 != num2) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
};